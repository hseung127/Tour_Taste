<link rel="stylesheet" href="css_gusuk/common.css">
<link rel="stylesheet" href="css_gusuk/main.css">
<link rel="stylesheet" href="css_gusuk/swiper.min.css">

<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Roboto:100,300,300i,400,500,600,700,900%7CRaleway:500">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/fonts.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/style2.css">  
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.jsp" %> 
  
      
      <!-- Base typography-->
      <section class="section section-sm section-first bg-default section-style-2 text-md-left">
        <div class="container">
          <div class="row row-50">
			<div class="allWrap">    
	            <div class="title-content">  
	            
	            	<a href="event-news?tabNum=1"><div class="tit-go-list"> <span class="tit-go-list-txt">&lt;&nbsp;이벤트</span></div></a>
	            	<div class="top-title">${eventDetailList.subject}</div>
	            	<div class="title-date">${eventDetailList.start_date} - ${eventDetailList.end_date}</div>
	            	<div class="post-area">
		            	<div class="post-area-left"><span>조회수 ${eventDetailList.view_count}</span></div>
		            	<div class="post-area-right"><span>${eventDetailList.name} | 
		            	<fmt:formatDate value="${eventDetailList.regdate}" pattern="yyyy.MM.dd"/></span></div>
	            	</div>
	            	
	            </div>  
	            
				<div class="detail-content">
		            <div class="detail-image">
		            	<img src="images/event/${eventDetailList.image1}" alt="">
		            </div>
		            <div class="detail-image">
		            	<img src="images/event/${eventDetailList.image2}" alt="">
		            </div>
		            <div class="detail-image">
		            	<img src="images/event/${eventDetailList.image3}" alt="" >
		            </div>
		            <div class="detail-image">
		            	<img src="images/event/${eventDetailList.image4}" alt="" >
		            </div>
		            <div class="detail-image" >
		            	<img src="images/event/${eventDetailList.image5}" alt="" >
		            </div>
		            <div class="detail-content-txt" >
		            	${newsDetailList.content}
		            </div>
		    
		        </div> 
		        
	        	<div class="end-text"> ※ 위 정보는 2022년 2월에 작성된 정보로, 이후 변경될 수 있으니 여행 하시기 전에 반드시 확인하시기 바랍니다.<br>
					※ 이 기사에 사용된 텍스트, 사진, 동영상 등의 정보는 한국관광공사가 저작권을 보유하고 있으므로 기사의 무단 사용을 금합니다.
				</div> 
				<div class="end-content">
					담당부서 : 이벤트마케팅팀 &nbsp;등록 및 수정문의 : 012-345-6789
				</div>
					
			</div>
          </div>
        </div>
      </section>
	
    
      <!-- Bottom Banner--><!-- a class="section section-banner" href="https://www.templatemonster.com/intense-multipurpose-html-template.html" style="background-image: url(images/banner/background-03-1920x310.jpg); background-image: -webkit-image-set( url(images/banner/background-03-1920x310.jpg) 1x, url(images/banner/background-03-3840x620.jpg) 2x )"><img src="images/banner/foreground-03-1600x310.png" srcset="images/banner/foreground-03-1600x310.png 1x, images/banner/foreground-03-3200x620.png 2x" alt="" width="1600" height="310"></a>  -->
      <%@ include file="../footer.jsp" %>   