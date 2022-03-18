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
	           		
	           		<div class="totalCountData">
	           			<div>${searchM1tListSize}</div>
	           			<div>${searchM1rListSize}</div>
	           			<div>${searchM0tListSize}</div>
	           			<div>${searchM0rListSize}</div>
	           		</div>
	           		
					<div class="searchKey" data-searchKey="${searchKey}">${searchKey}</div>
				
								<div class="searchBoard 0">
									<div class="search-title">관리자 추천 관광지
										<a class="search-go-list" href="worker_tList"> 더보기 </a> 
									</div>
									
									<c:forEach items="${searchM1tList}" var="m1tVO">
						            <ul class="search-list">
							            <li>
								            <div class="search-txt-area"> 
								            
								            	<div class="search-list-image">
							   						<img src="images/member1_t/${m1tVO.image1}" alt="" style="width:180px;height:120px; object-fit: cover;"/>
							   					</div>  
								            	 
									            <a class="search-list-tit" href="worker_tDetail?m1tseq=${m1tVO.m1tseq}">	
									            	<p>${m1tVO.subject} </p>
									           	</a>    
									       
									            <div class="search-content">        
									            	<p>${m1tVO.content}</p>    
									            </div>
									            
								            </div>
							            </li>
						            </ul>
						            </c:forEach>
						            <a href="searchM1tList?key=${searchKey}"><div class="search-more 0">모두 보기 ></div></a>
								</div>
								
								<div class="searchBoard 1">
									<div class="search-title">관리자 추천 맛집  
										<a class="search-go-list" href="worker_rList"> 더보기 </a> 
									</div>
									
									<c:forEach items="${searchM1rList}" var="m1rVO">
						            <ul class="search-list">
							            <li>
								            <div class="search-txt-area">    
								            
								            	<div class="search-list-image">
							   						<img src="images/member1_r/${m1rVO.image1}" alt="" style="width:180px;height:120px; object-fit: cover;"/>
							   					</div>
									                    
									            <a class="search-list-tit" href="worker_rDetail?m1rseq=${m1rVO.m1rseq}">	
									            	<p>${m1rVO.subject} </p>
									           	</a>    
									       
									           <%--  <div class="search-content">        
									            	<span>${m1rVO.kind}</span>    
									            </div>
									            
									            <div class="search-content">        
									            	<span>${m1rVO.area}</span>    
									            </div>  --%>
									       
									            <div class="search-content">        
									            	<p>${m1rVO.address}</p>    
									            </div>
									            
								            </div>
							            </li>
						            </ul>
						            </c:forEach>
						            <a href="searchM1rList?key=${searchKey}"><div class="search-more 1">모두 보기 ></div></a>
								</div>
								
								<div class="searchBoard 2">
									<div class="search-title">회원 추천 관광지
										<a class="search-go-list" href="member_tList"> 더보기 </a> 
									</div>
									
									<c:forEach items="${searchM0tList}"  var="m0tVO">
						            <ul class="search-list">
							            <li>
								            <div class="search-txt-area"> 
								            
								            	<div class="search-list-image">
							   						<img src="images/member0_t/${m0tVO.image1}" alt="" style="width:180px;height:120px; object-fit: cover;"/>
							   					</div>   
									                    
									            <a class="search-list-tit" href="member_tDetail?m0tseq=${m0tVO.m0tseq}">	
									            	<p>${m0tVO.subject}</p> 
									           	</a>    
									       
									            <div class="search-content">        
									            	<p>${m0tVO.content}</p>  
									            </div>
									        
								            </div>
							            </li>
						            </ul>
						            </c:forEach>
						            <a href="searchM0tList?key=${searchKey}"><div class="search-more 2">모두 보기 ></div></a>
								</div>
								
								<div class="searchBoard 3">
									<div class="search-title">회원 추천 맛집
										<a class="search-go-list" href="member_rList"> 더보기 </a>    	
									</div>
									
									<c:forEach items="${searchM0rList}" var="m0rVO">
						            <ul class="search-list">
							            <li>
								            <div class="search-txt-area">    
								            
								            	<div class="search-list-image">
							   						<img src="images/member0_r/${m0rVO.image1}" alt="" style="width:180px;height:120px; object-fit: cover;"/>
							   					</div> 
									                    
									            <a class="search-list-tit" href="member_rDetail?m0rseq=${m0rVO.m0rseq}">	
									            	<p>${m0rVO.subject} </p>
									           	</a>    
									       
									            <div class="search-content">        
									            	<p>${m0rVO.content}</p>
									            </div>
									            
								            </div>
							            </li>
						            </ul>
						            </c:forEach>
						            <a href="searchM0rList?key=${searchKey}"><div class="search-more 3">모두 보기 ></div></a>
								</div>
								
								
							</div>
			

			</div>
          </div>
        </section>
        

        
        
		
    <%@ include file="../footer.jsp" %>   