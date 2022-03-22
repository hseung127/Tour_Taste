
/**
 * 
 */

function go() {

}
/*
 *  소식 등록화면 출력
 */
function go_wrt(pageNum,rowsPerPage) {
	$('#admin_newsboardList').attr('action', 'admin_newsboard_write_form').submit();
	$('#admin_eventboardList').attr('action', 'admin_eventboard_write_form').submit();
	$('#admin_member1_rboardList').attr('action', 'admin_member1_rboard_write_form').submit();
	$('#admin_member1_tboardList').attr('action', 'admin_member1_tboard_write_form').submit();
	$('#admin_seasonboardList').attr('action', 'admin_seasonboard_write_form').submit();
}

/*
 * * 소식 등록 시에 입력값 확인
 */
function go_nsave() {

	if ($("#subject").val() == "") {
		alert("소식명을 입력하세요!");
		$("#subject").focus();
	} else if ($("#content").val() == "") {
		alert("내용을 입력하세요!");
		$("#content").focus();
	} else if ($("#newsboard_image").val() == "") {
		alert("이미지를 입력하세요!");
		$("#newsboard_image").focus();
	} else {
		// 주의: 이미지 파일을 전송하므로 enctype이 설정되어야 함.
		$("#nwrite_form").attr("encoding", "multipart/form-data");
		$("#nwrite_form").attr("action", "admin_newsboard_write").submit();
	}

}
function go_esave() {

	if ($("#subject").val() == "") {
		alert("이벤트명을 입력하세요!");
		$("#subject").focus();
	} else if ($("#content").val() == "") {
		alert("내용을 입력하세요!");
		$("#content").focus();
	} else if ($("#eventboard_image").val() == "") {
		alert("이미지를 입력하세요!");
		$("#eventboard_image").focus();
	} else {
		// 주의: 이미지 파일을 전송하므로 enctype이 설정되어야 함.
		$("#ewrite_form").attr("encoding", "multipart/form-data");
		$("#ewrite_form").attr("action", "admin_eventboard_write").submit();
	}

}
function go_ssave() {
	if ($("#subject").val() == "") {
		alert("시즌명을 입력하세요!");
		$("#subject").focus();
	} else if ($("#content").val() == "") {
		alert("상세내용 입력하세요!");
		$("#content").focus();
	} else if ($("#seasonboard_image").val() == "") {
		alert("이미지를 입력하세요!");
		$("#seasonboard_image").focus();
	} else {
		// 주의: 이미지 파일을 전송하므로 enctype이 설정되어야 함.
		$("#swrite_form").attr("encoding", "multipart/form-data");
		$("#swrite_form").attr("action", "admin_seasonboard_write").submit();
	}
}
function go_m1rsave() {
	if ($("#subject").val() == "") {
		alert("관리자맛집명을 입력하세요!");
		$("#subject").focus();
	} else if ($("#content").val() == "") {
		alert("상세내용 입력하세요!");
		$("#content").focus();
	} else if ($("#member1_rboard_image").val() == "") {
		alert("이미지를 입력하세요!");
		$("#member1_rboard_image").focus();
	} else if (!$('input:radio[name=area]').is(':checked')) {
		alert("지역을 선택해 주세요.");
	}else if (!$('input:radio[name=kind]').is(':checked')) {
		alert("음식종류를 선택해 주세요.");
	}else {
		// 주의: 이미지 파일을 전송하므로 enctype이 설정되어야 함.
		$("#m1rwrite_form").attr("encoding", "multipart/form-data");
		$("#m1rwrite_form").attr("action", "admin_member1_rboard_write").submit();
	}
}
function go_m1tsave() {
	if ($("#subject").val() == "") {
		alert("관리자여행명을 입력하세요!");
		$("#subject").focus();
	} else if ($("#content").val() == "") {
		alert("상세내용 입력하세요!");
		$("#content").focus();
	} else if ($("#member1_tboard_image").val() == "") {
		alert("이미지를 입력하세요!");
		$("#member1_tboard_image").focus();
	} else if (!$('input:radio[name=area]').is(':checked')) {
		alert("지역을 선택해 주세요.");
	}else {
		// 주의: 이미지 파일을 전송하므로 enctype이 설정되어야 함.
		$("#m1twrite_form").attr("encoding", "multipart/form-data");
		$("#m1twrite_form").attr("action", "admin_member1_tboard_write").submit();
	}
}


/*
 * 소식 수정화면 요청
 */
function go_nmod(pageNum, rowsPerPage,nseq) {
	$("#ndetail_form")
			.attr("action", "admin_newsboard_update_form?pageNum=" + pageNum+"&rowsPerPage="+rowsPerPage+"&nseq="+nseq)
			.submit();
}

