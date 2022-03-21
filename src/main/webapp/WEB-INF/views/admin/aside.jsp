<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<script>
function printClock() {
    
    var clock = document.getElementById("clock");            // 출력할 장소 선택
    var currentDate = new Date();                                     // 현재시간
    var calendar = currentDate.getFullYear() + "-" + (currentDate.getMonth()+1) + "-" + currentDate.getDate() // 현재 날짜
    var amPm = 'AM'; // 초기값 AM
    var currentHours = addZeros(currentDate.getHours(),2); 
    var currentMinute = addZeros(currentDate.getMinutes() ,2);
    var currentSeconds =  addZeros(currentDate.getSeconds(),2);
    
    if(currentHours >= 12){ // 시간이 12보다 클 때 PM으로 세팅, 12를 빼줌
    	amPm = 'PM';
    	currentHours = addZeros(currentHours - 12,2);
    }

    if(currentSeconds >= 50){// 50초 이상일 때 색을 변환해 준다.
       currentSeconds = '<span style="color:#de1951;">'+currentSeconds+'</span>'
    }
    clock.innerHTML =" <span style='font-size:30px;'>&nbsp;"+ amPm+ currentHours+":"+currentMinute+":"+currentSeconds +"</span>"; //날짜를 출력해 줌
    
    setTimeout("printClock()",1000);         // 1초마다 printClock() 함수 호출
}
$(document).ready = printClock;
</script>
<style>
@import url(//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css);
}
@import url(https://fonts.googleapis.com/css?family=Titillium+Web:300);
.fa-2x {
font-size: 2em;
}
.fa {
position: relative;
display: table-cell;
width: 60px;
height: 36px;
text-align: center;
vertical-align: middle;
font-size:20px;
}


.main-menu:hover,nav.main-menu.expanded,#sub-menu {
width:250px;
overflow:visible;
}

.main-menu {
background:#212121;
border-right:1px solid #e5e5e5;
position:absolute;
top:0;
bottom:0;
height:100%;
left:0;
width:60px;
overflow:hidden;
-webkit-transition:width .05s linear;
transition:width .05s linear;
-webkit-transform:translateZ(0) scale(1,1);
z-index:1000;
}

.main-menu>ul {
margin:7px 0;
}

.main-menu li {
position:relative;
display:block;
width:250px;
}

.main-menu li>a {
position:relative;
display:table;
border-collapse:collapse;
border-spacing:0;
color:#999;
 font-family: arial;
font-size: 14px;
text-decoration:none;
-webkit-transform:translateZ(0) scale(1,1);
-webkit-transition:all .1s linear;
transition:all .1s linear;
  
}

.main-menu .nav-icon {
position:relative;
display:table-cell;
width:60px;
height:36px;
text-align:center;
vertical-align:middle;
font-size:18px;
}

.nav-text {
position:relative;
display:table-cell;
vertical-align:middle;
width:190px;
  font-family: 'Titillium Web', sans-serif;
}

.main-menu>ul.logout {
position:absolute;
left:0;
bottom:0;
}

.no-touch .scrollable.hover {
overflow-y:hidden;
}

.no-touch .scrollable.hover:hover {
overflow-y:auto;
overflow:visible;
}
 
.main-menu>ul {
margin:7px 0;
}

.main-menu li {
position:relative;
display:block;
width:250px;
}

.main-menu li>a {
position:relative;
display:table;
border-collapse:collapse;
border-spacing:0;
color:#999;
 font-family: arial;
font-size: 14px;
text-decoration:none;
-webkit-transform:translateZ(0) scale(1,1);
-webkit-transition:all .1s linear;
transition:all .1s linear;
  
}
a:hover,a:focus {
text-decoration:none;
}

nav {
-webkit-user-select:none;
-moz-user-select:none;
-ms-user-select:none;
-o-user-select:none;
user-select:none;
}

