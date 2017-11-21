$(function() {
	$('.main').height($(window).height() - 60);
	$('.main').niceScroll({
        cursorcolor: '#ccc'
    });
    $('.content').css({
    	'min-height': $(window).height() - 130 + 'px',
    	'margin-bottom': '25px'
    });

	$('form input').width($('form label').width() - 150);
	$('form select').width($('form label').width() - 150);

	$('tbody').on('click', '.modify', function() {
		if ($(this).siblings('ul').hasClass('dnone')) {
			$(this).siblings('ul').removeClass('dnone');
		} else {
			$(this).siblings('ul').addClass('dnone')
		}
	})

	

	$('tbody').on('click', '.delete', function() {
		var $this = $(this);
		var dblChoseAlert = simpleAlert({
            "content":"确定删除此字段？",
            "buttons":{
                "确定":function () {
                    $this.parents('tr').remove();
                    dblChoseAlert.close();
                },
                "取消":function () {
                    dblChoseAlert.close();
                }
            }
        });
	});

	$('.stopAccount').click(function() {
		var ChoseAlert = simpleAlert({
            "content":"确定停用此账号",
            "buttons":{
                "确定":function () {
                    var userIdStr="";
                    $('tbody').find('tr').each(function() {
                    	if ($(this).find('input[type=checkbox]').prop('checked') == true) {
							//获取批量用户id
							var userId = $(this).find('input[type=hidden]').val().toString();
                            userIdStr = userIdStr + "-" + userId;
                            $(this).remove();
                        }
                    });
                    ChoseAlert.close();

                   //把用户状态改为停用
                    location.href="/crm/sysUser/stopSysUserStatus/"+userIdStr;
                },
                "取消":function () {
                    ChoseAlert.close();
                }
            }
        });
	});

    //跳转到页面
    $('body').on('change', '.dumppage', function() {
        var val = $(this).val();
        window.location.pathname = '/crm/sysUser/getSysUserList/' + val + '/10';

    });

	
	$('.cus').click(function() {
		if ($(this).find('ul').hasClass('dnone')) {
			$(this).find('ul').removeClass('dnone')
		} else {
			$(this).find('ul').addClass('dnone')
		}
	});

	$('.allOperate label').click(function(event) {
		// event.stopPropagation();
		// event.preventDefault()
		if ($(this).find('input').prop('checked')) {
			$('table input').prop('checked', 'checked');
			$('table label').addClass('borderPurple');
		} else {
			$('table input').prop('checked', false);
			$('table label').removeClass('borderPurple');
		}
	});

	$('tbody').on('click', '.forCheckbox', function(event) {
		event.stopPropagation();
		setTimeout(xxx,10);
		 var test=$(this).parents('tr').find('input[type=hidden]').val();
	})
	org();
	fenye();
});
function xxx(){
    var userIdStr="";
	var num = 0;
	var maxNum = $('tbody').find('tr').length;
	for (var i = 0; i < maxNum; i++) {
        if ($('tbody tr').eq(i).find('input[type=checkbox]').prop('checked') == true) {
            num++;
			//获取批量用户id
            var userId= $('tbody tr').eq(i).find('input[type=hidden]').val().toString();
           userIdStr=userIdStr+"-"+userId;
        }
    }
    $(".editSysUserInfo").click(function () {
        location.href="/crm/sysUser/getSysUserInfoById/"+userIdStr;
    });


	if (num == 0) {
		$('.allOperate').addClass('dnone');
	} else {
        $('.allOperate').removeClass('dnone');
	}

	if (num > 1) {
        $('.allOperate a').eq(0).addClass('dnone');
    } else {
        $('.allOperate a').eq(0).removeClass('dnone');
    }

	if (num == maxNum) {
		$('.allOperate label').addClass('borderPurple');
		$('.allOperate label').find('input').prop('checked', true);
	} else {
		$('.allOperate label').removeClass('borderPurple');
		$('.allOperate label').find('input').prop('checked', false);
	}
}

