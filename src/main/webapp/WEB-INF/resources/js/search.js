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
	
	
	
		    
});  



function go_search_index(e){
	var index = $(e).attr('data-index');
	$( 'html, body' ).animate( { scrollTop : 0 }, 400 );
	$("#search-pagination").find(".p-index").removeClass('current');
	$("#search-pagination").find("#p-index"+index).addClass('current');
}








/*var key = $('.searchKey').html(); //searchkey의 html 값 = 검색키워드값
if(key != ""){ //비어있지않으면?
    $(".search-list:contains('"+key+"')").each(function () {
        //var regex = new RegExp(key,'gi');
        $(this).html( $(this).text().replace(key, "<span class='text-red'>"+key+"</span>") );
    });
}
*/




