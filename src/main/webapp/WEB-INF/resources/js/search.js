//1. 검색 된거key 값 검색 창에 나오게
//2. 검색 된 key값 진하게 or 색


$(function(){

	
	//totalcount 값 가져오기
	var totalCount=[];
	totalCount = $('.totalCountData div').toArray(); //페이징 숫자부분 1,2,3...
	
	
	
	for (var index in totalCount){
		console.log(totalCount[index].innerHTML);
		var totalInt =parseInt(totalCount[index].innerHTML);
		if(totalInt == 0){ //검색 된 목록 없는건 안나오게
			$('.searchBoard'+'.'+index).addClass('none');
			console.log(totalCount[index].innerHTML);
		}else if(totalInt <= 3){ //3개 이하는 '모두 보기>' 없애기 
			$('.search-more'+'.'+index).addClass('none');
			console.log(totalCount[index].innerHTML);
		}
	}
	
	$("#p-index1").addClass('current');
	
		/*var key = $('.searchKey').attr('data-searchKey');
		console.log(key);
		$("span:contains(key)").css({color:"red"});*/
	var listTotalCount = $('.search-total-count span').html();
	if(listTotalCount<=10){
		$("#search-pagination").addClass('none');
	}
	
	
	
	//검색 키워드 하이라이트 표시
	var key = $('.searchKey').html(); //searchkey의 html 값 = 검색키워드값
	if(key != ""){ //비어있지않으면?
	    $(".search-list p:contains('"+key+"')").each(function () {
	        var regex = new RegExp(key,'gi');
	    	console.log($(this).html( $(this).text()));
	        $(this).html( $(this).text().replace(regex, "<strong class='key-color'>"+key+"</strong>") );
	    });
	    
	    
	    //검색창에 검색한 단어 표시
	    $("#searchTextBox").val(key);
	    
	}
	
	
	

	//검색창 클릭하면 테두리 굵게 표시
	/*$("#searchTextBox").click(function () {
		$("form.header-searchBox").css({"outline-color": "#666"});
	});*/
	
	//header-searchBox
	/*$('html').click(function() { 
		if(!$(this).hasClass("header-searchBox")) { 
			$("form.header-searchBox").css({"outline-color": "none"});
		} 
	});
	*/
	
	$(document).click(function(e){ //문서 body를 클릭했을때
 		/*if(e.target.className =="searchBoxClick"){return false} *///내가 클릭한 요소(target)를 기준으로 상위요소에 .share-pop이 없으면 (갯수가 0이라면)
		if(!$(this).hasClass("searchBoxClick")||!$(this).hasClass("search-image")||!$(this).hasClass("blind")) { 
			$("form.header-searchBox").css({"outline-color": "transparent"});
			console.log('3');
		} else{
			$("form.header-searchBox").css({"outline-color": "#666"});
		}
		

 		
 });



	
	//css({"background-color":"grey","opacity":"0.5"});


	
    
});  



function go_search_index(e){
	var index = $(e).attr('data-index');
	$( 'html, body' ).animate( { scrollTop : 0 }, 400 );
	$("#search-pagination").find(".p-index").removeClass('current');
	$("#search-pagination").find("#p-index"+index).addClass('current');
}











