<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<link rel="stylesheet" href="css/board/style.css">
	<script src="js/board/board.js"></script>
	<script src="js/ckeditor/ckeditor.js"></script>
	<style>
	 .boardcontainer input {
	 	float: left;
	 	width: 100%;
	 	margin-bottom: 5px;
	 }
	 .area_check label {
	 	padding: 5px;
	 }

	</style>
	</head>
	
	<section class="ftco-section">
		<div class="boardcontainer">
			<form name="frm" id="member_rinsertform" method="post" enctype="multipart/form-data">
			<input type="text" name="subject" id="title" placeholder="제목">
			<div class="area_check">
			<p>지역 선택
			<label><input type="radio" name="area" value="서울특별시">서울</label>
			<label><input type="radio" name="area" value="인천광역시">인천</label>
			<label><input type="radio" name="area" value="대전광역시">대전</label>
			<label><input type="radio" name="area" value="대구광역시">대구</label>
			<label><input type="radio" name="area" value="광주광역시">광주</label>
			<label><input type="radio" name="area" value="부산광역시">부산</label>
			<label><input type="radio" name="area" value="울산광역시">울산</label>
			<label><input type="radio" name="area" value="세종특별자치시">세종</label>
			<label><input type="radio" name="area" value="경기도">경기</label>
			<label><input type="radio" name="area" value="강원도">강원</label>
			<label><input type="radio" name="area" value="충청북도">충북</label>
			<label><input type="radio" name="area" value="충천남도">충남</label>
			<label><input type="radio" name="area" value="경상북도">경북</label>
			<label><input type="radio" name="area" value="경산남도">경남</label>
			<label><input type="radio" name="area" value="전라북도">전북</label>
			<label><input type="radio" name="area" value="전라남도">전남</label>
			<label><input type="radio" name="area" value="제주특별자치도">제주</label>
			</div>
			<textarea name="content" id="editor4"></textarea>
			<script>CKEDITOR.replace('editor4', {
				height : '500px',  // 입력창의 높이
				//filebrowserUploadUrl:'/mine/imageUpload.do'
			});</script>
			<input type="file" id="member0r_image" name="member0r_image" style="margin-top: 10px;">
			</form>
			<button type="button" class="btn" id="insertboard" onclick="go_mrsave()"><span>글등록</span></button>
		</div>
	</section>
<%@ include file="../footer.jsp" %>  


