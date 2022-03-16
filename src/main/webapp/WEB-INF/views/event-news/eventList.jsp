<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<ul class="event-list-section">

	<c:choose>
		    <c:when test="${eventListSize<=0}">
		    	<div class="total_check">
				<strong>등록된 상품이 없습니다.</strong>
				</div>
		    </c:when>
		    
			<c:otherwise>
			<div class="total_check">
				<strong>총&nbsp;<span>${eventListSize}</span>건</strong>
			</div>
		
			<c:forEach items="${eventList}" var="eventVO">		
				<li>
					<div class="event-link">
						<a href="event_detail?eseq=${eventVO.eseq}" class="event-list-img-link">
							<img src="images/event/${eventVO.image1}" alt="" class="event-list-img"> 
						</a> 
						<a href="event_detail?eseq=${eventVO.eseq}" class="event-list-subject">${eventVO.subject}</a> 
						<div class="event-list-date">${eventVO.start_date} ~ ${eventVO.end_date}</div>
					</div>
				</li>
			</c:forEach>
			
	</c:otherwise>	
</c:choose>  
	
</ul>
<%@ include file="page_area.jsp" %>

