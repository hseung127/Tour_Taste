/*
 * 회원 가입시, 필수 입력 항목 확인
 */
function go_save(){
	var i_RegExp = /^[a-zA-Z0-9]{4,15}$/; //id 유효성 검사 정규식
	var p_RegExp = /^[a-zA-Z0-9]{6,18}$/; //pwassword 유효성 검사 정규식
    var e_RegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;  //이메일 유효성검사
    var n_RegExp = /^[가-힣]{2,15}$/; //이름 유효성검사 정규식
    
    var objId = document.getElementById("id"); //아이디
    var objPwd = document.getElementById("pwd"); //비밀번호
    var objPwdChk = document.getElementById("pwdChk"); //비밀번호확인
    var objName = document.getElementById("name"); //이름
    var objEmail = document.getElementById("email");//메일
	   
	    // ================ ID 유효성검사 ================ //
    if(objId.value==''){
        alert("아이디를 입력해주세요.");
        $("#id").focus();
        return false;
    }
    if(!i_RegExp.test(objId.value)){ //아이디 유효성검사
        alert("아이디를 잘못 입력하였습니다. 다시 확인해주세요.");      
        $("#id").focus();
        return false;
    }
    
    // ================ PASSWORD 유효성검사 ===============//
    if(objPwd.value==''){ // 비밀번호 입력여부 검사
        alert("비밀번호를 입력해주세요.");
        $("#pwd").focus();
        return false;
    }
    if(!p_RegExp.test(objPwd.value)){ //패스워드 유효성검사
        alert("비밀번호를 잘못 입력하였습니다. 다시 확인해주세요.");
        $("#pwd").focus();
        return false;
    }
        
    if(objPwdChk.value!=objPwd.value){ //비밀번호와 비밀번호확인이 동일한지 검사
        alert("비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
        $("#pwdChk").focus();
        return false;
    }
    
    // ================ 이름 유효성검사 ================ //        
    if(objName.value ==''){
        alert("이름을 입력해주세요.");
        $("#name").focus();
        return false;
    }
    if(!n_RegExp.test(objName.value)){
        alert("이름을 잘못 잘못 입력하였습니다. 다시 확인해주세요.");
        $("#name").focus();
        return false;
    }
    
    // ================ email 유효성검사 ================ //
    if(e_RegExp.value == ''){ // 이메일 입력여부 검사
        alert("이메일을 입력해주세요.");
        $("#email").focus();
        return false;
    }
    
    if(!e_RegExp.test(objEmail.value)){ //이메일 유효성 검사
        alert("이메일을 잘못 잘못 입력하였습니다. 다시 확인해주세요.");
        $("#email").focus();
        return false;
    } else {
       alert("회원가입을 완료하려면 입력한 이메일 계정으로 수신한 확인 링크를 클릭해 주세요!");
      // 회원 가입 요청
      $("#join").attr("action", "join").submit();
   }
}


function go_find_pwd(){
	$("#find_pwd").attr("action", "find_pwd").submit();
}
