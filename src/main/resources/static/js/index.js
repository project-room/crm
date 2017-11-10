$(function() {
	var windowH = $(document).height();
	var windowW = $(window).width();
	$('.leftContent').height(windowH);
	var rightHeaderH = $('.rightContent .header').height();
	$('.rightContent .main').css({
		'min-height': windowH - rightHeaderH - 24
	});
	$('.rightContent .main > div').css({
		'min-height': windowH - rightHeaderH - 24 -60
	});
	$('.dynamicContent').height($('.dynamic').height() - $('.dynamic .dynamicHeader').height());
	$('.dailyContent').height($('.daily').height() - $('.daily .dailyHeader').height());
	$('.dynamicHeader').find('li').click(function() {
		$(this).addClass('active').siblings().removeClass('active');
		//需要ajax
	});

	scroll($('.dynamicContent'));
	scroll($('.dailyContent'));
	myDaily.dailyDel();
	myDaily.checkboxClick();
	myDaily.checkboxColor();
	myDaily.dailyNum();
	myDaily.edit();
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



//daily部分
var myDaily = {
	tip:null,
	
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
			if($(this).prop('checked') == true) {
				$(this).parents('label').addClass('borderPurple').siblings('div').find('input').css({
				'text-decoration': 'line-through'
			});
			} else {
				$(this).parents('label').removeClass('borderPurple').siblings('div').find('input').css({
				'text-decoration': 'none'
			});
			}
		});
	},

	//删除
	dailyDel: function() {
		$('.operate .del').click(function() {
			var $this = $(this);
        var dblChoseAlert = simpleAlert({
            "content":"确定删除？",
            "buttons":{
                "确定":function () {
                    $this.parents('li').remove();
                    dblChoseAlert.close();
                },
                "取消":function () {
                    dblChoseAlert.close();
                }
            }
        });
		});
	},

	//编辑
	edit: function() {
		$('.operate .edit').click(function() {
			$('form').find('input').attr('disabled', true).removeClass('active');
			$('form').find('button').css('display','none');
			$(this).parents('li').find('form').find('input').attr('disabled', false).addClass('active');
			$(this).parents('li').find('form').find('button').css('display','inline-block')
			tip = $(this).parents('li').find('form').find('input').val();
		});
		$('.sure').click(function() {
			tip = $(this).siblings('input').val();
			$(this).parents('li').find('form').find('input').attr('disabled', true).removeClass('active');
			$(this).parents('li').find('form').find('button').css('display','none')
		});
		$('.cancel').click(function() {
			$(this).siblings('input').val(tip);
			$(this).parents('li').find('form').find('input').attr('disabled', true).removeClass('active');
			$(this).parents('li').find('form').find('button').css('display','none')
		});
	},

};



