/*
 * 회원 가입시, 필수 입력 항목 확인
 */
function go_modify_pwd(){
    var RegExp = /^[a-zA-Z0-9]{6,18}$/; //pwassword 유효성 검사 정규식
   
   
    if($("#new_pwd").val() == ''){ // 비밀번호 입력여부 검사
        alert("새로운 비밀번호를 입력해주세요.");
        $("#new_pwd").focus();
        return false;
    }

    if(!RegExp.test($("#new_pwd").val())){ //패스워드 유효성검사
        alert("새로운 비밀번호를 잘못 입력하였습니다. 다시 확인해주세요.");
        $("#new_pwd").focus();
        return false;
    }
        
    if($("#new_pwdChk").val() != $("#new_pwd").val()){ //비밀번호와 비밀번호확인이 동일한지 검사
        alert("새로운 비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
        $("#new_pwdChk").focus();
        return false;
    } else {
       
    //비밀번호 변경 요청
    $("#modify_pwd").attr("action", "modify_pwd").submit();
   }
}
