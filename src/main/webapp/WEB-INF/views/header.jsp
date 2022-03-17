<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script> 
	<script type="text/javascript" src="member/member.js"></script>
	<script type="text/javascript" src="js/event.js"></script>
    <script type="text/javascript" src="js/search.js"></script>
    <script type="text/javascript" src="js/bookmark.js"></script>
    <script type="text/javascript" src="js/event-slide.js"></script>

	<link rel="icon" href="images/favicon.ico" type="image/x-icon">
    <!-- Stylesheets-->	
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Roboto:100,300,300i,400,500,600,700,900%7CRaleway:500">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/fonts.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/style2.css">
    
    
  
    <!--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
    <![endif]-->
  </head>
  <body>
    
    
    <!-- <div class="page"> -->
      <!-- Top Banner--><!--  a class="section section-banner text-center d-none d-xl-block" href="https://www.templatemonster.com/intense-multipurpose-html-template.html" style="background-image: url(images/banner/background-04-1920x60.jpg); background-image: -webkit-image-set( url(images/banner/background-04-1920x60.jpg) 1x, url(images/banner/background-04-3840x120.jpg) 2x )"><img src="images/banner/foreground-04-1600x60.png" srcset="images/banner/foreground-04-1600x60.png 1x, images/banner/foreground-04-3200x120.png 2x" alt="" width="1600" height="310"></a>-->
      <!-- Page Header-->
      <header class="section page-header">
        <!-- RD Navbar-->
        
        <div class="rd-navbar-wrap">
          <nav class="rd-navbar rd-navbar-modern" data-layout="rd-navbar-fixed" data-sm-layout="rd-navbar-fixed" data-md-layout="rd-navbar-fixed" data-md-device-layout="rd-navbar-fixed" data-lg-layout="rd-navbar-static" data-lg-device-layout="rd-navbar-fixed" data-xl-layout="rd-navbar-static" data-xl-device-layout="rd-navbar-static" data-xxl-layout="rd-navbar-static" data-xxl-device-layout="rd-navbar-static" data-lg-stick-up-offset="56px" data-xl-stick-up-offset="56px" data-xxl-stick-up-offset="56px" data-lg-stick-up="true" data-xl-stick-up="true" data-xxl-stick-up="true">
            <div class="rd-navbar-inner-outer">
              <div class="rd-navbar-inner">
                <!-- RD Navbar Panel-->
                <div class="rd-navbar-panel">
                  <!-- RD Navbar Toggle-->
                  <button class="rd-navbar-toggle" data-rd-navbar-toggle=".rd-navbar-nav-wrap"><span></span></button>
                  <!-- RD Navbar Brand-->
                  <div class="rd-navbar-brand"><a class="brand" href="index"><img class="brand-logo-dark" src="images/logo-TnT2.png" alt="logo" width="198" height="66"/></a></div>
                </div>
                <div class="rd-navbar-right rd-navbar-nav-wrap">
                  <div class="rd-navbar-aside">
                    <ul class="rd-navbar-contacts-2">
                      <li>
                        <div class="search">
			              <form class="searchBox" action="search" method="get" onsubmit="go_search()">
			                <input type="text" id="searchTextBox" name="key" placeholder="다음 여행지를 검색해 보세요">
			                <button type="submit" id="searchButton"> 
			                	<span class="blind">검색</span>
			                	<img class="search-image" src="images/search_icon_240.png"/>
			                </button>
			              </form>
			             </div>
                      </li>
                      
         			 <c:choose>
                      <c:when test="${empty sessionScope.loginUser}">
                      <li>
                          <div class="unit unit-spacing-xs">
                          <div class="unit-left"><img class="login-image" src="images/login-icon.png"/></div>
                          <div class="unit-body"><a class="phone" href="login_form">로그인</a></div>
                          </div>
                      </li>
                      <li>
                        <div class="unit unit-spacing-xs">
                          <div class="unit-left"><img class="signup-image" src="images/signup-icon.png"/></div>
                          <div class="unit-body"><a class="address" onclick="location='contract_form'" style="cursor: pointer;">회원가입</a></div>
                        </div>
                      </li>
                       </c:when>
                       <c:otherwise>
                       <li>
                          <div class="unit unit-spacing-xs">
                          <div class="unit-left"><img class="login-image" src="images/login-icon.png"/></div>
	                          <div class="unit-body"><a class="phone" href="logout">로그아웃</a></div>
                         </div>
                      </li>
                      <li>
                        <div class="unit unit-spacing-xs">
                          <div class="unit-left"><img class="signup-image" src="images/signup-icon.png"/></div>
                          <div class="unit-body"><a class="address" onclick="location='mypage_form'" style="cursor: pointer;">마이 페이지</a></div>
                        </div>
                      </li>
                      <c:if test="${sessionScope.loginUser.user_type == 1}">
      		 				<li>
      		 		<a href="admin_index">관리자화면</a>
      		 				</li>
      					 </c:if>
                      </c:otherwise>
					</c:choose> 
                                       
                    </ul>  
                    
                    
                    
                    <!-- <ul class="list-share-2">
                      <li><a class="icon mdi mdi-facebook" href="#"></a></li>
                      <li><a class="icon mdi mdi-twitter" href="#"></a></li>
                      <li><a class="icon mdi mdi-instagram" href="#"></a></li>
                      <li><a class="icon mdi mdi-google-plus" href="#"></a></li>
                    </ul> -->
                  </div>
                  <div class="rd-navbar-main">
                    <!-- RD Navbar Nav-->
                    <ul class="rd-navbar-nav">
                      <li class="rd-nav-item active"><a class="rd-nav-link" href="index">Home</a>
                      </li>
                      <li class="rd-nav-item"><a class="rd-nav-link" href="about-us">시즌 테마</a>
                      </li>
                      <li class="rd-nav-item"><a class="rd-nav-link" href="area">지역</a>
                      </li>
                      <li class="rd-nav-item"><a class="rd-nav-link" href="event-news?tabNum=1">이벤트&소식</a>
                      </li>
                    </ul>
                
                <div class="rd-navbar-project-hamburger rd-navbar-project-hamburger-open rd-navbar-fixed-element-1" data-multitoggle=".rd-navbar-inner" data-multitoggle-blur=".rd-navbar-wrap" data-multitoggle-isolate="data-multitoggle-isolate">
                  <div class="project-hamburger"><span class="project-hamburger-arrow"></span><span class="project-hamburger-arrow"></span><span class="project-hamburger-arrow"></span>
                  </div>
                </div>
                <div class="rd-navbar-project">
                  <!-- rd-navbar-project-title -->
                    <h5 class="ham-title">추천</h5>
                  
                    <ul class="ham-ul">
                      <li class="ham-li"><a class="ham-ul-a" href="worker_tList">관리자 추천 관광지</a>
                      </li>
                      <li class="ham-li"><a class="ham-ul-a" href="worker_rList">관리자 추천 맛집</a>
                      </li>
                      <li class="ham-li"><a class="ham-ul-a" href="member_tList">회원 추천 관광지</a>
                      </li>
                      <li class="ham-li"><a class="ham-ul-a" href="member_rList">회원 추천 맛집</a>
                      </li>
                    </ul>
              
            
              </div>
            </div>
          </nav>
        </div>
      </header>
      
     