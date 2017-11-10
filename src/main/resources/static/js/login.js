$(function() {
	var windowH = $(window).height();
	var windowW = $(window).width();
	var imgH;
	$('img').load(function() {
		imgH = $(this).height();
		$('.logMsg').height(imgH);
		$('.content').css({'margin-top':(windowH-imgH) / 2 + 'px'});
	});
});