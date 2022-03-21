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
<h1>관리자맛집 수정</h1>  
<form name="frm" id="m1rupdate_form" method="post" enctype="multipart/form-data">
<input type="hidden" name="m1rseq" value="${member1_rboardVO.m1rseq}">
		<input type="hidden" name="pageNum" value="${criteria.pageNum}">
        <input type="hidden" name="rowsPerPage" value="${criteria.rowsPerPage}"> 
        <input type="hidden" name="keyword" value="${criteria.keyword}">
<input type="hidden" name="code" >
<input type="hidden" name="nonmakeImg" value="${member1_rboardVO.image1}"> <!-- 기존 이미지 저장  -->
<table id="list">
<tr>
    <td width="343" colspan="5">
    음식종류
      <input type="text" name="kind" id="kind" size="47" maxlength="100" value="${member1_rboardVO.kind}">
    </td>
  </tr>
  <tr>
    <td width="343" colspan="5">
    지역
      <input type="text" name="area" id="area" size="47" maxlength="100" value="${member1_rboardVO.area}">
    </td>
  </tr>
  <tr>
    <td width="343" colspan="5">
      <input type="text" name="subject" id="subject" size="47" maxlength="100" value="${member1_rboardVO.subject}">
    </td>
  </tr>
  <tr>
    <td colspan="5">
      <textarea name="content" id="content" rows="8" cols="70" >${member1_rboardVO.content}</textarea>
            <script>

						

							CKEDITOR.replace("content", {
								height : '500px'});
						</script>
    </td>
  </tr>
        <tr>
  <td width="343" colspan="5">
  주소
       <input type="text" name="adress" id="adress" size="47" maxlength="100" value="${member1_rboardVO.address}" >
  </td>
</tr>
  <tr>
  <td width="343" colspan="5">
  전화번호
       <input type="tel" name="phone" id="phone" size="47" maxlength="100" value="${member1_rboardVO.phone}" >
  </td>
</tr>
  <tr>
    <td colspan="5">
      <img src="member1_rboard_images/${member1_rboardVO.image1}" width="200pt">     
      <br>
      <input type="file" name="member1_rboard_image" id="member1_rboard_image">
      <input type="hidden" name="image" value="${member1_rboardVO.image1}">
    </td> 
  </tr>    
</table>
<input class="btn" type="button" value="취소" onClick="go_mov('${criteria.pageNum}', '${criteria.rowsPerPage}')">
<input class="btn" type="button" value="등록" onClick="go_m1rmod_save('${member1_rboardVO.m1rseq}')">      

</form> 

</div>
	<footer id="footer">
	<div id="footer_box">
		<%@ include file="../footer.jsp" %> 
	</div>
</footer>
</body>
</html>