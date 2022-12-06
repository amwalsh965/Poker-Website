$(document).ready(function() {
	$(document).ready(function(){
	$(".table").css("height", $(window).height());
	$(".table").css("width", $(window).width());
	
	$("#canvas").css("height", $(window).height());
	$("#canvas").css("width", $(window).width());
	
	$(".main-container-for-game").css("height", $(window).height());
	$(".main-container-for-game").css("width", $(window).width());
	
	$("#main-container").css("height", $(window).height());
	$("#main-container").css("width", $(window).width());
	
	$(".table-image").css("height", $(window).height());
	$(".table-image").css("width", $(window).width());
	});
	var width1 = $(window).width();
	var height1 = $(window).height();
	$(window).resize(function() {
		var width = $(window).width();
		var height = $(window).height();
		if(width != width1) {
			$(".table").css("height", .94*(width/2));
			$(".table").css("width", width);
			
			$("#canvas").css("height", .94*(width/2));
			$("#canvas").css("width", width);
			
			$(".main-container-for-game").css("height", .94*(width/2));
			$(".main-container-for-game").css("width", width);
			
			$("#main-container").css("height", .94*(width/2));
			$("#main-container").css("width", width);
			
			$(".table-image").css("height", .94*(width/2));
			$(".table-image").css("width", width);
		}
		if(height != height1) {
			$(".table").css("height", height);
			$(".table").css("width", (height*2)/.94);
			
			$("#canvas").css("height", height);
			$("#canvas").css("width", (height*2)/.94);
			
			$(".main-container-for-game").css("height", height);
			$(".main-container-for-game").css("width", (height*2)/.94);
			
			$("#main-container").css("height", height);
			$("#main-container").css("width", (height*2)/.94);
			
			$(".table-image").css("height", height);
			$(".table-image").css("width", (height*2)/.94);
		}
		
		width1 = width;
		height1 = height;
		
	});
});
