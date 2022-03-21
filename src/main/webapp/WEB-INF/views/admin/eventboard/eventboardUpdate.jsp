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
<h1>이벤트 수정</h1>  
<form name="frm" id="eupdate_form" method="post" enctype="multipart/form-data">
<input type="hidden" name="eseq" value="${eventboardVO.eseq}">
		<input type="hidden" name="pageNum" value="${criteria.pageNum}">
        <input type="hidden" name="rowsPerPage" value="${criteria.rowsPerPage}"> 
        <input type="hidden" name="keyword" value="${criteria.keyword}">
<input type="hidden" name="code" >
<input type="hidden" name="nonmakeImg" value="${eventboardVO.image1}"> <!-- 기존 이미지 저장  -->
<table id="list">
<tr>  
  <td width="100px;">
     이벤트 시작일  <input type="text" name="start_date" id="start_date" size="47" maxlength="100" autocomplete="off" readonly="readonly" value="${eventboardVO.start_date}">
  </td>
  <td width="100px;">
       
    이벤트 종료일   <input type="text" name="end_date" id="end_date" size="47" maxlength="100" autocomplete="off" readonly="readonly" value="${eventboardVO.end_date}">
  </td>
  <!-- 
  <td>
  	메인 빅이미지 게시여부
  <input type="checkbox" id="cb1" value="${eventboardVO.bighome_yn}">
    <label for="cb1"></label>
  </td>
   -->
</tr>
 <tr>
  <tr>
   
    <td width="343" colspan="3">
      <input type="text" name="subject" id="subject" size="47" maxlength="100" value="${eventboardVO.subject}">
    </td>
  </tr>
  <tr>
    
    <td colspan="3">
      <textarea name="content" id="content" rows="8" cols="70" >${eventboardVO.content}</textarea>
            <script>

							CKEDITOR.replace("content", {
								height : '500px'});
						</script>
    </td>
  </tr>
    <!-- 
  <tr>
     <td  colspan="3">
   	<h3>메인이미지</h3> 
   	<img src="eventboard_images/${eventboardVO.homeimg}" width="200pt"> 
   	<br> 
   	  <input type="file"  multiple="multiple" name="homeimg" id="homeimg">
      <input type="hidden" name="image" value="${eventboardVO.homeimg}">


    </td>
  </tr> -->
 	 <input type="hidden" name="image" value="${eventboardVO.image1}">
    <tr>
    
    <td colspan="3">
    	<h3>내용 이미지</h3>
      <img src="eventboard_images/${eventboardVO.image1}" width="200pt">     
      <br>
      <input type="file" name="eventboard_image" id="eventboard_image"onchange="readURL(this);" class="oriImg">
					<img id="blah" src="#" class="thumbImg"/>
      <input type="hidden" name="image" value="${eventboardVO.image1}">
    </td> 
  </tr>    
</table>
<input class="btn" type="button" value="취소" onClick="go_mov('${criteria.pageNum}', '${criteria.rowsPerPage}')">
<input class="btn" type="button" value="등록" onClick="go_emod_save('${eventboardVO.eseq}')">          

</form> 

</div>
	<footer id="footer">
	<div id="footer_box">
		<%@ include file="../footer.jsp" %> 
	</div>
</footer>
</body>
</html>