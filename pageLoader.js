
$(document).ready(function(){
	$(".options").click(function() {
		$("#option-dropdown").css("visibility", "visible");
		$(".options").css("visibility", "hidden");
	});
	
	$(".close-button").click(function() {
		$("#option-dropdown").css("visibility", "hidden");
		$(".options").css("visibility", "visible");
	});
});