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
		// ��ǰ��� ��ȸ
		List<EventVO> eventList = eventService.getListWithPaging(criteria);
			
		
		// ȭ�鿡 ǥ���� ��������ư ���� ����
		PageMaker pageMaker = new PageMaker();
		
		
		pageMaker.setCriteria(criteria);  // ���� �������� �������� �׸� �� ���� ����
		int totalCount = eventService.getCountEventList();
		pageMaker.setTotalCount(totalCount); // ��ü ��ǰ��� ���� ���� �� ������ ���� �ʱ�ȭ
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
		
		// ��ȸ�� ����
		eventService.EventViewCount(eseq);//(eseq);

	
		// ȭ�鿡 ������ ���� ����
		//(1) �ֹ��� ���� ����
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
