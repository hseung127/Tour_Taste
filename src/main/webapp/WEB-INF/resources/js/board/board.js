// member tour 
// member tour 글쓰기 화면 출력
function go_mtinsert() {
	$("#member_tform").attr("action", "member_tinsert_form").submit();
}

// member tour 글 등록
function go_mtsave() {
	var $area = $("[name=area]");
	
	if ($("#title").val() == "") {
		alert("제목을 입력하세요.");
		$("#title").focus();
	} else if (!$('input:radio[name=area]').is(':checked')) {
		alert("지역을 선택해 주세요.");
	} else {
		$("#member_tinsertform").attr("action", "member_tinsert").submit();
	}
}

// member tour 글 수정페이지로 이동
function go_mtupdateform() {
	$("#member_tdetailform").attr("action", "member_tupdate_form").submit();
}

// 글 수정
function go_mtupdate() {
	if ($("#title").val() == "") {
		alert("제목을 입력하세요.");
		$("#title").focus();
	} else if (!$('input:radio[name=area]').is(':checked')) {
		alert("지역을 선택해 주세요.");
	} else {
		$("#member_tupdateform").attr("action", "member_tupdate").submit();
	}
}

// member tour 글 삭제
function go_mtdelete() {
	if (!confirm("삭제하시겠습니까?")) {
		
	} else {
		$("#member_tdetailform").attr("action", "member_tdelete").submit();
	}
}




// member restaurant 
// member restaurant 글쓰기 화면 출력
function go_mrinsert() {
	$("#member_rform").attr("action", "member_rinsert_form").submit();
}

// member restaurant 글 등록
function go_mrsave() {
	var $area = $("[name=area]");
	
	if ($("#title").val() == "") {
		alert("제목을 입력하세요.")
		$("#title").focus();
	} else if (!$('input:radio[name=area]').is(':checked')) {
		alert("지역을 선택해 주세요.");
	} else {
		$("#member_rinsertform").attr("action", "member_rinsert").submit();
	}
}

//member restaurant 글 수정페이지로 이동
function go_mrupdateform() {
	$("#member_rdetailform").attr("action", "member_rupdate_form").submit();
}

// 글 수정
function go_mrupdate() {
	if ($("#title").val() == "") {
		alert("제목을 입력하세요.");
		$("#title").focus();
	} else if (!$('input:radio[name=area]').is(':checked')) {
		alert("지역을 선택해 주세요.");
	} else {
		$("#member_rupdateform").attr("action", "member_rupdate").submit();
	}
}

// member restaurant 글 삭제
function go_mrdelete() {
	if (!confirm("삭제하시겠습니까?")) {
		
	} else {
		$("#member_rdetailform").attr("action", "member_rdelete").submit();
	}
}