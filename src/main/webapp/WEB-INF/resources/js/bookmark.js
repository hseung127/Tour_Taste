function insert_bookmark(seq,index){

	$('#home-m1r-bookmark'+index).load("insert_bookmark_m1r", {m1rseq:seq, index:index}, function() {
		
		
	});

}


function bookmark_alert_login(){
	alert('로그인이 필요한 서비스입니다.');
}