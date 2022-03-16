// member tour 글쓰기 화면 출력
function go_mtinsert() {
	$("#member_tform").attr("action", "member_tinsert_form").submit();
}

// member tour 글 등록
function go_mtsave() {
	var $area = $("[name=area]");
	
	if ($("#title").val == "") {
		alert("제목을 입력하세요.")
		$("#title").focus();
	} else if ($("#editor4").val == "") {
		alert("내용을 입력하세요.")
		$("#editor4").focus();
	} else if ($area.val == "") {
		alert("지역을 선택해 주세요.")
	} else {
		$("#member_tinsertform").attr("action", "member_tinsert").submit();
	}
}

// member restaurant 글쓰기 화면 출력
function go_mrinsert() {
	$("#member_rform").attr("action", "member_rinsert_form").submit();
}

// member restaurant 글 등록
function go_mrsave() {
	var $area = $("[name=area]");
	
	if ($("#title").val == "") {
		alert("제목을 입력하세요.")
		$("#title").focus();
	} else if ($("#editor4").val == "") {
		alert("내용을 입력하세요.")
		$("#editor4").focus();
	} else if ($area.val == "") {
		alert("지역을 선택해 주세요.")
	} else {
		$("#member_rinsertform").attr("action", "member_rinsert").submit();
	}
}