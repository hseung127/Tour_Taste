<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="./jquery-ui-1.12.1/datepicker-ko.js"></script>


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

<h1>이벤트등록</h1>  
<!-- [1] 파일을 업로드 하기 위해서는 폼태그를 post 방식으로 전송하고,
인코딩 타입을 multipart/form-data 로 지정해야 한다. -->
<form name="frm" id="ewrite_form" method="post" enctype="multipart/form-data">

<table id="list">  

<tr>  
  <td width="100px;">
     이벤트 시작일  <input type="text" name="start_date" id="start_date" size="47" maxlength="100" autocomplete="off" readonly="readonly">
  </td>
  <td width="100px;">
       
    이벤트 종료일   <input type="text" name="end_date" id="end_date" size="47" maxlength="100" autocomplete="off" readonly="readonly">
  </td>
  <td>
  	메인 빅이미지 게시여부
  <input type="checkbox" id="cb1">
    <label for="cb1"></label>
  </td>
</tr>
 <tr>


</tr>  
<tr>

  <td colspan="3">
       <input type="text" name="subject" id="subject" size="47" maxlength="100" value="" placeholder="제목을 입력해주세요.">
  </td>
</tr>
    
  <tr>

    <td colspan="3">
    	
      <textarea name="content" id="content" rows="8" cols="70" >
      </textarea>
            <script>

							
							CKEDITOR.replace("content", {
								height : '500px'});
						</script>
  
  </tr>
   <tr>

    <td  colspan="3">
   	<h3>메인이미지</h3> 
      <input type="file"  multiple="multiple" name="homeimg" id="homeimg">
    </td>
  </tr> 
  <tr>
    <td colspan="3">
   		<h3>내용 이미지</h3> 
<!--  [2] 파일 업로드를 하기 위한 input 태그는 타입 속성 값을 file로 지정해야 한다.  -->
      <input type="file"  multiple="multiple" name="eventboard_image" id="eventboard_image">
      <span style="font-size:10px; color: gray;">※첨부파일은 최대 5개까지 등록이 가능합니다.</span>
    </td>
  </tr>    
</table>
<input class="btn" type="button" value="취소" onClick="go_mov()">
<input class="btn" type="button" value="등록" onClick="go_esave()">           
</form> 
</div>
	<footer id="footer">
	<div id="footer_box">
		<%@ include file="../footer.jsp" %> 
	</div>
</footer>
<script>
$(function() {
	  $("#start_date").datepicker();
	});
</script>
</body>
</html>