function org() {
	$('body').on('click', 'h3 .delete', function() {
		var bumenName = $('h3 .bumenName').text();
		var $this = $(this);
		var dblChoseAlert = simpleAlert({
            "content":"确定删除" + bumenName + "?<br />删除后部门组织架构会清空",
            "buttons":{
                "确定":function () {
                	 $('.organize .content').html('')
                    $('.organize .content').html('<div class="addNewOrg"><img src="img/wait2.png"/><p>您的组织架构为空，<span>立即添加</span></p></div>')
                    dblChoseAlert.close();
                },
                "取消":function () {
                    dblChoseAlert.close();
                }
            }
        });
	});
	$('.jingli p').click(function() {
		$(this).siblings('ul').slideToggle();
		if($(this).find('span').text() == '-') {
			$(this).find('span').text('+');
		} else {
			$(this).find('span').text('-');
		}
	});

	$('.org').click(function() {
		if ($(this).find('.bumen').hasClass('dnone')) {
			$(this).find('.bumen').removeClass('dnone')
		} else {
			$(this).find('.bumen').addClass('dnone');
		}
		
	});
	$('.operate_O').click(function() {
		if ($(this).siblings('.ceng1').hasClass('dnone')) {
			$(this).siblings('.ceng1').removeClass('dnone');
		} else {
			$(this).siblings('.ceng1').addClass('dnone');
		}
	});

	$('.addBumen').click(function() {
		$('.addBumenPop').removeClass('dnone');
	});

	$('body').on('click', '.addNewOrg span', function() {
		$('.addBumenPop').removeClass('dnone');
	})

	$('.addXiaji').click(function() {
		$('.xiajiPop').removeClass('dnone');
	});

	$('.rename').click(function() {
		var name = $('h3 .bumenName').text();
		$('.reNamePop label input').val(name);
		$('.reNamePop').removeClass('dnone');
	});

	$('.cancel').click(function() {
		$('.Pop').addClass('dnone');
	});

	$('.shelter').click(function() {
		$('.Pop').addClass('dnone');
	});

	$('.sure').click(function() {
		if ($('from label input').val() != undefined) {
			setTimeout(window.location.reload(),100)
		}
	});

	//添加员工时获取角色
	$('.EmployeeMsg #addEmployee').click(function() {
		var userName= $("input[name='userName']").val();
		var userAccounts= $("input[name='userAccounts']").val();
		var userPassword=$("input[name='userPassword']").val();
		var userPhone=$("input[name='userPhone']").val();
		var userDepartment= $("input[name='userDepartment']").val();
		var userPosition=$("input[name='userPosition']").val();
		//1-管理员，2-销售经理，3-销售员
		var roleName= $('.juese').val();
		$.ajax({
			url:"/crm/sysUser/addSysUser",
			data:{"userName":userName,"userAccounts":userAccounts,"userPassword":userPassword,"userPhone":userPhone,"userDepartment":userDepartment,"userPosition":userPosition,"roleName":roleName},
			type:"POST",
			success:function (data) {
				location.href="/crm/sysUser/getSysUserList/1/10";

            },fail:function (data) {

            }
		});
	});
	//取消添加员工
    $('.EmployeeMsg .cancel').click(function () {
    	location.href="/crm/sysUser/getSysUserList/1/10";
    });


	//加载员工列表
	$.ajax({
		url:"/crm/sysUser/getSysUserList",
		type:"POST",
		success:function (data) {

        },fail:function (data) {

        }
	});

	//搜所用户名
    $("#searchUserNameOrAccount").click(function () {
	      var  userNameOrAccount=$("input[name='userNameOrAccount']").val();
	      location.href="/crm/sysUser/searchUserNameOrAccount/"+userNameOrAccount+"/1/10"
    });

    //单击单条记录获取该条记录的信息
    $('tbody').on('click', 'tr', function() {
        var userId= $(this).children("input[type=hidden]").val().toString();
        location.href="/crm/sysUser/getSysUserInfoById/"+userId;
    });

    //编辑用户
    $('.EmployeeMsg #editEmployee').click(function() {
        var userName= $("input[name='userName']").val();
        var userAccounts= $("input[name='userAccounts']").val();
        var userPassword=$("input[name='userPassword']").val();
        var userPhone=$("input[name='userPhone']").val();
        var userDepartment= $("input[name='userDepartment']").val();
        var userPosition=$("input[name='userPosition']").val();
        // var userStatus=$("input[name='userStatus']").val();
        var userStatus=$(".opcontroller option:selected").val();
        var userId=$("input[name='userId']").val();
        // //1-管理员，2-销售经理，3-销售员
        var roleId= $('.juese').val();
        $.ajax({
            url:"/crm/sysUser/editSysUserInfo",
            data:{"userName":userName,"userAccounts":userAccounts,"userPassword":userPassword,"userPhone":userPhone,"userDepartment":userDepartment,"userPosition":userPosition,"roleId":roleId,"userStatus":userStatus,"userId":userId},
            type:"POST",
            success:function (data) {
                location.href="/crm/sysUser/getSysUserList/1/10";
            },fail:function (data) {

            }
        });
    });

    //如果没有登录调到登录页面
    $.ajax({
        url:"/crm/sysUser/loadUserId",
        type:"POST",
        success:function (data) {
            var userId=data.toString();
            if(userId=='null'){
                location.href="/crm/cstCustomer/toLogin";
            }
        },fail:function (data) {

        }
    });

}