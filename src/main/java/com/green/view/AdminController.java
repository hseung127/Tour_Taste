package com.green.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.green.tnt.dto.CommentsVO;
import com.green.tnt.dto.EventboardVO;
import com.green.tnt.dto.Member0_rboardVO;
import com.green.tnt.dto.Member0_tboardVO;
import com.green.tnt.dto.Member1_rboardVO;
import com.green.tnt.dto.Member1_tboardVO;
import com.green.tnt.dto.MemberVO;
import com.green.tnt.dto.NewsboardVO;
import com.green.tnt.dto.SeasonboardVO;
import com.green.tnt.comments.CommentsService;
import com.green.tnt.eventboard.EventboardService;
import com.green.tnt.member.MemberService;
import com.green.tnt.member0_rboard.Member0_rboardService;
import com.green.tnt.member0_tboard.Member0_tboardService;
import com.green.tnt.member1_rboard.Member1_rboardService;
import com.green.tnt.member1_tboard.Member1_tboardService;
import com.green.tnt.newsboard.NewsboardService;
import com.green.tnt.seasonboard.SeasonboardService;

import utils.Criteria;
import utils.PageMaker;

@Controller
@SessionAttributes("adminUser")
public class AdminController {
	

	@Autowired
	private NewsboardService newsboardService;
	@Autowired
	private Member0_rboardService member0_rboardService;
	@Autowired
	private Member0_tboardService member0_tboardService;
	@Autowired
	private Member1_rboardService member1_rboardService;
	@Autowired
	private Member1_tboardService member1_tboardService;
	@Autowired
	private SeasonboardService seasonboardService;
	@Autowired
	private EventboardService eventboardService;
	@Autowired
	private CommentsService commentsService;
	@Autowired
	private MemberService memberService;
	

	


	/**
	 * admin
	 */

	@GetMapping(value = "/admin_index")
	public String adminLoginView() {

		return "admin/index";
	}

	@GetMapping(value = "/admin_logout")
	public String adminLogout(SessionStatus status, HttpSession session) {
		memberService.signout(session);
		status.setComplete();
		
		return "index";
	}
	
	/**
	 * admin member
	 */
	@RequestMapping(value = "/admin_member_list")
	public String adminMemberList(@RequestParam(value = "keyword", defaultValue = "") String name, Criteria criteria,
			Model model) {

		List<MemberVO> mList = memberService.listMember(name);
		model.addAttribute("memberList",mList);
		return "admin/member/memberList";
	}
	
	@RequestMapping(value = "/admin_chart_list")
	public String adminMemberList(Model model) {

		return "admin/member/chart";
	}

	/**
	 * newsboard
	 */

	/*게시판 조회 */
	@RequestMapping(value="admin_newsboard_get")
	public void adminNewsboardGet(int nseq,Model model , Criteria criteria){
		model.addAttribute("pageInfo",newsboardService.countNewsboardList(criteria));
	}

	@RequestMapping(value = "/admin_newsboard_list")
	public String adminNewsboardList(Criteria criteria,
			Model model) {


		List<NewsboardVO> newsList = newsboardService.getListWithPaging(criteria);

	
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = newsboardService.countNewsboardList(criteria);
		pageMaker.setTotalCount(totalCount);

		model.addAttribute("newsboardList", newsList);
		model.addAttribute("newsboardListSize", newsList.size());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/newsboard/newsboardList";
	}



	@PostMapping(value = "/admin_newsboard_write_form")
	public String adminNewsboardWriteView(Model model) {
		

		return "admin/newsboard/newsboardWrite";
	}
	

