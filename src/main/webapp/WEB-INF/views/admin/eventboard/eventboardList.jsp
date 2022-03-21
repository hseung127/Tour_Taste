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
		
		<style>
td{
text-align: center;
}
</style>
	</header>
	<aside id="aside">
		<div id="aside_box">
		<%@ include file="../aside.jsp" %> 
		</div>
	</aside>

	<div id="container">
		<div id="wrap">
  <form action="" autocomplete="on">
  <input id="search" name="keyword" type="text" placeholder="검색어를 입력해주세요."><input id="keyword" value="${pageMaker.criteria.keyword}" type="submit">
  </form>
</div>
		<h1>이벤트 리스트</h1>	
<form name="efrm" id="admin_eventboardList" method="post">
        		<input type="hidden" name="pageNum" value="${pageMaker.criteria.pageNum }">
        <input type="hidden" name="rowsPerPage" value="${pageMaker.criteria.rowsPerPage }"> 
        <input type="hidden" name="keyword" value="${pageMaker.criteria.keyword}">
<table id="eventboardList">
	<thead>
    <tr>
       <th scope="col"><input id="allCheck" type="checkbox" name="allCheck" onclick="checkAll()"></th> <th>번호</th><th>제목</th><th>이름</th><th>등록일</th><th>조회수</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
    <c:when test="${eventboardListSize<=0}">
    <tr>
      <td width="100%" colspan="7" align="center" height="23">
        등록된 글이 없습니다.
      </td>      
    </tr>
    </c:when>
	<c:otherwise>
	<c:forEach items="${eventboardList}" var="eventboardVO">
    <tr>
    <td><input name="eseq" type="checkbox" value="${eventboardVO.eseq}">
      </td>
      <td height="23" align="center" >${eventboardVO.eseq}</td>
      <td style="text-align: left; padding-left: 50px; padding-right: 0px;">   
        <a href="admin_eventboard_detail${pageMaker.makeQuery(pageMaker.criteria.pageNum)}&eseq=${eventboardVO.eseq}">
		
    	 ${eventboardVO.subject}     
   		</a>
   	  </td>
   	  <td>${eventboardVO.name} </td>
      <td><fmt:formatDate value="${eventboardVO.regdate}"/></td>
      <td><c:out value="${eventboardVO.hit}"/></td>
  
    </tr>
    </c:forEach>
	</c:otherwise>	
</c:choose>  
</tbody>
</table>
<div id="btnList">
     		<input class="btn" type="button" name="btn_selectdelete" onClick="go_edelete()" value="삭제">  
	        <input class="btn" type="button" name="btn_write" value="등록" onClick="go_wrt()">
     		</div> 
</form>


<div class="pageInfo_wrap">
	<div class="pageInfo_area">
		<ul class="pageInfo">
		
				<!-- 이전페이지 버튼 -->
				<c:if test="${pageMaker.prev}">
					<li class="paginate_button previous"><a href="admin_eventboard_list${pageMaker.makeQuery(pageMaker.startPage-1)}">previous</a>
					</li>
				</c:if>

				<!-- 각번호 페이지 버튼 -->
				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="index">
				<li class="pageinfo_btn ${pageMaker.criteria.pageNum == index ? "active":"" }">
					<a href="admin_eventboard_list${pageMaker.makeQuery(index)}">${index}</a>
				</li>
				</c:forEach>

				<!--  다음페이지 버튼 -->
				<c:if test="${pageMaker.next}">
					<li class="paginate_button next">
					<a href="admin_eventboard_list${pageMaker.makeQuery(pageMaker.endPage+1)}">next</a>
					</li>
				</c:if>
			</ul>
	</div>
</div>

</div>


	<footer id="footer">
	<div id="footer_box">
		<%@ include file="../footer.jsp" %> 
	</div>
</footer>
</body>
</html>