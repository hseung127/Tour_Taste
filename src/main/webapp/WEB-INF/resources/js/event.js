$(document).ready(function(){
	
	var tabNum = $(".tab-num").html();
	console.log(tabNum);
	if(tabNum == 2){
		/*$("#tab-2").load('event_list', function() {
			$("#p-index2").addClass('current');
		});
		
		*/
		$("#tab-2").load('news_list', function() {
			$('.tab-link').removeClass('current'); 
	        $('.tab-content').removeClass('current'); 

	        $("[data-tab='tab-2']").addClass('current');      
			$("#tab-2").addClass('current');
		});
		
		console.log("2번실행");
	}else{
		$("#tab-1").load('event_list', function() {
			$('.tab-link').removeClass('current'); 
	        $('.tab-content').removeClass('current'); 

	        $("[data-tab='tab-1']").addClass('current');      
			$("#tab-1").addClass('current');
		});
	}
						
						
						
						/*$(document).ready(function(){
							$("#p-index1").addClass('current');
						});*/
						
						tab_click(); //여기에 필요없음
					        
				    
});  


function go_index(e) { //현재 페이지 아래(border-bottom)에 _ 표시
	
	var indexUrl1 = 'event_list' + $(e).attr('data-index-url');
	var indexUrl2 = 'news_list' + $(e).attr('data-index-url');
	var index = $(e).attr('data-index'); //1,2,3
	var tabLinkCurrent = $('.tab-link.current').attr('data-tab'); //tab-1 or tab-2
	
	$( 'html, body' ).animate( { scrollTop : 0 }, 400 );
	
	if(tabLinkCurrent =='tab-1'){
		$("#tab-1").load(indexUrl1, function() { //내용에 로딩
			$("#tab-1").find("#p-index"+index).addClass('current');
		});
	}else if(tabLinkCurrent =='tab-2'){
		$("#tab-2").load(indexUrl2, function() {
			$("#tab-2").find("#p-index"+index).addClass('current');
		});
	}
}


function go_page(e){
	var tabLinkCurrent = $('.tab-link.current').attr('data-tab');
	var preUrl = $(e).attr('data-pre-url');
	var nextUrl=$(e).attr('data-next-url');
	
	if(preUrl != ""){
		if(tabLinkCurrent =='tab-1'){
			$("#tab-1").load("event_list"+preUrl, function() {
				$("#p-index"+index-1).addClass('current');
			});
		}else if(tabLinkCurrent =='tab-2'){
			$("#tab-2").load("news_list"+preUrl, function() {
				$("#p-index"+index-1).addClass('current');
			});
		}
	}else if(preUrl != ""){ 
		if(tabLinkCurrent =='tab-1'){
			$("#tab-1").load("event_list"+preUrl, function() {
				$("#p-index"+index-1).addClass('current');
			});
		}else if(tabLinkCurrent =='tab-2'){
			$("#tab-2").load("news_list"+preUrl, function() {
				$("#p-index"+index-1).addClass('current');
			});
		}
	}
}




function tab_click() {
    $('.tab-link').click(function () {
    	var tabId = $(this).attr('data-tab'); //현재  data-tab='tab-2' 가져옴

    	$('.tab-link').removeClass('current'); //모든 내용의 current 지우기
        $('.tab-content').removeClass('current'); //모든 내용의 current 지우기

        $(this).addClass('current');  //현재 class에 current 추가
        $("#" + tabId).addClass('current'); //아이디가 'tab-2'인것 (= 내용)
        								     //에 current 추가

        //var currentId = $("#" + tabId).attr('id');  //현재 아이디의 id 가져오기? 

        if(tabId =='tab-1'){ //현재 tab-1 이면
        	$("#" + tabId).load('event_list',function() { //내용에 로딩
        		$("#p-index1").addClass('current'); //로딩 되면 1에 current 추가
        		
        	});
        
        }else if(tabId =='tab-2'){
        	
        	$("#" + tabId).load('news_list',function() { 
        		console.log(333);
        		$("#tab-2").find("#p-index1").addClass('current'); //로딩 되면 2에 current 추가
        														
        	});
        }
	});
}