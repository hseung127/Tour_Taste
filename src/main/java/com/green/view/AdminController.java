package com.green.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	

	
	@RequestMapping(value = "/address")
	public String address(Model model) {

		return "admin/address/address";
	}
	@RequestMapping(value = "/ii")
	public String ii(Model model) {

		return "admin/member/ii";
	}

	/**
	 * newsboard
	 */

	/*게시판 조회 */
	@RequestMapping(value="admin_newsboard_get")
	public void adminNewsboardGet(Model model , Criteria criteria){
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
		
				vo.setImage1(fileName);
			
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/newsboard_images/");
				
						
				try {
					
					File dest = new File(image_path + fileName);
					uploadFile.transferTo(dest);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			
		
		newsboardService.insertNewsboard(vo);
		
		return "redirect:admin_newsboard_list";
	}
	// ck 업로드

	/*

		@RequestMapping(value = "NckUpload")
		public void postCKEditorImgUpload(HttpServletRequest req,
										  HttpServletResponse res,
										  @RequestParam MultipartFile upload) {
			
			
			// �옖�뜡 臾몄옄 �깮�꽦
			UUID uid = UUID.randomUUID();
			
			OutputStream out = null;
			PrintWriter printWriter = null;
					
			// �씤肄붾뵫
			res.setCharacterEncoding("utf-8");
			res.setContentType("text/html;charset=utf-8");
			
			try {
				
				String fileName = upload.getOriginalFilename();  // �뙆�씪 �씠由� 媛��졇�삤湲�
				byte[] bytes = upload.getBytes();
				
				// �뾽濡쒕뱶 寃쎈줈
				String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName;
				
				out = new FileOutputStream(new File(ckUploadPath));
				out.write(bytes);
				out.flush();  // out�뿉 ���옣�맂 �뜲�씠�꽣瑜� �쟾�넚�븯怨� 珥덇린�솕
				
				String callback = req.getParameter("CKEditorFuncNum");
				printWriter = res.getWriter();
				String fileUrl = "/ckUpload/" + uid + "_" + fileName;  // �옉�꽦�솕硫�
				
				// �뾽濡쒕뱶�떆 硫붿떆吏� 異쒕젰
				printWriter.println("<script type='text/javascript'>"
							+ "window.parent.CKEDITOR.tools.callFunction("
							+ callback+",'"+ fileUrl+"','�씠誘몄�瑜� �뾽濡쒕뱶�븯���뒿�땲�떎.')"
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
	public String adminNewsboardDetail(Model model,@ModelAttribute("criteria") Criteria criteria,int nseq) {

		
		NewsboardVO newsboard = newsboardService.getNewsboard(nseq);
		newsboardService.newsboardHit(nseq);
		
		System.out.println("page"+criteria.getPageNum()+"rows"+criteria.getRowsPerPage());
		model.addAttribute("newsboardVO", newsboard);
		model.addAttribute("pageNum",criteria.getPageNum());
		model.addAttribute("rowsPerPage",criteria.getRowsPerPage());

		return "admin/newsboard/newsboardDetail";
	}
	
	
	


	@PostMapping(value="/admin_newsboard_update_form")
	public String adminNewsboardUpdateView(NewsboardVO vo, Model model,int nseq,Criteria criteria) {
		
		
		NewsboardVO newsboard = newsboardService.getNewsboard(nseq);
		
		model.addAttribute("newsboardVO", newsboard);
		model.addAttribute("criteria",criteria);
		
		return "admin/newsboard/newsboardUpdate";
	}
	

	@RequestMapping(value="/admin_newsboard_update")
	public String adminNewsboardUpdate(@RequestParam(value="newsboard_image") MultipartFile uploadFile,
					@RequestParam(value="nonmakeImg") String origImage,
					NewsboardVO vo, HttpSession session,@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr) {
		
		
		UUID uid = UUID.randomUUID();



			String fileName = "";
			
		
			if (!uploadFile.isEmpty()) {  
				fileName = uploadFile.getOriginalFilename();
		
				vo.setImage1(fileName);
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/newsboard_images/");
				
						
				try {
			
					File dest = new File(image_path + fileName);
					uploadFile.transferTo(dest);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			} else {
		
				vo.setImage1(origImage);
			}
			
			
			newsboardService.updateNewsboard(vo);
			rttr.addAttribute("pageNum",criteria.getPageNum());
			rttr.addAttribute("rowsPerPage",criteria.getRowsPerPage());
			return "redirect:admin_newsboard_list";
		
	}	

	@PostMapping(value="admin_newsboard_delete")
	public String adminNewsboardDelete(@RequestParam(value="nseq")int nseq,
			@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr){
			
			
			newsboardService.deleteNewsboard(nseq);
			rttr.addAttribute("pageNum",criteria.getPageNum());
			rttr.addAttribute("rowsPerPage",criteria.getRowsPerPage());
			
			System.out.println("criteriaPage="+criteria.getPageNum()+"rows="+criteria.getRowsPerPage());
		return "redirect:admin_newsboard_list";
	}
	@PostMapping(value="admin_newsboard_ndelete")
	public String NewsboarNdelete(@RequestParam(value="nseq") int[]nseq,
			@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr) {
		
		for(int i=0; i<nseq.length; i++) {
			newsboardService.deleteNewsboard(nseq[i]);
		}
		rttr.addAttribute("pageNum",criteria.getPageNum());
		rttr.addAttribute("rowsPerPage",criteria.getRowsPerPage());
		return "redirect:admin_newsboard_list";
	}

	
	
	/**
	 *  member0 r board
	 */
	@RequestMapping(value = "/admin_member0_rboard_list")
	public String adminmember0_rboardList(Criteria criteria,
			Model model) {


		List<Member0_rboardVO> member0_rList = member0_rboardService.ListWithPaging(criteria);

	
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = member0_rboardService.countMember0_rboard(criteria);
		pageMaker.setTotalCount(totalCount);

		model.addAttribute("member0_rboardList", member0_rList);
		model.addAttribute("member0_rboardListSize", member0_rList.size());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/member0_rboard/member0_rboardList";
	}
	
	
	
	@RequestMapping(value="/admin_member0_rboard_detail")
	public String adminmember0_rboardDetail(Model model,@ModelAttribute("criteria")Criteria criteria,int m0rseq) {

		Member0_rboardVO member0_rboard = member0_rboardService.getMember0_rboard(m0rseq);
		member0_rboardService.member0_rboardHit(m0rseq);
		
		
		System.out.println("page"+criteria.getPageNum()+"rows"+criteria.getRowsPerPage());
		model.addAttribute("member0_rboardVO", member0_rboard);
		model.addAttribute("pageNum",criteria.getPageNum());
		model.addAttribute("rowsPerPage",criteria.getRowsPerPage());

		return "admin/member0_rboard/member0_rboardDetail";
	}
	
	@PostMapping(value="admin_member0_rboard_delete")
	public String adminmMember0_rboardDelete(@RequestParam(value="m0rseq")int m0rseq,
			@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr){
		
		member0_rboardService.deletemember0_rboard(m0rseq);
		rttr.addAttribute("pageNum",criteria.getPageNum());
		rttr.addAttribute("rowsPerPage",criteria.getRowsPerPage());
		return "redirect:admin_member0_rboard_list";
	}
	
	@PostMapping(value="admin_member0_rboard_m0rdelete")
	public String member0_rboardSdelete(@RequestParam(value="m0rseq") int[]m0rseq	,
			@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr) {
		
		for(int i=0; i<m0rseq.length; i++) {
			member0_rboardService.deletemember0_rboard(m0rseq[i]);
		}
		rttr.addAttribute("pageNum",criteria.getPageNum());
		rttr.addAttribute("rowsPerPage",criteria.getRowsPerPage());
		return "redirect:admin_member0_rboard_list";
	}
	
	/*
	 * member0 tboard
	 */
	@RequestMapping(value = "/admin_member0_tboard_list")
	public String adminmember0_tboardList(Criteria criteria,
			Model model) {


		List<Member0_tboardVO> member0_tList = member0_tboardService.ListWithPaging(criteria);

	
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = member0_tboardService.countMember0_tboard(criteria);
		pageMaker.setTotalCount(totalCount);

		model.addAttribute("member0_tboardList", member0_tList);
		model.addAttribute("member0_tboardListSize", member0_tList.size());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/member0_tboard/member0_tboardList";
	}
	
	@RequestMapping(value="/admin_member0_tboard_detail")
	public String adminmember0_tboardDetail(Model model,@ModelAttribute("criteria")Criteria criteria,int m0tseq) {

		Member0_tboardVO member0_tboard = member0_tboardService.getMember0_tboard(m0tseq);
		member0_tboardService.member0_tboardHit(m0tseq);
		
		
		System.out.println("page"+criteria.getPageNum()+"rows"+criteria.getRowsPerPage());
		model.addAttribute("member0_tboardVO", member0_tboard);
		model.addAttribute("pageNum",criteria.getPageNum());
		model.addAttribute("rowsPerPage",criteria.getRowsPerPage());
		return "admin/member0_tboard/member0_tboardDetail";
	}
	@PostMapping(value="admin_member0_tboard_delete")
	public String adminmMember0_tboardDelete(@RequestParam(value="m0tseq")int m0tseq, 
			@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr){
		
		member0_tboardService.deletemember0_tboard(m0tseq);
		rttr.addAttribute("pageNum",criteria.getPageNum());
		rttr.addAttribute("rowsPerPage",criteria.getRowsPerPage());
		return "redirect:admin_member0_tboard_list";
	}
	
	@PostMapping(value="admin_member0_tboard_m0tdelete")
	public String member0_tboardm0tdelete(@RequestParam(value="m0tseq") int[]m0tseq	,
			@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr) {
		
		for(int i=0; i<m0tseq.length; i++) {
			member0_tboardService.deletemember0_tboard(m0tseq[i]);
		}

		rttr.addAttribute("pageNum",criteria.getPageNum());
		rttr.addAttribute("rowsPerPage",criteria.getRowsPerPage());
		return "redirect:admin_member0_tboard_list";
	}
	
	/*
	 * member1 rboard
	 */
	@RequestMapping(value = "/admin_member1_rboard_list")
	public String adminmember1_rboardList(Criteria criteria,
			Model model) {


		List<Member1_rboardVO> member1_rList = member1_rboardService.ListWithPaging(criteria);

	
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = member1_rboardService.countMember1_rboard(criteria);
		pageMaker.setTotalCount(totalCount);

		model.addAttribute("member1_rboardList", member1_rList);
		model.addAttribute("member1_rboardListSize", member1_rList.size());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/member1_rboard/member1_rboardList";
	}
	
	@RequestMapping(value="/admin_member1_rboard_detail")
	public String adminmember1_rboardDetail(Model model,@ModelAttribute("criteria")Criteria criteria,int m1rseq) {

		Member1_rboardVO member1_rboard = member1_rboardService.getMember1_rboard(m1rseq);
		member1_rboardService.member1_rboardHit(m1rseq);
		
		
		
		System.out.println("page"+criteria.getPageNum()+"rows"+criteria.getRowsPerPage());
		model.addAttribute("member1_rboardVO", member1_rboard);
		model.addAttribute("pageNum",criteria.getPageNum());
		model.addAttribute("rowsPerPage",criteria.getRowsPerPage());

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
	
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/member1_rboard_images/");
				System.out.println("占싱뱄옙占쏙옙 占쏙옙占쎌씠誘몄�寃쎈줈: " + image_path);
						
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
	public String adminmember1_rboardUpdateView(Member1_rboardVO vo, Model model,int m1rseq, Criteria criteria) {
		
		
		Member1_rboardVO m1rboard = member1_rboardService.getMember1_rboard(m1rseq);
		
		model.addAttribute("member1_rboardVO", m1rboard);	
		model.addAttribute("criteria",criteria);
		return "admin/member1_rboard/member1_rboardUpdate";
	}
	

	@RequestMapping(value="/admin_member1_rboard_update")
	public String adminMember1_rboardUpdate(@RequestParam(value="member1_rboard_image") MultipartFile uploadFile,
					@RequestParam(value="nonmakeImg") String origImage,
					Member1_rboardVO vo, HttpSession session,@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr) {
	
			String fileName = "";
			
		
			if (!uploadFile.isEmpty()) {  
				fileName = uploadFile.getOriginalFilename();
		
				vo.setImage1(fileName);
	
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/member1_rboard_images/");
				System.out.println("占싱뱄옙占쏙옙 占쏙옙占�: " + image_path);
						
				try {
			
					File dest = new File(image_path + fileName);
					uploadFile.transferTo(dest);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			} else {
		
				vo.setImage1(origImage);

			}
			member1_rboardService.updateMember1_rboard(vo);
			rttr.addAttribute("pageNum",criteria.getPageNum());
			rttr.addAttribute("rowsPerPage",criteria.getRowsPerPage());
			
			
			return "redirect:admin_member1_rboard_list";
	}
	@PostMapping(value="admin_member1_rboard_delete")
	public String adminmMember1_rboardDelete(@RequestParam(value="m1rseq")int m1rseq,
			@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr){
		
		member1_rboardService.deletemember1_rboard(m1rseq);
		rttr.addAttribute("pageNum",criteria.getPageNum());
		rttr.addAttribute("rowPerPage",criteria.getRowsPerPage());
		return "redirect:admin_member1_rboard_list";
	}
	@PostMapping(value="admin_member1_rboard_m1rdelete")
	public String member1_rboardSdelete(@RequestParam(value="m1rseq") int[]m1rseq,
			@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr) {
		
		for(int i=0; i<m1rseq.length; i++) {
			member1_rboardService.deletemember1_rboard(m1rseq[i]);
		}
		rttr.addAttribute("pageNum",criteria.getPageNum());
		rttr.addAttribute("rowsPerPage",criteria.getRowsPerPage());
		return "redirect:admin_member1_rboard_list";
	}
	/*
	 * member1 tboard
	 */
	@RequestMapping(value = "/admin_member1_tboard_list")
	public String adminmember1_tboardList(Criteria criteria,
			Model model) {


		List<Member1_tboardVO> member1_tList = member1_tboardService.ListWithPaging(criteria);

	
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = member1_tboardService.countMember1_tboard(criteria);
		pageMaker.setTotalCount(totalCount);

		model.addAttribute("member1_tboardList", member1_tList);
		model.addAttribute("member1_tboardListSize", member1_tList.size());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/member1_tboard/member1_tboardList";
	}
	
	@RequestMapping(value="/admin_member1_tboard_detail")
	public String adminMember1_tboardDetail( Model model,int m1tseq,@ModelAttribute("criteria") Criteria criteria) {
		Member1_tboardVO m1tBoard = member1_tboardService.getMember1_tboard(m1tseq);
		member1_tboardService.member1_tboardHit(m1tseq);
		
		System.out.println("page"+criteria.getPageNum()+"rows"+criteria.getRowsPerPage());
		model.addAttribute("member1_tboardVO", m1tBoard);
		model.addAttribute("pageNum",criteria.getPageNum());
		model.addAttribute("rowsPerPage",criteria.getRowsPerPage());
		
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
	
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/member1_tboard_images/");
				System.out.println("占싱뱄옙占쏙옙 占쏙옙占쎌씠誘몄�寃쎈줈: " + image_path);
						
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
	public String adminmember1_tboardUpdateView(Member1_tboardVO vo, Model model,int m1tseq,Criteria criteria) {
		
		
		Member1_tboardVO m1tboard = member1_tboardService.getMember1_tboard(m1tseq);
		
		model.addAttribute("member1_tboardVO", m1tboard);	
		model.addAttribute("criteria",criteria);
		return "admin/member1_tboard/member1_tboardUpdate";
	}
	

	@RequestMapping(value="/admin_member1_tboard_update")
	public String adminMember1_tboardUpdate(@RequestParam(value="member1_tboard_image") MultipartFile uploadFile,
					@RequestParam(value="nonmakeImg") String origImage,
					Member1_tboardVO vo, HttpSession session,@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr) {
	
			String fileName = "";
			
		
			if (!uploadFile.isEmpty()) {  
				fileName = uploadFile.getOriginalFilename();
		
				vo.setImage1(fileName);
	
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/member1_tboard_images/");
				System.out.println("占싱뱄옙占쏙옙 占쏙옙占�: " + image_path);
						
				try {
			
					File dest = new File(image_path + fileName);
					uploadFile.transferTo(dest);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			} else {
		
				vo.setImage1(origImage);

			}
			
			
			member1_tboardService.updateMember1_tboard(vo);
			rttr.addAttribute("pageNum",criteria.getPageNum());
			rttr.addAttribute("rowsPerPage",criteria.getRowsPerPage());
			return "redirect:admin_member1_tboard_list";
	}
	
	@PostMapping(value="admin_member1_tboard_delete")
	public String adminmMember1_tboardDelete(@RequestParam(value="m1tseq")int m1tseq, 
			@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr){
		
		member1_tboardService.deletemember1_tboard(m1tseq);
		rttr.addAttribute("pageNum",criteria.getPageNum());
		rttr.addAttribute("rowsPerPage",criteria.getRowsPerPage());
		return "redirect:admin_member1_tboard_list";
	}
	
	@PostMapping(value="admin_member1_tboard_m1tdelete")
	public String member1_tboardSdelete(@RequestParam(value="m1tseq") int[]m1tseq	,
			@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr) {
		
		for(int i=0; i<m1tseq.length; i++) {
			member1_tboardService.deletemember1_tboard(m1tseq[i]);
		}
		rttr.addAttribute("pageNum",criteria.getPageNum());
		rttr.addAttribute("rowsPerPage",criteria.getRowsPerPage());
		return "redirect:admin_member1_tboard_list";
	}
	
	
	/*
	 * seasonboard
	 */
	@RequestMapping(value = "/admin_seasonboard_list")
	public String adminseasonboardList(Criteria criteria,
			Model model) {


		List<SeasonboardVO> seasonList = seasonboardService.ListWithPaging(criteria);

	
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = seasonboardService.countSeasonboard(criteria);
		pageMaker.setTotalCount(totalCount);

		model.addAttribute("seasonboardList", seasonList);
		model.addAttribute("seasonboardListSize", seasonList.size());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/seasonboard/seasonboardList";
	}
	
	@RequestMapping(value="/admin_seasonboard_detail")
	public String adminSeasonboardDetail(Model model,int sseq,@ModelAttribute("criteria")Criteria criteria) {
		
		SeasonboardVO sBoard = seasonboardService.getSeasonboard(sseq);
		seasonboardService.seasonboardHit(sseq);
		
		
		System.out.println("page"+criteria.getPageNum()+"rows"+criteria.getRowsPerPage());
		model.addAttribute("pageNum",criteria.getPageNum());
		model.addAttribute("rowsPerPage",criteria.getRowsPerPage());
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
		
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/seasonboard_images/");
				System.out.println("占싱뱄옙占쏙옙 占쏙옙占쎌씠誘몄�寃쎈줈: " + image_path);
						
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
	public String adminSeasonboardUpdateView(SeasonboardVO vo, Model model,int sseq,Criteria criteria) {
		
		
		SeasonboardVO sboard = seasonboardService.getSeasonboard(sseq);
		
		model.addAttribute("seasonboardVO", sboard);	
		model.addAttribute("criteria",criteria);
		return "admin/seasonboard/seasonboardUpdate";
	}
	

	@RequestMapping(value="/admin_seasonboard_update")
	public String adminseasonboardUpdate(@RequestParam(value="seasonboard_image") MultipartFile uploadFile,
					@RequestParam(value="nonmakeImg") String origImage,
					SeasonboardVO vo, HttpSession session,@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr) {
	
			String fileName = "";
			
		
			if (!uploadFile.isEmpty()) {  
				fileName = uploadFile.getOriginalFilename();
		
				vo.setImage1(fileName);
				vo.setBannerimg(fileName);
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/seasonboard_images/");
				System.out.println("占싱뱄옙占쏙옙 占쏙옙占�: " + image_path);
						
				try {
			
					File dest = new File(image_path + fileName);
					uploadFile.transferTo(dest);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			} else {
		
				vo.setImage1(origImage);
				vo.setBannerimg(fileName);
			}
			
			rttr.addAttribute("pageNum",criteria.getPageNum());
			rttr.addAttribute("rowsPerPage",criteria.getRowsPerPage());
			seasonboardService.updateSeasonboard(vo);
			
			return "redirect:admin_seasonboard_list";
		
	}	
	
	@PostMapping(value="admin_seasonboard_delete")
	public String adminSeasonboardDelete(@RequestParam(value="sseq")int sseq, 
			@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr){
		
		seasonboardService.deleteSeasonboard(sseq);
		rttr.addAttribute("pageNum",criteria.getPageNum());
		rttr.addAttribute("rowsPerPage",criteria.getRowsPerPage());
		return "redirect:admin_seasonboard_list";
	}
	
	@PostMapping(value="admin_seasonboard_sdelete")
	public String seasonboardSdelete(@RequestParam(value="sseq") int[]sseq,
			@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr) {
		
		
		for(int i=0; i<sseq.length; i++) {
			seasonboardService.deleteSeasonboard(sseq[i]);
		}
		rttr.addAttribute("pageNum",criteria.getPageNum());
		rttr.addAttribute("rowsPerPage",criteria.getRowsPerPage());
		return "redirect:admin_seasonboard_list";
	}
	/*
	 * eventboard
	 */
	@RequestMapping(value = "/admin_eventboard_list")
	public String admineventboardList(Criteria criteria,
			Model model) {


		List<EventboardVO> eventList = eventboardService.ListWithPaging(criteria);

	
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = eventboardService.countEventboard(criteria);
		pageMaker.setTotalCount(totalCount);

		model.addAttribute("eventboardList", eventList);
		model.addAttribute("eventboardListSize", eventList.size());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/eventboard/eventboardList";
	}
	
	@RequestMapping(value="/admin_eventboard_detail")
	public String admineventboardDetail(Model model,@ModelAttribute("criteria")Criteria criteria,int eseq) {

		
		EventboardVO eventboard = eventboardService.getEventboard(eseq);
		eventboardService.eventboardHit(eseq);
		
		
		System.out.println("page"+criteria.getPageNum()+"rows"+criteria.getRowsPerPage());
		model.addAttribute("eventboardVO", eventboard);
		model.addAttribute("pageNum",criteria.getPageNum());
		model.addAttribute("rowsPerPage",criteria.getRowsPerPage());
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
	
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/eventboard_images/");
		
						
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
	public String adminEVentboardUpdateView(EventboardVO vo, Model model,int eseq,Criteria criteria) {
		
		
		EventboardVO eboard = eventboardService.getEventboard(eseq);
		
		model.addAttribute("eventboardVO", eboard);	
		model.addAttribute("criteria",criteria);
		return "admin/eventboard/eventboardUpdate";
	}
	

	@RequestMapping(value="/admin_eventboard_update")
	public String adminEventboardUpdate(@RequestParam(value="eventboard_image") MultipartFile uploadFile,
					@RequestParam(value="nonmakeImg") String origImage,
					EventboardVO vo, HttpSession session,@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr) {
	
			String fileName = "";
			
		
			if (!uploadFile.isEmpty()) {  
				fileName = uploadFile.getOriginalFilename();
		
				vo.setImage1(fileName);
	
				
			
				String image_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/eventboard_images/");
				System.out.println(" " + image_path);
						
				try {
			
					File dest = new File(image_path + fileName);
					uploadFile.transferTo(dest);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			} else {
		
				vo.setImage1(origImage);

			}
			
			rttr.addAttribute("pageNum",criteria.getPageNum());
			rttr.addAttribute("rowsPerPage",criteria.getRowsPerPage());
			eventboardService.updateEventboard(vo);
			
			return "redirect:admin_eventboard_list";
		
	}	
	
	@PostMapping(value="admin_eventboard_delete")
	public String adminmeventboardDelete(@RequestParam(value="eseq")int eseq, 
			@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr){
		
		eventboardService.deleteEventboard(eseq);
		rttr.addAttribute("pageNum",criteria.getPageNum());
		rttr.addAttribute("rowPerPage",criteria.getRowsPerPage());

		return "redirect:admin_eventboard_list";
	}
	@PostMapping(value="admin_eventboard_edelete")
	public String eventboardSdelete(@RequestParam(value="eseq") int[]eseq,
			@ModelAttribute("criteria") Criteria criteria,RedirectAttributes rttr) {
		
		for(int i=0; i<eseq.length; i++) {
			eventboardService.deleteEventboard(eseq[i]);
		}

		rttr.addAttribute("pageNum",criteria.getPageNum());
		rttr.addAttribute("rowsPerPage",criteria.getRowsPerPage());
		return "redirect:admin_eventboard_list";
	}

}

