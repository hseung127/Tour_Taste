package com.green.view;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.tnt.dto.MemberVO;
import com.green.tnt.bookmark.BookmarkService;
import com.green.tnt.dto.BookmarkVO;
import com.green.tnt.dto.EventVO;
import com.green.tnt.dto.Member0_rVO;
import com.green.tnt.dto.Member1_rVO;
import com.green.tnt.dto.Member1_tVO;
import com.green.tnt.dto.NewsVO;
import com.green.tnt.dto.SeasonVO;
import com.green.tnt.event.EventService;
import com.green.tnt.member0_r.Member0_rService;
import com.green.tnt.member1_r.Member1_rService;
import com.green.tnt.member1_t.Member1_tService;
import com.green.tnt.news.NewsService;
import com.green.tnt.season.SeasonService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private SeasonService seasonService;
	@Autowired
	private Member1_tService m1tService;
	@Autowired
	private Member1_rService m1rService;
	@Autowired
	private Member0_rService m0rService;
	@Autowired
	private EventService eventService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private BookmarkService bookmarkService;
	
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String homeAction(Model model, BookmarkVO vo, HttpSession session) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		// 메인페이지 시즌테마
		List<SeasonVO> homeSeasonList =  seasonService.getHomeSeasonList();
		model.addAttribute("homeSeasonList", homeSeasonList);

		//System.out.println(homeSeasonList.toString());

		// 메인페이지 관리자 추천 관광지 
		List<Member1_tVO> homeMember1_tList =  m1tService.getHomeMember1_tList();
		model.addAttribute("homeM1tList", homeMember1_tList);

		//System.out.println(homeMember1_tList.toString());
		
		// 메인페이지 관리자 추천 맛집
		List<Member1_rVO> homeMember1_rList =  m1rService.getHomeMember1_rList();
		model.addAttribute("homeM1rList", homeMember1_rList);
		
		
		int[] homeM1rSeq = new int[4];
		int[] homeM1rCountBookmark = new int [4];
		int[] homeM1rBookmarkyn = new int[4];
		int bookmarkLoginCheck = 0; 
		/** 수정해야함 오류뜸*/
		for(int i=0; i<=3; i++) {
			Member1_rVO homeM1rBVO = homeMember1_rList.get(i);
			homeM1rSeq[i] = homeM1rBVO.getM1rseq(); 
			vo.setM1rseq(homeM1rSeq[i]);
			
			
			 List<BookmarkVO> homeCountM1rBookmark = bookmarkService.getCountM1rBookmark(vo);
			 //System.out.println("ī��Ʈ����Ʈ"+homeCountM1rBookmark);
			 BookmarkVO homeM1rCountBookmarkBVO = homeCountM1rBookmark.get(0);
			 homeM1rCountBookmark[i] = homeM1rCountBookmarkBVO.getM1rCount(); 
			 //System.out.println("��Ʈ"+homeM1rCountBookmark[i]);
			
		}
		
		
		if (loginUser != null) {  
			
			for(int i=0; i<=3; i++) {
				
				vo.setId(loginUser.getId()); 
				System.out.println(loginUser.getId());
				vo.setM1rseq(homeM1rSeq[i]); 
				System.out.println("vo"+vo);
				
				
				 List<BookmarkVO> M1rbookmarkyn = bookmarkService.M1rBookmarkyn(vo);
				
				
				 BookmarkVO M1rbookmarkynBVO = M1rbookmarkyn.get(0);
				 homeM1rBookmarkyn[i] = M1rbookmarkynBVO.getM1rBookmarkyn(); 
				 System.out.println("�α���yn"+homeM1rBookmarkyn[i]);
				 
				
			}
			
			bookmarkLoginCheck = 1;
			
			
		}else {
			
			for(int i=0; i<=3; i++) { 
				homeM1rBookmarkyn[i] = 0;
				//System.out.println("yn"+homeM1rBookmarkyn[i]); 
			}
			 
			bookmarkLoginCheck = 0;
		}
		

		model.addAttribute("homeM1rBookmarkyn", homeM1rBookmarkyn); 
		model.addAttribute("homeM1rCountBookmark", homeM1rCountBookmark); 
		model.addAttribute("bookmarkLoginCheck", bookmarkLoginCheck);
			 
		
		
		
		//메인페이지 회원 추천 맛집
		List<Member0_rVO> homeMember0_rList =  m0rService.getHomeMember0_rList();
		model.addAttribute("homeM0rList", homeMember0_rList);
		
		System.out.println(homeMember0_rList.toString());
		
		// 메인페이지 이벤트
		List<EventVO> homeEventList = eventService.getHomeEventList();
		model.addAttribute("homeEventList", homeEventList);
		
		//System.out.println(homeEventList.toString());
		
		// 메인페이지 큰 이벤트
		List<EventVO> bigHomeEventList = eventService.getBigHomeEventList();
		model.addAttribute("bigHomeEventList", bigHomeEventList);
		
		//System.out.println(bigHomeEventList.toString());
		
		
		// 메인페이지 소식
		List<NewsVO> homeNewsList = newsService.getHomeNewsList();
		model.addAttribute("homeNewsList", homeNewsList);
		
		System.out.println(homeNewsList.toString());

		return "index";
	}
	
	
	//메인페이지 이벤트-소식
	@GetMapping(value="/event-news")
	public String eventNewsAction(Model model, @RequestParam(value="tabNum") String tabNum) {
		
		model.addAttribute("tabNum", tabNum);
		
		return "event-news/event-news";
	}
	
	
	
	/*
	 * 메인페이지 관리자 추천 맛집 북마크
	 */
	@PostMapping(value="/insert_bookmark_m1r")
	public String insertM1rBookmark(BookmarkVO vo, Model model, HttpSession session, @RequestParam(value="m1rseq") String m1rseq, @RequestParam(value="index") String index) {
		

		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
	
		if (loginUser == null) {  
			return null;//"member/login";
		} else {
			vo.setId(loginUser.getId());
			vo.setM1rseq(Integer.parseInt(m1rseq));  
			
			
			
			int idx = Integer.parseInt(index);
	
			List<BookmarkVO> countBookmark = bookmarkService.getCountM1rBookmark(vo);
			model.addAttribute("m1rCountBookmark", countBookmark);
			System.out.println("ī���"+countBookmark);
			//int count1 = countBookmark[idx].;
			BookmarkVO arrCount1 = countBookmark.get(0);
			int count1 = arrCount1.getM1rCount();
			
			
		
			System.out.println("�߰�"+vo.getId()+vo.getM1rseq());
			bookmarkService.insertM1rBookmark(vo);
			
			model.addAttribute("m1rCountBookmark", countBookmark);
			
		
			List<BookmarkVO> countBookmarkUpdate = bookmarkService.getCountM1rBookmark(vo);
			model.addAttribute("m1rCountBookmarkUpdate", countBookmarkUpdate);
			

			BookmarkVO arrCount2 = countBookmarkUpdate.get(0);
			int count2 = arrCount2.getM1rCount();
			
			//System.out.println(count1);
			//System.out.println(count2);
			
			if(count1 == count2) { 
				
				return null;
			}else {
				
				model.addAttribute("idx", idx);
				
				return "bookmark/bookmarkFinish";
			}
			
			
			
			
		}

	}
	
	
	@GetMapping(value="/area")
	public String goarea(Model model) {
		
	
		return "area";
	}
	

	
	
	

}
