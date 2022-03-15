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
		// ��ǰ��� ��ȸ
		List<NewsVO> newsList = newsService.getListWithPaging(criteria);
						
		// ȭ�鿡 ǥ���� ��������ư ���� ����
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);  // ���� �������� �������� �׸� �� ���� ����
		int totalCount = newsService.getCountNewsList();
		pageMaker.setTotalCount(totalCount); // ��ü ��ǰ��� ���� ���� �� ������ ���� �ʱ�ȭ
		System.out.println("[NewsList] pageMaker="+pageMaker);
						
		model.addAttribute("newsList", newsList);
		model.addAttribute("newsListSize", totalCount);
		model.addAttribute("pageMaker", pageMaker);
				
		
		return "event-news/newsList"; 
	}


}
