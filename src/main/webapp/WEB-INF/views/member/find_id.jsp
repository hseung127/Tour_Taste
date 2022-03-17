<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../header.jsp" %>
<head>
<style>
	.login_page{
	    border: 1px solid rgb(142, 179, 228);
	    border-radius: 20px;
	    width: 500px;
	    height: auto;
	    padding-top: 20px;
		margin: 0 auto;
		margin-bottom: 130px;
		margin-top: 70px;
		
	}

	.find_id_text {
		text-align: center;
		margin-top: 10px;
	}
	
	.find_id_p{
		font-size: 17px;
	}
	
	.find_btn_box{
		width: 250px;
    	margin: auto;
	}

	.find_btn{
	     width: 250px;
	     font-size: 20px;
	     font-weight: 700;
	     line-height: 26px;
	     background-color: rgb(142, 179, 228);
	     color: white;
	     cursor: pointer;
	     margin-top: 30px;
	     margin-bottom: 30px;
	     border-radius: 15px;
	     height: 40px;
	}
	
	.find_id_span{
		font-size: 23px;
		color: rgb(142, 179, 228);
	}
</style>
</head>
<body>
	<div class="login_page">
		<div class="find_id_text">
			<h2 style="font-size: 30px;">아이디 찾기 결과</h2><br>
			<p class="find_id_p">회원님의 아이디는 <span class="find_id_span">${ id }</span> 입니다.</p>
		</div>
		
		<div class="find_btn_box">
			<input type="button" onclick="location='login_form'" class="find_btn" value="로그인"><br>
		</div>
	</div>
</body>

<%@ include file="../footer.jsp" %>