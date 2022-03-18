<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<link rel="stylesheet" href="css/board/style.css">
	<script src="js/board/board.js"></script>

    <!-- Demo styles -->
    <style>
     html,
     body {
       position: relative;
       height: 100%;
     }

     body {
       background: #fff;
       font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
       font-size: 14px;
       color: #000;
       margin: 0;
       padding: 0;
     }
     
     #subject {
     	border-top: 1px solid #ccc;
     	border-bottom: 1px solid #ccc;
     	padding: 10px 5px 10px 5px;
     	background: #fcfcfc;
     	font-weight: 600;
     }
     
     #writer {
     	text-align: left;
     	padding: 0 0 0 5px;
     	line-height: 0.8em;
     }
     
     #regdate {
     	text-align: right;
     	margin-bottom: 0;
     }
      
	#board {
		cursor: pointer;
	}
	
	.btn {
		margin-left: 2px;
	}
	
	.comments {
		margin-top: 100px;
	}
    </style>
  	</head> 
  	
	<section class="ftco-section">
		<div class="boardcontainer">
			<h4 id="board" class="h4 mb-4 text-left" onClick="location.href='/biz/member_tList?area=전체'">회원 추천 게시판</h4>
			<form name="frm" id="member_tdetailform" method="post">
			<input type='hidden' name="m0tseq" value='${m0t.m0tseq}'/>
			<p id="regdate">${m0t.regdate}</p>
				<h5 class="h5 mb-4 text-left" id="subject">${m0t.subject}</h5>
				<p id="writer">${m0t.name}</p>
			<hr>
			<div class="content" style="text-align: left; height: 100%;">
				<img src="images/member0_t/${m0t.image1}" style="display:block; padding: 10px;">
		   		${m0t.content}
		    </div>
		    </form>
		    <hr>
		    <c:set var="boardwriterid" value="${m0t.id}"/>
		    <c:set var="loginuserid" value="${loginUser.id}"/>
		    <button type="button" class="btn" id="boardbutton" onclick="location.href='/biz/member_tList?area=전체'"><span>글목록</span></button>
		    <c:if test="${boardwriterid eq loginuserid}">
		    <button type="button" class="btn" id="boardbutton" onclick="go_mtdelete()"><span>글삭제</span></button>
		    <button type="button" class="btn" id="boardbutton" onclick="go_mtupdateform()"><span>글수정</span></button>
		    </c:if>
		</div>
	</section>
<%@ include file="../footer.jsp" %>  