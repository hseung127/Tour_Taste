<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>       
<style>
	.login_page{
	    border: 1px solid rgb(142, 179, 228);
	    border-radius: 20px;
	    width: 500px;
	    height: auto;
	    padding-top: 20px;
		margin-top: 50px;
		margin-left: auto;
		margin-right: auto;
		
	}
	
	.login_input{
		width: 300px;
	   	margin: auto;
	   	margin-top: 30px;
	}
	
	.login_box {
	     font-size:13pt;
	     width: 300px;
	     height : 35px;
	}
	
	.login_text {
		text-align: center;
		margin-top: 10px;
	}
	
	.login_btn_box{
		width: 250px;
	   	margin: auto;
	}
	
	.login_btn{
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
		
	#buttons{
	  color: rgb(138, 132, 132);
	  cursor: pointer;
	  margin-top: 30px;
	  text-align: center;
	  margin-bottom: 50px;
	  
	}
	
	#msg{
		font-size: 17px;
		margin-top: 20px;
		color: red;
		text-align: center;
	}
	
	label{	
		font-size: 17px;
		margin-top: 10px;
	}
</style>
<body>
	<div class="login_page">
		<form method="post" action="login">
			<div class="login_text">
				<h2 style="font-size: 30px;">로그인</h2>
			</div>
		    <div class="login_input">
				<label>아이디 <input class="login_box" type="text" id="id" name="id" required></label>
				<label>비밀번호 <input class="login_box" type="password" id="pwd" name="pwd" required></label>
			</div>
			<div>
				<p id="msg">${message}</p>
			</div>
			<div class="login_btn_box">
	    		<input type="submit" value="로그인" class="login_btn"><br>
	    	</div>
		</form>
	</div>
	<div id="buttons">
	  <a onclick="location='find_id_form'" id="find_id_btn">아이디 찾기 &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	  <a onclick="location='find_pwd_form'" id="find_pwd_btn">비밀번호 찾기 &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	  <a onclick="location='contract_form'" id="join_btn">가입하기</a>
	</div>
</body> 
<%@ include file="../footer.jsp" %>