function go_emod(pageNum, rowsPerPage,eseq) {
	$("#edetail_form")
			.attr("action", "admin_eventboard_update_form?pageNum=" + pageNum+"&rowsPerPage="+rowsPerPage+"&eseq=" + eseq)
			.submit();
}
function go_smod(pageNum, rowsPerPage,sseq) {
	$("#sdetail_form")
			.attr("action", "admin_seasonboard_update_form?pageNum=" + pageNum+"&rowsPerPage="+rowsPerPage+"&sseq=" + sseq)
			.submit();
}
function go_m1rmod(pageNum, rowsPerPage,m1rseq) {
	$("#m1rdetail_form")
			.attr("action", "admin_member1_rboard_update_form?pageNum=" + pageNum+"&rowsPerPage="+rowsPerPage+"&m1rseq=" + m1rseq)
			.submit();
}
function go_m1tmod(pageNum, rowsPerPage,m1tseq) {
	$("#m1tdetail_form")
			.attr("action", "admin_member1_tboard_update_form?pageNum=" + pageNum+"&rowsPerPage="+rowsPerPage+"&m1tseq=" + m1tseq)
			.submit();
}

/*
 * 소식 수정 요청
 */
function go_nmod_save(nseq) {
	if ($("#subject").val() == "") {
		alert("소식명을 입력하세요!");
		$("#subject").focus();
	} else if ($("#content").val() == "") {
		alert("상세내용 입력하세요!");
		$("#content").focus();
	} else {
		// 주의: 이미지 파일을 전송하므로 enctype이 설정되어야 함.
		$("#nupdate_form").attr("encoding", "multipart/form-data");
		$("#nupdate_form").attr("action", "admin_newsboard_update").submit();
	}
}
function go_emod_save(eseq) {
	if ($("#subject").val() == "") {
		alert("이벤트명을 입력하세요!");
		$("#subject").focus();
	} else if ($("#content").val() == "") {
		alert("상세내용 입력하세요!");
		$("#content").focus();
	} else {
		// 주의: 이미지 파일을 전송하므로 enctype이 설정되어야 함.
		$("#eupdate_form").attr("encoding", "multipart/form-data");
		$("#eupdate_form").attr("action", "admin_eventboard_update").submit();
	}
}

function go_smod_save(sseq) {
	if ($("#subject").val() == "") {
		alert("시즌명을 입력하세요!");
		$("#subject").focus();
	} else if ($("#content").val() == "") {
		alert("상세내용 입력하세요!");
		$("#content").focus();
	} else {
		// 주의: 이미지 파일을 전송하므로 enctype이 설정되어야 함.
		$("#supdate_form").attr("encoding", "multipart/form-data");
		$("#supdate_form").attr("action", "admin_seasonboard_update").submit();
	}
}
function go_m1rmod_save(m1rseq) {
	if ($("#subject").val() == "") {
		alert("관리자맛집명을 입력하세요!");
		$("#subject").focus();
	} else if ($("#content").val() == "") {
		alert("상세내용 입력하세요!");
		$("#content").focus();
	} else {
		// 주의: 이미지 파일을 전송하므로 enctype이 설정되어야 함.
		$("#m1rupdate_form").attr("encoding", "multipart/form-data");
		$("#m1rupdate_form").attr("action", "admin_member1_rboard_update").submit();
	}
}
function go_m1tmod_save(m1tseq) {
	if ($("#subject").val() == "") {
		alert("관리자여행명을 입력하세요!");
		$("#subject").focus();
	} else if ($("#content").val() == "") {
		alert("상세내용 입력하세요!");
		$("#content").focus();
	} else {
		// 주의: 이미지 파일을 전송하므로 enctype이 설정되어야 함.
		$("#m1tupdate_form").attr("encoding", "multipart/form-data");
		$("#m1tupdate_form").attr("action", "admin_member1_tboard_update").submit();
	}
}
/*
 *  수정 취소하고 목록으로 이동함.
 */
function go_mov(pageNum,rowsPerPage) {
	/*write*/
	$("#nwrite_form").attr("action", "admin_newsboard_list").submit();
	$('#m1rwrite_form').attr("action", "admin_member1_rboard_list").submit();
	$('#m1twrite_form').attr("action", "admin_member1_tboard_list").submit();
	$('#ewrite_form').attr("action", "admin_eventboard_list").submit();
	$('#swrite_form').attr("action", "admin_seasonboard_list").submit();	
		/*update*/
	$('#supdate_form').attr("action", "admin_seasonboard_list?pageNum="+pageNum+"&rowsPerPage="+rowsPerPage).submit();
	$("#nupdate_form").attr("action", "admin_newsboard_list?pageNum="+pageNum+"&rowsPerPage="+rowsPerPage).submit();
	$('#m1rupdate_form').attr("action", "admin_member1_rboard_list?pageNum="+pageNum+"&rowsPerPage="+rowsPerPage).submit();
	$('#m1tupdate_form').attr("action", "admin_member1_tboard_list?pageNum="+pageNum+"&rowsPerPage="+rowsPerPage).submit();
	$('#eupdate_form').attr("action", "admin_eventboard_list?pageNum="+pageNum+"&rowsPerPage="+rowsPerPage).submit();

	
	
	
}
/*페이지 유징 */


