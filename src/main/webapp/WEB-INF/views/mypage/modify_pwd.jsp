
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<head>
<style>
	.join_page{
	    border: 1px solid rgb(142, 179, 228);
	    border-radius: 20px;
	    width: 500px;
	    height: auto;
	    padding-top: 20px;
		margin: 0 auto;
		margin-bottom: 130px;
		margin-top: 70px;
		
	}
            
	.modify_pwd_input{
		width: 300px;
    	margin: auto;
    	margin-top: 30px;
	}
	
    .join_box{
		font-size:13pt;
		width: 300px;
		height : 35px;
    }
    
  	.modify_pwd_text {
		text-align: center;
		margin-top: 10px;
	}

    input::placeholder {
        color: rgb(138, 132, 132);
    }
    
   	.modify_pwd_btn_box{
		width: 250px;
    	margin: auto;
	}

    .join_btn{
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
    
    label{
    	font-size: 17px;
		margin-top: 10px;
	}
</style>
<script>
$(document).ready(function() {
	
		$("#cur_pwd").blur(function() {
		      var RegExp = /^[a-zA-Z0-9]{6,18}$/; // 비밀번호 검사식
		      if($("#cur_pwd").val() == ''){
		         $(".error_box_cur_pwd").text("현재 비밀번호를 입력해주세요.");
		         $(".error_box_cur_pwd").css("color", "red");
		         return false;
		      } else {
		    	  $(".error_box_cur_pwd").text("");
		          $(".error_box_cur_pwd").css("color", "red");
		          return false;
		      }
	   });   

	   //비밀번호 유효성 검사
	   $("#new_pwd").blur(function() {
		  var RegExp = /^[a-zA-Z0-9]{6,18}$/; // 비밀번호 검사식
	      var new_pwd = $("#new_pwd").val();   //pwd값이 "pwd"인 입력란의 값을 저장
	      if($("#new_pwd").val() == ''){
	         $(".error_box_new_pwd").text("비밀번호를 입력해주세요.");
	         $(".error_box_new_pwd").css("color", "red");
	         return false;
	      }   
	       if(RegExp.test(new_pwd)!= true){
	          $(".error_box_new_pwd").text("유효한 비밀번호가 아닙니다.");
	         $(".error_box_new_pwd").css("color", "red");
	         return false;
	       }else{
	          $(".error_box_new_pwd").text("사용 가능한 비밀번호 입니다.");
	          $(".error_box_new_pwd").css("color", "green");
	       }
	   });   
	   
	   //비밀번호 재확인
	   $("#new_pwdChk").blur(function(){
		   
			if($("#new_pwdChk").val() == ''){
		      $(".error_box_new_pwdChk").text("비밀번호를 재입력해주세요");
		      $(".error_box_new_pwdChk").css("color", "red");
		      return false;
			}
			if($("#new_pwdChk").val() == $("#new_pwd").val()){
			   $(".error_box_new_pwdChk").text("비밀번호가 일치합니다.");
			   $(".error_box_new_pwdChk").css("color", "green");
			   return false;
			}else{
			   $(".error_box_new_pwdChk").text("비밀번호가 일치하지 않습니다.");
			   $(".error_box_new_pwdChk").css("color", "red");
			   return false;
			} 
	      
	   });
	      
	});
</script>
</head>
<body>
	<div class="join_page">
	    <form id="modify_pwd" action="modify_pwd" method="post" name="formm">
	    	<div class="modify_pwd_text">
				<h2 style="font-size: 30px;">비밀번호 변경</h2>
			</div>
			<div class="modify_pwd_input">
		        <label>현재 비밀번호  <input type="text" name="cur_pwd" id="cur_pwd" placeholder="현재 비밀번호를 입력해주세요" class="join_box"></label>
		        <span class="point error_box_cur_pwd"></span>
		        <label style=" padding-right: 15px;">비밀번호 <input type="password"  name="new_pwd" id="new_pwd" placeholder="6~18자의 영문 대소문자, 숫자" class="join_box"></label> 
		        <span class="point error_box_new_pwd"></span>
		        <label style="padding-right: 55px;">비밀번호 확인 <input type="password"  name="new_pwdChk" id="new_pwdChk" placeholder="비밀번호를 재입력해주세요" class="join_box"></label> 
		        <span class="point error_box_new_pwdChk"></span>
	        </div>
	        <div class="modify_pwd_btn_box">
	            <input type="button" value="변경 확인" class="join_btn" onclick="go_modify_pwd()">
	        </div>
	    </form>
    </div>
</body>
<%@ include file="../footer.jsp" %>