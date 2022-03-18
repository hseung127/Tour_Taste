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
<h1>소식 상세 보기</h1> 
<form name="frm" id="ndetail_form" method="post">
<input type="hidden" name="nseq" value="${newsboardVO.nseq}"/>
<table id="list">    
    <tr>
        <th align="center" >소식 명</th>
        <td colspan="5">${newsboardVO.subject}</td>
    </tr>
    
     
    <tr>
        <th>상세설명</th>
        <td colspan="5">${newsboardVO.content}</td>
    </tr>
    
    <tr>
     <th>이미지</th>
     <td colspan="5" align="center">
  <!--[7]  이미지를 출력하기 -->     
     <img src="newsboard_images/${newsboardVO.image}" width="200pt">    
     </td>
    </tr>
     
</table>
<!--[8] 수정 버튼이 눌리면 상품 수정 페이지로 이동하되 현재 페이지와 상품 일련번호 값을 전달해 준다. --> 
<input class="btn"  type="button" value="수정" onClick="go_nmod('${newsboardVO.nseq}')">
<input class="btn" type="button"  value="삭제" onClick="go_delete()">
<!--[9] 목록 버튼이 눌리면 상품 리스트 페이지로 이동하되 현재 페이지를 전달해 준다. --> 
<input class="btn" id="list_btn" type="button" value="목록" onClick="go_list('${criteria.pageNum}', '${criteria.rowsPerPage}')">           


</form>
</div>
	<form name="infoForm" method="post" action="admin_newsboard_write">
		<input type="hidden" id="nseq" name="nseq" value = "${pageInfo.nseq}">
		<input type="hidden" name="pageNum" value="${criteria.pageNum}">
        <input type="hidden" name="rowsPerPage" value="${criteria.rowsPerPage}"> 
        <input type="hidden" name="keyword" value="${criteria.keyword}">
        
	</form>
	
	<footer id="footer">
	<div id="footer_box">
		<%@ include file="../footer.jsp" %> 
	</div>
</footer>


</body>
</html>