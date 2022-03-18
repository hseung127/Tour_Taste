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
<%@ include file="../header.jsp" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
      <!-- Base typography-->
      <section class="section section-sm section-first bg-default section-style-2 text-md-left">
        <div class="container">
          <div class="row row-50">

	           <div class="search-all-wrap">     
					
					<div class="searchKey" data-searchKey="${searchKey}">${searchKey}</div>
					<div class="search-title list">관리자 추천 관광지    
						<div class="search-total-count">
							총&nbsp;<span>${searchM1tListSize}</span>건 
	            		</div>
					</div>
				

					<c:forEach items="${searchM1tList}" var="m1tVO">
		            <ul class="search-list">
			            <li class="search-area">
				            <div class="search-txt-area">    
					                   
			                   	<div class="search-list-image">
							   		<img src="images/member1_t/${m1tVO.image1}" alt="" style="width:180px;height:120px; object-fit: cover;"/>
							   	</div> 
					            
					            <a class="search-list-tit" href="worker_tDetail?m1tseq=${m1tVO.m1tseq}">	
					            	<p>${m1tVO.subject}</p>
					           	</a>  
								
					            <div class="search-content">        
					            	<p>${m1tVO.content}</p> 
					            </div>

				            </div>
			            </li>
		            </ul>
		            </c:forEach>
	            
	            	<div class="search-page-area">
	            	<%@ include file="page_area.jsp" %>
	            	</div>
								
								
				</div>
			
			
				 
			
			
			
			</div>
          </div>
        </section>
        

        
        
		
    <%@ include file="../footer.jsp" %>   