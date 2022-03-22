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
		<input type="hidden" id="nseq" name="nseq" value = "${newsboardVO.nseq}">
		<input type="hidden" name="pageNum" value="${criteria.pageNum}">
        <input type="hidden" name="rowsPerPage" value="${criteria.rowsPerPage}"> 
        <input type="hidden" name="keyword" value="${criteria.keyword}">
<table id="list">   

    <tr>
      <th>제목</th> 
        <td colspan="5">${newsboardVO.subject}</td>
    </tr>


     
    <tr>
    <th>내용</th>
        <td colspan="5">${newsboardVO.content}</td>
    </tr>
  <tr>
  <th>이미지</th>
 	 <td>
     <img src="newsboard_images/${newsboardVO.image1}" width="200pt">    
     </td>
 	</tr>    

    

     
</table>
<input class="btn" id="list_btn" type="button" value="목록" onClick="go_list('${criteria.pageNum}', '${criteria.rowsPerPage}')">  
<input class="btn" type="button"  value="삭제" onClick="go_delete()">
<input class="btn"  type="button" value="수정" onClick="go_nmod('${criteria.pageNum}', '${criteria.rowsPerPage}','${newsboardVO.nseq}')">

</form>
</div>

	
	<footer id="footer">
	<div id="footer_box">
		<%@ include file="../footer.jsp" %> 
	</div>
</footer>


</body>
</html>