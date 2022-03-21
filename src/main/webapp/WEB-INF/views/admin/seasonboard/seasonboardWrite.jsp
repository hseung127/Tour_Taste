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

<h1>시즌등록</h1>  
<!-- [1] 파일을 업로드 하기 위해서는 폼태그를 post 방식으로 전송하고,
인코딩 타입을 multipart/form-data 로 지정해야 한다. -->
<form name="frm" id="swrite_form" method="post" enctype="multipart/form-data">


<table id="list"> 
<tr>
  <td width="343" colspan="5">
       <input type="text" name="subject" id="subject" size="47" maxlength="100" placeholder="제목을 입력해주세요.">
  </td>
</tr>
    
  <tr>

    <td colspan="5">

      <textarea name="content" id="content" rows="8" cols="70" >
      </textarea>
            <script>

							CKEDITOR.replace("content", {
								height : '500px'});
						</script>
  </tr>
  <tr>
    <td width="343" colspan="5">
<!--  [2] 파일 업로드를 하기 위한 input 태그는 타입 속성 값을 file로 지정해야 한다.  -->
      <input type="file" name="seasonboard_image" id="seasonboard_image"onchange="readURL(this);" class="oriImg">
					<img id="blah" src="#" class="thumbImg"/>
    </td>
  </tr> 
  
  <!-- 
  <tr>
    <td colspan="5">
    	배너 내용
      <textarea name="b_content" id="b_content" rows="8" cols="70" >
      </textarea>
            <script>

							CKEDITOR.replace("b_content", {
								height : '200px'});
						</script>
  </tr>        
<tr>
    <td width="343" colspan="5">
    	배너 이미지
 [2] 파일 업로드를 하기 위한 input 태그는 타입 속성 값을 file로 지정해야 한다. 
      <input type="file" name="seasonboard_bannerimg" id="seasonboard_bannerimg">
    </td>
  </tr>  --> 
</table>
<input class="btn" type="button" value="취소" onClick="go_mov()">
<input class="btn" type="button" value="등록" onClick="go_ssave()">           
</form> 
</div>
	<footer id="footer">
	<div id="footer_box">
		<%@ include file="../footer.jsp" %> 
	</div>
</footer>
</body>
</html>