/*
 * 상세보기에서 목록으로 이동
 */
function go_list(pageNum,rowsPerPage) {
	$("#ndetail_form").attr("action", "admin_newsboard_list?pageNum="+pageNum+"&rowsPerPage="+rowsPerPage).submit();
	$("#m0rdetail_form").attr("action", "admin_member0_rboard_list?pageNum="+pageNum+"&rowsPerPage="+rowsPerPage).submit();
	$('#m0tdetail_form').attr("action", "admin_member0_tboard_list?pageNum="+pageNum+"&rowsPerPage="+rowsPerPage).submit();
	$('#m1rdetail_form').attr("action", "admin_member1_rboard_list?pageNum="+pageNum+"&rowsPerPage="+rowsPerPage).submit();
	$('#m1tdetail_form').attr("action", "admin_member1_tboard_list?pageNum="+pageNum+"&rowsPerPage="+rowsPerPage).submit();
	$('#edetail_form').attr("action", "admin_eventboard_list?pageNum="+pageNum+"&rowsPerPage="+rowsPerPage).submit();
	$('#sdetail_form').attr("action", "admin_seasonboard_list?pageNum="+pageNum+"&rowsPerPage="+rowsPerPage).submit();
	$('#cdetail_form').attr("action", "admin_comments_list?pageNum="+pageNum+"&rowsPerPage="+rowsPerPage).submit();

}



function go_delete() {
	var con = confirm("정말로 삭제하시겠습니까?");
	
	if(con){
		$('#ndetail_form').attr("action","admin_newsboard_delete").submit();
		$('#m0rdetail_form').attr("action","admin_member0_rboard_delete").submit();
		$('#m0tdetail_form').attr("action","admin_member0_tboard_delete").submit();
		$('#m1rdetail_form').attr("action","admin_member1_rboard_delete").submit();
		$('#m1tdetail_form').attr("action","admin_member1_tboard_delete").submit();
		$('#edetail_form').attr("action","admin_eventboard_delete").submit();
		$('#sdetail_form').attr("action","admin_seasonboard_delete").submit();
		$('#cdetail_form').attr("action","admin_comments_delete").submit();
		alert("삭제가 완료되었습니다.");
	}else {
		return false;
	}
	

}
function checkAll(){
	if( $("#allCheck").is(':checked') ){
        $("input[name=nseq]").prop("checked", true);
      }else{
        $("input[name=nseq]").prop("checked", false);
      }
	
	if( $("#allCheck").is(':checked') ){
        $("input[name=sseq]").prop("checked", true);
      }else{
        $("input[name=sseq]").prop("checked", false);
      }
	
	if( $("#allCheck").is(':checked') ){
        $("input[name=m1rseq]").prop("checked", true);
      }else{
        $("input[name=m1rseq]").prop("checked", false);
      }
	
	if( $("#allCheck").is(':checked') ){
        $("input[name=m1tseq]").prop("checked", true);
      }else{
        $("input[name=m1tseq]").prop("checked", false);
      }
	
	if( $("#allCheck").is(':checked') ){
        $("input[name=m0rseq]").prop("checked", true);
      }else{
        $("input[name=m0rseq]").prop("checked", false);
      }
	
	if( $("#allCheck").is(':checked') ){
        $("input[name=m0tseq]").prop("checked", true);
      }else{
        $("input[name=m0tseq]").prop("checked", false);
      }
	
	if( $("#allCheck").is(':checked') ){
        $("input[name=eseq]").prop("checked", true);
      }else{
        $("input[name=eseq]").prop("checked", false);
      }

}

