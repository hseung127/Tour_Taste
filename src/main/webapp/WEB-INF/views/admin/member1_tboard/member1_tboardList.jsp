<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
td{
text-align: center;
}
</style>
</head>
<body onload="printClock()">
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
			<div id="wrap">
  <form action="" autocomplete="on">
  <input id="search" name="keyword" type="text" placeholder="검색어를 입력해주세요."><input id="keyword" value="${pageMaker.criteria.keyword}" type="submit">
  </form>
			

</div>
<h1>관리자여행지 리스트</h1>
<form name="m1tfrm" id="admin_member1_tboardList" method="post">
		<input type="hidden" name="pageNum" value="${pageMaker.criteria.pageNum }">
        <input type="hidden" name="rowsPerPage" value="${pageMaker.criteria.rowsPerPage }"> 
        <input type="hidden" name="keyword" value="${pageMaker.criteria.keyword}">

<table id="member1_tboardList" class="listbox">
   	<thead>
    <tr>
         <th scope="col"><input id="allCheck" type="checkbox" name="allCheck" onclick="checkAll()"></th><th>번호</th><th>제목</th><th>이름</th><th>등록일</th><th>조회수</th>
     
    </tr>
    </thead>
    <tbody>
    <c:choose>
    <c:when test="${member1_tboardListSize<=0}">
    <tr>
      <td width="100%" colspan="7" align="center" height="23">
        등록된 글이 없습니다.
      </td>      
    </tr>
    </c:when>
	<c:otherwise>
	<c:forEach items="${member1_tboardList}" var="member1_tboardVO">
    <tr>
    <td><input name="m1tseq" type="checkbox" value="${member1_tboardVO.m1tseq}">
      </td>
      <td height="23" align="center" >${member1_tboardVO.m1tseq}</td>
      <td style="text-align: left; padding-left: 50px; padding-right: 0px;">   
        <a href="admin_member1_tboard_detail${pageMaker.makeQuery(pageMaker.criteria.pageNum)}&m1tseq=${member1_tboardVO.m1tseq}">
		
    	 ${member1_tboardVO.subject}     
   		</a>
   	  </td>
   	  <td>${member1_tboardVO.name} </td>
      <td><fmt:formatDate value="${member1_tboardVO.regdate}"/></td>
      <td>${member1_tboardVO.hit}</td>
  
    </tr>
    </c:forEach>
    
	</c:otherwise>	
</c:choose>
</tbody>  
</table>
<div id="btnList">
     		<input class="btn" type="button" name="btn_selectdelete" onClick="go_m1tdelete()" value="삭제"> 
	        <input class="btn" type="button" name="btn_write" value="등록" onClick="go_wrt()">
 
     		</div> 
</form>

<div class="pageInfo_wrap">
	<div class="pageInfo_area">
		<ul class="pageInfo">
		
				<!-- 이전페이지 버튼 -->
				<c:if test="${pageMaker.prev}">
					<li class="paginate_button previous"><a href="admin_member1_tboard_list${pageMaker.makeQuery(pageMaker.startPage-1)}">previous</a>
					</li>
				</c:if>

				<!-- 각번호 페이지 버튼 -->
				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="index">
				<li class="pageinfo_btn ${pageMaker.criteria.pageNum == index ? "active":"" }">
					<a href="admin_member1_tboard_list${pageMaker.makeQuery(index)}">${index}</a>
				</li>
				</c:forEach>

				<!--  다음페이지 버튼 -->
				<c:if test="${pageMaker.next}">
					<li class="paginate_button next">
					<a href="admin_member1_tboard_list${pageMaker.makeQuery(pageMaker.endPage+1)}">next</a>
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