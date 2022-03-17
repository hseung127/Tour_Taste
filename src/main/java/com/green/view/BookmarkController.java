package com.green.view;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.green.tnt.bookmark.BookmarkService;
import com.green.tnt.dto.BookmarkVO;

@RestController
@RequestMapping(value = "/ajax", produces = "application/json; charset=UTF-8")
@Controller
public class BookmarkController {
	
	@Autowired BookmarkService bmservice;

	@RequestMapping("/insertM1tBM")
	public String insertM1tBM(
			@RequestParam HashMap<String, Object> params, 
			HttpSession session, BookmarkVO vo) {
		// 1. 회원, 게시글 시퀀스를 받음
		// 2. 서비스한테 1.을 넘겨줌
		String memsequence = "";
		/*
			1. session에서 memberSq
			2. 이걸로 북마크를 조회해서
			
			
			
		*/
		
		
		
		
		// 4. 성공했다면, 0000
		return "1234";
	}
	
	@RequestMapping("/comment")
	public Object commentControl() {
		
		// 1. 회원, 게시글 시퀀스, 작성 내용 등을 받음
		// 2. 서비스한테 1.을 넘겨줌
		// 3. 서비스가 받아서 로직 수행 ( 댓글 등록/삭제 )
		// 4. 성공했다면, 0000
		
		if ( true ) { 
			return "0000";
		}
		else {
			return "0001";
		}
	}
	
		
		
		

}
