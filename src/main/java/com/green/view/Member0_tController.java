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

import com.green.tnt.dto.Member0_tVO;
import com.green.tnt.dto.Member1_tVO;
import com.green.tnt.dto.MemberVO;
import com.green.tnt.member0_t.Member0_tService;
import com.green.tnt.member1_t.Member1_tService;

import utils.Criteria;
import utils.PageMaker;

@Controller
public class Member0_tController {
	
	@Autowired
	private Member0_tService m0tService;
	
	
	// ��� ����¡
	@RequestMapping(value="/member_tList")
	public String getMember0_tList(Member0_tVO vo, Model model, Criteria criteria) {
		
		List<Member0_tVO> member0tList = m0tService.getM0_tListPaging(criteria, vo);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = m0tService.countMember0_tList(vo);
		System.out.println("totalCount="+totalCount);
		pageMaker.setTotalCount(totalCount);
		System.out.println("pageMaker="+pageMaker);
		
		
		model.addAttribute("member0tList", member0tList);
		//model.addAttribute("member0tListSize", member0tList.size());
		model.addAttribute("member0tListSize", totalCount);
		model.addAttribute("pageMaker", pageMaker);
		
		return "member_t/member_tList";
	}
	
	@PostMapping(value="/member_tinsert_form")
	public String goMemberTourInsert(HttpSession session) {
		
		// (1) �α��� Ȯ��
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		// (2) �α����� �ȵǾ� ������ �α���
		if (loginUser == null) {
			return "member/login";
		} else {
			return "member_t/member_tInsert";
		}
		
	}
	
	@PostMapping(value="/member_tinsert")
	public String goMemberTourSave(Member0_tVO vo, HttpSession session) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "member/login";
		} else {
			vo.setName(loginUser.getName());
			
			m0tService.insertMember0_t(vo);
		
			return "redirect:member_tList";
		}
		
	}
	
	// �� ����
	@RequestMapping(value="/member_tDetail")
	public String member_tDetail(Member0_tVO vo, Model model) {
		
		Member0_tVO member0_t = m0tService.getM0_tDetail(vo);
		
		model.addAttribute("m0t", member0_t);
		
		return "member_t/member_tDetail";
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

