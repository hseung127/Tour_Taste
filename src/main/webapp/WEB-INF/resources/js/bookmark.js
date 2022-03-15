function insert_bookmark(seq,index){
	/*$("#btn-m1r-bookmark"+seq)*/
	//var countText = $(this).attr('data-count'); 
	$('#home-m1r-bookmark'+index).load("insert_bookmark_m1r", {m1rseq:seq, index:index}, function() {
		
		//var updateCountText = "${m1rCountBookmarkUpdate["+index+"].m1rCount}";
		//$("#home-m1r-bookmark").text(countText); 
		//$("#home-m1r-bookmark").html(updateCountText);
		//console.log($("#home-m1r-bookmark").text(countText));
		/*$("#btn-m1r-bookmark"+seq).html*/
		//$(".product.wow.fadeInLeft").finish();
	});

}
