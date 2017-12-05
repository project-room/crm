$(function() {
	var windowH = $(document).height();
	var windowW = $(window).width();
	$('.leftContent').height(windowH);
	var rightHeaderH = $('.rightContent .header').height();
	$('.rightContent .main').height(windowH - rightHeaderH - 24);
	RightHeaderClick();


	$('.modify').hover(function() {
	    $(this).find('img').attr('src', '/crm/img/more2.png')
    },function() {
        $(this).find('img').attr('src', '/crm/img/more3.png')
    });



    //根据客户名来模糊搜所客户信息
    // $(".search").click(function () {
    //     var custCompany=$(".searchName").val();
    //     location.href="/crm/cstCustomer/selectCstCustomerByName/"+custCompany+"/1/7"
    // });


	//session
    // // 设置值
    // sessionStorage.setItem('key_a', 1);
    // 取值
    var roleNameSession = sessionStorage.getItem('roleNameSession');
    //这样速度太慢
    // if(roleNameSession!="管理员"){
    //   $(".settitemdisplay").css("display", "none");
    // }




    //隐藏设置项和系统设置
    $.ajax({
        url:"/crm/sysUser/getSession",
        type:"POST",
        success: function (data) {
            //把角色名注入到sessionStorage中
            sessionStorage.setItem('roleNameSession', data);
            if(data!="管理员"){
                //设置模块
                $(".settitemdisplay").css("display", "none");
                //用户系统设置
                $(".systemSetting") .css("display","none");
                if(data!="销售经理")
                $('.showHideDeling').css("display","none");
            }
        },fail:function () {

        }
    });

    if(roleNameSession!="销售员"){
        $(".seas .tag").text("公海池");
    }



    //系统设置
    $(".systemSetting").click(function () {
        location.href="/crm/sysUser/getSysUserList/1/10";
    });
    
    //退出登录 
    $(".loginOut").click(function () {
        location.href="/crm/sysUser/loginOut";
        //删除sessionStorage的值
        sessionStorage.removeItem("roleNameSession");
        localStorage.removeItem('userName');
        localStorage.removeItem('userpsd');
    });

    //加载用户名
    $.ajax({
        url:"/crm/sysUser/loadUserName",
        type:"POST",
        success:function (data) {
           var userName=data.toString();
           $(".userName").text(userName);
        },fail:function (data) {

        }
    });

    //个人资料
    $(".personData").click(function () {
        location.href="/crm/sysUser/lookPersonInfo";
    });


});

