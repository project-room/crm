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
		event.stopPropagation();
		$(this).find('div').css({
			display: 'block'
		});
	})

	$('.user').click(function() {
		event.stopPropagation();
		$(this).find('.xiala').find('img').attr('src', 'img/shangla.png');
		$(this).find('.detail').css({
			display: 'block'
		});
	})

	$('body').click(function(event) {
		event.stopPropagation();
		$('.detail').css({
			display: 'none'
		});
		$('.rightContent .header .mail div').css({
			display: 'none'
		});
	});
}