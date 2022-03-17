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
	
   	.join_input{
		width: 300px;
    	margin: auto;
    	margin-top: 30px;
	}
            
    .join_box{
		font-size:13pt;
		width: 300px;
		height : 35px;	
    }
    
   	.join_text {
		text-align: center;
		margin-top: 10px;
	}

    input::placeholder {
        color: rgb(138, 132, 132);
    }
    
   	.join_btn_box{
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
    
    .star{
        color: rgb(142, 179, 228);
    }
    
    label{
		font-size: 17px;
		margin-top: 10px;
	}
</style>
<script>
$(document).ready(function() {
	   $("#id").on("blur", function() {
	      var id = $('#id').val(); //id값이 "id"인 입력란의 값을 저장
	      var RegExp = /^[a-zA-Z0-9]{4,15}$/;
	        $.ajax({
	            url:'idCheck', //Controller에서 인식할 주소
	            type:'post', //POST 방식으로 전달
	            data:{id:id},
	            dataType: 'json',
	            success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다 
	                   if(cnt != 1){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디
	                      if($("#id").val() == ''){
	                        $(".error_box_id").text("아이디를 입력해주세요.");
	                        $(".error_box_id").css("color", "red");
	                        return false;
	                     }   
	                      if(!RegExp.test($("#id").val())){
	                         $(".error_box_id").text("유효한 아이디가 아닙니다.");
	                        $(".error_box_id").css("color", "red");
	                        return false;
	                      } else{
	                         $(".error_box_id").text("사용 가능한 아이디 입니다.");
	                        $(".error_box_id").css("color", "green");
	                      }
	                       
	                   } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
	                      $(".error_box_id").text("이미 존재하는 아이디 입니다.");
	                     $(".error_box_id").css("color", "red");
	                     return false;
	                   }
	                    
	               },
	                  error:function(){
	                   alert("에러입니다");
	               }
	          }); 
	   });
	   
	   //비밀번호 유효성 검사
	   $("#pwd").blur(function() {
	      var RegExp = /^[a-zA-Z0-9]{6,18}$/; // 비밀번호 검사식
	      var pwd = $("#pwd").val();   //pwd값이 "pwd"인 입력란의 값을 저장
	      if($("#pwd").val() == ''){
	         $(".error_box_pwd").text("비밀번호를 입력해주세요.");
	         $(".error_box_pwd").css("color", "red");
	         return false;
	      }   
	       if(RegExp.test(pwd)!=true){
	          $(".error_box_pwd").text("유효한 비밀번호가 아닙니다.");
	         $(".error_box_pwd").css("color", "red");
	         return false;
	       }else{
	          $(".error_box_pwd").text("사용 가능한 비밀번호 입니다.");
	          $(".error_box_pwd").css("color", "green");
	       }
	   });   
	   
	   //비밀번호 재확인
	   $("#pwdChk").blur(function(){
		  if($("#pwdChk").val() == ''){
		         $(".error_box_pwdChk").text("비밀번호를 재입력해주세요");
		         $(".error_box_pwdChk").css("color", "red");
		         return false;
		  }   
		   
	      if($("#pwdChk").val() == $("#pwd").val()){
	         $(".error_box_pwdChk").text("비밀번호가 일치합니다.");
	         $(".error_box_pwdChk").css("color", "green");
	         $("#pwDoubleChk").val("true");
	         return false;
	      }else{
	         $(".error_box_pwdChk").text("비밀번호가 일치하지 않습니다.");
	         $(".error_box_pwdChk").css("color", "red");
	         $("#pwDoubleChk").val("false");
	         return false;
	      } 
	   });
	   
	   //이름 유효성 검사
	   $("#name").blur(function() {
	      var RegExp = /^[가-힣]{2,15}$/;   //이름 유효성검사
	      var name = $("#name").val();   //pwd값이 "pwd"인 입력란의 값을 저장
	      if($("#name").val() == ''){
	         $(".error_box_name").text("이름을 입력해주세요.");
	         $(".error_box_name").css("color", "red");
	         return false;
	      }   
	       if(RegExp.test(name)!=true){
	          $(".error_box_name").text("유효한 이름이 아닙니다.");
	         $(".error_box_name").css("color", "red");
	         return false;
	       }else{
	          $(".error_box_name").text("알맞게 입력하였습니다.");
	          $(".error_box_name").css("color", "green");
	       }
	   });
	   
	   //이메일 유효성 검사
	   $("#email").blur(function() {
	      var RegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;  //이메일 유효성검사
	      var email = $("#email").val();   //pwd값이 "pwd"인 입력란의 값을 저장
	      if($("#email").val() == ''){
	         $(".error_box_email").text("이메일을 입력해주세요.");
	         $(".error_box_email").css("color", "red");
	         return false;
	      }   
	       if(RegExp.test(email)!=true){
	          $(".error_box_email").text("유효한 이메일이 아닙니다.");
	         $(".error_box_email").css("color", "red");
	         return false;
	       }else{
	          $(".error_box_email").text("알맞게 입력하였습니다.");
	          $(".error_box_email").css("color", "green");
	       }
	   });
	      
	});
</script>
</head>

<body>
	<div class="join_page">
    	<form id="join" action="join" method="post" name="formm">
			<div class="join_text">
				<h2 style="font-size: 30px;">회원가입</h2>
			</div>
			<div class="join_input">
		        <label>아이디 <span class="star">*</span><input type="text" name="id" id="id" placeholder="4~15자의 영문 대소문자, 숫자" class="join_box"></label>
		        <span class="point error_box_id"></span>
		        <label>비밀번호 <span class="star">*</span> <input type="password"  name="pwd" id="pwd" placeholder="6~18자의 영문 대소문자, 숫자" class="join_box"></label>
		        <span class="point error_box_pwd"></span>
		        <label>비밀번호 확인 <span class="star">*</span> <input type="password"  name="pwdChk" id="pwdChk" placeholder="비밀번호를 재입력해주세요" class="join_box"></label>
		        <span class="point error_box_pwdChk"></span>
		        <label>이름 <span class="star">*</span> <input type="text" name="name" id="name" placeholder="이름을 입력해주세요" class="join_box"></label>
		        <span class="point error_box_name"></span>
		        <label>이메일 <span class="star">*</span> <input type="text" name="email" id="email" placeholder="ex)tour@gmail.com" class="join_box"></label>
		        <span class="point error_box_email"></span>
		    </div>
	        <div class="join_btn_box">
	            <input type="button" value="회원가입" class="join_btn" onclick="go_save()">
	        </div>
    	</form>
    </div>
</body>
<%@ include file="../footer.jsp" %>
  