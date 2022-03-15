<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header id="header">
	<div id="header_box">
		<%@ include file="../header.jsp" %> 
		</div>
	</header>
	<aside id="aside">
		<div id="aside_box">
		<%@ include file="../aside.jsp" %> 
		</div>
	</aside>
	<div id=container>
<h1> 상세 보기</h1> 
<form name="frm" id="m0rdetail_form" method="post">
<input type="hidden" name="m0rseq" value="${member0_rboardVO.m0rseq}"/>
<table id="list">    
    <tr>
        <th align="center" >회원맛집</th>
        <td colspan="5">${member0_rboardVO.subject}</td>
    </tr>
    
     
    <tr>
        <th>상세설명</th>
        <td colspan="5">${member0_rboardVO.content}</td>
    </tr>
    
    <tr>
     <th>이미지</th>
     <td colspan="5" align="center">
  <!--[7] 이미지를 출력하기 -->     
     <img src="member0_rboard_images/${member0_rboardVO.image1}" width="200pt">
     <img src="member0_rboard_images/${member0_rboardVO.image2}" width="200pt"> 
     <img src="member0_rboard_images/${member0_rboardVO.image3}" width="200pt"> 
     <img src="member0_rboard_images/${member0_rboardVO.image4}" width="200pt"> 
     <img src="member0_rboard_images/${member0_rboardVO.image5}" width="200pt">     
     </td>
    </tr>
     
</table>
<!--[8] 수정 버튼이 눌리면 수정 페이지로 이동하되 현재 페이지와  일련번호 값을 전달해 준다. --> 
<input class="btn"  type="button" value="수정" onClick="go_mod('${member0_rboardVO.m0rseq}')">
<input class="btn" type="button"  value="삭제" onClick="go_delete()">
<!--[9] 목록 버튼이 눌리면  리스트 페이지로 이동하되 현재 페이지를 전달해 준다. --> 
<input class="btn"  type="button" value="목록" onClick="go_list()">           
</form>
</div>
	<footer id="footer">
	<div id="footer_box">
		<%@ include file="../footer.jsp" %> 
	</div>
</footer>
</body>
</html>