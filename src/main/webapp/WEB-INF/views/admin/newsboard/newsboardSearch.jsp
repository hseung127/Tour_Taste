<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script>
 $(function(){
  $('#searchBtn').click(function() {
   self.location = "listSearch"
     + '${pageMaker.makeQuery(1)}'
     + "&searchType="
     + $("select option:selected").val()
     + "&keyword="
     + encodeURIComponent($('#keywordInput').val());
    });
 });   
 </script>
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
		<h1>소식 리스트</h1>	
<form name="nfrm" id="admin_newsboardSearch" method="post">
<table>
  <tr>
  <td width="642">
    
     <div class="search row">
	<div class="col-xs-2 col-sm-2">
		<select name="searchType" class="form-control"> 
			<option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
			<option value="t"<c:out value="${scri.searchType eq 's' ? 'selected' : ''}"/>>제목</option>
			<option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
			<option value="w"<c:out value="${scri.searchType eq 'n' ? 'selected' : ''}"/>>작성자</option>
			<option value="tc"<c:out value="${scri.searchType eq 'sc' ? 'selected' : ''}"/>>제목+내용</option>
		</select>
	</div>	
	
	<div class="col-xs-10 col-sm-10">
		<div class="input-group">
			<input type="text" name="keyword" id="keyword" value="${scri.keyword}" class="form-control"/>
			<span class="input-group-btn">
				<button id="searchBtn" class="btn btn-default">검색</button>
			</span>
		</div>
	</div>


</div>	
  </td>
  </tr>
</table>
<table id="newsboardList">
    <tr>
    
    <th scope="col"><input id="allCheck" type="checkbox" name="allCheck" onclick="allChk(this);">
    
    </th><th scope="col">번호</th><th scope="col">제목</th ><th scope="col">이름</th><th scope="col">등록일</th>
    </tr>
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
      <td><input name="RowCheck" type="checkbox" value="${newsboardVO.nseq}"></td>
      <td height="23" align="center">${newsboardVO.nseq}</td>
      <td style="text-align: left; padding-left: 50px; padding-right: 0px;">   
        <a href="admin_newsboard_detail?${newsboardVO.nseq}	&pageNum=${scri.pageNum}&
															rowsPerPage=${scri.rowsPerPage}&
															searchType=${scri.searchType}&
															keyword=${scri.keyword}">${newsboardVO.subject}</a>
		
    	   
   		
   	  </td>
   	  <td>${newsboardVO.name} </td>
      <td><fmt:formatDate value="${newsboardVO.regdate}"/></td>
  
    </tr>
    </c:forEach>
    <tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr>
	</c:otherwise>	
</c:choose>  
</table>
</form>

<div class="pageInfo_wrap">
	<div class="pageInfo_area">
		<ul class="pageInfo" class="pageInfo">
		
				<!-- 이전페이지 버튼 -->
				<c:if test="${pageMaker.prev}">
					<li class="paginate_button previous">
					<a href="admin_newsboard_search?num=${pageMaker.makeSearch(pageMaker.startPage+1)}">previous</a>
					</li>
				</c:if>

				<!-- 각번호 페이지 버튼 -->
					<c:forEach begin="${pageMaker.startPage}"end="${pageMaker.endPage}" var="idx">
						<li class="pageInfo_btn ${pageMaker.cri.page == idx ? 'class=active' : ''}"/>>
						<a href="admin_newsboard_search?{pageMaker.makeSearch(idx)}">${idx}</a>
						<li>
					</c:forEach>

					<!--  다음페이지 버튼 -->
				<c:if test="${pageMaker.next}">
					<li class="paginate_button next">
					<a href="admin_newsboard_search?num=${pageMaker.makeSearch(pageMaker.endPage+1)}">next</a>
					</li>
				</c:if>
			</ul>
	</div>
</div>
	

	     <input class="btn" type="button" name="btn_write" value="등록" onClick="go_wrt()">
</div>
	<footer id="footer">
	<div id="footer_box">
		<%@ include file="../footer.jsp" %> 
	</div>

</footer>

</body>
</html>