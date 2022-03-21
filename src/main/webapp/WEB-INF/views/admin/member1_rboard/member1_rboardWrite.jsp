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

<h1>관리자맛집 등록</h1>  
<hr>
<!-- [1] 파일을 업로드 하기 위해서는 폼태그를 post 방식으로 전송하고,
인코딩 타입을 multipart/form-data 로 지정해야 한다. -->
<form name="frm" id="m1rwrite_form" method="post" enctype="multipart/form-data">

<table id="list"> 
<tr>
<td class="food_check" id="kind">
			<p>음식
			<label><input type="radio" name="food" value="한식">한식</label>
			<label><input type="radio" name="food" value="중식">중식</label>
			<label><input type="radio" name="food" value="일식">일식</label>
			<label><input type="radio" name="food" value="양식">양식</label>
			<label><input type="radio" name="food" value="카페">카페</label>
			<label><input type="radio" name="food" value="분식">분식</label>
			<label><input type="radio" name="food" value="패스트푸드">패스트푸드</label>
			</td>
			</tr>
			
<tr>
<td class="area_check" id="area">
			<p>지역 선택
			<label><input type="radio" name="area" value="서울특별시">서울</label>
			<label><input type="radio" name="area" value="인천광역시">인천</label>
			<label><input type="radio" name="area" value="대전광역시">대전</label>
			<label><input type="radio" name="area" value="대구광역시">대구</label>
			<label><input type="radio" name="area" value="광주광역시">광주</label>
			<label><input type="radio" name="area" value="부산광역시">부산</label>
			<label><input type="radio" name="area" value="울산광역시">울산</label>
			<label><input type="radio" name="area" value="세종특별자치시">세종</label>
			<label><input type="radio" name="area" value="경기도">경기</label>
			<label><input type="radio" name="area" value="강원도">강원</label>
			<label><input type="radio" name="area" value="충청북도">충북</label>
			<label><input type="radio" name="area" value="충천남도">충남</label>
			<label><input type="radio" name="area" value="경상북도">경북</label>
			<label><input type="radio" name="area" value="경산남도">경남</label>
			<label><input type="radio" name="area" value="전라북도">전북</label>
			<label><input type="radio" name="area" value="전라남도">전남</label>
			<label><input type="radio" name="area" value="제주특별자치도">제주</label>
			</td> 
			</tr>  
<tr>
  <td width="343" colspan="5">
       <input type="text" name="subject" id="subject" size="47" maxlength="100" value=""placeholder="제목을 입력해주세요.">
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
       <input type="text" name="adress" id="adress" size="47" maxlength="100" value="" placeholder="주소를 입력해주세요.">
  </td>
</tr>
  <tr>
  <td width="343" colspan="5">
       <input type="tel" name="phone" id="phone" size="47" maxlength="100" value="" placeholder="전화번호를 입력해주세요.">
  </td>
</tr>  
  <tr>
    <td width="343" colspan="5">
<!--  [2] 파일 업로드를 하기 위한 input 태그는 타입 속성 값을 file로 지정해야 한다.  -->
      <input type="file" name="member1_rboard_image" id="member1_rboard_image">
      
 </td>
 </tr>
 </table>

<input class="btn" type="button" value="취소" onClick="go_mov()">
<input class="btn" type="button" value="등록" onClick="go_m1rsave()">           

</form> 
</div>
	<footer id="footer">
	<div id="footer_box">
		<%@ include file="../footer.jsp" %> 
	</div>
</footer>
</body>
</html>