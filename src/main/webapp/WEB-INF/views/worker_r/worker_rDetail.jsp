<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<link rel="stylesheet" href="css/board/style.css">

	<!-- Link Swiper's CSS -->
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>

    <!-- Demo styles -->
    <style>
      html,
      body {
        position: relative;
        height: 100%;
      }

      body {
        background: #fff;
        font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
        font-size: 14px;
        color: #000;
        margin: 0;
        padding: 0;
      }

      .swiper {
        width: 100%;
        height: 100%;
        margin: 25px 0px;
      }

      .swiper-slide {
        text-align: center;
        font-size: 18px;
        background: #fff;

        /* Center slide text vertically */
        display: -webkit-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex;
        -webkit-box-pack: center;
        -ms-flex-pack: center;
        -webkit-justify-content: center;
        justify-content: center;
        -webkit-box-align: center;
        -ms-flex-align: center;
        -webkit-align-items: center;
        align-items: center;
      }

      .swiper-slide img {
        display: block;
        width: 100%;
        height: 100%;
        object-fit: cover;
      }
    </style>
  	</head> 
  	
	<section class="ftco-section">
		<div class="boardcontainer">
			<h3 class="h3 mb-4 text-center">${m1r.subject}</h3>
			<hr>
		    <div class="swiper mySwiper">
		      <div class="swiper-wrapper">
		        <div class="swiper-slide"><img src="images/member1_t/m1t_00001_image01.png"></img></div>
		        <div class="swiper-slide"><img src="images/member1_t/m1t_00002_image01.png"></img></div>
		        <div class="swiper-slide"><img src="images/member1_t/m1t_00003_image01.png"></img></div>
		        <div class="swiper-slide"><img src="images/member1_t/m1t_00004_image01.png"></img></div>
		        <div class="swiper-slide"><img src="images/member1_t/m1t_00005_image01.png"></img></div>
		      </div>
		      <div class="swiper-button-next"></div>
		      <div class="swiper-button-prev"></div>
		    </div>
		    <h5 class="h5 mb-4 text-left">?????? : ${m1r.address}</h5>
		    <h5 class="h5 mb-4 text-left">???????????? : ${m1r.phone}</h5>
			<hr>
			<div id="map" style="width:940px;height:400px;margin-bottom:40px"></div>
			<hr>
			<input id="address" type="hidden" value="${m1r.address}">
		</div>
	</section>

	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0c9691acd20617ed5ba8b8ae9c71aed1&libraries=services"></script>
	<script>
	var mapContainer = document.getElementById('map'), // ????????? ????????? div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // ????????? ????????????
        level: 3 // ????????? ?????? ??????
    };  

	var address = document.getElementById('address').value;
	
	// ????????? ???????????????    
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	// ??????-?????? ?????? ????????? ???????????????
	var geocoder = new kakao.maps.services.Geocoder();
	
	// ????????? ????????? ???????????????
	geocoder.addressSearch(address, function(result, status) {
	
	    // ??????????????? ????????? ??????????????? 
	     if (status === kakao.maps.services.Status.OK) {
	
	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	
	        // ??????????????? ?????? ????????? ????????? ???????????????
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });
	
	        // ?????????????????? ????????? ?????? ????????? ???????????????
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:cente;padding:6px 0;">${m1r.subject}</div>'
	        });
	        infowindow.open(map, marker);
	
	        // ????????? ????????? ??????????????? ?????? ????????? ??????????????????
	        map.setCenter(coords);
	    } 
	});   
	</script>
  	<body>

    <!-- Swiper JS -->
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

    <!-- Initialize Swiper -->
    <script>
      var swiper = new Swiper(".mySwiper", {
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
      });
    </script>
<%@ include file="../footer.jsp" %>  