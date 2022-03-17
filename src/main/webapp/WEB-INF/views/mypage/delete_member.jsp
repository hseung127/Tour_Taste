<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<head>
<style>
	
	.delete_memeber_page{
	    border: 1px solid rgb(142, 179, 228);
	    border-radius: 20px;
	    width: 500px;
	    height: auto;
	    padding-top: 20px;
		margin: 0 auto;
		margin-bottom: 130px;
		margin-top: 70px;
		
	}
	
   	.delete_input{
		width: 300px;
    	margin: auto;
    	margin-top: 30px;
	}
            
    .delete_box{
		font-size:13pt;
		width: 300px;
		height : 35px;	
    }
    
   	.delete_text {
		text-align: center;
		margin-top: 10px;
	}

    
   	.delete_btn_box{
		width: 250px;
    	margin: auto;
	}

    .delete_btn{
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
    
	.delete_btn_cancel{
	     width: 250px;
	     font-size: 20px;
	     font-weight: 700;
         color: rgb(233, 94, 94);
	     line-height: 26px;
         background-color: white;
	     cursor: pointer;
	     margin-bottom: 30px;
	     border-radius: 15px;
	     border-color: rgb(233, 94, 94);
	     height: 40px;
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
</head>
<body>
	<div class="delete_memeber_page">
    	<form id="deleteMember" action="deleteMember" method="post" name="formm">
			<div class="delete_text">
				<h2 style="font-size: 30px;">회원 탈퇴</h2>
			</div>
			<div class="delete_input">
		        <label>아이디<input type="text" name="id" id="id" class="delete_box"></label>
		        <span class="point error_box_id"></span>
		        <label>비밀번호<input type="password"  name="pwd" id="pwd" class="delete_box"></label>
		        <span class="point error_box_pwd"></span>
		    </div>
		    <div>
				<p id="msg">${message}</p>
			</div>
	        <div class="delete_btn_box">
        		<input type="submit" value="탈퇴 확인" class="delete_btn"><br>
       			<input type="button" onclick="history.go(-1);" value="취소" class="delete_btn_cancel"><br>
	        </div>
    	</form>
    </div>
</body>
<%@ include file="../footer.jsp" %>