<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>

	<link rel="stylesheet" href="css/board/style.css">
	
	<style>
	.area_box span {
		font-size: 22px;
		margin: 5px;
	}
	
	.hotplace_view {
		margin-top: 50px;
	}
	</style>
	
	</head>
	<section class="ftco-section">
		<div class="boardcontainer">
			<h4 class="h4 mb-4 text-left">지역</h4>
			<div class="area_box">
				<button type="button" class="btn" onClick = "location.href = '/biz/worker_tList?area=전체'"><span>#전체</span></button>
				<button type="button" class="btn" onClick = "location.href = '/biz/worker_tList?area=서울특별시'"><span>#서울</span></button>
				<button type="button" class="btn" onClick = "location.href = '/biz/worker_tList?area=부산광역시'"><span>#부산</span></button>
				<button type="button" class="btn" onClick = "location.href = '/biz/worker_tList?area=대구광역시'"><span>#대구</span></button>
				<button type="button" class="btn" onClick = "location.href = '/biz/worker_tList?area=인천광역시'"><span>#인천</span></button>
				<button type="button" class="btn" onClick = "location.href = '/biz/worker_tList?area=광주광역시'"><span>#광주</span></button>
				<button type="button" class="btn" onClick = "location.href = '/biz/worker_tList?area=대전광역시'"><span>#대전</span></button>
				<button type="button" class="btn" onClick = "location.href = '/biz/worker_tList?area=울산광역시'"><span>#울산</span></button>
				<button type="button" class="btn" onClick = "location.href = '/biz/worker_tList?area=세종특별자치시'"><span>#세종</span></button>
				<button type="button" class="btn" onClick = "location.href = '/biz/worker_tList?area=경기도'"><span>#경기</span></button>
				<button type="button" class="btn" onClick = "location.href = '/biz/worker_tList?area=강원도'"><span>#강원</span></button>
				<button type="button" class="btn" onClick = "location.href = '/biz/worker_tList?area=충청남도'"><span>#충남</span></button>
				<button type="button" class="btn" onClick = "location.href = '/biz/worker_tList?area=충청북도'"><span>#충북</span></button>
				<button type="button" class="btn" onClick = "location.href = '/biz/worker_tList?area=경상북도'"><span>#경북</span></button>
				<button type="button" class="btn" onClick = "location.href = '/biz/worker_tList?area=경상남도'"><span>#경남</span></button>
				<button type="button" class="btn" onClick = "location.href = '/biz/worker_tList?area=전라북도'"><span>#전북</span></button>
				<button type="button" class="btn" onClick = "location.href = '/biz/worker_tList?area=전라남도'"><span>#전남</span></button>
				<button type="button" class="btn" onClick = "location.href = '/biz/worker_tList?area=제주특별자치도'"><span>#제주</span></button>
			</div>
			<hr>
			<div class="hotplace_view">
				<h4 class="h4 mb-4 text-left">꽃피는 3월의 인기 여행지</h4>
					<div class="row row-md row-30">
		            <div class="col-sm-6 col-lg-4">
		              <div class="oh-desktop">
		                <article class="services-terri wow slideInUp">
		                  <div class="services-terri-figure"><img src="images/area/jeju.jpg"   alt="" style="width:370px;height:278px; object-fit: cover;"/>
		                  </div>
		                  <div class="services-terri-caption">
		                    <h5 class="services-terri-title"><a href="/biz/worker_tList?area=제주특별자치도">제주도 서귀포</a></h5>
		                  </div>
		                </article>
		              </div>
		            </div>
		            <div class="col-sm-6 col-lg-4">
		              <div class="oh-desktop">
		                <article class="services-terri wow slideInDown">
		                  <div class="services-terri-figure"><img src="images/area/busan.jpg" alt="" style="width:370px;height:278px; object-fit: cover;"/>
		                  </div>
		                  <div class="services-terri-caption">
		                    <h5 class="services-terri-title"><a href="/biz/worker_tList?area=부산광역시">부산특별시</a></h5>
		                  </div>
		                </article>
		              </div>
		            </div>
		            <div class="col-sm-6 col-lg-4">
		              <div class="oh-desktop">
		                <article class="services-terri wow slideInUp">
		                  <div class="services-terri-figure"><img src="images/area/yeosu.jpg" alt="" style="width:370px;height:278px; object-fit: cover;"/>
		                  </div>
		                  <div class="services-terri-caption">
		                    <h5 class="services-terri-title"><a href="/biz/worker_tList?area=전라남도">전라남도 여수</a></h5>
		                  </div>
		                </article>
		              </div>
		            </div>
		            <div class="col-sm-6 col-lg-4">
		              <div class="oh-desktop">
		                <article class="services-terri wow slideInDown">
		                  <div class="services-terri-figure"><img src="images/area/danyang.jpg" alt="" style="width:370px;height:278px; object-fit: cover;"/>
		                  </div>
		                  <div class="services-terri-caption">
		                    <h5 class="services-terri-title"><a href="/biz/worker_tList?area=충청북도">충청북도 단양</a></h5>
		                  </div>
		                </article>
		              </div>
	            	</div>
	            	<div class="col-sm-6 col-lg-4">
		              <div class="oh-desktop">
		                <article class="services-terri wow slideInUp">
		                  <div class="services-terri-figure"><img src="images/area/gyeongju.jpg"   alt="" style="width:370px;height:278px; object-fit: cover;"/>
		                  </div>
		                  <div class="services-terri-caption">
		                    <h5 class="services-terri-title"><a href="/biz/worker_tList?area=경상북도">경상북도 경주</a></h5>
		                  </div>
		                </article>
		              </div>
		            </div>
		            <div class="col-sm-6 col-lg-4">
		              <div class="oh-desktop">
		                <article class="services-terri wow slideInUp">
		                  <div class="services-terri-figure"><img src="images/area/gangreung.jpg"   alt="" style="width:370px;height:278px; object-fit: cover;"/>
		                  </div>
		                  <div class="services-terri-caption">
		                    <h5 class="services-terri-title"><a href="/biz/worker_tList?area=강원도">강원도 강릉</a></h5>
		                  </div>
		                </article>
		              </div>
		            </div>
				</div>
			</div>
			<br>
			<hr>
			<div class="hotplace_view">
				<h4 class="h4 mb-4 text-left">3월의  인기만점 맛있는 집</h4>
					<div class="row row-md row-30">
		            <div class="col-sm-6 col-lg-4">
		              <div class="oh-desktop">
		                <article class="services-terri wow slideInUp">
		                  <div class="services-terri-figure"><img src="images/area/r1.jpg"   alt="" style="width:370px;height:278px; object-fit: cover;"/>
		                  </div>
		                  <div class="services-terri-caption">
		                    <h5 class="services-terri-title"><a href="#">현대옥</a></h5>
		                  </div>
		                </article>
		              </div>
		            </div>
		            <div class="col-sm-6 col-lg-4">
		              <div class="oh-desktop">
		                <article class="services-terri wow slideInDown">
		                  <div class="services-terri-figure"><img src="images/area/r2.jpg" alt="" style="width:370px;height:278px; object-fit: cover;"/>
		                  </div>
		                  <div class="services-terri-caption">
		                    <h5 class="services-terri-title"><a href="#">서가앤쿡</a></h5>
		                  </div>
		                </article>
		              </div>
		            </div>
		            <div class="col-sm-6 col-lg-4">
		              <div class="oh-desktop">
		                <article class="services-terri wow slideInUp">
		                  <div class="services-terri-figure"><img src="images/area/r3.jpg" alt="" style="width:370px;height:278px; object-fit: cover;"/>
		                  </div>
		                  <div class="services-terri-caption">
		                    <h5 class="services-terri-title"><a href="#">남원어촌횟집</a></h5>
		                  </div>
		                </article>
		              </div>
		            </div>
		            <div class="col-sm-6 col-lg-4">
		              <div class="oh-desktop">
		                <article class="services-terri wow slideInDown">
		                  <div class="services-terri-figure"><img src="images/area/r4.jpg" alt="" style="width:370px;height:278px; object-fit: cover;"/>
		                  </div>
		                  <div class="services-terri-caption">
		                    <h5 class="services-terri-title"><a href="#">부부막창꼼장어</a></h5>
		                  </div>
		                </article>
		              </div>
	            	</div>
	            	<div class="col-sm-6 col-lg-4">
		              <div class="oh-desktop">
		                <article class="services-terri wow slideInUp">
		                  <div class="services-terri-figure"><img src="images/area/r5.jpg"   alt="" style="width:370px;height:278px; object-fit: cover;"/>
		                  </div>
		                  <div class="services-terri-caption">
		                    <h5 class="services-terri-title"><a href="#">춘천서면닭갈비</a></h5>
		                  </div>
		                </article>
		              </div>
		            </div>
		            <div class="col-sm-6 col-lg-4">
		              <div class="oh-desktop">
		                <article class="services-terri wow slideInUp">
		                  <div class="services-terri-figure"><img src="images/area/r6.jpg"   alt="" style="width:370px;height:278px; object-fit: cover;"/>
		                  </div>
		                  <div class="services-terri-caption">
		                    <h5 class="services-terri-title"><a href="#">원조황소곱창</a></h5>
		                  </div>
		                </article>
		              </div>
		            </div>
				</div>
			</div>
			<br>
			<hr>
		</div>
	</section>
	
	
 
<%@ include file="footer.jsp" %>  


