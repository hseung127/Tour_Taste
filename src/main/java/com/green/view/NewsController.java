package com.green.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.green.tnt.dto.EventVO;
import com.green.tnt.dto.NewsVO;
import com.green.tnt.event.EventService;
import com.green.tnt.news.NewsService;

import utils.Criteria;
import utils.PageMaker;

@Controller
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	@GetMapping("/news_list") 
	public String newsListAction(Criteria criteria, Model model) {
			
		
		criteria.setRowsPerPage(10);
		// 상품목록 조회
		List<NewsVO> newsList = newsService.getListWithPaging(criteria);
						
		// 화면에 표시할 페이지버튼 정보 설정
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);  // 현재 페이지와 페이지당 항목 수 정보 설정
		int totalCount = newsService.getCountNewsList();
		pageMaker.setTotalCount(totalCount); // 정체 상품목록 갯수 설정 및 페이지 정보 초기화
		System.out.println("[NewsList] pageMaker="+pageMaker);
						
		model.addAttribute("newsList", newsList);
		model.addAttribute("newsListSize", totalCount);
		model.addAttribute("pageMaker", pageMaker);
				
		
		return "event-news/newsList"; 
	}


}
