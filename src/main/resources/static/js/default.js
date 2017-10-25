$(function() {
	var windowH = $(document).height();
	var windowW = $(window).width();
	$('.leftContent').height(windowH);
	var rightHeaderH = $('.rightContent .header').height();
	$('.rightContent .main').height(windowH - rightHeaderH - 24);
	RightHeaderClick();
});

//右边头部email和user
function RightHeaderClick() {
	$('.mail').click(function() {
		$(this).find('div').css({
			display: 'block'
		});
	}).mouseout(function() {
		$(this).find('div').css({
			display: 'none'
		});
	});
	$('.mail div').mouseover(function() {
		$(this).css({
			display: 'block'
		});
	}).mouseout(function() {
		$(this).css({
			display: 'none'
		});
	});

	$('.user').click(function() {
		$(this).find('.xiala').find('img').attr('src', 'img/shangla.png');
		$(this).find('.detail').css({
			display: 'block'
		});
	}).mouseout(function() {
		$(this).find('.xiala').find('img').attr('src', 'img/xiala.png');
		$(this).find('.detail').css({
			display: 'none'
		});
	});
	$('.user .detail').mouseover(function() {
		$(this).siblings('.xiala').find('img').attr('src', 'img/shangla.png');
		$(this).css({
			display: 'block'
		});
	}).mouseout(function() {
		$(this).siblings('.xiala').find('img').attr('src', 'img/xiala.png');
		$(this).css({
			display: 'none'
		});
	});
}