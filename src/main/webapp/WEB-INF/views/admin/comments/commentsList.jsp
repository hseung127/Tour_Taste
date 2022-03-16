<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
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

	<div id="container">
		<h1>댓글 리스트</h1>	
<form name="frm" id="admin_commentsList" method="post">
<table>
  <tr>
  <td width="642">
      소식
     <input type="text" name="key1" id="key">
     <input class="btn" type="button" name="btn_search" value="검색" onClick="go_search()">
     <input class="btn" type="button" name="btn_write" value="삭제" onClick="go_ddelete">
     
  </td>
  </tr>
</table>
<table id="commentsList">
    <tr>
        <th>번호</th><th>댓글내용</th><th>이름</th><th>등록일</th>
    </tr>
    <c:choose>
    <c:when test="${commentsListSize<=0}">
    <tr>
      <td width="100%" colspan="7" align="center" height="23">
        등록된 글이 없습니다.
      </td>      
    </tr>
    </c:when>
	<c:otherwise>
	<c:forEach items="${commentsList}" var="commentsVO">
    <tr>
      <td height="23" align="center" >${commentsVO.com_seq}</td>
      <td style="text-align: left; padding-left: 50px; padding-right: 0px;">   
        <a href="admin_comments_detail${pageMaker.makeQuery(pageMaker.criteria.pageNum)}&com_seq=${commentsVO.com_seq}">
		
    	 ${commentsVO.content}     
   		</a>
   	  </td>
   	  <td>${commentsVO.name} </td>
      <td><fmt:formatDate value="${commentsVO.regdate}"/></td>
  
    </tr>
    </c:forEach>
    <tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr>
	</c:otherwise>	
</c:choose>  
</table>
</form>

	<div id="page">
	
		<%@ include file="page.jsp" %> 
	</div>
	</div>
	<footer id="footer">
	<div id="footer_box">
		<%@ include file="../footer.jsp" %> 
	</div>
</footer>
</body>
</html>