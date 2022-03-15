package com.green.view;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.green.tnt.dto.Member0_rVO;
import com.green.tnt.dto.Member0_tVO;
import com.green.tnt.dto.Member1_tVO;
import com.green.tnt.dto.MemberVO;
import com.green.tnt.member0_r.Member0_rService;
import com.green.tnt.member0_t.Member0_tService;
import com.green.tnt.member1_t.Member1_tService;

import utils.Criteria;
import utils.PageMaker;

@Controller
public class Member0_rController {
	
	@Autowired
	private Member0_rService m0rService;
	
	
	// ��� ����¡
	@RequestMapping(value="/member_rList")
	public String getMember0_rList(Member0_rVO vo, Model model, Criteria criteria) {
		
		List<Member0_rVO> member0rList = m0rService.getM0_rListPaging(criteria, vo);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = m0rService.countMember0_rList(vo);
		System.out.println("totalCount="+totalCount);
		pageMaker.setTotalCount(totalCount);
		System.out.println("pageMaker="+pageMaker);
		
		
		model.addAttribute("member0rList", member0rList);
		//model.addAttribute("member0rListSize", member0rList.size());
		model.addAttribute("member0rListSize", totalCount);
		model.addAttribute("pageMaker", pageMaker);
		
		return "member_r/member_rList";
	}
	
	@PostMapping(value="/member_rinsert_form")
	public String goMemberRestaurantInsert(HttpSession session) {
		
		// (1) �α��� Ȯ��
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		// (2) �α����� �ȵǾ� ������ �α���
		if (loginUser == null) {
			return "member/login";
		} else {
			return "member_r/member_rInsert";
		}
		
	}
	
	@PostMapping(value="/member_rinsert")
	public String goMemberRestaurantSave(Member0_rVO vo, HttpSession session) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "member/login";
		} else {
			vo.setName(loginUser.getName());
			
			m0rService.insertMember0_r(vo);
		
			return "redirect:member_rList";
		}
		
	}
	
	// �� ����
	@RequestMapping(value="/member_rDetail")
	public String member_rDetail(Member0_rVO vo, Model model) {
		
		Member0_rVO member0_r = m0rService.getM0_rDetail(vo);
		
		model.addAttribute("m0r", member0_r);
		
		return "member_r/member_rDetail";
	}
	/*//�̹��� ���ε�
	@RequestMapping(value="/mine/imageUpload.do", method = RequestMethod.POST) 
	public void imageUpload(HttpServletRequest request, 
			HttpServletResponse response, MultipartHttpServletRequest multiFile , 
			@RequestParam MultipartFile upload) throws Exception{ 
		
		// ���� ���� ���� 
		UUID uid = UUID.randomUUID(); 
		
		OutputStream out = null; 
		PrintWriter printWriter = null; 
		
		//���ڵ� 
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8"); 
		
		try{ 
			//���� �̸� �������� 
			String fileName = upload.getOriginalFilename(); 
			byte[] bytes = upload.getBytes(); 
			
			//�̹��� ��� ���� 
			String path = "D:/spring-workspace/TnT-0305/src/main/webapp/WEB-INF/resources/images";// fileDir�� ���� ������ �׳� �̹��� ��� �������ָ� �ȴ�. 
			String ckUploadPath = path + uid + "_" + fileName; 
			File folder = new File(path); 
			
			//�ش� ���丮 Ȯ�� 
			if(!folder.exists()){ 
				try{ folder.mkdirs(); // ���� ���� 
				}catch(Exception e){ 
					e.getStackTrace(); 
					} 
				} 
			out = new FileOutputStream(new File(ckUploadPath)); 
			out.write(bytes); 
			out.flush(); // outputStram�� ����� �����͸� �����ϰ� �ʱ�ȭ 
			
			String callback = request.getParameter("CKEditorFuncNum"); 
			printWriter = response.getWriter(); 
			String fileUrl = "/mine/ckImgSubmit.do?uid=" + uid + "&fileName=" + fileName; // �ۼ�ȭ�� 
			
			// ���ε�� �޽��� ��� 
			printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}"); 
			printWriter.flush(); 
				
			}catch(IOException e){ 
				e.printStackTrace(); 
			} finally { 
				try { 
					if(out != null) { out.close(); } 
					if(printWriter != null) { printWriter.close(); } 
					} catch(IOException e) { e.printStackTrace(); } 
				} 
		return; 
				
	}
	
	@RequestMapping(value="/mine/ckImgSubmit.do") 
	public void ckSubmit(@RequestParam(value="uid") String uid 
			, @RequestParam(value="fileName") String fileName 
			, HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{ 
		
		//������ ����� �̹��� ��� 
		String path = "D:/spring-workspace/TnT-0305/src/main/webapp/WEB-INF/resources/images";
		
		String sDirPath = path + uid + "_" + fileName;
		
		File imgFile = new File(sDirPath); 
		
		//���� �̹��� ã�� ���ϴ� ��� ����ó���� �� �̹��� ������ �����Ѵ�. 
		if(imgFile.isFile()){ 
			byte[] buf = new byte[1024]; 
			int readByte = 0; 
			int length = 0; 
			byte[] imgBuf = null;
			
			FileInputStream fileInputStream = null; 
			ByteArrayOutputStream outputStream = null; 
			ServletOutputStream out = null; 
			
			try{ 
				fileInputStream = new FileInputStream(imgFile); 
				outputStream = new ByteArrayOutputStream(); 
				out = response.getOutputStream(); 
				
				while((readByte = fileInputStream.read(buf)) != -1){ 
					outputStream.write(buf, 0, readByte); 
				} 
				
				imgBuf = outputStream.toByteArray(); 
				length = imgBuf.length; 
				out.write(imgBuf, 0, length); 
				out.flush(); 
				
			}catch(IOException e){ 
				e.printStackTrace(); 
			}finally { 
				outputStream.close(); 
				fileInputStream.close(); 
				out.close();
			} 
			
		}
	}*/

	
}