	@PostMapping(value="/admin_newsboard_write")
	public String adminNewsboardWrite(@RequestParam(value="newsboard_image") MultipartFile uploadFile,
								    NewsboardVO vo, HttpSession session) {
			String fileName = "";
			
				fileName = uploadFile.getOriginalFilename();
		
				vo.setImage(fileName);
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/newsboard_images/");
				System.out.println("�̹��� ���이미지경로: " + image_path);
						
				try {
					
					File dest = new File(image_path + fileName);
					uploadFile.transferTo(dest);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			
		
		newsboardService.insertNewsboard(vo);
		
		return "redirect:admin_newsboard_list";
	}
	// ck 에디터에서 파일 업로드

	/*

		@RequestMapping(value = "NckUpload")
		public void postCKEditorImgUpload(HttpServletRequest req,
										  HttpServletResponse res,
										  @RequestParam MultipartFile upload) {
			
			
			// 랜덤 문자 생성
			UUID uid = UUID.randomUUID();
			
			OutputStream out = null;
			PrintWriter printWriter = null;
					
			// 인코딩
			res.setCharacterEncoding("utf-8");
			res.setContentType("text/html;charset=utf-8");
			
			try {
				
				String fileName = upload.getOriginalFilename();  // 파일 이름 가져오기
				byte[] bytes = upload.getBytes();
				
				// 업로드 경로
				String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName;
				
				out = new FileOutputStream(new File(ckUploadPath));
				out.write(bytes);
				out.flush();  // out에 저장된 데이터를 전송하고 초기화
				
				String callback = req.getParameter("CKEditorFuncNum");
				printWriter = res.getWriter();
				String fileUrl = "/ckUpload/" + uid + "_" + fileName;  // 작성화면
				
				// 업로드시 메시지 출력
				printWriter.println("<script type='text/javascript'>"
							+ "window.parent.CKEDITOR.tools.callFunction("
							+ callback+",'"+ fileUrl+"','이미지를 업로드하였습니다.')"
							+"</script>");
				
				printWriter.flush();
				
			} catch (IOException e) { e.printStackTrace();
			} finally {
				try {
					if(out != null) { out.close(); }
					if(printWriter != null) { printWriter.close(); }
				} catch(IOException e) { e.printStackTrace(); }
			} 
			
			return;	
		}
		
	*/ 
	 



	@RequestMapping(value="/admin_newsboard_detail")
	public String adminNewsboardDetail(NewsboardVO vo, Model model) {

		
		newsboardService.newsboardHit(vo);
		
		
		NewsboardVO newsboard = newsboardService.getNewsboard(vo);
		
		model.addAttribute("newsboardVO", newsboard);
		
		return "admin/newsboard/newsboardDetail";
	}
	
	
	


	@PostMapping(value="/admin_newsboard_update_form")
	public String adminNewsboardUpdateView(NewsboardVO vo, Model model) {
		
		
		NewsboardVO newsboard = newsboardService.getNewsboard(vo);
		
		model.addAttribute("newsboardVO", newsboard);	
		
		return "admin/newsboard/newsboardUpdate";
	}
	

	@RequestMapping(value="/admin_newsboard_update")
	public String adminNewsboardUpdate(@RequestParam(value="newsboard_image") MultipartFile uploadFile,
					@RequestParam(value="nonmakeImg") String origImage,
					NewsboardVO vo, HttpSession session) {
		// 랜덤 문자 생성 
		
		UUID uid = UUID.randomUUID();



			String fileName = "";
			
		
			if (!uploadFile.isEmpty()) {  
				fileName = uploadFile.getOriginalFilename();
		
				vo.setImage(fileName);
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/newsboard_images/");
				System.out.println("�̹��� ���: " + image_path);
						
				try {
			
					File dest = new File(image_path + fileName);
					uploadFile.transferTo(dest);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			} else {
		
				vo.setImage(origImage);
			}
			
			
			newsboardService.updateNewsboard(vo);
			
			return "redirect:admin_newsboard_list";
		
	}	

	@PostMapping(value="admin_newsboard_delete")
	public String adminNewsboardDelete(@RequestParam(value="nseq")int nseq){
		
			newsboardService.deleteNewsboard(nseq);

		return "redirect:admin_newsboard_list";
	}
	@PostMapping(value="admin_newsboard_sdelete")
	public String NewsboardSdelete(@RequestParam(value="nseq") int[]nseq) {
		
		for(int i=0; i<nseq.length; i++) {
			newsboardService.deleteNewsboard(nseq[i]);
		}
		
		return "redirect:admin_newsboard_list";
	}

	
	
	/**
	 *  member0 r board
	 */
	@RequestMapping(value = "/admin_member0_rboard_list")
	public String adminMember0_rboardList(@RequestParam(value = "key", defaultValue = "") String subject, Criteria criteria,
			Model model) {

		
		List<Member0_rboardVO> m0rList = member0_rboardService.ListWithPaging(criteria, subject);

		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = member0_rboardService.countMember0_rboard(subject);
		pageMaker.setTotalCount(totalCount);	
		
		model.addAttribute("member0_rboardList",m0rList);
		model.addAttribute("member0_rboardListSize", m0rList.size());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/member0_rboard/member0_rboardList";
		
	}
	
	
	
	@RequestMapping(value="/admin_member0_rboard_detail")
	public String adminMember0_rboardDetail(Member0_rboardVO vo, Model model) {
		
		
		Member0_rboardVO m0rBoard = member0_rboardService.getMember0_rboard(vo);
		
		model.addAttribute("member0_rboardVO", m0rBoard);
		
		
		return "admin/member0_rboard/member0_rboardDetail";
	}
	
	@PostMapping(value="admin_member0_rboard_delete")
	public String adminmMember0_rboardDelete(@RequestParam(value="m0rseq")int m0rseq){
		
		member0_rboardService.deletemember0_rboard(m0rseq);

		return "redirect:admin_member0_rboard_list";
	}
	
	/*
	 * member0 tboard
	 */
	@RequestMapping(value = "/admin_member0_tboard_list")
	public String adminMember0_tboardList(@RequestParam(value = "key", defaultValue = "") String subject, Criteria criteria,
			Model model) {
		List<Member0_tboardVO> m0tList = member0_tboardService.ListWithPaging(criteria, subject);

		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = member0_tboardService.countMember0_tboard(subject);
		pageMaker.setTotalCount(totalCount);

		model.addAttribute("member0_tboardList",m0tList);
		model.addAttribute("member0_tboardListSize", m0tList.size());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/member0_tboard/member0_tboardList";
	}
	
	@RequestMapping(value="/admin_member0_tboard_detail")
	public String adminMember0_tboardDetail(Member0_tboardVO vo, Model model) {
		
		
		Member0_tboardVO m0tBoard = member0_tboardService.getMember0_tboard(vo);
		
		model.addAttribute("member0_tboardVO", m0tBoard);
		
		
		return "admin/member0_tboard/member0_tboardDetail";
	}
	@PostMapping(value="admin_member0_tboard_delete")
	public String adminmMember0_tboardDelete(@RequestParam(value="m0tseq")int m0tseq){
		
		member0_tboardService.deletemember0_tboard(m0tseq);

		return "redirect:admin_member0_tboard_list";
	}
	
	/*
	 * member1 rboard
	 */
	@RequestMapping(value = "/admin_member1_rboard_list")
	public String adminMember1_rboardList(@RequestParam(value = "key", defaultValue = "") String subject, Criteria criteria,
			Model model) {

		List<Member1_rboardVO> m1rList = member1_rboardService.ListWithPaging(criteria, subject);

		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = member1_rboardService.countMember1_rboard(subject);
		pageMaker.setTotalCount(totalCount);	
		
		model.addAttribute("member1_rboardList",m1rList);
		model.addAttribute("member1_rboardListSize", m1rList.size());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/member1_rboard/member1_rboardList";
	}
	
	@RequestMapping(value="/admin_member1_rboard_detail")
	public String adminMember1_rboardDetail(Member1_rboardVO vo, Model model) {
		
		
		Member1_rboardVO m1rBoard = member1_rboardService.getMember1_rboard(vo);
		
		model.addAttribute("member1_rboardVO", m1rBoard);
		
		
		return "admin/member1_rboard/member1_rboardDetail";
	}
	
	@PostMapping(value = "/admin_member1_rboard_write_form")
	public String adminMember1_rboardWriteView(Model model) {
		

		return "admin/member1_rboard/member1_rboardWrite";
	}
	

	@PostMapping(value="/admin_member1_rboard_write")
	public String adminMember1_rWrite(@RequestParam(value="member1_rboard_image") MultipartFile uploadFile,
								    Member1_rboardVO vo, HttpSession session) {
			String fileName = "";
			
				fileName = uploadFile.getOriginalFilename();
		
				vo.setImage1(fileName);
				vo.setImage2(fileName);
				vo.setImage3(fileName);
				vo.setImage4(fileName);
				vo.setImage5(fileName);
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/member1_rboard_images/");
				System.out.println("�̹��� ���이미지경로: " + image_path);
						
				try {
					
					File dest = new File(image_path + fileName);
					uploadFile.transferTo(dest);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			
		
		member1_rboardService.insertMember1_rboard(vo);
		
		return "redirect:admin_member1_rboard_list";
	}

	


	@PostMapping(value="/admin_member1_rboard_update_form")
	public String adminmember1_rboardUpdateView(Member1_rboardVO vo, Model model) {
		
		
		Member1_rboardVO m1rboard = member1_rboardService.getMember1_rboard(vo);
		
		model.addAttribute("member1_rboardVO", m1rboard);	
		
		return "admin/member1_rboard/member1_rboardUpdate";
	}
	

	@RequestMapping(value="/admin_member1_rboard_update")
	public String adminMember1_rboardUpdate(@RequestParam(value="member1_rboard_image") MultipartFile uploadFile,
					@RequestParam(value="nonmakeImg") String origImage,
					Member1_rboardVO vo, HttpSession session) {
	
			String fileName = "";
			
		
			if (!uploadFile.isEmpty()) {  
				fileName = uploadFile.getOriginalFilename();
		
				vo.setImage1(fileName);
				vo.setImage2(fileName);
				vo.setImage3(fileName);
				vo.setImage4(fileName);
				vo.setImage5(fileName);
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/member1_rboard_images/");
				System.out.println("�̹��� ���: " + image_path);
						
				try {
			
					File dest = new File(image_path + fileName);
					uploadFile.transferTo(dest);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			} else {
		
				vo.setImage1(origImage);
				vo.setImage2(origImage);
				vo.setImage3(origImage);
				vo.setImage4(origImage);
				vo.setImage5(origImage);
			}
			
			
			member1_rboardService.updateMember1_rboard(vo);
			
			return "redirect:admin_member1_rboard_list";
	}
	@PostMapping(value="admin_member1_rboard_delete")
	public String adminmMember1_rboardDelete(@RequestParam(value="m1rseq")int m1rseq){
		
		member1_rboardService.deletemember1_rboard(m1rseq);

		return "redirect:admin_member1_rboard_list";
	}
	/*
	 * member1 tboard
	 */
	@RequestMapping(value = "/admin_member1_tboard_list")
	public String adminMember1_tboardList(@RequestParam(value = "key", defaultValue = "") String subject, Criteria criteria,
			Model model) {
		List<Member1_tboardVO> m1rList = member1_tboardService.ListWithPaging(criteria, subject);

		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = member1_tboardService.countMember1_tboard(subject);
		pageMaker.setTotalCount(totalCount);	
		
		model.addAttribute("member1_tboardList",m1rList);
		model.addAttribute("member1_tboardListSize", m1rList.size());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/member1_tboard/member1_tboardList";
	}
	
	@RequestMapping(value="/admin_member1_tboard_detail")
	public String adminMember1_tboardDetail(Member1_tboardVO vo, Model model) {
		
		
		Member1_tboardVO m1tBoard = member1_tboardService.getMember1_tboard(vo);
		
		model.addAttribute("member1_tboardVO", m1tBoard);
		
		
		return "admin/member1_tboard/member1_tboardDetail";
	}
	@PostMapping(value = "/admin_member1_tboard_write_form")
	public String adminMember1_tboardWriteView(Model model) {
		

		return "admin/member1_tboard/member1_tboardWrite";
	}
	

	@PostMapping(value="/admin_member1_tboard_write")
	public String adminMember1_tWrite(@RequestParam(value="member1_tboard_image") MultipartFile uploadFile,
								    Member1_tboardVO vo, HttpSession session) {
			String fileName = "";
			
				fileName = uploadFile.getOriginalFilename();
		
				vo.setImage1(fileName);
				vo.setImage2(fileName);
				vo.setImage3(fileName);
				vo.setImage4(fileName);
				vo.setImage5(fileName);
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/member1_tboard_images/");
				System.out.println("�̹��� ���이미지경로: " + image_path);
						
				try {
					
					File dest = new File(image_path + fileName);
					uploadFile.transferTo(dest);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			
		
		member1_tboardService.insertMember1_tboard(vo);
		
		return "redirect:admin_member1_tboard_list";
	}

	


	@PostMapping(value="/admin_member1_tboard_update_form")
	public String adminmember1_tboardUpdateView(Member1_tboardVO vo, Model model) {
		
		
		Member1_tboardVO m1tboard = member1_tboardService.getMember1_tboard(vo);
		
		model.addAttribute("member1_tboardVO", m1tboard);	
		
		return "admin/member1_tboard/member1_tboardUpdate";
	}
	

	@RequestMapping(value="/admin_member1_tboard_update")
	public String adminMember1_tboardUpdate(@RequestParam(value="member1_tboard_image") MultipartFile uploadFile,
					@RequestParam(value="nonmakeImg") String origImage,
					Member1_tboardVO vo, HttpSession session) {
	
			String fileName = "";
			
		
			if (!uploadFile.isEmpty()) {  
				fileName = uploadFile.getOriginalFilename();
		
				vo.setImage1(fileName);
				vo.setImage2(fileName);
				vo.setImage3(fileName);
				vo.setImage4(fileName);
				vo.setImage5(fileName);
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/member1_tboard_images/");
				System.out.println("�̹��� ���: " + image_path);
						
				try {
			
					File dest = new File(image_path + fileName);
					uploadFile.transferTo(dest);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			} else {
		
				vo.setImage1(origImage);
				vo.setImage2(origImage);
				vo.setImage3(origImage);
				vo.setImage4(origImage);
				vo.setImage5(origImage);
			}
			
			
			member1_tboardService.updateMember1_tboard(vo);
			
			return "redirect:admin_member1_tboard_list";
	}
	
	@PostMapping(value="admin_member1_tboard_delete")
	public String adminmMember1_tboardDelete(@RequestParam(value="m1tseq")int m1tseq){
		
		member1_tboardService.deletemember1_tboard(m1tseq);

		return "redirect:admin_member1_tboard_list";
	}
	
	
	/*
	 * seasonboard
	 */
	@RequestMapping(value = "/admin_seasonboard_list")
	public String adminSeasonboardList(@RequestParam(value = "key", defaultValue = "") String subject, Criteria criteria,
			Model model) {

		
		
		
		
		List<SeasonboardVO> sList = seasonboardService.listSeasonboard(subject);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = seasonboardService.countSeasonboard(subject);	
		pageMaker.setTotalCount(totalCount);
		model.addAttribute("seasonboardList",sList);
		model.addAttribute("seasonboardListSize", sList.size());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/seasonboard/seasonboardList";
	}
	
	@RequestMapping(value="/admin_seasonboard_detail")
	public String adminSeasonboardDetail(SeasonboardVO vo, Model model) {
		
		
		SeasonboardVO sBoard = seasonboardService.getSeasonboard(vo);
		
		model.addAttribute("seasonboardVO", sBoard);
		
		
		return "admin/seasonboard/seasonboardDetail";
	}
	@PostMapping(value = "/admin_seasonboard_write_form")
	public String adminseasonboardWriteView(Model model) {
		

		return "admin/seasonboard/seasonboardWrite";
	}
	

	@PostMapping(value="/admin_seasonboard_write")
	public String adminSeasonWrite(@RequestParam(value="seasonboard_image") MultipartFile uploadFile,
								    SeasonboardVO vo, HttpSession session) {
			String fileName = "";
			
				fileName = uploadFile.getOriginalFilename();
		
				vo.setImage1(fileName);
				vo.setImage2(fileName);
				vo.setImage3(fileName);
				vo.setImage4(fileName);
				vo.setImage5(fileName);
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/seasonboard_images/");
				System.out.println("�̹��� ���이미지경로: " + image_path);
						
				try {
					
					File dest = new File(image_path + fileName);
					uploadFile.transferTo(dest);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			
		
		seasonboardService.insertSeasonboard(vo);
		
		return "redirect:admin_seasonboard_list";
	}

	


	@PostMapping(value="/admin_seasonboard_update_form")
	public String adminSeasonboardUpdateView(SeasonboardVO vo, Model model) {
		
		
		SeasonboardVO sboard = seasonboardService.getSeasonboard(vo);
		
		model.addAttribute("seasonboardVO", sboard);	
		
		return "admin/seasonboard/seasonboardUpdate";
	}
	

	@RequestMapping(value="/admin_seasonboard_update")
	public String adminseasonboardUpdate(@RequestParam(value="seasonboard_image") MultipartFile uploadFile,
					@RequestParam(value="nonmakeImg") String origImage,
					SeasonboardVO vo, HttpSession session) {
	
			String fileName = "";
			
		
			if (!uploadFile.isEmpty()) {  
				fileName = uploadFile.getOriginalFilename();
		
				vo.setImage1(fileName);
				vo.setImage2(fileName);
				vo.setImage3(fileName);
				vo.setImage4(fileName);
				vo.setImage5(fileName);
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/seasonboard_images/");
				System.out.println("�̹��� ���: " + image_path);
						
				try {
			
					File dest = new File(image_path + fileName);
					uploadFile.transferTo(dest);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			} else {
		
				vo.setImage1(origImage);
				vo.setImage2(origImage);
				vo.setImage3(origImage);
				vo.setImage4(origImage);
				vo.setImage5(origImage);
			}
			
			
			seasonboardService.updateSeasonboard(vo);
			
			return "redirect:admin_seasonboard_list";
		
	}	
	
	@PostMapping(value="admin_seasonboard_delete")
	public String adminSeasonboardDelete(@RequestParam(value="sseq")int sseq){
		
		seasonboardService.deleteSeasonboard(sseq);

		return "redirect:admin_seasonboard_list";
	}
	/*
	 * eventboard
	 */
	@RequestMapping(value = "/admin_eventboard_list")
	public String adminEventboardList(@RequestParam(value = "key", defaultValue = "") String subject, Criteria criteria,
			Model model) {

		

		
		List<EventboardVO> eList = eventboardService.ListWithPaging(criteria, subject);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = eventboardService.countEventboard(subject);
		pageMaker.setTotalCount(totalCount);
		model.addAttribute("eventboardList",eList);
		model.addAttribute("eventboardListSize", eList.size());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/eventboard/eventboardList";
	}
	
	@RequestMapping(value="/admin_eventboard_detail")
	public String admineventboardDetail(EventboardVO vo, Model model) {
		
		
		EventboardVO eBoard = eventboardService.getEventboard(vo);
		
		model.addAttribute("eventboardVO", eBoard);
		
		
		return "admin/eventboard/eventboardDetail";
	}
	@PostMapping(value = "/admin_eventboard_write_form")
	public String adminEventboardWriteView(Model model) {
		

		return "admin/eventboard/eventboardWrite";
	}
	

	@PostMapping(value="/admin_eventboard_write")
	public String adminEventWrite(@RequestParam(value="eventboard_image") MultipartFile uploadFile,
								    EventboardVO vo, HttpSession session,List<MultipartFile> file) {
			String fileName = "";
			
				fileName = uploadFile.getOriginalFilename();
		
				vo.setImage1(fileName);
				vo.setImage2(fileName);
				vo.setImage3(fileName);
				vo.setImage4(fileName);
				vo.setImage5(fileName);
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/eventboard_images/");
				System.out.println("�̹��� ���이미지경로: " + image_path);
						
				try {
					
					File dest = new File(image_path + fileName);
					uploadFile.transferTo(dest);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			
		
		eventboardService.insertEventboard(vo);
		
		return "redirect:admin_eventboard_list";
	}

	


	@PostMapping(value="/admin_eventboard_update_form")
	public String adminEVentboardUpdateView(EventboardVO vo, Model model) {
		
		
		EventboardVO eboard = eventboardService.getEventboard(vo);
		
		model.addAttribute("eventboardVO", eboard);	
		
		return "admin/eventboard/eventboardUpdate";
	}
	

	@RequestMapping(value="/admin_eventboard_update")
	public String adminEventboardUpdate(@RequestParam(value="eventboard_image") MultipartFile uploadFile,
					@RequestParam(value="nonmakeImg") String origImage,
					EventboardVO vo, HttpSession session) {
	
			String fileName = "";
			
		
			if (!uploadFile.isEmpty()) {  
				fileName = uploadFile.getOriginalFilename();
		
				vo.setImage1(fileName);
				vo.setImage2(fileName);
				vo.setImage3(fileName);
				vo.setImage4(fileName);
				vo.setImage5(fileName);
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/eventboard_images/");
				System.out.println("�̹��� ���: " + image_path);
						
				try {
			
					File dest = new File(image_path + fileName);
					uploadFile.transferTo(dest);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			} else {
		
				vo.setImage1(origImage);
				vo.setImage2(origImage);
				vo.setImage3(origImage);
				vo.setImage4(origImage);
				vo.setImage5(origImage);
			}
			
			
			eventboardService.updateEventboard(vo);
			
			return "redirect:admin_eventboard_list";
		
	}	
	
	@PostMapping(value="admin_eventboard_delete")
	public String adminmeventboardDelete(@RequestParam(value="eseq")int eseq){
		
		eventboardService.deleteEventboard(eseq);

		return "redirect:admin_eventboard_list";
	}
	/*
	 * comments
	 */
	/*
		@RequestMapping(value = "/admin_comments_list")
		public String adminCommentsList(@RequestParam(value = "key", defaultValue = "") String content, Criteria criteria,
				Model model) {
			
			
			List<CommentsVO> cList = commentsService.ListWithPaging(criteria, content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCriteria(criteria);
			int totalCount = commentsService.countComments(content);
			pageMaker.setTotalCount(totalCount);
			

			
			
			model.addAttribute("commentsList",cList);
			model.addAttribute("commentsListSize", cList.size());
			model.addAttribute("pageMaker", pageMaker);
			return "admin/comments/commentsList";
		}
		*/
	/*
		@RequestMapping(value="/admin_comments_detail")
		public String admincommentsDetail(CommentsVO vo, Model model) {
			
			
			CommentsVO cBoard = commentsService.getComments(vo);
			
			model.addAttribute("commentsVO", cBoard);
			
			
			return "admin/comments/commentsDetail";
	}*/
	
	
		@PostMapping(value="admin_comments_delete")
		public String adminmcommentsDelete(@RequestParam(value="com_seq")int com_seq){
			
			commentsService.deleteComments(com_seq);

			return "redirect:admin_comments_list";
		}
}

