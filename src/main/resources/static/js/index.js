$(function() {
	var windowH = $(document).height();
	var windowW = $(window).width();
	console.log(windowH);
	$('.leftContent').height(windowH);
	var rightHeaderH = $('.rightContent .header').height();
	$('.rightContent .main').height(windowH - rightHeaderH - 24);
	$('.rightContent .main > div').height((windowH - rightHeaderH - 24 - 60) );
	$('.dynamicContent').height($('.dynamic').height() - $('.dynamic .dynamicHeader').height());
	$('.dailyContent').height($('.daily').height() - $('.daily .dailyHeader').height());
	

	scroll($('.dynamicContent'));
	scroll($('.dailyContent'));
	RightHeaderClick();
	myDaily.dailyDel();
	myDaily.checkboxClick();
	myDaily.checkboxColor();
	myDaily.dailyNum();
	$('.dailyContent').find('input[type=checkbox]').click(function(){
		myDaily.dailyNum();
	});
	// $('body').on('click', $('.dailyContent').find('input[type=checkbox]'), function(event) {
	// 	event.stopPropagation();
	// 	dailyNum();
	// })
});

function scroll(ele) {
	ele.niceScroll({
		cursorcolor: '#ccc'
	});
}

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
  }).mouseout(function(){
	 $(this).css({
			display: 'none'
		});
  });

  $('.user').click(function() {
	 $(this).find('.xiala').find('img').attr('src','img/shangla.png');
	 $(this).find('.detail').css({
			display: 'block'
	 });
  }).mouseout(function() {
	 $(this).find('.xiala').find('img').attr('src','img/xiala.png');
	 $(this).find('.detail').css({
			display: 'none'
		});
  });
  $('.user .detail').mouseover(function() {
	 $(this).siblings('.xiala').find('img').attr('src','img/shangla.png');
	 $(this).css({
			display: 'block'
	 });
  }).mouseout(function(){
	 $(this).siblings('.xiala').find('img').attr('src','img/xiala.png');
	 $(this).css({
			display: 'none'
		});
  });
}

//daily部分
var myDaily = {
	
	//今日事务数量
	dailyNum: function() {
		var restNum = 0;
		var maxNum = $('.dailyContent').find('li').length;
		for (var i = 0; i < maxNum; i++) {
			if ($('.dailyContent').find('li').eq(i).find('input[type=checkbox]').prop('checked') == false) {
				restNum++;
			}
		}
		$('.dailyHeader').find('span').text('(' + restNum + '/' + maxNum + ')');
	},

	//改变checkbox的边框颜色
	checkboxColor: function() {
		var dailyTime = $('.daily').find('.createTime');
		for (var i = 0; i < dailyTime.length; i++) {
			if (dailyTime.eq(i).hasClass('dblock')) {
				dailyTime.eq(i).parents('li').find('label').addClass('borderRed');
			} else {
				dailyTime.eq(i).parents('li').find('label').removeClass('borderRed');
			}
		}
	},

	//选中和非选中的状态
	checkboxClick: function() {
		$('.daily input[type=checkbox]').click(function() {
			if ($(this).prop('checked') === true) {
				//需要ajax
				$(this).parent().css({
					'border-color': '#7460ee',
					'box-shadow': 'none',
					background: 'url(img/checkedPurple.png) center no-repeat'
				});
				$(this).parent().siblings('div').find('p').css({
					'text-decoration': 'line-through'
				});
				$(this).parent().siblings('div').find('.createTime').addClass('dnone').removeClass('dblock');
			} else {
				//需要ajax
				$(this).parent().css({
					'border-color': '#ccc',
					'box-shadow': 'inset 0 0 4px #ccc',
					background: 'none'
				});
				$(this).parent().siblings('div').find('p').css({
					'text-decoration': 'none'
				});
			}
		});
	},

	//删除
	dailyDel: function() {
		$('.operate .del').click(function() {
			$(this).parents('li').remove();
		});
	},

	//编辑
	edit: function() {
		$('.operate .edit').click(function() {
			
		});
	}
};



