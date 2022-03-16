<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>

	<link rel="stylesheet" href="css/board/style.css">
	
	<style>
	.area_box span {
		font-size: 22px;
		margin: 5px;
	}
	</style>
	
	</head>
	<section class="ftco-section">
		<div class="boardcontainer">
			<h4 class="h4 mb-4 text-left">지역</h4>
			<div class="area_box">
				<button type="button" class="btn" onClick = "location.href = '/test/worker_tList?area=전체'"><span>#전체</span></button>
				<button type="button" class="btn" onClick = "location.href = '/test/worker_tList?area=서울특별시'"><span>#서울</span></button>
				<button type="button" class="btn" onClick = "location.href = '/test/worker_tList?area=부산광역시'"><span>#부산</span></button>
				<button type="button" class="btn" onClick = "location.href = '/test/worker_tList?area=대구광역시'"><span>#대구</span></button>
				<button type="button" class="btn" onClick = "location.href = '/test/worker_tList?area=인천광역시'"><span>#인천</span></button>
				<button type="button" class="btn" onClick = "location.href = '/test/worker_tList?area=광주광역시'"><span>#광주</span></button>
				<button type="button" class="btn" onClick = "location.href = '/test/worker_tList?area=대전광역시'"><span>#대전</span></button>
				<button type="button" class="btn" onClick = "location.href = '/test/worker_tList?area=울산광역시'"><span>#울산</span></button>
				<button type="button" class="btn" onClick = "location.href = '/test/worker_tList?area=세종특별자치시'"><span>#세종</span></button>
				<button type="button" class="btn" onClick = "location.href = '/test/worker_tList?area=경기도'"><span>#경기</span></button>
				<button type="button" class="btn" onClick = "location.href = '/test/worker_tList?area=강원도'"><span>#강원</span></button>
				<button type="button" class="btn" onClick = "location.href = '/test/worker_tList?area=충청남도'"><span>#충남</span></button>
				<button type="button" class="btn" onClick = "location.href = '/test/worker_tList?area=충청북도'"><span>#충북</span></button>
				<button type="button" class="btn" onClick = "location.href = '/test/worker_tList?area=경상북도'"><span>#경북</span></button>
				<button type="button" class="btn" onClick = "location.href = '/test/worker_tList?area=경상남도'"><span>#경남</span></button>
				<button type="button" class="btn" onClick = "location.href = '/test/worker_tList?area=전라북도'"><span>#전북</span></button>
				<button type="button" class="btn" onClick = "location.href = '/test/worker_tList?area=전라남도'"><span>#전남</span></button>
				<button type="button" class="btn" onClick = "location.href = '/test/worker_tList?area=제주특별자치도'"><span>#제주</span></button>
			</div>
		</div>
	</section>
 
<%@ include file="footer.jsp" %>  


