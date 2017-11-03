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

	$('body').click(function() {
		$('.detail').css({
			display: 'none'
		});
		$('.rightContent .header .mail div').css({
			display: 'none'
		});
	});

	$('tbody').on('click', '.forCheckbox input', function(event) {
		event.stopPropagation();
		// alert(0);
		if ($(this).prop('checked') == true){
			$(this).parents('label').addClass('borderPurple');
		} else {
			$(this).parents('label').removeClass('borderPurple');
		}
	})

    $('body').on('click', '.forCheckbox input', function(event) {
        event.stopPropagation();
        // alert(0);
        if ($(this).prop('checked') == true){
            $(this).parents('label').addClass('borderPurple');
        } else {
            $(this).parents('label').removeClass('borderPurple');
        }
    })
	

	// $('.forCheckbox input').click(function() {
		
	// 	if ($(this).prop('checked') == true){
	// 		alert(1)
	// 		$(this).parents('label').css({
	// 			background: 'url("img/checked.png") no-repeat center',
	// 		});
	// 	} else {
	// 		alert(2)
	// 		$(this).parents('label').css({
	// 			background: 'url("img/checked.png") no-repeat center',
	// 		});
	// 	}
		
	// })
}




function fenye() {
    $('body').on('click', '.page-pre', function() {
        if ($('.page-number.active').find('a').text() == 2) {
            $('.page-number').eq(0).trigger('click');
        } else if($('.page-number.active').find('a').text() == $('.page-number').eq($('.page-number').length - 1).find('a').text()) {
            $('.page-number').eq($('.page-number').length - 2).trigger('click');
        } else {
            $('.page-number.active').prev().trigger('click');
        }
    });
    $('body').on('click', '.page-next', function() {
        if ($('.page-number.active').find('a').text() == 1) {
            $('.page-number').eq(1).trigger('click');
        } else if($('.page-number.active').find('a').text() == $('.page-number').eq($('.page-number').length - 1).find('a').text() - 1) {
            $('.page-number').eq($('.page-number').length - 1).trigger('click');
        } else {
            $('.page-number.active').next().trigger('click');
        }
    });
    $('body').on('click', '.page-first', function() {
        $('.page-number').eq(0).trigger('click');
    });
    $('.page-last').click(function() {
        $('.page-number').eq($('.page-number').length - 1).trigger('click');
    });
    $('body').on('click', '.page-number', function(event) {
        // $(this).addClass('active').siblings('.page-number').removeClass('active');
        forFenye();
    });
    forFenye();
    
}

function forFenye() {
    var yema = location.href.split('/');
    for (var i = 0; i < $('.page-number').length; i++) {
        if ($('.page-number').eq(i).find('a').text() == yema[yema.length - 2]) {
            $('.page-number').eq(i).addClass('active');
        }
    }

    $('.page-number.active').siblings('.page-number').addClass('dnone');
    $('.page-number.active').prev('.page-number').removeClass('dnone');
    $('.page-number.active').prev('.page-number').prev('.page-number').removeClass('dnone');
    $('.page-number.active').next('.page-number').removeClass('dnone');
    $('.page-number.active').next('.page-number').next('.page-number').removeClass('dnone');
    $('.page-number').eq(0).removeClass('dnone');
    $('.page-number').eq($('.page-number').length - 1).removeClass('dnone');
    if ($('.page-number.active').find('a').text() <= 4) {
        if ($('.page-last').eq(0).find('a').text() <= 5) {
            $('.page-separator').remove();
        } else {
            $('.page-separator').remove();
            $('.page-number').eq($('.page-number').length - 1).before('<li class="page-separator disabled"><a href="#">...</a></li>');
        }  
    } else if ($('.page-number.active').find('a').text() > 4 && $('.page-number.active').find('a').text() < $('.page-number').eq($('.page-number').length - 1).find('a').text() - 3) {
        $('.page-separator').remove();
        $('.page-number').eq($('.page-number').length - 1).before('<li class="page-separator disabled"><a href="#">...</a></li>');
        $('.page-number').eq(0).after('<li class="page-separator disabled"><a href="#">...</a></li>');
    } else if ($('.page-number.active').find('a').text() >= $('.page-number').eq($('.page-number').length - 1).find('a').text() - 3) {
        if ($('.page-last').eq(0).find('a').text() <= 5) {
            $('.page-separator').remove();
        } else {
            $('.page-separator').remove();
            $('.page-number').eq(0).after('<li class="page-separator disabled"><a href="#">...</a></li>');
        }
    } 
    if ($('.page-number.active').find('a').text() == 1) {
        $('.page-number').eq(1).removeClass('dnone');
        $('.page-number').eq(2).removeClass('dnone');
        if ($('.page-last').eq(0).find('a').text() <= 5) {
            $('.page-number').eq(3).removeClass('dnone');
        }
        $('.page-pre').addClass('disabled');
    } else {
        $('.page-pre').removeClass('disabled');
    }
    if ($('.page-number.active').find('a').text() == $('.page-number').eq($('.page-number').length - 1).find('a').text()) {
        $('.page-number').eq($('.page-number').length - 2).removeClass('dnone');
        $('.page-number').eq($('.page-number').length - 3).removeClass('dnone');
        if ($('.page-last').eq(0).find('a').text() <= 5) {
            $('.page-number').eq($('.page-number').length - 4).removeClass('dnone');
        }
        $('.page-next').addClass('disabled');
    } else {
        $('.page-next').removeClass('disabled');
    }
}