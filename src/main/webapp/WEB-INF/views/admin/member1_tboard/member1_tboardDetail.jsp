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
<h1>관리자여행지 상세 보기</h1> 
<form name="m1tfrm" id="m1tdetail_form" method="post">
<input type="hidden" name="m1tseq" value="${member1_tboardVO.m1tseq}"/>
		<input type="hidden" name="pageNum" value="${criteria.pageNum}">
        <input type="hidden" name="rowsPerPage" value="${criteria.rowsPerPage}"> 
        <input type="hidden" name="keyword" value="${criteria.keyword}">
<table id="list">
    <tr>
        <th align="center" >지역</th>
        <td colspan="5">${member1_tboardVO.area}</td>
    </tr>    
    <tr>
        <th align="center" >제목</th>
        <td colspan="5">${member1_tboardVO.subject}</td>
    </tr>
    
     
    <tr>
        <th>내용</th>
        <td colspan="5">${member1_tboardVO.content}</td>
    </tr>
      <tr>
        <th>주소</th>
        <td colspan="5">${member1_tboardVO.address}</td>
    </tr>
      <tr>
        <th>전화번호</th>
        <td colspan="5">${member1_tboardVO.phone}</td>
    </tr>
    <tr>
     <th>이미지</th>
     <td colspan="5" align="center">
  <!--[7] 이미지를 출력하기 -->     
     <img src="member1_tboard_images/${member1_tboardVO.image1}" width="200pt">  
     </td>
    </tr>
     
</table>
<!--[8] 수정 버튼이 눌리면 수정 페이지로 이동하되 현재 페이지와  일련번호 값을 전달해 준다. --> 
<input class="btn" id="list_btn" type="button" value="목록" onClick="go_list('${criteria.pageNum}', '${criteria.rowsPerPage}')">
<input class="btn" type="button"  value="삭제" onClick="go_delete()">

<input class="btn"  type="button" value="수정" onClick="go_m1tmod('${criteria.pageNum}', '${criteria.rowsPerPage}','${member1_tboardVO.m1tseq}')">            
</form>
</div>

	<footer id="footer">
	<div id="footer_box">
		<%@ include file="../footer.jsp" %> 
	</div>
</footer>
</body>
</html>