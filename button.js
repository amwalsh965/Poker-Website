
$(document).ready(function(){
	$(".options").click(function() {
		$(".option-dropdown").toggleClass("dropdown-open-click", true);
		$(".settings").toggleClass("dropdown-opened", true);
		$(".login").toggleClass("dropdown-opened", true);
		$(".close-button").toggleClass("dropdown-opened", true);
		$(".options").css("visibility", "hidden");
	});
	
	$(".close-button").click(function() {
		$(".option-dropdown").toggleClass("dropdown-open-click", false);
		$(".options").css("visibility", "visible");
	});
	
	function keyPress (e) {
    	if(e.key === "Escape") {
        	$(".option-dropdown").toggleClass("dropdown-open-click", false);
			$(".options").css("visibility", "visible");
    	}
	}
	
	$(document).on("keydown", keyPress);
});