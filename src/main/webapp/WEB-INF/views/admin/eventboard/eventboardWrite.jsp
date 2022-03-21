<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
      $(function(){
         $('#start_date').datepicker();
      })
</script>
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
<tr id="datebox"> 

  <td width="100px;">
    	<label for="start">Start date:</label> <input type="date" id="start_date" name="start_date" value="2022-03-21"
       min="2022-03-21" max="2022-12-31">
  </td>
  <td width="100px;">
     <label for="start">End date:</label> <input type="date" id="end_date" name="end_date" value="2022-03-21"
       min="2022-03-21" max="2022-12-31">
  </td>
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

   <!--  <td  colspan="3">
   	<h3>메인이미지</h3> 
      <input type="file"  multiple="multiple" name="homeimg" id="homeimg">
    </td>
  </tr>-->  
  <tr>
    <td colspan="3">
   		<h3>내용 이미지</h3> 
<!--  [2] 파일 업로드를 하기 위한 input 태그는 타입 속성 값을 file로 지정해야 한다.  -->
      <input type="file"  multiple="multiple" name="eventboard_image" id="eventboard_image"onchange="readURL(this);" class="oriImg">
					<img id="blah" src="#" class="thumbImg"/>
      
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
	//input을 datepicker로 선언
	$("#start_date").datepicker({
	dateFormat: 'yy-mm-dd' //달력 날짜 형태
	,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
	,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
	,changeYear: true //option값 년 선택 가능
	,changeMonth: true //option값 월 선택 가능
	,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시
	,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
	,buttonImageOnly: true //버튼 이미지만 깔끔하게 보이게함
	,buttonText: "선택" //버튼 호버 텍스트
	,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
	,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
	,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
	,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
	,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
	,minDate: "-5Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
	,maxDate: "+5y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)
	});

	//초기값을 오늘 날짜로 설정해줘야 합니다.
	$('#start_date').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
	});
</script>
</body>
</html>