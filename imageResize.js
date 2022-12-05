$(document).ready(function() {
	$(window).resize(function() {
		var width = $(window).width();
		var height = $(window).height();
		
		var imgHeight = height * .09;
		var imgWidth = width * .0275;
		
		$(".card-image").css("width", imgWidth+"px");
		$(".card-image").css("height", imgHeight+"px");
	});
});