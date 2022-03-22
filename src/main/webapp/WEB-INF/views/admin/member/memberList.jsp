<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			<%@ include file="../header.jsp"%>
		</div>
	</header>
	<aside id="aside">
		<div id="aside_box">
			<%@ include file="../aside.jsp"%>
		</div>
	</aside>

	<div id="container">
		<script type="text/javascript">
			function go_search(name) {
				document.frm.action = "admin_member_list?keyword=" + name;

			}
		</script>
			<div id="wrap">
  <form action="admin_member_update" autocomplete="on">
  <input id="search" name="keyword" type="text" placeholder="검색어를 입력해주세요."><input id="keyword" value="${pageMaker.criteria.keyword}" type="submit" onclick="go_search(this.key)">
  </form>
</div>
		<h1>회원리스트</h1>
		<form name="frm" method="post">
	<br>
			<table id="admin_memberList">
				<thead>
				
					<tr>
						
						<th>아이디</th>
						<th>이름</th>
						<th>이메일</th>
						<th>회원등급</th>
						<th>가입일</th>
					
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${memberList}" var="memberVO">
						<tr>
						
							<td>${memberVO.id}
									
								
							</td>
							<td>${memberVO.name}</td>
							<td>${memberVO.email}</td>
							<td><c:if test="${memberVO.user_type == 1}">
       		관리자
       		</c:if> <c:if test="${memberVO.user_type == 0}">
       		회원
       		</c:if></td>

							<td><fmt:formatDate value="${memberVO.regdate}" /></td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</form>
<form id="moveForm">
		<input type="hidden" name="pageNum" value="${pageMaker.criteria.pageNum }">
        <input type="hidden" name="rowsPerPage" value="${pageMaker.criteria.rowsPerPage }"> 
        <input type="hidden" name="keyword" value="${pageMaker.criteria.rowsPerPage }"> 
</form>	
<div class="pageInfo_wrap">
	<div class="pageInfo_area">
		<ul class="pageInfo">
		
				<!-- 이전페이지 버튼 -->
				<c:if test="${pageMaker.prev}">
					<li class="paginate_button previous"><a href="admin_member_list${pageMaker.makeQuery(pageMaker.startPage-1)}">previous</a>
					</li>
				</c:if>

				<!-- 각번호 페이지 버튼 -->
				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="index">
				<li class="pageinfo_btn ${pageMaker.criteria.pageNum == index ? "active":"" }">
					<a href="admin_member_list${pageMaker.makeQuery(index)}">${index}</a>
				</li>
				</c:forEach>

				<!--  다음페이지 버튼 -->
				<c:if test="${pageMaker.next}">
					<li class="paginate_button next">
					<a href="admin_member_list${pageMaker.makeQuery(pageMaker.endPage+1)}">next</a>
					</li>
				</c:if>
			</ul>
	</div>
</div>

</div>

	<footer id="footer">
		<div id="footer_box">
			<%@ include file="../footer.jsp"%>
		</div>
	</footer>
</body>
</html>