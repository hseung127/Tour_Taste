<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<link rel="stylesheet" href="css/board/style.css">

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
	
    </style>
  	</head> 
  	
	<section class="ftco-section">
		<div class="boardcontainer">
			<h4 id="board" class="h4 mb-4 text-left" onClick="location.href='/test/member_tList?area=전체'">회원 추천 게시판</h4>
			<p id="regdate">${m0t.regdate}</p>
				<h5 class="h5 mb-4 text-left" id="subject">${m0t.subject}</h5>
				<p id="writer">${m0t.name}</p>
			<hr>
			<div class="content" style="text-align: left; height: 300px;">
		   		${m0t.content}
		    </div>
		    <hr>
		    <button type="button" class="btn" id="insertboard" onclick="location.href='/test/member_tList?area=전체'"><span>글목록</span></button>
		</div>
	</section>
<%@ include file="../footer.jsp" %>  