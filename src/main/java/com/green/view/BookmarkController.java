package com.green.view;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.green.tnt.bookmark.BookmarkService;
import com.green.tnt.dto.BookmarkVO;


@Controller
@RequestMapping(value = "/ajax", produces = "application/json; charset=UTF-8")
public class BookmarkController {
	
	@Autowired BookmarkService bmservice;
	
	// 관리자 여행 게시판 즐겨찾기 추가
	@ResponseBody
	@RequestMapping("/insertM1tBM")
	public HashMap insertM1tBM(
			@RequestParam HashMap<String, Object> params, 
			HttpSession session, BookmarkVO vo) {
		System.out.println("insertM1tBM 입력 Parameter:");
		System.out.println("m1tseq="+params.get("m1tseq"));
		System.out.println("id="+params.get("id"));
		
		vo.setId(params.get("id").toString());
		vo.setM1tseq(Integer.parseInt(params.get("m1tseq").toString()));
		
		bmservice.insertM1tBM(vo);
		int newBseq = bmservice.getBM_currval();
		HashMap<String, Object> result = new HashMap<>();
		result.put("resultMessage", "성공");
		result.put("newBseq", newBseq);
		// 4. 성공했다면, 0000
		return result;
	}
	
	// 관리자 맛집 게시판 즐겨찾기 추가
	@ResponseBody
	@RequestMapping("/insertM1rBM")
	public HashMap insertM1rBM(
			@RequestParam HashMap<String, Object> params, 
			HttpSession session, BookmarkVO vo) {
		System.out.println("insertM1rBM 입력 Parameter:");
		System.out.println("m1rseq="+params.get("m1rseq"));
		System.out.println("id="+params.get("id"));
		
		vo.setId(params.get("id").toString());
		vo.setM1rseq(Integer.parseInt(params.get("m1rseq").toString()));
		
		bmservice.insertM1rBM(vo);
		int newBseq = bmservice.getBM_currval();
		HashMap<String, Object> result = new HashMap<>();
		result.put("resultMessage", "성공");
		result.put("newBseq", newBseq);
		// 4. 성공했다면, 0000
		return result;
	}
	
	// 관리자 여행 게시판 즐겨찾기 삭제
	@ResponseBody
	@RequestMapping("/deleteBM")
	public HashMap deleteBM(
			@RequestParam HashMap<String, Object> params, 
			HttpSession session, BookmarkVO vo) {

		
		bmservice.deleteBM(vo);
		
		HashMap<String, Object> result = new HashMap<>();
		result.put("resultMessage", "성공");
		
		return result;
	}
		

}
