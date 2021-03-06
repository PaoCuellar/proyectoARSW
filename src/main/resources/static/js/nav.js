var ww = document.body.clientWidth;

$(document).ready(function() {
	$(".nav li a").each(function() {
		if ($(this).next().length > 0) {
			$(this).addClass("parent");
		};
	})
    
	$(".toggleMenu").click(function(e) {
		e.preventDefault();
		$(this).toggleClass("active");
		$(".nav").toggle();
	});
    
    $("#logout").click(function(){
        localStorage.removeItem("login")
		localStorage.removeItem("admin")
        window.location.href="/index.html"
    })
	adjustMenu();
})

$(window).bind('resize orientationchange', function() {
	ww = document.body.clientWidth;
	adjustMenu();
});

var adjustMenu = function() {
	if (ww < 800) {
		$(".toggleMenu").css("display", "inline-block");
		if (!$(".toggleMenu").hasClass("active")) {
			$(".nav").hide();
		} else {
			$(".nav").show();
		}
		$(".nav li").unbind('mouseenter mouseleave');
		$(".nav li a.parent").unbind('click').bind('click', function(e) {
			// must be attached to anchor element to prevent bubbling
			e.preventDefault();
			$(this).parent("li").toggleClass("hover");
		});
	} 
	else if (ww >= 768) {
		$(".toggleMenu").css("display", "none");
		$(".nav").show();
		$(".nav li").removeClass("hover");
		$(".nav li a").unbind('click');
		$(".nav li").unbind('mouseenter mouseleave').bind('mouseenter mouseleave', function() {
		 	// must be attached to li so that mouseleave is not triggered when hover over submenu
		 	$(this).toggleClass('hover');
		});
	}
    var loginvar = localStorage.getItem("login")
    if (loginvar){
        $(".showlogin").each((index,element) => {$(element).show()})
        $(".hidlogin").each((index,element) => {$(element).hide()})
    }
    else{
        $(".showlogin").each((index,element) => {$(element).hide()})
        $(".hidlogin").each((index,element) => {$(element).show()})
    }

	var logvar = localStorage.getItem("admin")
	if (logvar){
		$(".showInfo").each((index,element) => {$(element).show()})
	}
	else{
		$(".showInfo").each((index,element) => {$(element).hide()})
	}
}