function go_ndelete(){
var con = confirm("정말로 삭제하시겠습니까?");
var count = 0;
//삭제할 항목이 하나인 경우 확인
if (document.nfrm.nseq.length == undefined) {
	if (document.nfrm.nseq.checked == true) {
		count++;
	}
}
// 삭제할 항목이 2개 이상인 경우 확인
for (var i=0; i<document.nfrm.nseq.length; i++) {
	if (document.nfrm.nseq[i].checked == true) {
		count++;
	}
}

if (count == 0) {
	alert("삭제할 항목을 선택해 주세요!");
} else {
	if(con){
		 $("#admin_newsboardList").attr("action", "admin_newsboard_ndelete").submit();

	}
}




}
function go_m1rdelete(){
	var con = confirm("정말로 삭제하시겠습니까?");
	var count = 0;
if (document.m1rfrm.m1rseq.length == undefined) {
	if (document.m1rfrm.m1rseq.checked == true) {
		count++;
	}
}
// 삭제할 항목이 2개 이상인 경우 확인
for (var i=0; i<document.m1rfrm.m1rseq.length; i++) {
	if (document.m1rfrm.m1rseq[i].checked == true) {
		count++;
	}
}

if (count == 0) {
	alert("삭제할 항목을 선택해 주세요!");
} else {
	if(con){
		 $("#admin_member1_rboardList").attr("action", "admin_member1_rboard_m1rdelete").submit();

	}
}
}

function go_m0rdelete(){
	var con = confirm("정말로 삭제하시겠습니까?");
	var count = 0;
if (document.m0rfrm.m0rseq.length == undefined) {
	if (document.m0rfrm.m0rseq.checked == true) {
		count++;
	}
}
// 삭제할 항목이 2개 이상인 경우 확인
for (var i=0; i<document.m0rfrm.m0rseq.length; i++) {
	if (document.m0rfrm.m0rseq[i].checked == true) {
		count++;
	}
}

if (count == 0) {
	alert("삭제할 항목을 선택해 주세요!");
} else {
	if(con){
		 $("#admin_member0_rboardList").attr("action", "admin_member0_rboard_m0rdelete").submit();

	}
}
}


function go_m0tdelete(){
	var con = confirm("정말로 삭제하시겠습니까?");
	var count = 0;
if (document.m0tfrm.m0tseq.length == undefined) {
	if (document.m0tfrm.m0tseq.checked == true) {
		count++;
	}
}
// 삭제할 항목이 2개 이상인 경우 확인
for (var i=0; i<document.m0tfrm.m0tseq.length; i++) {
	if (document.m0tfrm.m0tseq[i].checked == true) {
		count++;
	}
}

if (count == 0) {
	alert("삭제할 항목을 선택해 주세요!");
} else {
	if(con){
		 $("#admin_member0_tboardList").attr("action", "admin_member0_tboard_m0tdelete").submit();

	}
}
}

function go_m1tdelete(){
	var con = confirm("정말로 삭제하시겠습니까?");
	var count = 0;
if (document.m1tfrm.m1tseq.length == undefined) {
	if (document.m1tfrm.m1tseq.checked == true) {
		count++;
	}
}
// 삭제할 항목이 2개 이상인 경우 확인
for (var i=0; i<document.m1tfrm.m1tseq.length; i++) {
	if (document.m1tfrm.m1tseq[i].checked == true) {
		count++;
	}
}

if (count == 0) {
	alert("삭제할 항목을 선택해 주세요!");
} else {
	if(con){
		 $("#admin_member1_tboardList").attr("action", "admin_member1_tboard_m1tdelete").submit();

	}
}
}

function go_sdelete(pageNum,rowsPerPage){
	var con = confirm("정말로 삭제하시겠습니까?");
	var count = 0;
if (document.sfrm.sseq.length == undefined) {
	if (document.sfrm.sseq.checked == true) {
		count++;
	}
}
// 삭제할 항목이 2개 이상인 경우 확인
for (var i=0; i<document.sfrm.sseq.length; i++) {
	if (document.sfrm.sseq[i].checked == true) {
		count++;
	}
}

if (count == 0) {
	alert("삭제할 항목을 선택해 주세요!");
} else {
	if(con){
		 $("#admin_seasonboardList").attr("action", "admin_seasonboard_sdelete?pageNum="+pageNum+"&rowsPerPage="+rowsPerPage).submit();

	}
}
}

function go_edelete(){
	var con = confirm("정말로 삭제하시겠습니까?");
	var count = 0;
if (document.efrm.eseq.length == undefined) {
	if (document.efrm.eseq.checked == true) {
		count++;
	}
}
// 삭제할 항목이 2개 이상인 경우 확인
for (var i=0; i<document.efrm.eseq.length; i++) {
	if (document.efrm.eseq[i].checked == true) {
		count++;
	}
}

if (count == 0) {
	alert("삭제할 항목을 선택해 주세요!");
} else {
	if(con){
		 $("#admin_eventboardList").attr("action", "admin_eventboard_edelete").submit();

	}
}
}



//파일미리보기 

function readURL(input) {
	if (input.files && input.files[0]) {
	var reader = new FileReader();
	reader.onload = function (e) {
	$('#blah').attr('src', e.target.result);
	}
	reader.readAsDataURL(input.files[0]);
	}
	}