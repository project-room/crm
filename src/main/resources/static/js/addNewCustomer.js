$(function() {
	var windowH = $(document).height();
	var rightHeaderH = $('.rightContent .header').height();
	$('.rightContent .main > div').css({
		'min-height': windowH - rightHeaderH - 24 -65
	});
	$('.rightContent .main > div').width($('.rightContent .main').width() - 60);

	$('.save').click(function() {
		var companyName = $('#companyName').val();
		var contactName = $('#contactName').val();
		var mobilephone = $('#mobilephone').val();
		var telephone = $('#telephone').val();
		var mail = $('#mail').val();
		var province = $('#province').val();
		console.log(companyName, contactName, mobilephone, telephone, mail, province);
		//location.href = 'seas.html';
	});
	$('.addNew .cancel').click(function(){
		location.href = 'seas.html';
	})

    // //通过用户名换取用户id
    // var userNameChange=$("#userNameRevertUserId").text();
    // $.ajax({
    //     url: "/crm/sysUser/userNameRevertUserId",
    //     data:{"userName":userNameChange},
    //     type: "POST",
    //     success: function (data) {
    //         $("#forUserId").val(data.toString());
    //     }, fail: function (data) {
    //     }
    // });
    //获取用户id
    $.ajax({
        url: "/crm/sysUser/loadUserId",
        type: "POST",
        success: function (data) {
            $("#forUserId").val(data.toString());
        }, fail: function (data) {
        }
    });

    
    //保存客户
	$("#save").click(function () {
		$("#saveForm").submit();
    });
	//取消保存客户
	$("#cancel").click(function () {
		location.href="/crm/cstCustomer/getPage/1/7";
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
});


// 编辑客户信息
$(function() {
	$('.editMsg').click(function() {
		// for (var i = 0; i < $('form label').length; i++) {

		// }
		$('input').attr('disabled',false);
		$('input[type=button]').addClass('di_block').removeClass('dnone');
		$('.main .editMsgForm label').css({
			'border-bottom': '1px solid #eee'
		});
	});
	$('.editMsgForm').find('.save').click(function() {
		$('.editMsgForm').find('input').attr('disabled',true);
		$('input[type=button]').addClass('dnone').removeClass('di_block');
		$('.main .editMsgForm label').css({
			'border-bottom': 'none'
		});
	});
	$('.editMsgForm').find('.cancel').click(function() {
		$('.editMsgForm').find('input').attr('disabled',true);
		$('input[type=button]').addClass('dnone').removeClass('di_block');
		$('.main .editMsgForm label').css({
			'border-bottom': 'none'
		});
	});
})