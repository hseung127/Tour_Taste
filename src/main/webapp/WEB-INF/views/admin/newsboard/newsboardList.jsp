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
	
	
<div id="wrap">
  <form action="" autocomplete="on">
  <input id="search" name="keyword" type="text" placeholder="검색어를 입력해주세요."><input id="keyword" value="${pageMaker.criteria.keyword}" type="submit">
  </form>
</div>
<h1>소식 리스트</h1>
<form name="nfrm" id="admin_newsboardList" method="post">
	

<!--  <div class="search_wrap">
    	<input type="text" name="keyword" id="keyword" value="${pageMaker.criteria.keyword}">
    	<input class="btn" type="button" name="btn_search" value="검색" onClick="go_search()">
    </div> -->
   

		   		
<table id="newsboardList">
	<thead>
    <tr>
    
    <th scope="col"><input id="allCheck" type="checkbox" name="allCheck" onclick="checkAll()"></th><th scope="col">번호</th><th scope="col">제목</th ><th scope="col">이름</th><th scope="col">등록일</th><th scope="col">조회수</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
    <c:when test="${newsboardListSize<=0}">
    <tr>
      <td width="100%" colspan="7" align="center" height="23">
        등록된 글이 없습니다.
      </td>      
    </tr>
    </c:when>
	<c:otherwise>
	<c:forEach items="${newsboardList}" var="newsboardVO">
    <tr>
      <td><input name="nseq" type="checkbox" value="${newsboardVO.nseq}">
      </td>
      <td height="23" align="center">${newsboardVO.nseq}</td>
      <td style="text-align: left; padding-left: 50px; padding-right: 0px;">   
        <a href="admin_newsboard_detail${pageMaker.makeQuery(pageMaker.criteria.pageNum)}&nseq=${newsboardVO.nseq}">
    	 ${newsboardVO.subject}     
   		</a>
   	  </td>
   	  <td>${newsboardVO.name} </td>
      <td><fmt:formatDate value="${newsboardVO.regdate}"/></td>
      <td align="center" ><c:out value="${newsboardVO.hit}"/></td>
  
    </tr>
    </c:forEach>
	</c:otherwise>	
</c:choose> 
</tbody>

</table>
<div id="btnList">
	        <input class="btn" type="button" name="btn_write" value="등록" onClick="go_wrt()">
     		<input class="btn" type="button" name="btn_selectdelete" onClick="go_sdelete()" value="삭제">  
     		</div> 
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
					<li class="paginate_button previous"><a href="admin_newsboard_list${pageMaker.makeQuery(pageMaker.startPage-1)}">previous</a>
					</li>
				</c:if>

				<!-- 각번호 페이지 버튼 -->
				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="index">
				<li class="pageinfo_btn">
					<a href="admin_newsboard_list${pageMaker.makeQuery(index)}">${index}</a>
				</li>
				</c:forEach>

				<!--  다음페이지 버튼 -->
				<c:if test="${pageMaker.next}">
					<li class="paginate_button next">
					<a href="admin_newsboard_list${pageMaker.makeQuery(pageMaker.endPage+1)}">next</a>
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