nav ul,nav li {
outline:0;
margin:0;
padding:0;
}
.main-menu li:hover>a,nav.main-menu li.active>a,.dropdown-menu>li>a:hover,.dropdown-menu>li>a:focus,.dropdown-menu>.active>a,.dropdown-menu>.active>a:hover,.dropdown-menu>.active>a:focus,.no-touch .dashboard-page nav.dashboard-menu ul li:hover a,.dashboard-page nav.dashboard-menu ul li.active a {
color:#fff;
background-color:#5fa2db;
}
.area {
float: left;
background: #e2e2e2;
width: 100%;
height: 100%;
}
@font-face {
  font-family: 'Titillium Web';
  font-style: normal;
  font-weight: 300;
  src: local('Titillium WebLight'), local('TitilliumWeb-Light'), url(http://themes.googleusercontent.com/static/fonts/titilliumweb/v2/anMUvcNT0H1YN4FII8wpr24bNCNEoFTpS2BTjF6FB5E.woff) format('woff');
}
.main-menu > ul ul {
    display: none;
    top: 0;
    left: 100%;
background:#212121;
border-right:1px solid #e5e5e5;
	color:#fff;
}
.main-menu ul > li:hover ul {
    display: block;
    
}
#admin_title{
magin: 2px;
color: #fff;
}
#clock{
position:absolute;
left:0;
bottom:20;}
</style>

</head>
<body onload="printClock()"><div class="area"></div><nav class="main-menu">
<h1 id="admin_title" style="color:#fff";><a href="admin_newsboard_list"style="color:#fff";>T&T<span id="admin" style="color:#fff";>Admin</span></a></h1>
            <ul>
                <li>
                    <a href="index">
                        <i class="fa fa-home fa-2x"></i>
                        <span class="nav-text">
                            홈으로
                        </span>
                    </a>
                  
                </li>
                
                <li>
                    <a href="#">
                       <i class="fa fa-list fa-2x"></i>
                        <span class="nav-text">
                          	  관리자게시판
                        </span>
                    </a>

                    <ul class="sub-menu">
                    			<li><a href='admin_newsboard_list'>  <i class="fa"></i><span class="nav-text"> 소식</span></a></li>
								<li><a href='admin_eventboard_list'>  <i class="fa"></i><span class="nav-text"> 이벤트</span></a></li>
								<li><a href='admin_seasonboard_list'>  <i class="fa"></i> <span class="nav-text">시즌테마</span></a></li>
								<li><a href='admin_member0_tboard_list'>  <i class="fa"></i><span class="nav-text">회원 여행지</span></a></li>
								<li><a href='admin_member0_rboard_list'>   <i class="fa"></i><span class="nav-text">회원 맛집</span></a></li>
								<li><a href='admin_member1_tboard_list'>  <i class="fa"></i><span class="nav-text"> 관리자 여행지</span></a></li>
								<li><a href='admin_member1_rboard_list'>  <i class="fa"></i><span class="nav-text"> 관리자 맛집</span></a></li>
              	  </ul>

            	</li>
      
                
                <li>
                   <a href="admin_member_list">
                       <i class="fa fa-table fa-2x"></i>
                        <span class="nav-text">
                            회원 리스트
                        </span>
                    </a>
                </li>
                <li>
                   <a href="address">
                        <i class="fa fa-map-marker fa-2x"></i>
                        <span class="nav-text">
                            Maps
                        </span>
                    </a>
                </li>
                <li>
                    <a href="#">
                       <i class="fa fa-info fa-2x"></i>
                        <span class="nav-text">
                            ii
                        </span>
                    </a>
                </li>
            </ul>
<div class="top-part" style=" color: #666; font-size: 15px;" id="clock"></div>
            <ul class="logout">
                <li>
                   <a href="admin_logout">
                         <i class="fa fa-power-off fa-2x"></i>
                        <span class="nav-text">
                            Logout
                        </span>
                    </a>
                </li>  
            </ul>
        </nav>
  </body>
    </html>