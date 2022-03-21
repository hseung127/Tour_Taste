
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!-- <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"> -->
    <link rel="stylesheet" href="css_gusuk/common.css">
    <link rel="stylesheet" href="css_gusuk/main.css">
    <link rel="stylesheet" href="css_gusuk/swiper.min.css">
  
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Roboto:100,300,300i,400,500,600,700,900%7CRaleway:500">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/fonts.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/style2.css">
<%@ include file="header.jsp" %>  
<%@ include file="loading.jsp" %>  
  
      <!-- Swiper-->
      <section class="section swiper-container swiper-slider swiper-slider-2 swiper-slider-3" data-loop="true" data-autoplay="5000" data-simulate-touch="false" data-slide-effect="fade">
        <div class="swiper-wrapper text-sm-left">
          <div class="swiper-slide context-dark" data-slide-bg="images/season/${homeSeasonList[0].bannerimg}">
            <div class="swiper-slide-caption section-md">
              <div class="container">
                <div class="row">
                  <div class="col-sm-9 col-md-8 col-lg-7 col-xl-7 offset-lg-1 offset-xxl-0">
                    <h1 class="oh swiper-title"><span class="d-inline-block" data-caption-animate="slideInUp" data-caption-delay="0">${homeSeasonList[0].subject}</span></h1>
                    <p class="big swiper-text" data-caption-animate="fadeInLeft" data-caption-delay="300">${homeSeasonList[0].b_content}</p>
                    <!--<a class="button button-lg button-primary button-winona button-shadow-2" href="#" data-caption-animate="fadeInUp" data-caption-delay="300">보러가기</a>-->
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="swiper-slide context-dark" data-slide-bg="images/season/${homeSeasonList[1].bannerimg}">
            <div class="swiper-slide-caption section-md">
              <div class="container">
                <div class="row">
                  <div class="col-sm-8 col-lg-7 offset-lg-1 offset-xxl-0">
                    <h1 class="oh swiper-title"><span class="d-inline-block" data-caption-animate="slideInDown" data-caption-delay="0">${homeSeasonList[1].subject}</span></h1>
                    <p class="big swiper-text" data-caption-animate="fadeInRight" data-caption-delay="300">${homeSeasonList[1].b_content}</p>
                    <!-- <div class="button-wrap oh"><a class="button button-lg button-primary button-winona button-shadow-2" href="#" data-caption-animate="slideInUp" data-caption-delay="0">보러가기</a></div> -->
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
       
        <!-- Swiper Pagination-->
        <div class="swiper-pagination" data-bullet-custom="true"></div>
        <!-- Swiper Navigation-->
        <div class="swiper-button-prev">
          <!-- <div class="preview">
            <div class="preview__img"></div>
          </div> -->
          <div class="swiper-button-arrow"></div>
        </div>
        <div class="swiper-button-next">
          <div class="swiper-button-arrow"></div>
          <!-- <div class="preview">
            <div class="preview__img"></div>
          </div> -->
        </div>
      </section>
      <!-- What We Offer-->
      <section class="section section-md bg-default">
        <div class="container">
          <div class="home-title-wrap-m1t">
	          <h5 class="oh-desktop"><span class="d-inline-block wow slideInDown">| 관리자 추천 관광지</span></h5>
	          <a href="worker_tList"  class="home_btn_more_m1t">더보기</a>
          </div>
          <div class="row row-md row-30">
            <div class="col-sm-6 col-lg-4">
              <div class="oh-desktop">
                <!-- Services Terri-->
                <article class="services-terri wow slideInUp">
                  <div class="services-terri-figure"><img src="images/member1_t/${homeM1tList[0].image1}"   alt="" style="width:370px;height:278px; object-fit: cover;"/>
                  </div>
                  <div class="services-terri-caption"><%-- <span class="services-terri-icon">${homeM1tList[0].area}</span> --%>
                    <h5 class="services-terri-title"><a href="worker_tDetail?m1tseq=${homeM1tList[0].m1tseq}">${homeM1tList[0].subject}</a></h5>
                  </div>
                </article>
              </div>
            </div>
            <div class="col-sm-6 col-lg-4">
              <div class="oh-desktop">
                <!-- Services Terri-->
                <article class="services-terri wow slideInDown">
                  <div class="services-terri-figure"><img src="images/member1_t/${homeM1tList[1].image1}" alt="" style="width:370px;height:278px; object-fit: cover;"/>
                  </div>
                  <div class="services-terri-caption"><!-- <span class="services-terri-icon"></span> -->
                    <h5 class="services-terri-title"><a href="worker_tDetail?m1tseq=${homeM1tList[1].m1tseq}">${homeM1tList[1].subject}</a></h5>
                  </div>
                </article>
              </div>
            </div>
            <div class="col-sm-6 col-lg-4">
              <div class="oh-desktop">
                <!-- Services Terri-->
                <article class="services-terri wow slideInUp">
                  <div class="services-terri-figure"><img src="images/member1_t/${homeM1tList[2].image1}" alt="" style="width:370px;height:278px; object-fit: cover;"/>
                  </div>
                  <div class="services-terri-caption"><!-- <span class="services-terri-icon"></span> -->
                    <h5 class="services-terri-title"><a href="worker_tDetail?m1tseq=${homeM1tList[2].m1tseq}">${homeM1tList[2].subject}</a></h5>
                  </div>
                </article>
              </div>
            </div>
            <div class="col-sm-6 col-lg-4">
              <div class="oh-desktop">
                <!-- Services Terri-->
                <article class="services-terri wow slideInDown">
                  <div class="services-terri-figure"><img src="images/member1_t/${homeM1tList[3].image1}" alt="" style="width:370px;height:278px; object-fit: cover;"/>
                  </div>
                  <div class="services-terri-caption"><!-- <span class="services-terri-icon"></span> -->
                    <h5 class="services-terri-title"><a href="worker_tDetail?m1tseq=${homeM1tList[3].m1tseq}">${homeM1tList[3].subject}</a></h5>
                  </div>
                </article>
              </div>
            </div>
            <div class="col-sm-6 col-lg-4">
              <div class="oh-desktop">
                <!-- Services Terri-->
                <article class="services-terri wow slideInUp">
                  <div class="services-terri-figure"><img src="images/member1_t/${homeM1tList[4].image1}" alt="" style="width:370px;height:278px; object-fit: cover;"/>
                  </div>
                  <div class="services-terri-caption"><!-- <span class="services-terri-icon"></span> -->
                    <h5 class="services-terri-title"><a href="worker_tDetail?m1tseq=${homeM1tList[4].m1tseq}">${homeM1tList[4].subject}</a></h5>
                  </div>
                </article>
              </div>
            </div>
            <div class="col-sm-6 col-lg-4">
              <div class="oh-desktop">
                <!-- Services Terri-->
                <article class="services-terri wow slideInDown">
                  <div class="services-terri-figure"><img src="images/member1_t/${homeM1tList[5].image1}" alt="" style="width:370px;height:278px; object-fit: cover;"/>
     
                  </div>
                  <div class="services-terri-caption"><!-- <span class="services-terri-icon"></span> -->
                    <h5 class="services-terri-title"><a href="worker_tDetail?m1tseq=${homeM1tList[5].m1tseq}">${homeM1tList[5].subject}</a></h5>
                  </div>
                </article>
              </div>
            </div>
          </div>
        </div>
      </section>

      <!-- Section CTA-->
     <!--  <section class="primary-overlay section parallax-container" data-parallax-img="news_images/n_image06.jpg">
        <div class="parallax-content section-xl context-dark text-md-left">
          <div class="container">
            <div class="row justify-content-end">
              <div class="col-sm-8 col-md-7 col-lg-5">
                <div class="cta-modern">
                  <h3 class="cta-modern-title wow fadeInRight">원하는 날<br> 원하는 곳에서</h3>
                  <p class="lead">KT 멤버십 2월 룰렛이벤트</p>
                  <p class="cta-modern-text oh-desktop" data-wow-delay=".1s"><span class="cta-modern-decor wow slideInLeft"></span><span class="d-inline-block wow slideInDown">2월01일~2월31일</span></p><a class="button button-md button-secondary-2 button-winona wow fadeInUp" href="#" data-wow-delay=".2s">보러가기</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section> -->

      <section class="section section-lg bg-default"> <!--구석구석 시작-->
        <div class="container">
			<div class="specialEdition">
			
			    <div class="mc_inner">
			        
			         <div class="top_cont clfix">
			            
			            <div class="top_leftCont">   
				            <div class="imgbannerArea">	
					            <a href="event_detail?eseq=${bigHomeEventList[0].eseq}">
					            	<img src="images/event/${bigHomeEventList[0].homeimg}" alt="2022 여행 트렌드 능력고사!">
					            </a>
				            </div>
			
			                <div class="article bd0">
			                    <div class="tit_atc">
			                       	 오늘의 여행  Issue
			                        <a href="event-news?tabNum=2" class="home_btn_more_news">더보기</a>
			                    </div>
			                    <ul class="list_board">
			                        <li>
			                            <a href="news_detail?nseq=${homeNewsList[0].nseq}" ><!-- <em style="color:#a2660d">코로나바이러스감염증-19ㅣ</em> -->${homeNewsList[0].subject}</a>
			                        </li>
			                        <li>
			                            <a href="news_detail?nseq=${homeNewsList[1].nseq}" ><!-- <em style="color:#a2660d">안전여행 가이드ㅣ</em> -->${homeNewsList[1].subject}</a>
			                        </li>
			                        <li>
			                            <a href="news_detail?nseq=${homeNewsList[2].nseq}"  ><!-- <em style="color:#a2660d">한국관광공사ㅣ</em> -->${homeNewsList[2].subject}</a>
			                        </li>
			                        <li>
			                            <a href="news_detail?nseq=${homeNewsList[3].nseq}" ><!-- <em style="color:#a2660d">강원도여행 |</em> -->${homeNewsList[3].subject}</a>
			                        </li>
			                    </ul>
			                </div>
			                
			              </div>
			            
			            
				            <!-- 홍보배너 (PC)-->
				            <div class="banner_pcTop active">
				                <div class="swiper-container swiper-container-initialized swiper-container-horizontal">
				                    
				                    <ul class="swiper-wrapper"  style="transition-duration: 0ms; transform: translate3d(-1395px, 0px, 0px);">
				                        
				                        <li class="swiper-slide swiper-slide-duplicate swiper-slide-next swiper-slide-duplicate-prev" data-swiper-slide-index="1" style="width: 465px;">	
				                            <ul>		
				                                <li>
				                                    <a href="event_detail?eseq=${homeEventList[0].eseq}"><img class="swiper-lazy swiper-lazy-loaded" alt="트래블리더 14기 모집!" style="background-color: #ffffff;" src="images/event/${homeEventList[0].homeimg}"></a>
				                                </li>		
				                                <li>
				                                    <a href="event_detail?eseq=${homeEventList[1].eseq}"><img class="swiper-lazy swiper-lazy-loaded" alt="탄소 배출량 줄이는 친환경 추천 여행지! 친추 여행지" style="background-color: #ffffff;" src="images/event/${homeEventList[1].homeimg}"></a>
				                                </li>		
				                                <li>
				                                    <a href="event_detail?eseq=${homeEventList[2].eseq}"><img class="swiper-lazy swiper-lazy-loaded" alt="배우 정해인 목소리로 듣는 오디오 가이드 오디! 남양주 정약용 유적지" style="background-color: #ffffff;" src="images/event/${homeEventList[2].homeimg}"></a>
				                                </li>		
				                                <li>
				                                    <a href="event_detail?eseq=${homeEventList[3].eseq}"><img class="swiper-lazy swiper-lazy-loaded" alt="함께 떠나는 랜선 축제 여행! 대한민국 축제의 모든 것!" style="background-color: #ffffff;" src="images/event/${homeEventList[3].homeimg}"></a>
				                                </li>	
				                            </ul>
				                        </li>
				                        
				                        <li class="swiper-slide swiper-slide-duplicate-active" data-swiper-slide-index="0" style="width: 465px;">	
				                            <ul>		
				                                <li>
				                                    <a href="event_detail?eseq=${homeEventList[4].eseq}"><img class="swiper-lazy swiper-lazy-loaded" alt="가볼래-터와 함께 여행을 구독하세요!" style="background-color: #ebe8fd;" src="images/event/${homeEventList[4].homeimg}"></a>
				                                </li>		
				                                <li>
				                                    <a href="event_detail?eseq=${homeEventList[5].eseq}"><img class="swiper-lazy swiper-lazy-loaded" alt="최애 맛집 제보 이벤트! 그곳이 알고싶다" style="background-color: #fff6de;" src="images/event/${homeEventList[5].homeimg}"></a>
				                                </li>		
				                                <li>
				                                    <a href="event_detail?eseq=${homeEventList[6].eseq}"><img class="swiper-lazy swiper-lazy-loaded" alt="최초이거나 유일하거나! 레어템으로 소문난 관광지!" style="background-color: #def6ff;" src="images/event/${homeEventList[6].homeimg}"></a>
				                                </li>		
				                                <li>
				                                    <a href="event_detail?eseq=${homeEventList[7].eseq}"><img class="swiper-lazy swiper-lazy-loaded" alt="월간 19투어 여수편! 여수의 숨은 매력을 발견해보세요!" style="background-color: #fdf0f2;" src="images/event/${homeEventList[7].homeimg}"></a>
				                                </li>	
				                            </ul>
				                        </li>
				                        
				                        <li class="swiper-slide swiper-slide-prev swiper-slide-duplicate-next" data-swiper-slide-index="1" style="width: 465px;">	
				                            <ul>		
				                                <li>
				                                    <a href="event_detail?eseq=${homeEventList[0].eseq}"><img class="swiper-lazy swiper-lazy-loaded" alt="트래블리더 14기 모집!" style="background-color: #ffffff;" src="images/event/${homeEventList[0].homeimg}"></a>
				                                </li>		
				                                <li>
				                                    <a href="event_detail?eseq=${homeEventList[1].eseq}"><img class="swiper-lazy swiper-lazy-loaded" alt="탄소 배출량 줄이는 친환경 추천 여행지! 친추 여행지" style="background-color: #ffffff;" src="images/event/${homeEventList[1].homeimg}"></a>
				                                </li>		
				                                <li>
				                                    <a href="event_detail?eseq=${homeEventList[2].eseq}"><img class="swiper-lazy swiper-lazy-loaded" alt="배우 정해인 목소리로 듣는 오디오 가이드 오디! 남양주 정약용 유적지" style="background-color: #ffffff;" src="images/event/${homeEventList[2].homeimg}"></a>
				                                </li>		
				                                <li>
				                                    <a href="event_detail?eseq=${homeEventList[3].eseq}"><img class="swiper-lazy swiper-lazy-loaded" alt="함께 떠나는 랜선 축제 여행! 대한민국 축제의 모든 것!" style="background-color: #ffffff;" src="images/event/${homeEventList[3].homeimg}"></a>
				                                </li>	
				                            </ul>
				                        </li>
				                        
				                        <li class="swiper-slide swiper-slide-duplicate swiper-slide-active" data-swiper-slide-index="0" style="width: 465px;">	
				                        	<ul>		
				                        		<li>
				                        			<a href="event_detail?eseq=${homeEventList[4].eseq}"><img class="swiper-lazy swiper-lazy-loaded" alt="가볼래-터와 함께 여행을 구독하세요!" style="background-color: #ebe8fd;" src="images/event/${homeEventList[4].homeimg}"></a>
				                        		</li>		
				                        		<li>
				                            		<a href="event_detail?eseq=${homeEventList[5].eseq}"><img class="swiper-lazy swiper-lazy-loaded" alt="최애 맛집 제보 이벤트! 그곳이 알고싶다" style="background-color: #fff6de;" src="images/event/${homeEventList[5].homeimg}"></a>
				                        		</li>		
				                        		<li>
				                            		<a href="event_detail?eseq=${homeEventList[6].eseq}"><img class="swiper-lazy swiper-lazy-loaded" alt="최초이거나 유일하거나! 레어템으로 소문난 관광지!" style="background-color: #def6ff;" src="images/event/${homeEventList[6].homeimg}"></a>
				                        		</li>		
				                        		<li>
				                            		<a href="event_detail?eseq=${homeEventList[7].eseq}"><img class="swiper-lazy swiper-lazy-loaded" alt="월간 19투어 여수편! 여수의 숨은 매력을 발견해보세요!" style="background-color: #fdf0f2;" src="images/event/${homeEventList[7].homeimg}"></a>
				                        		</li>	
				                    		</ul>
				                		</li>
				                		
				            		</ul>
				            		
				            		
				                	<span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span><span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span><span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span><span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span><span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span><span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span></div>
				                
					                <div class="paging">
					                    <!-- <div class="btn_autoArea">
					                        <button class="btn_autoPlay">재생</button>
					                        <button class="btn_autoStop">멈춤</button>
					                    </div> -->
				                    	<div class="swiper-pagination swiper-pagination-clickable swiper-pagination-bullets">
				                    		<button type="button" class="swiper-pagination-bullet swiper-pagination-bullet-active" id="event-slide-btn1" tabindex="0" role="button" aria-label="Go to slide 1">
				                    			<span class="blind">1번째 슬라이드 보기</span>
				                    		</button>
				                    		<button type="button" class="swiper-pagination-bullet" id="event-slide-btn2" tabindex="0" role="button" aria-label="Go to slide 2">
				                    			<span class="blind">2번째 슬라이드 보기</span>
				                    		</button>
				                   		</div>
					                </div>
				
				              </div>
			            
			            
			           </div>
			            
			           
			     </div>
			       
		     </div>
		  </div>
       
	  </section> <!-- 구석구석끝-->
          
     
            
            
       <!-- Our Shop-->
      <section class="section section-lg bg-default">
      <div class="container">
          <!-- <h3 class="oh-desktop"><span class="d-inline-block wow slideInUp">관리자 추천 음식점</span></h3> -->
          
          <!-- <div class="home-m1r-title-wrap"> -->
          	<h5 style="float:left; left:345px;"> ㅣ 관리자 추천 맛집</h5> <br>
          	<a href="worker_rList"  class="home_btn_more_m1r">더보기</a>
          <!-- </div> -->
          <div class="row-m1r row-lg row-30">
          
            <div class="col-sm-6 col-lg-4 col-xl-3">
              <!-- Product-->
              <article class="product wow fadeInLeft" data-wow-delay=".15s">
                <div class="product-figure"><img src="images/member1_r/${homeM1rList[0].image1}" alt="" style="width:161px; height:162px; object-fit: cover; "/>
                </div>
                <div class="product-rating">${homeM1rList[0].area}<!-- span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star text-gray-13"></span> -->
                </div>
                <h6 class="product-title">${homeM1rList[0].subject}</h6>
                <div class="product-price-wrap">
                  <c:choose>
	                  <c:when test="${homeM1rBookmarkyn[0] == 0}">
	                  	<div class="product-price" id="home-m1r-bookmark0" >♡${homeM1rCountBookmark[0]}</div>
	                  </c:when>
	                  <c:otherwise>
	                  	<div class="product-price" id="home-m1r-bookmark0" >&hearts;${homeM1rCountBookmark[0]}</div>
	                  </c:otherwise>
               	  </c:choose>
                </div>
                <div class="product-button">
                  <c:choose>
	                  <c:when test="${bookmarkLoginCheck == 1}">
	                  	<div class="button-wrap"><button type="button" class="button button-xs button-primary button-winona" onclick="insert_bookmark(${homeM1rList[0].m1rseq},0);">즐겨찾기 추가</button></div>
	                  </c:when>
	                  <c:otherwise>
	                  	<div class="button-wrap"><button type="button" class="button button-xs button-primary button-winona" onclick="bookmark_alert_login()">즐겨찾기 추가</button></div>
	                  </c:otherwise>
               	  </c:choose> 
                  <div class="button-wrap"><a class="button button-xs button-secondary button-winona" href="worker_rDetail?m1rseq=${homeM1rList[0].m1rseq}">상세보기</a></div>
                </div>
              </article>
            </div>
            
            <div class="col-sm-6 col-lg-4 col-xl-3">
              <!-- Product-->
              <article class="product wow fadeInLeft" data-wow-delay=".1s">
                <div class="product-figure"><img src="images/member1_r/${homeM1rList[1].image1}" alt="" style="width:161px; height:162px; object-fit: cover;"/>
                </div>
                <div class="product-rating">${homeM1rList[1].area}<!-- span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span> -->
                </div>
                <h6 class="product-title">${homeM1rList[1].subject}</h6>
                <div class="product-price-wrap">
                  <c:choose>
	                  <c:when test="${homeM1rBookmarkyn[1] == 0}">
	                  	<div class="product-price" id="home-m1r-bookmark1" >♡${homeM1rCountBookmark[1]}</div>
	                  </c:when>
	                  <c:otherwise>
	                  	<div class="product-price" id="home-m1r-bookmark1" >&hearts;${homeM1rCountBookmark[1]}</div>
	                  </c:otherwise>
               	  </c:choose>
               	 
                </div>
                <div class="product-button">
                  <c:choose>
	                  <c:when test="${bookmarkLoginCheck == 1}">
	                  	<div class="button-wrap"><button type="button" class="button button-xs button-primary button-winona" onclick="insert_bookmark(${homeM1rList[1].m1rseq},1);">즐겨찾기 추가</button></div>
	                  </c:when>
	                  <c:otherwise>
	                  	<div class="button-wrap"><button type="button" class="button button-xs button-primary button-winona" onclick="bookmark_alert_login()">즐겨찾기 추가</button></div>
	                  </c:otherwise>
               	  </c:choose> 
                  <div class="button-wrap"><a class="button button-xs button-secondary button-winona" href="worker_rDetail?m1rseq=${homeM1rList[1].m1rseq}">상세보기</a></div>
                </div><!-- <span class="product-badge product-badge-new">BEST</span>  -->
              </article>
            </div>
            
            <div class="col-sm-6 col-lg-4 col-xl-3">
              <!-- Product-->
              <article class="product wow fadeInLeft" data-wow-delay=".05s">
                <div class="product-figure"><img src="images/member1_r/${homeM1rList[2].image1}" alt="" style="width:161px; height:162px; object-fit: cover;"/>
                </div>
                <div class="product-rating">${homeM1rList[2].area}<!--<span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star text-gray-13"></span> -->
                </div>
                <h6 class="product-title">${homeM1rList[2].subject}</h6>
                <div class="product-price-wrap">
                  <c:choose>
	                  <c:when test="${homeM1rBookmarkyn[2] == 0}">
	                  	<div class="product-price" id="home-m1r-bookmark2" >♡${homeM1rCountBookmark[2]}</div>
	                  </c:when>
	                  <c:otherwise>
	                  	<div class="product-price" id="home-m1r-bookmark2" >&hearts;${homeM1rCountBookmark[2]}</div>
	                  </c:otherwise>
               	  </c:choose>
                </div>
                <div class="product-button">
                  <c:choose>
	                  <c:when test="${bookmarkLoginCheck == 1}">
	                  	<div class="button-wrap"><button type="button" class="button button-xs button-primary button-winona" onclick="insert_bookmark(${homeM1rList[2].m1rseq},2);">즐겨찾기 추가</button></div>
	                  </c:when>
	                  <c:otherwise>
	                  	<div class="button-wrap"><button type="button" class="button button-xs button-primary button-winona" onclick="bookmark_alert_login()">즐겨찾기 추가</button></div>
	                  </c:otherwise>
               	  </c:choose>     
                  <div class="button-wrap"><a class="button button-xs button-secondary button-winona" href="worker_rDetail?m1rseq=${homeM1rList[2].m1rseq}">상세보기</a></div>
                </div>
              </article>
            </div>
            
            <div class="col-sm-6 col-lg-4 col-xl-3">
              <!-- Product-->
              <article class="product wow fadeInLeft">
                <div class="product-figure"><img src="images/member1_r/${homeM1rList[3].image1}" alt="" style="width:161px; height:162px; object-fit: cover;"/>
                </div>
                <div class="product-rating">${homeM1rList[3].area}<!--<span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span>-->
                </div>
                <h6 class="product-title">${homeM1rList[3].subject}</h6>
                <div class="product-price-wrap">
                  <c:choose>
	                  <c:when test="${homeM1rBookmarkyn[3] == 0}">
	                  	<div class="product-price" id="home-m1r-bookmark3" >♡${homeM1rCountBookmark[3]}</div>
	                  </c:when>
	                  <c:otherwise>
	                  	<div class="product-price" id="home-m1r-bookmark3" >&hearts;${homeM1rCountBookmark[3]}</div>
	                  </c:otherwise>
               	  </c:choose>
                </div>
                <div class="product-button">
                  <c:choose>
	                  <c:when test="${bookmarkLoginCheck == 1}">
	                  	<div class="button-wrap"><button type="button" class="button button-xs button-primary button-winona" onclick="insert_bookmark(${homeM1rList[3].m1rseq},3);">즐겨찾기 추가</button></div>
	                  </c:when>
	                  <c:otherwise>
	                  	<div class="button-wrap"><button type="button" class="button button-xs button-primary button-winona" onclick="bookmark_alert_login()">즐겨찾기 추가</button></div>
	                  </c:otherwise>
               	  </c:choose>
                  <div class="button-wrap"><a class="button button-xs button-secondary button-winona" href="worker_rDetail?m1rseq=${homeM1rList[3].m1rseq}">상세보기</a></div>
                </div><!-- span class="product-badge product-badge-sale">Steady</span> -->
              </article>
            </div>
            
            
          </div>
   
   
        <!-- <div class="container"> -->
         <!--  <h3 class="oh-desktop"><span class="d-inline-block wow slideInUp">회원 추천 음식점</span></h3> -->
          <hr>
          <hr>
          <hr>
          <div class="blank-m0r"></div>
          <!-- <div class="home-m0r-title-wrap"> -->
          	<h5 style="float:left; left:345px;"> ㅣ 회원 추천 맛집 </h5>   <hr>    	
          	<a href="member_rList"  class="home_btn_more_m0r">더보기</a>
         <!--  </div> -->
          	
          <div class="row-m0r row-lg row-30">
            
            <div class="col-sm-6 col-lg-4 col-xl-3">
              <article class="product wow fadeInLeft" data-wow-delay=".15s">
                <div class="product-figure"><img src="images/member0_r/${homeM0rList[0].image1}" alt="" style="width:161px; height:162px; object-fit: cover;"/>
                </div>
                <div class="product-rating">${homeM0rList[0].name}
                </div>
                <h6 class="product-title">${homeM0rList[0].subject}</h6>
                <div class="product-price-wrap">
                  <div class="product-price">&#9733;${homeM0rList[0].staravg}</div>
                </div>
                <div class="product-button">
                 <!--  <div class="button-wrap"><a class="button button-xs button-primary button-winona" href="#">즐겨찾기 추가</a></div> -->
                  <div class="button-wrap"><a class="button button-xs button-secondary button-winona" href="member_rDetail?m0rseq=${homeM0rList[0].m0rseq}">상세보기</a></div>
                </div>
              </article>
            </div>
            
            <div class="col-sm-6 col-lg-4 col-xl-3">
              <article class="product wow fadeInLeft" data-wow-delay=".1s">
                <div class="product-figure"><img src="images/member0_r/${homeM0rList[1].image1}" alt="" style="width:161px; height:162px; object-fit: cover;"/>
                </div>
                <div class="product-rating">${homeM0rList[1].name}<!-- <span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span> -->
                </div>
                <h6 class="product-title">${homeM0rList[1].subject}</h6>
                <div class="product-price-wrap">
                  <div class="product-price">&#9733;${homeM0rList[1].staravg}</div>
                </div>
                <div class="product-button">
                  <!-- <div class="button-wrap"><a class="button button-xs button-primary button-winona" href="#">즐겨찾기 추가</a></div> -->
                  <div class="button-wrap"><a class="button button-xs button-secondary button-winona" href="member_rDetail?m0rseq=${homeM0rList[1].m0rseq}">상세보기</a></div>
                </div><!-- <span class="product-badge product-badge-new">New</span> -->
              </article>
            </div>
            
            <div class="col-sm-6 col-lg-4 col-xl-3">
              <article class="product wow fadeInLeft" data-wow-delay=".05s">
                <div class="product-figure"><img src="images/member0_r/${homeM0rList[2].image1}" alt="" style="width:161px; height:162px; object-fit: cover;"/>
                </div>
                <div class="product-rating">${homeM0rList[2].name}<!-- <span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star text-gray-13"></span> -->
                </div>
                <h6 class="product-title">${homeM0rList[2].subject}</h6>
                <div class="product-price-wrap">
                  <div class="product-price">&#9733;${homeM0rList[2].staravg}</div>
                </div>
                <div class="product-button">
                  <!-- <div class="button-wrap"><a class="button button-xs button-primary button-winona" href="#">즐겨찾기 추가</a></div> -->
                  <div class="button-wrap"><a class="button button-xs button-secondary button-winona" href="member_rDetail?m0rseq=${homeM0rList[2].m0rseq}">상세보기</a></div>
                </div>
              </article>
            </div>
            
            <div class="col-sm-6 col-lg-4 col-xl-3">
              <article class="product wow fadeInLeft">
                <div class="product-figure"><img src="images/member0_r/${homeM0rList[3].image1}" alt="" style="width:161px; height:162px; object-fit: cover;"/>
                </div>
                <div class="product-rating">${homeM0rList[3].name}<!-- <span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span> -->
                </div>
                <h6 class="product-title">${homeM0rList[3].subject}</h6>
                <div class="product-price-wrap">
                  <div class="product-price product-price-old"></div> 
                  <div class="product-price">&#9733;${homeM0rList[3].staravg}</div>
                </div>
                <div class="product-button">
                  <!-- <div class="button-wrap"><a class="button button-xs button-primary button-winona" href="#">즐겨찾기 추가</a></div> -->
                  <div class="button-wrap"><a class="button button-xs button-secondary button-winona" href="member_rDetail?m0rseq=${homeM0rList[3].m0rseq}">상세보기</a></div>
                </div><!-- <span class="product-badge product-badge-sale">Steady</span> -->
              </article>
            </div>
            
            
          </div>
          
          
          
        </div>
        
    
       </section>


		
      <!-- 베너광고-->
     <!--   <section class="primary-overlay section parallax-container" data-parallax-img="news_images/n_image08.jpg">
        <div class="parallax-content section-xxl context-dark text-md-left">
          <div class="container">
            <div class="row justify-content-end">
              <div class="col-sm-9 col-md-7 col-lg-5">
                <div class="cta-modern">
                  <h3 class="cta-modern-title cta-modern-title-2 oh-desktop"><span class="d-inline-block wow fadeInLeft">필름카메라체험<br>-30% EVENT </span></h3>
                  <p class="cta-modern-text cta-modern-text-2 oh-desktop" data-wow-delay=".1s"><span class="cta-modern-decor cta-modern-decor-2 wow slideInLeft"></span><span class="d-inline-block wow slideInUp">내가 찍은 필름사진 직접 현상까지!</span></p><a class="button button-lg button-secondary button-winona wow fadeInRight" href="contacts.jsp" data-wow-delay=".2s">보러가기</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>-->


	<!-- 옆으로 하나씩 넘어가는 회원추천음식점  -->
     <!-- <section class="section section-xl bg-default">
        <div class="container">
          <h3 class="wow fadeInLeft">회원 추천 음식점</h3>
        </div>
        <div class="container container-style-1">
          <div class="owl-carousel owl-style-12" data-items="1" data-sm-items="2" data-lg-items="3" data-margin="30" data-xl-margin="45" data-autoplay="true" data-nav="true" data-center="true" data-smart-speed="400">
           
           
            <article class="quote-tara">
              <div class="quote-tara-caption">
                <div class="quote-tara-text">
                  <p class="q"><img src="member_Rimages/mr_image01.jpg" alt="" /></p>
                </div>
                <div class="quote-tara-figure">4.7<img src="images/user-6-115x115.jpg" alt="" width="115" height="115"/>
                </div>
              </div>
              <h6 class="quote-tara-author">왕자장어</h6>
              <div class="quote-tara-status">jjkim</div>
            </article>
       
       
            <article class="quote-tara">
              <div class="quote-tara-caption">
                <div class="quote-tara-text">
                  <p class="q"><img src="member_Rimages/mr_image02.jpg" alt="" /></p>
                </div>
                <div class="quote-tara-figure"><img src="images/user-8-115x115.jpg" alt="" width="115" height="115"/>
                </div>
              </div>
              <h6 class="quote-tara-author">파씨오네</h6>
              <div class="quote-tara-status">rkd7878</div>
            </article>
           
           
            <article class="quote-tara">
	              <div class="quote-tara-caption">
		                <div class="quote-tara-text">
		                  <p class="q"><img src="member_Rimages/mr_image03.jpg" alt="" /></p>
		                </div>
	                	<div class="quote-tara-figure"><img src="images/user-7-115x115.jpg" alt="" width="115" height="115"/>
	                	</div>
	              </div>
	              <h6 class="quote-tara-author">대파생곱창</h6>
	              <div class="quote-tara-status">eovk99</div>
            </article>
         
         
            <article class="quote-tara">
   				<div class="quote-tara-caption">
	                <div class="quote-tara-text">
	                  <p class="q"><img src="member_Rimages/mr_image04.jpg" alt="" /></p>
	                </div>
	                <div class="quote-tara-figure"><img src="images/user-9-115x115.jpg" alt="" width="115" height="115"/>
	                </div>
              	</div>
              	<h6 class="quote-tara-author">정열식당</h6>
              	<div class="quote-tara-status">wjdd22</div>
            </article>
            
            
            
          </div>
        </div>
        
     </section> -->

     <!-- <section class="section section-last bg-default">
      <h3 class="oh-desktop"><span class="d-inline-block wow slideInDown">회원 추천 관광지</span></h3><br><br>
        <div class="container-fluid container-inset-0 isotope-wrap">
          <div class="row row-10 gutters-10 isotope" data-isotope-layout="masonry" data-isotope-group="gallery" data-lightgallery="group">
            <div class="col-xs-6 col-sm-4 col-xl-2 isotope-item oh-desktop">
           
           
            
            <article class="thumbnail thumbnail-mary thumbnail-mary-2 wow slideInLeft"><a class="thumbnail-mary-figure" href="images/gallery-1-1200x800-original.jpg" data-lightgallery="item"><img src="member_Timages/mt_image01.jpg" alt="" style="width:310px; height:585px;"/></a>
                <div class="thumbnail-mary-caption">
                  <div>
                    <h6 class="thumbnail-mary-title"><a href="#">순천만 국가정원</a></h6>
                    <div class="thumbnail-mary-location">rkds77</div>
                  </div>
                </div>
              </article>
            </div>
            <div class="col-xs-6 col-sm-8 col-xl-4 isotope-item oh-desktop"> 
     
              
           <article class="thumbnail thumbnail-mary thumbnail-mary-big wow slideInRight"><a class="thumbnail-mary-figure" href="images/gallery-2-1200x800-original.jpg" data-lightgallery="item"><img src="member_Timages/mt_image02.jpg" alt="" style="width:631px; height:587px;"/></a>
                <div class="thumbnail-mary-caption">
                  <div>
                    <h6 class="thumbnail-mary-title"><a href="#">마시안 해변</a></h6>
                    <div class="thumbnail-mary-location">rkeh00</div>
                  </div>
                </div>
              </article>
            </div>
            <div class="col-xs-6 col-sm-4 col-xl-2 isotope-item oh-desktop">
            
            
              <article class="thumbnail thumbnail-mary thumbnail-mary-2 wow slideInDown"><a class="thumbnail-mary-figure" href="images/gallery-3-1200x800-original.jpg" data-lightgallery="item"><img src="member_Timages/mt_image03.jpg" alt="" style="width:311px; height:289px;"/></a>
                <div class="thumbnail-mary-caption">
                  <div>
                    <h6 class="thumbnail-mary-title"><a href="#">인천 자월도</a></h6>
                    <div class="thumbnail-mary-location">jisuk33</div>
                  </div>
                </div>
              </article>
            </div>
            <div class="col-xs-6 col-sm-8 col-xl-4 isotope-item oh-desktop"> 
            
            
            <article class="thumbnail thumbnail-mary wow slideInUp"><a class="thumbnail-mary-figure" href="images/gallery-4-1200x800-original.jpg" data-lightgallery="item"><img src="member_Timages/mt_image04.jpg" alt="" style="width:631px; height:289px;"/></a>
                <div class="thumbnail-mary-caption">
                  <div>
                    <h6 class="thumbnail-mary-title"><a href="#">담양 대나무골</a></h6>
                    <div class="thumbnail-mary-location">wldn66</div>
                  </div>
                </div>
              </article>
            </div>
            <div class="col-xs-6 col-sm-4 col-xl-2 isotope-item oh-desktop"> 
      
      
          <article class="thumbnail thumbnail-mary thumbnail-mary-2 wow slideInUp"><a class="thumbnail-mary-figure" href="images/gallery-5-1200x800-original.jpg" data-lightgallery="item"><img src="member_Timages/mt_image05.jpg" alt="" style="width:311px; height:289px;"/></a>
                <div class="thumbnail-mary-caption">
                  <div>
                    <h6 class="thumbnail-mary-title"><a href="#">춘천 레고랜드</a></h6>
                    <div class="thumbnail-mary-location">Summer11</div>
                  </div>
                </div>
              </article>
            </div>
            <div class="col-xs-6 col-sm-4 col-xl-2 isotope-item oh-desktop">
          
          
              <article class="thumbnail thumbnail-mary thumbnail-mary-2 wow slideInRight"><a class="thumbnail-mary-figure" href="images/gallery-6-1200x800-original.jpg" data-lightgallery="item"><img src="member_Timages/mt_image06.jpg" alt="" style="width:311px; height:289px;"/></a>
                <div class="thumbnail-mary-caption">
                  <div>
                    <h6 class="thumbnail-mary-title"><a href="#">인천공항 자기부상열차</a></h6>
                    <div class="thumbnail-mary-location">dmfd77</div>
                  </div>
                </div>
              </article>
            </div>
            <div class="col-xs-6 col-sm-4 col-xl-2 isotope-item oh-desktop">
           
           
              <article class="thumbnail thumbnail-mary thumbnail-mary-2 wow slideInLeft"><a class="thumbnail-mary-figure" href="images/gallery-6-1200x800-original.jpg" data-lightgallery="item"><img src="member_Timages/mt_image07.jpg" alt="" style="width:311px; height:289px;"/></a>
                <div class="thumbnail-mary-caption">
                  <div>
                    <h6 class="thumbnail-mary-title"><a href="#">태안 밧개 해수욕장</a></h6>
                    <div class="thumbnail-mary-location">Kky88</div>
                  </div>
                </div>
              </article>
            </div>
          </div>
        </div>
      </section> -->

      <!-- Tell-->
