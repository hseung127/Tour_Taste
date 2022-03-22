<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Main</title>
<script src='js/main.js'></script>
<script src='js/calendar.js'></script>
<script src='js/clock.js'></script>
<script>


function addZeros(num, digit) { // 자릿수 맞춰주기
	  var zero = '';
	  num = num.toString();
	  if (num.length < digit) {
	    for (i = 0; i < digit - num.length; i++) {
	      zero += '0';
	    }
	  }
	  return zero + num;
}
 </script>
		<script> $('#calendar'). fullCalendar ({ 
				googleCalendarApiKey: 'AIzaSyD-hhwVvgAMdzBbH8tgayvMjw8D6a1NvRw', 
				header: { 
					left: '',center: 'prev, title, next', 
					// right: 'month, basicWeek, agendaDay'
			right: '' 
			}, 
			monthYearFormat: 'MMMM YYYY', 
			ventLimit: true,
			fixedWeekCount: false, defaultView: 'month', 
			dayNamesShort:["S","M","T","W","T","F","S"],
			buttonText: { 
				today : "오늘", 
				month :"월별",
				week : "주별", 
				day : "일별", 
				}, 
			eventSources : // 한국 기념일ko.south_korea 추가 
			[ { googleCalendarId : 'qkrdmlghks@kakao.com' } , 
				 ] }); </script>
	<style>			 
 * {
  box-sizing: border-box;
  outline: none;
}



:root {
  --bg-color: #f5f8ff;;
  --main-color: #353536;
  --secondary-color: #8e92a4;
  --main-text-color: #5d606b;
  --secondary-dark-color: #9496a5;
  --tag-color-one: #e0fbf6;
  --tag-color-text-one: #58c2a9;
  --tag-color-two: #ece7fe;
  --tag-color-text-two: #8972f3;
  --tag-color-three: #fde7ea;
  --tag-color-text-three: #e77f89;
  --tag-color-four: #f7f8fc;
  --tag-color-text-four: #a0a6b5;
  --button-color: #49beb7;
  --box-color: #fff1d6;
  --box-color-2: #d3e6ff;
  --box-color-3: #ffd9d9;
  --box-color-4: #daffe5;
  --task-color: #777982;
}

%flex {
  display: flex;
  align-items: center;
}


ul {
  list-style-type: none;
  padding: 0;
}

button { 
  border: none; 
  background: none;
  cursor: pointer;
}

.task-manager {
  display: flex;
  justify-content: space-between;
  width: 100%;
  background: #fff;
  border-radius: 4px;
  box-shadow:
  0 0.3px 2.2px rgba(0, 0, 0, 0.011),
  0 0.7px 5.3px rgba(0, 0, 0, 0.016),
  0 1.3px 10px rgba(0, 0, 0, 0.02),
  0 2.2px 17.9px rgba(0, 0, 0, 0.024),
  0 4.2px 33.4px rgba(0, 0, 0, 0.029),
  0 10px 80px rgba(0, 0, 0, 0.04);
  overflow: hidden;
}







.circle {
  border-radius: 50%;
  width: 10px;
  height: 10px;
  background-color: #fe4d46;
  box-shadow: 14px 0 0 0 #fbc023, 28px 0 0 0 #7dd21f;
}

.circle-2 {
  border-radius: 50%;
  width: 4px;
  height: 4px;
  background-color: #d5d7e3;
  box-shadow: -6px 0 0 0 #d5d7e3, 6px 0 0 0 #d5d7e3;
}

.right-bar {
  width: 320px;
  border-left: 1px solid #e3e7f7;
  display: flex;
  flex-direction: column;
 } 
  #header { 
    font-size: 20px; 
    color: var(--main-text-color);
    margin-left: 30px;
    text-align: center;
    height: 100px;
  }


.top-part {
  padding: 10px;
  @extend %flex; 
  

}

.right-content {
  padding: 10px 40px;
  overflow-y: auto;
  flex: 1;
}

.task-box {
  position: relative;
  border-radius: 12px;
  width: 100%;
  margin: 20px 0;
  padding: 16px;
  cursor: pointer;
  box-shadow: 2px 2px 4px 0px rgba(235,235,235,1);
  
  &:hover {
    transform: scale(1.02);
  }
}





}
 .header { 
    font-size: 26px; 
    color: var(--main-color); 
    margin-top: 30px;
    text-align: center;
  }
.page-content1 {
  display: flex;
  flex-direction: column;
  flex: 1;
  padding: 40px 20px 0 300px;
}

.page-content2 {
  display: flex;
  flex-direction: column;
  flex: 1;
  padding: 40px 20px 0 20px;
}



.tasks-wrapper {
  padding: 30px 0;
  flex: 1;
  overflow-y: auto;
  height: 100%;
  padding-right: 8px;
}

.task {
  display: flex;
  justify-content: space-between;
  position: relative;
  margin-bottom: 16px;
  padding-left: 30px;
  color: var(--task-color);
  font-size: 13px;
  font-weight: 500;
  
  &:hover {
    transform: translatex(2px);
  }
  

}

 label .label-text { position: relative; }

 label .label-text:before {
  content:'';
  position: absolute;
  width: 14px;
  height: 14px;
  border: 1px solid #ddd;
  border-radius: 2px;
  left: -24px;
  transition: .2s ease;
}



