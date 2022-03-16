package com.green.view;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.tnt.dto.EventVO;
import com.green.tnt.event.EventService;

import utils.Criteria;
import utils.PageMaker;


@Controller
public class EventController {
	
	
	@Autowired
	private EventService eventService;
	
	@GetMapping(value="/event")
	public String eventAction(Model model) {
		
	
		return "event-news/event";
	}
	
	
	@GetMapping(value="/event_list")
	public String eventListAction(Criteria criteria, Model model) {
		
		
		//Criteria criteria = new Criteria(1, 4);
		
		criteria.setRowsPerPage(4);
//		
		// 상품목록 조회
		List<EventVO> eventList = eventService.getListWithPaging(criteria);
			
		
		// 화면에 표시할 페이지버튼 정보 설정
		PageMaker pageMaker = new PageMaker();
		
		
		pageMaker.setCriteria(criteria);  // 현재 페이지와 페이지당 항목 수 정보 설정
		int totalCount = eventService.getCountEventList();
		pageMaker.setTotalCount(totalCount); // 정체 상품목록 갯수 설정 및 페이지 정보 초기화
		//criteria.setRowsPerPage(4);
		System.out.println("[EventList] pageMaker="+pageMaker);
						
		model.addAttribute("eventList", eventList);
		model.addAttribute("eventListSize", totalCount);
		model.addAttribute("pageMaker", pageMaker);
		//System.out.println(eventList.size());
		
		return "event-news/eventList";
	}
	
	
	@GetMapping(value="/event_detail")
	public String eventListAction(EventVO vo, Model model, @RequestParam("eseq") String eseq) {
	
	//List<EventVO> eventDetailList = eventService.listOrderById(vo);
		
		// 조회수 증가
		eventService.EventViewCount(eseq);//(eseq);

	
		// 화면에 츨력할 정보 생성
		//(1) 주문자 정보 생성
		EventVO eventDetailList = eventService.getSelectEventDetail(eseq);
		/*
		 * String subject = eventDetailList.getSubject(); String start_date
		 * =eventDetailList.getStart_date(); String end_date
		 * =eventDetailList.getEnd_date(); String name =eventDetailList.getName();
		 * Timestamp regdate =eventDetailList.getRegdate(); String image1
		 * =eventDetailList.getImage1(); String image2 =eventDetailList.getImage2();
		 * String image3 =eventDetailList.getImage3(); String image4
		 * =eventDetailList.getImage4(); String image5 =eventDetailList.getImage5();
		 * String content =eventDetailList.getContent();
		 */
	
		model.addAttribute("eventDetailList", eventDetailList);

	
	return "event-news/eventDetail";
}
	
	

}
