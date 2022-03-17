<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css/board/style.css">
	<script src="js/board/jquery.min.js"></script>
	<script src="js/board/popper.js"></script>
	<script src="js/board/bootstrap.min.js"></script>
	<script src="js/board/main.js"></script>
	<script src="js/board/board.js"></script>
	

	</head>
	<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-4">
					<h2 class="heading-section">회원 추천 맛집</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h3 class="h5 mb-4 text-left">
					<a class="countlist">총 ${member0rListSize}건</a>
					</h3>
					<div class="btn_txt">
						<button type="button" class="btn"><span>최신순</span></button>
						<button type="button" class="btn"><span>인기순</span></button>
					</div>
					<form name="frm" id="member_rform" method="post">
					<div class="table-wrap">
						<table class="table">
						  <thead class="thead-primary">
						    <tr>
						    	<th>제목</th>
						      	<th>글쓴이</th>
						    </tr>
						  </thead>
						  <tbody>
						  <c:forEach var="member0_rList" items="${member0rList}">
						    <tr class="alert" role="alert">
						      <td>
						      	<div class="email">
						      		<span><a href="member_rDetail${pageMaker.makeQuery(pageMaker.criteria.pageNum)}&m0rseq=${member0_rList.m0rseq}">${member0_rList.subject}</a></span>
						      		<span>${member0_rList.regdate}</span>
						      	</div>
						      </td>
						      <td>
						      	<a id="writer">${member0_rList.name}</a>
				        	</td>
						    </tr>
						    </c:forEach>
						    <tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr>
						  </tbody>
						</table>
						<%@ include file="mr_page_area.jsp" %>
					</div>		
					</form>
					<button type="button" class="btn" id="insertboard" onclick="go_mrinsert()"><span>글쓰기</span></button>
				</div>
				<div class="area-box">
					<button type="button" class="btn" onClick = "location.href = '/biz/member_rList?area=전체'"><span>#전체</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/member_rList?area=서울특별시'"><span>#서울</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/member_rList?area=부산광역시'"><span>#부산</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/member_rList?area=대구광역시'"><span>#대구</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/member_rList?area=인천광역시'"><span>#인천</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/member_rList?area=광주광역시'"><span>#광주</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/member_rList?area=대전광역시'"><span>#대전</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/member_rList?area=울산광역시'"><span>#울산</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/member_rList?area=세종특별자치시'"><span>#세종</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/member_rList?area=경기도'"><span>#경기</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/member_rList?area=강원도'"><span>#강원</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/member_rList?area=충청남도'"><span>#충남</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/member_rList?area=충청북도'"><span>#충북</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/member_rList?area=경상북도'"><span>#경북</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/member_rList?area=경상남도'"><span>#경남</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/member_rList?area=전라북도'"><span>#전북</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/member_rList?area=전라남도'"><span>#전남</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/member_rList?area=제주특별자치도'"><span>#제주</span></button>
				</div>
			</div>
		</div>
	</section>

<%@ include file="../footer.jsp" %>  



