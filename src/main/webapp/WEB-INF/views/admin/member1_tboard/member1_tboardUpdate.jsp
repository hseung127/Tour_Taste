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
		<input type="hidden" name="pageNum" value="${criteria.pageNum }">
        <input type="hidden" name="rowsPerPage" value="${criteria.rowsPerPage}"> 
        <input type="hidden" name="keyword" value="${criteria.keyword}">
<input type="hidden" name="code" >
<input type="hidden" name="nonmakeImg" value="${member1_tboardVO.image1}"> <!-- 기존 이미지 저장  -->
<table id="list">
			
<tr>
<td class="area_check" id="area" name="area">
			<p>지역 선택
			<label><input type="radio" name="area" value="서울특별시" value="01">서울</label>
			<label><input type="radio" name="area" value="인천광역시"value="02">인천</label>
			<label><input type="radio" name="area" value="대전광역시"value="03">대전</label>
			<label><input type="radio" name="area" value="대구광역시" value="04">대구</label>
			<label><input type="radio" name="area" value="광주광역시" value="05">광주</label>
			<label><input type="radio" name="area" value="부산광역시" value="06">부산</label>
			<label><input type="radio" name="area" value="울산광역시" value="07">울산</label>
			<label><input type="radio" name="area" value="세종특별자치시" value="08">세종</label>
			<label><input type="radio" name="area" value="경기도" value="09">경기</label>
			<label><input type="radio" name="area" value="강원도" value="10">강원</label>
			<label><input type="radio" name="area" value="충청북도"value="11">충북</label>
			<label><input type="radio" name="area" value="충천남도"value="12">충남</label>
			<label><input type="radio" name="area" value="경상북도"value="13">경북</label>
			<label><input type="radio" name="area" value="경산남도"value="14">경남</label>
			<label><input type="radio" name="area" value="전라북도" value="15">전북</label>
			<label><input type="radio" name="area" value="전라남도"value="16">전남</label>
			<label><input type="radio" name="area" value="제주특별자치도"value="17">제주</label>
			</td> 
			</tr>  
<tr>
  <tr>

    <td>
      <input type="text" name="subject" id="subject" size="47" maxlength="100" value="${member1_tboardVO.subject}">
    </td>
  </tr>
  <tr>

    <td colspan="5">
      <textarea name="content" id="content" rows="8" cols="70" >${member1_tboardVO.content}</textarea>
            <script>

						

							CKEDITOR.replace("content", {
								height : '500px'});
						</script>
    </td>
  </tr>
        <tr>
  <td width="343" colspan="5">
      주소<input type="text" name="adress" id="adress" size="47" maxlength="100" value="${member1_tboardVO.address}" >
  </td>
</tr>
  <tr>
  <td width="343" colspan="5">
    전화번호   <input type="tel" name="phone" id="phone" size="47" maxlength="100" value="" value="${member1_tboardVO.phone}">
  </td>
</tr>  
  <tr>
    <td colspan="5">
      <img src="member1_tboard_images/${member1_tboardVO.image1}" width="200pt">     
      <br>
      <input type="file" name="member1_tboard_image" id="member1_tboard_image"onchange="readURL(this);" class="oriImg">
					<img id="blah" src="#" class="thumbImg"/>
      <input type="hidden" name="image" value="${member1_tboardVO.image1}">
    </td> 
  </tr>    
</table>
<input class="btn" type="button" value="등록" onClick="go_m1tmod_save('${member1_tboardVO.m1tseq}')">          
<input class="btn" type="button" value="취소" onClick="go_mov('${criteria.pageNum}', '${criteria.rowsPerPage}')">
</form> 
</div>
	<footer id="footer">
	<div id="footer_box">
		<%@ include file="../footer.jsp" %> 
	</div>
</footer>
</body>
</html>