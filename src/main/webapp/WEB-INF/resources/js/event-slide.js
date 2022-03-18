$(document).ready(function(){


	
	$('#event-slide-btn1').click( function() {
		$('#event-slide-btn2').removeClass('swiper-pagination-bullet-active'); 
        $("#event-slide-btn1").addClass('swiper-pagination-bullet-active');  	
		//$(".swiper-wrapper").css({"transform":"translate(-465px)"}); 
		$("div").find(".swiper-wrapper").css({"transform":"translate(-465px)"}); 
		console.log('1');
		} );
	
	
	
	$('#event-slide-btn2').click( function() {
		$('#event-slide-btn1').removeClass('swiper-pagination-bullet-active'); 
        $("#event-slide-btn2").addClass('swiper-pagination-bullet-active'); 
		$(".swiper-wrapper").css({"transform":"translate(0px)"}); 
		console.log('2');
		} );
	

});
