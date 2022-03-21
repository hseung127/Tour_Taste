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
<h1>관리자맛집 상세 보기</h1> 
<form name="m1rfrm" id="m1rdetail_form" method="post">
<input type="hidden" name="m1rseq" value="${member1_rboardVO.m1rseq}"/>
		<input type="hidden" name="pageNum" value="${criteria.pageNum}">
        <input type="hidden" name="rowsPerPage" value="${criteria.rowsPerPage}"> 
        <input type="hidden" name="keyword" value="${criteria.keyword}">
<table id="list"> 
    <tr>
        <th align="center" >음식</th>
        <td colspan="5">${member1_rboardVO.kind}</td>
    </tr>
        <tr>
        <th align="center" >지역</th>
        <td colspan="5">${member1_rboardVO.area}</td>
    </tr>   
    <tr>
        <th align="center" >제목</th>
        <td colspan="5">${member1_rboardVO.subject}</td>
    </tr>
    
     
    <tr>
        <th>상세설명</th>
        <td colspan="5">${member1_rboardVO.content}</td>
    </tr>
        
         <tr>
        <th>주소</th>
        <td colspan="5">${member1_rboardVO.address}</td>
    </tr>
        <tr>
        <th>전화번호</th>
        <td colspan="5">${member1_rboardVO.phone}</td>
</tr>
    <tr>
     <th>이미지</th>
     <td colspan="5" align="center">
  <!--[7] 이미지를 출력하기 -->     
     <img src="member1_rboard_images/${member1_rboardVO.image1}" width="200pt">
     </td>
    </tr>
     
</table>
<!--[8] 수정 버튼이 눌리면 수정 페이지로 이동하되 현재 페이지와  일련번호 값을 전달해 준다. --> 
<input class="btn"  type="button" value="목록" onClick="go_list('${criteria.pageNum}', '${criteria.rowsPerPage}')">  


<input class="btn" type="button"  value="삭제" onClick="go_delete()">
<!--[9] 목록 버튼이 눌리면  리스트 페이지로 이동하되 현재 페이지를 전달해 준다. --> 
<input class="btn"  type="button" value="수정" onClick="go_m1rmod('${criteria.pageNum}', '${criteria.rowsPerPage}','${member1_rboardVO.m1rseq}')">  
       
</form>
</div>
	<footer id="footer">
	<div id="footer_box">
		<%@ include file="../footer.jsp" %> 
	</div>
</footer>
</body>
</html>