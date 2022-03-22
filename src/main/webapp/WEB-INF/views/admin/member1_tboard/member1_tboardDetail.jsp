<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header id="header">
	<div id="header_box">
		<%@ include file="../header.jsp" %> 
		</div>
	</header>
	<aside id="aside">
		<div id="aside_box">
		<%@ include file="../aside.jsp" %> 
		</div>
	</aside>
	<div id=container>
<h1>관리자여행지 상세 보기</h1> 
    <div id="map" style="width:1024px;height:350px;margin-bottom:40px"></div>
<form name="m1tfrm" id="m1tdetail_form" method="post">
<input type="hidden" name="m1tseq" value="${member1_tboardVO.m1tseq}"/>
<input id="address" type="hidden" value="${member1_tboardVO.address}">
		<input type="hidden" name="pageNum" value="${criteria.pageNum}">
        <input type="hidden" name="rowsPerPage" value="${criteria.rowsPerPage}"> 
        <input type="hidden" name="keyword" value="${criteria.keyword}">
<table id="list">
    <tr>
        <th align="center" >지역</th>
        <td colspan="5">${member1_tboardVO.area}</td>
    </tr>    
    <tr>
        <th align="center" >제목</th>
        <td colspan="5">${member1_tboardVO.subject}</td>
    </tr>
    
     
    <tr>
        <th>내용</th>
        <td colspan="5">${member1_tboardVO.content}</td>
    </tr>

      <tr>
        <th>주소</th>
        <td colspan="5">${member1_tboardVO.address}</td>
    </tr>  
    <tr>
        <th>편의시설</th>
        <td colspan="5">${member1_tboardVO.convenience}</td>
    </tr>
      <tr>
        <th>전화번호</th>
        <td colspan="5">${member1_tboardVO.phone}</td>
    </tr>
    <tr>
     <th>이미지</th>
     <td colspan="5" align="center">
  <!--[7] 이미지를 출력하기 -->     
     <img src="member1_tboard_images/${member1_tboardVO.image1}" width="200pt">  
     </td>
    </tr>
     
</table>
<!--[8] 수정 버튼이 눌리면 수정 페이지로 이동하되 현재 페이지와  일련번호 값을 전달해 준다. --> 
<input class="btn" id="list_btn" type="button" value="목록" onClick="go_list('${criteria.pageNum}', '${criteria.rowsPerPage}')">
<input class="btn" type="button"  value="삭제" onClick="go_delete()">

<input class="btn"  type="button" value="수정" onClick="go_m1tmod('${criteria.pageNum}', '${criteria.rowsPerPage}','${member1_tboardVO.m1tseq}')">            
</form>
</div>

	<footer id="footer">
	<div id="footer_box">
		<%@ include file="../footer.jsp" %> 
	</div>
</footer>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0d084e07a8c1557f5ddba2b8502865d9&libraries=services"></script>
	<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

	var address = document.getElementById('address').value;
	
	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(address, function(result, status) {
	
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
	            content: '<div style="width:150px;text-align:cente;padding:6px 0;">${m1t.subject}</div>'
	        });
	        infowindow.open(map, marker);
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } 
	});   
	</script>
</body>
</html>