//右边头部email和user
function RightHeaderClick() {
	$('.mail').click(function(event) {
		event.stopPropagation();
		$(this).find('div').css({
			display: 'block'
		});
	})

	$('.user').click(function(event) {
		event.stopPropagation();
		$(this).find('.xiala').find('img').attr('src', '/crm/img/shangla.png');
		$(this).find('.detail').css({
			display: 'block'
		});
	})

	$('body').dblclick(function(e) {
		$('.detail').css({
			display: 'none'
		});
		$('.rightContent .header .mail div').css({
			display: 'none'
		});
        $('.add_list_a').css({
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
        $(this).addClass('active').siblings('.page-number').removeClass('active');
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
        if ($('.dumppage option').eq(i).text() == yema[yema.length - 2]) {
            $('.dumppage option').eq(i).attr('selected',true);
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
        console.log($('.page-number').length)
        if ($('.page-number').length <= 5) {
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
        if ($('.page-number').length <= 5) {
            $('.page-separator').remove();
        } else {
            $('.page-separator').remove();
            $('.page-number').eq(0).after('<li class="page-separator disabled"><a href="#">...</a></li>');
        }
    } 
    if ($('.page-number.active').find('a').text() == 1) {
        $('.page-first').addClass('disabled');
        $('.page-number').eq(1).removeClass('dnone');
        $('.page-number').eq(2).removeClass('dnone');
        if ($('.page-number').length <= 5) {
            $('.page-separator').remove();
            $('.page-number').eq(3).removeClass('dnone');
        }
        $('.page-pre').addClass('disabled');
    } else {
        $('.page-pre').removeClass('disabled');
        $('.page-first').removeClass('disabled');

    }
    if ($('.page-number.active').find('a').text() == $('.page-number').eq($('.page-number').length - 1).find('a').text()) {
        $('.page-last').addClass('disabled');
        $('.page-number').eq($('.page-number').length - 2).removeClass('dnone');
        $('.page-number').eq($('.page-number').length - 3).removeClass('dnone');
        if ($('.page-number').length <= 5) {
            $('.page-separator').remove();
            $('.page-number').eq($('.page-number').length - 4).removeClass('dnone');
        }
        $('.page-next').addClass('disabled');
    } else {
        $('.page-last').removeClass('disabled');
        $('.page-next').removeClass('disabled');
    }
    
   //表单筛选
    var mobile = $('#mobile'), 
        mobileReg = /^1([358][0-9][0-9]{8})|([4][7][0-9]{8})|([7][0781][0-9]{8})$/,
        telphone = $('#telphone'), 
        telphoneReg = /^0[0-9]{2,3}[-][0-9]{7,8}$/,
        email = $("#mail"), 
        emailReg = /^[0-9a-zA-Z_.-]+[@][0-9a-zA-Z_-]+([.][a-zA-Z]+){1,2}$/;
    function checkTxt(element,reg){
       $(element).blur(function(){
               if(!reg.test(element.val())){
                $(this).next().html('请输入正确的格式').css('color',"red");
            }else{
                $(this).next().html('')
            }
       })
    }

    checkTxt(mobile,mobileReg);
    checkTxt(telphone,telphoneReg);
    checkTxt(email,emailReg);
}

function fenye2() {
    $('.page-number2.active').siblings('.page-number2').addClass('dnone');
    $('.page-number2.active').prev('.page-number2').removeClass('dnone');
    $('.page-number2.active').prev('.page-number2').prev('.page-number2').removeClass('dnone');
    $('.page-number2.active').next('.page-number2').removeClass('dnone');
    $('.page-number2.active').next('.page-number2').next('.page-number2').removeClass('dnone');
    $('.page-number2').eq(0).removeClass('dnone');
    $('.page-number2').eq($('.page-number2').length - 1).removeClass('dnone');
    if ($('.page-number2.active').find('a').text() <= 4) {
        if ($('.page-number2').length <= 5) {
            $('.page-separator2').remove();
        } else {
            $('.page-separator2').remove();
            $('.page-number2').eq($('.page-number2').length - 1).before('<li class="page-separator2 disabled"><a href="#">...</a></li>');
        }  
    } else if ($('.page-number2.active').find('a').text() > 4 && $('.page-number2.active').find('a').text() < $('.page-number2').eq($('.page-number2').length - 1).find('a').text() - 3) {
        $('.page-separator2').remove();
        $('.page-number2').eq($('.page-number2').length - 1).before('<li class="page-separator2 disabled"><a href="#">...</a></li>');
        $('.page-number2').eq(0).after('<li class="page-separator2 disabled"><a href="#">...</a></li>');
    } else if ($('.page-number2.active').find('a').text() >= $('.page-number2').eq($('.page-number2').length - 1).find('a').text() - 3) {
        if ($('.page-number2').length <= 5) {
            $('.page-separator2').remove();
        } else {
            $('.page-separator2').remove();
            $('.page-number2').eq(0).after('<li class="page-separator2 disabled"><a href="#">...</a></li>');
        }
    } 
    if ($('.page-number2.active').find('a').text() == 1) {
        $('.page-number2').eq(1).removeClass('dnone');
        $('.page-number2').eq(2).removeClass('dnone');
        if ($('.page-number2').length <= 5) {
            $('.page-number2').eq(3).removeClass('dnone');
        }
    } else {
    }
    if ($('.page-number2.active').find('a').text() == $('.page-number2').eq($('.page-number2').length - 1).find('a').text()) {
        $('.page-number2').eq($('.page-number2').length - 2).removeClass('dnone');
        $('.page-number2').eq($('.page-number2').length - 3).removeClass('dnone');
        if ($('.page-number2').length <= 5) {
            $('.page-number2').eq($('.page-number2').length - 4).removeClass('dnone');
        }
    } else {
    }
}
