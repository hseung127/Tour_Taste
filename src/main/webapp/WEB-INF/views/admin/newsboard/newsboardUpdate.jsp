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
<h1>소식 수정</h1>  
<form name="frm" id="nupdate_form" method="post" enctype="multipart/form-data">
		<input type="hidden" id="nseq" name="nseq" value = "${newsboardVO.nseq}">
		<input type="hidden" name="pageNum" value="${criteria.pageNum}">
        <input type="hidden" name="rowsPerPage" value="${criteria.rowsPerPage}"> 
        <input type="hidden" name="keyword" value="${criteria.keyword}">
<input type="hidden" name="code" >
<input type="hidden" name="nonmakeImg" value="${newsboardVO.image1}"> <!-- 기존 이미지 저장  -->
<table id="list">
  <tr>

    <td width="343" colspan="5">
      <input type="text" name="subject" id="subject" size="47" maxlength="100" value="${newsboardVO.subject}">
    </td>
  </tr>
  <tr>

    <td colspan="5">
      <textarea name="content" id="content" rows="8" cols="70" >${newsboardVO.content}
      </textarea>
      <script>

							

							CKEDITOR.replace("content", {
								height : '500px'});
						</script>
    </td>
  </tr>
  <tr>

    <td colspan="5">
      <img src="newsboard_images/${newsboardVO.image1}" width="200pt">     
      <br>
      <input type="file" name="newsboard_image" id="newsboard_image"onchange="readURL(this);" class="oriImg">
					<img id="blah" src="#" class="thumbImg"/>
      <input type="hidden" name="image" value="${newsboardVO.image1}">
    </td> 
  </tr>    
</table>
<input class="btn" type="button" value="취소" onClick="go_mov('${criteria.pageNum}', '${criteria.rowsPerPage}')">
<input class="btn" type="button" value="등록" onClick="go_nmod_save('${newsboardVO.nseq}','${criteria.pageNum}', '${criteria.rowsPerPage}')">        



</form> 

</div>
	<footer id="footer">
	<div id="footer_box">
		<%@ include file="../footer.jsp" %> 
	</div>
</footer>
</body>
</html>