<!--   <section class="section section-sm section-first bg-default">
        <div class="container">
          <h3 class="heading-3">Book your Table</h3>
          <form class="rd-form rd-mailform form-style-1" data-form-output="form-output-global" data-form-type="contact" method="post" action="bat/rd-mailform.php">
            <div class="row row-20 gutters-20">
              <div class="col-md-6 col-lg-4 oh-desktop">
                <div class="form-wrap wow slideInDown">
                  <input class="form-input" id="contact-your-name-6" type="text" name="name" data-constraints="@Required">
                  <label class="form-label" for="contact-your-name-6">Your Name*</label>
                </div>
              </div>
              <div class="col-md-6 col-lg-4 oh-desktop">
                <div class="form-wrap wow slideInUp">
                  <input class="form-input" id="contact-email-6" type="email" name="email" data-constraints="@Email @Required">
                  <label class="form-label" for="contact-email-6">Your E-mail*</label>
                </div>
              </div>
              <div class="col-lg-4 oh-desktop">
                <div class="form-wrap wow slideInDown">  --> 
                  <!--Select 2-->
           <!-- <select class="form-input" data-minimum-results-for-search="Infinity" data-constraints="@Required">
                    <option value="1">Select a Service</option>
                    <option value="2">Dine-In</option>
                    <option value="3">Carry-Out</option>
                    <option value="4">Event Catering</option>
                  </select>
                </div>
              </div>
              <div class="col-12">
                <div class="form-wrap wow fadeIn">
                  <label class="form-label" for="contact-message-6">Message</label>
                  <textarea class="form-input textarea-lg" id="contact-message-6" name="message" data-constraints="@Required"></textarea>
                </div>
              </div>
            </div>
            <div class="group-custom-1 group-middle oh-desktop">
              <button class="button button-lg button-primary button-winona wow fadeInRight" type="submit">Send message</button> -->
              <!-- Quote Classic-->
        <!--  <article class="quote-classic quote-classic-3 wow slideInDown">
                <div class="quote-classic-text">
                  <p class="q">Please reserve your table at least 1 day in advance.</p>
                </div>
              </article>
            </div>
          </form>
        </div>
      </section> -->

      <!-- Section Services  Last section-->
 <!-- 
 
     <section class="section section-sm bg-default">
        <div class="container">
          <div class="owl-carousel owl-style-11 dots-style-2" data-items="1" data-sm-items="1" data-lg-items="2" data-xl-items="4" data-margin="30" data-dots="true" data-mouse-drag="true" data-rtl="true">
            <article class="box-icon-megan wow fadeInUp">
              <div class="box-icon-megan-header">
                <div class="box-icon-megan-icon linearicons-bag"></div>
              </div>
              <h5 class="box-icon-megan-title"><a href="#">Free Delivery</a></h5>
              <p class="box-icon-megan-text">If you order more than 3 pizzas, we will gladly deliver them to you for free.</p>
            </article>
            <article class="box-icon-megan wow fadeInUp" data-wow-delay=".05s">
              <div class="box-icon-megan-header">
                <div class="box-icon-megan-icon linearicons-map2"></div>
              </div>
              <h5 class="box-icon-megan-title"><a href="#">Convenient Location</a></h5>
              <p class="box-icon-megan-text">Our pizzeria is situated in the downtown and is very easy to reach even on weekends.</p>
            </article>
            <article class="box-icon-megan wow fadeInUp" data-wow-delay=".1s">
              <div class="box-icon-megan-header">
                <div class="box-icon-megan-icon linearicons-radar"></div>
              </div>
              <h5 class="box-icon-megan-title"><a href="#">Free Wi-Fi</a></h5>
              <p class="box-icon-megan-text">We have free Wi-Fi available to all clients and visitors of our pizzeria.</p>
            </article>
            <article class="box-icon-megan wow fadeInUp" data-wow-delay=".15s">
              <div class="box-icon-megan-header">
                <div class="box-icon-megan-icon linearicons-thumbs-up"></div>
              </div>
              <h5 class="box-icon-megan-title"><a href="#">Best Service</a></h5>
              <p class="box-icon-megan-text">The client is our #1 priority as we deliver top-notch customer service.</p>
            </article>
          </div>
        </div>
      </section>  --> 

	 <!--  </div> -->  <!-- header.jsp 에서 이어짐 -->
      <!-- Bottom Banner--><!-- a class="section section-banner" href="https://www.templatemonster.com/intense-multipurpose-html-template.html" style="background-image: url(images/banner/background-03-1920x310.jpg); background-image: -webkit-image-set( url(images/banner/background-03-1920x310.jpg) 1x, url(images/banner/background-03-3840x620.jpg) 2x )"><img src="images/banner/foreground-03-1600x310.png" srcset="images/banner/foreground-03-1600x310.png 1x, images/banner/foreground-03-3200x620.png 2x" alt="" width="1600" height="310"></a> -->
      <%@ include file="footer.jsp" %>   
      