<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	
	<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Roboto:100,300,300i,400,500,600,700,900%7CRaleway:500">
	<link rel="stylesheet" href="css/board/style.css">
	
	<script src="js/board/jquery.min.js"></script>
	<script src="js/board/popper.js"></script>
	<script src="js/board/bootstrap.min.js"></script>
	<script src="js/board/main.js"></script>

	</head>
	<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-4">
					<h2 class="heading-section">관리자 추천 관광지</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h3 class="h5 mb-4 text-left">
					<a class="countlist">총 ${member1tListSize}건</a>
					</h3>
					<div class="btn_txt">
						<button type="button" class="btn"><span>최신순</span></button>
						<button type="button" class="btn"><span>인기순</span></button>
					</div>
					<div class="table-wrap">
						<table class="table">
						  <thead class="thead-primary">
						    <tr>
						    	<th>사진</th>
						    	<th>관광지</th>
						      	<th>&nbsp;</th>
						    </tr>
						  </thead>
						  <tbody>
						  	<c:forEach var="member1_tList" items="${member1tList}">
						    <tr class="alert" role="alert">
						    	<td>
						    		<!-- <div class="img" style="background-image: url(images/gallery-1-1200x800-original.jpg);"></div> -->
						    		<div class="img"><a href="worker_tDetail${pageMaker.makeQuery(pageMaker.criteria.pageNum)}&m1tseq=${member1_tList.m1tseq}"><img src="images/member1_t/한글.jpg"></a></div>
						    	</td>
						      <td>
						      	<div class="email">
						      		<span><a href="worker_tDetail${pageMaker.makeQuery(pageMaker.criteria.pageNum)}&m1tseq=${member1_tList.m1tseq}">${member1_tList.subject}</a></span>
						      		<span>${member1_tList.address}</span>
						      	</div>
						      </td>
						      <td>
						      	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				            	<span aria-hidden="true"><i class="fa fa-close"></i></span>
				          		</button>
				        	</td>
						    </tr>
						    </c:forEach>
						    <tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr>
						  </tbody>
						</table>
						<%@ include file="wt_page_area.jsp" %>
					</div>
				</div>
				<div class="area-box">
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
		</div>
	</section>
 
<%@ include file="../footer.jsp" %>  


