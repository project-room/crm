$(function() {
	$('.main > .baseInfo').width($('.main').width()-60);
	$('.baseInfo div:nth-child(2)').width($('.baseInfo').width() - 321);
	$('.main').height($(window).height() - 60);
	$('.leftContent').height($(window).height());
	$('.main').niceScroll({
		cursorcolor: '#ccc'
	});

})