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
	<script>
		
		const BEFORE_IMG_URL = 'images/bookmark0.png';
		const AFTER_IMG_URL = 'images/bookmark1.png';
		
		function bookmarkOnClick ( componentId, memberId, m1rseq ) {
			const cId = '#'.concat(componentId); // #bookmark_1
			const xstgValue = $( cId ).attr('src');
			
			const cName = $( cId ).attr('name'); // bseq_1
			const bseq = cName.split("_")[1];
			
			const url = xstgValue === BEFORE_IMG_URL ? '/biz/ajax/insertM1rBM'
					  : xstgValue === AFTER_IMG_URL ? '/biz/ajax/deleteBM'
					  : '';
			console.log(url)
			console.log( componentId, bseq, memberId, m1rseq );
			
			$.ajax({
			      type : 'post' // 타입 (get, post, put 등등)
			    , url : url // 요청할 서버url
			    , dataType : 'json'// 데이터 타입 (html, xml, json, text 등등)
			    , data : { 
			        'm1rseq' : String(m1rseq)
			        , 'id' : String(memberId)
			        , 'bseq' : String(bseq)
			    }
			    , success : function(result) { // 결과 성공 콜백함수
					if ( xstgValue === BEFORE_IMG_URL ){
						$(cId).attr('src', AFTER_IMG_URL)
						$(cId).attr('name', 'bseq_'.concat(result.newBseq) )
						alert('즐겨찾기에 추가되었습니다.')
					} else {
						$(cId).attr('src', BEFORE_IMG_URL)
						$(cId).attr('name', 'bseq_'.concat('0') )
						alert('즐겨찾기에서 삭제되었습니다.')
					}
			    }
			    , error : function(request, status, error) { // 결과 에러 콜백함수
			    	alert('에러')
			    }
			})
			
		}
	</script>

	</head>
	<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-4">
					<h2 class="heading-section">관리자 추천 맛집</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h3 class="h5 mb-4 text-left">
					<a class="countlist">총 ${member1rListSize}건</a>
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
						    	<th>음식점</th>
						      	<th>&nbsp;</th>
						    </tr>
						  </thead>
						  <tbody>
						  	<c:forEach var="member1_rList" items="${member1rList}">
						    <tr class="alert" role="alert">
						    	<td>
						    		<div class="img"><a href="worker_rDetail${pageMaker.makeQuery(pageMaker.criteria.pageNum)}&m1rseq=${member1_rList.m1rseq}"><img src="images/member1_r/${member1_rList.image1}" style="width:195px; height:130px; object-fit: cover;"></a></div>
						    	</td>
						      <td>
						      	<div class="email">
						      		<span><a href="worker_rDetail${pageMaker.makeQuery(pageMaker.criteria.pageNum)}&m1rseq=${member1_rList.m1rseq}">${member1_rList.subject}</a></span>
						      		<span>${member1_rList.address}</span>
						      	</div>
						      </td>
						      
						      <c:set var="loginuserid" value="${loginUser.id}"/>
							  <c:if test="${not empty loginuserid}">
							    	<td>
							      		<a><img src=""
							      				id="bookmark_${status.count}" name = "bseq_${member1_rList.bseq}" style="cursor:pointer;" 
							      				onclick=" bookmarkOnClick ( 'bookmark_'.concat(${status.count}), '${loginUser.id}', '${member1_rList.m1rseq}' )">
						      			</a>
							    		<script>
							    			if ( Number('${member1_rList.bseq}') > 0  ){
							    				$('#bookmark_${status.count}').attr('src', AFTER_IMG_URL)
							    			} 
							    			else {
							    				$('#bookmark_${status.count}').attr('src', BEFORE_IMG_URL)
							    			}
							    		</script>
						        	 </td>
						           </c:if>
						    	</tr>
						    </c:forEach>
						    <tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr>
						  </tbody>
						</table>
						<%@ include file="wr_page_area.jsp" %>
					</div>
				</div>
				<div class="area-box">
					<button type="button" class="btn" onClick = "location.href = '/biz/worker_rList?area=전체'"><span>#전체</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/worker_rList?area=서울특별시'"><span>#서울</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/worker_rList?area=부산광역시'"><span>#부산</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/worker_rList?area=대구광역시'"><span>#대구</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/worker_rList?area=인천광역시'"><span>#인천</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/worker_rList?area=광주광역시'"><span>#광주</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/worker_rList?area=대전광역시'"><span>#대전</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/worker_rList?area=울산광역시'"><span>#울산</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/worker_rList?area=세종특별자치시'"><span>#세종</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/worker_rList?area=경기도'"><span>#경기</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/worker_rList?area=강원도'"><span>#강원</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/worker_rList?area=충청남도'"><span>#충남</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/worker_rList?area=충청북도'"><span>#충북</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/worker_rList?area=경상북도'"><span>#경북</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/worker_rList?area=경상남도'"><span>#경남</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/worker_rList?area=전라북도'"><span>#전북</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/worker_rList?area=전라남도'"><span>#전남</span></button>
					<button type="button" class="btn" onClick = "location.href = '/biz/worker_rList?area=제주특별자치도'"><span>#제주</span></button>
				</div>
			</div>
		</div>
	</section>

<%@ include file="../footer.jsp" %>  


