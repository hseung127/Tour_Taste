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
<h1>관리자여행지 수정</h1>  
<form name="frm" id="m1tupdate_form" method="post" enctype="multipart/form-data">
<input type="hidden" name="m1tseq" value="${member1_tboardVO.m1tseq}">
<input type="hidden" name="code" >
<input type="hidden" name="nonmakeImg" value="${member1_tboardVO.image1}"> <!-- 기존 이미지 저장  -->
<table id="list">
  <tr>
    <th>제목</th>
    <td width="343" colspan="5">
      <input type="text" name="subject" id="subject" size="47" maxlength="100" value="${member1_tboardVO.subject}">
    </td>
  </tr>
  <tr>
    <th>내용</th>
    <td colspan="5">
      <textarea name="content" id="content" rows="8" cols="70" >${member1_tboardVO.content}</textarea>
            <script>

							var ckeditor_config = {
								resize_enaleb : false,
								enterMode : CKEDITOR.ENTER_BR,
								shiftEnterMode : CKEDITOR.ENTER_P,
								filebrowserUploadUrl : "ckUpload"
							};

							CKEDITOR.replace("content", ckeditor_config);
						</script>
    </td>
  </tr>
  <tr>
    <th>이미지</th>
    <td colspan="5">
      <img src="member1_tboard_images/${member1_tboardVO.image1}" width="200pt">     
      <br>
      <input type="file" name="member1_tboard_image" id="member1_tboard_image">
      <input type="hidden" name="image" value="${member1_tboardVO.image1}">
    </td> 
  </tr>    
</table>
<input class="btn" type="button" value="등록" onClick="go_m1tmod_save('${member1_tboardVO.m1tseq}')">          
<input class="btn" type="button" value="취소" onClick="go_mov()">
</form> 
</div>
	<footer id="footer">
	<div id="footer_box">
		<%@ include file="../footer.jsp" %> 
	</div>
</footer>
</body>
</html>