.tag {
  font-size: 10px;
  padding: 4px 8px;
  border-radius: 20px;
  
  &.approved {
    background-color: var(--tag-color-one);
    color: var(--tag-color-text-one);
  }
  
  &.progress {
    background-color: var(--tag-color-two);
    color: var(--tag-color-text-two);
  }
  
  &.review {
    background-color: var(--tag-color-three);
    color: var(--tag-color-text-three);
  }
  
  &.waiting {
    background-color: var(--tag-color-four);
    color: var(--tag-color-text-four);
  }
}

.upcoming { 
  border-bottom: 1px solid #ddd; 
  padding-bottom: 30px;
  margin-bottom: 30px;
}

@media screen and (max-width: 900px) {
  .left-bar {
    display: none;
  }
}

@media screen and (max-width: 700px) {
  .task-manager {
    flex-direction: column;
    overflow-y: auto;
  }
  
  .right-bar, .page-content1,.page-content2 {
    width: 100%;
    display: block;
  }
  
  .tasks-wrapper { height: auto; }
}

@media screen and (max-width: 520px) {
  .page-content1 { padding: 40px 10px 0 10px; }
  
  .right-content { padding: 10px 16px; }
  
}				
				 </style>

</head>

<body onload="printClock()">
	<div class="header">
		<%@ include file="header.jsp" %> 
		</div>	
<div class="task-manager">

	<section>
	<aside>
		<%@ include file="aside.jsp" %> 
	</aside>
	</section>
  <div class="page-content1">
<a>${homeSeasonList[0].subject} </a>
    <div class="tasks-wrapper">
    <a class="countlist">${newsboardList}</a>
    
    <div class="header upcoming">소식 게시판</div>
   
  			                    <ul class="list_board">
			                        <li>
			                            <a href="news_detail?nseq=${homeNewsList[0].nseq}" ><em style="color:#a2660d">코로나바이러스감염증-19ㅣ</em> ${homeNewsList[0].subject}</a>
			                        
			                
      </div>
      <div class="header upcoming">이벤트 게시판</div>
    <div>
      <ul class="list_board">
			                        <li>
			                            <a href="#" > <span class="label-text">제목</span></a>
			                        </li>
			                        <li>
			                            <a href="#" >제목</a>
			                        </li>
			                        <li>
			                            <a href="#"  >제목</a>
			                        </li>
			                        <li>
			                            <a href="#" >제목</a>
			                        </li>
			                    </ul>
      </div>
      <div class="header upcoming">시즌 게시판</div>
    <div>
      <ul class="list_board">
			                        <li>
			                            <a href="#" > <span class="label-text">제목</span></a>
			                        </li>
			                        <li>
			                            <a href="#" >제목</a>
			                        </li>
			                        <li>
			                            <a href="#"  >제목</a>
			                        </li>
			                        <li>
			                            <a href="#" >제목</a>
			                        </li>
			                    </ul>
			                    <br>
			                    <br>
			                
      </div>
      <hr>
      <div class="header upcoming">회원 맛집 게시판</div>
    <div>
      <ul class="list_board">
			                        <li>
			                            <a href="#" > <span class="label-text">제목</span></a>
			                        </li>
			                        <li>
			                            <a href="#" >제목</a>
			                        </li>
			                        <li>
			                            <a href="#"  >제목</a>
			                        </li>
			                        <li>
			                            <a href="#" >제목</a>
			                        </li>
			                    </ul>
      </div>

    </div>
  </div>
    <div class="page-content2">
    <div class="tasks-wrapper">
         <div class="header upcoming">회원 여행 게시판</div>
    <div>
      <ul class="list_board">
			                        <li>
			                            <a href="#" > <span class="label-text">제목</span></a>
			                        </li>
			                        <li>
			                            <a href="#" >제목</a>
			                        </li>
			                        <li>
			                            <a href="#"  >제목</a>
			                        </li>
			                        <li>
			                            <a href="#" >제목</a>
			                        </li>
			                    </ul>
      </div>
      <div class="header upcoming">관리자 맛집 게시판</div>
    <div>
      <ul class="list_board">
			                        <li>
			                            <a href="#" > <span class="label-text">제목</span></a>
			                        </li>
			                        <li>
			                            <a href="#" >제목</a>
			                        </li>
			                        <li>
			                            <a href="#"  >제목</a>
			                        </li>
			                        <li>
			                            <a href="#" >제목</a>
			                        </li>
			                    </ul>
      </div>
      <div class="header upcoming">관리자 여행 게시판</div>
    <div>
      <ul class="list_board">
			                        <li>
			                            <a href="#" > <span class="label-text">제목</span></a>
			                        </li>
			                        <li>
			                            <a href="#" >제목</a>
			                        </li>
			                        <li>
			                            <a href="#"  >제목</a>
			                        </li>
			                        <li>
			                            <a href="#" >제목</a>
			                        </li>
			                    </ul>
      </div>
    </div>

</div>
<div id='calendar' style="width:300px; height:300px"></div>
  <div class="right-bar">

    <div class="top-part" style=" color: #666; font-size: 15px; text-align: center;"
				id="clock">
      현재시간
    </div>
    <div class="right-content">
   <div id="map" style="width:225px;height:240px;"></div><a href="address" style="text-align: center;">지도 이동</a>

  
    </div>
  </div>
  </div>
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0d084e07a8c1557f5ddba2b8502865d9&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('서울 송파구 올림픽로 240', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:100px;text-align:center;padding:6px 0;">롯데월드</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>
</body>
</html>