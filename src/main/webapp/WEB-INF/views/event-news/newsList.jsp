<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
 
<div class="wrap_contView marTnon clfix">

	        <!-- 리스트 -->
	        
	        
	        <div class="box_leftType1">
	        <c:choose>
			    <c:when test="${newsListSize<=0}">
			    	<div class="total_check">
						<strong>등록된 소식이 없습니다.</strong>
					</div>
			    </c:when>
			<c:otherwise>
	        
	  
	            <div class="total_check checkBd">
	              
			<strong>총&nbsp;<span>${newsListSize}</span>건</strong>
	
	            </div>

				<c:forEach items="${newsList}" var="newsVO">
	            <ul class="list_board1">
		            <li class="bdr_nor">
			            <div class="area_txt">    
				                    
				            <a class="news-list-tit" href="news_detail?nseq=${newsVO.nseq}">	
				            	<strong class="tit">${newsVO.subject} </strong> 
				           	</a>    
				       
				            <div class="date">        
				            	<span><fmt:formatDate value="${newsVO.regdate}" pattern="yyyy.MM.dd"/></span>
				            </div>
				            
			            </div>
		            </li>
	            </ul>
	            </c:forEach>
	
	</c:otherwise>	
</c:choose>  
				<div class="page-area">
	            <%@ include file="page_area.jsp" %>
	            </div>
	            
	            
	        </div>
	        
	    </div>