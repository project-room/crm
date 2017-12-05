$(function() {
	var windowH = $(document).height();
	var rightHeaderH = $('.rightContent .header').height();
	$('.rightContent .main > div').css({
		'min-height': windowH - rightHeaderH - 24 -65
	});
	$('.rightContent .main > div').width($('.rightContent .main').width() - 60);

	var customereMsg = {};


	$('.editMsg').click(function() {
		customereMsg.companyName = $('#companyName').val();
		customereMsg.contactName = $('#contactName').val();
		customereMsg.mobilephone = $('#mobilephone').val();
		customereMsg.telephone = $('#telephone').val();
		customereMsg.mail = $('#mail').val();
		customereMsg.province = $('#province').val();

		$('#companyName').attr('disabled', false);
		$('#contactName').attr('disabled', false);
		$('#mobilephone').attr('disabled', false);
		$('#telephone').attr('disabled', false);
		$('#mail').attr('disabled', false);
		$('#province').attr('disabled', false);

		$('input[type=button]').addClass('di_block').removeClass('dnone');
		$('.main .editMsgForm label').css({
			'border-bottom': '1px solid #eee'
		});
	});
	$('.editMsgForm').find('.save').click(function() {

		customereMsg.companyName = $('#companyName').val();
		customereMsg.contactName = $('#contactName').val();
		customereMsg.mobilephone = $('#mobilephone').val();
		customereMsg.telephone = $('#telephone').val();
		customereMsg.mail = $('#mail').val();
		customereMsg.province = $('#province').val();

		$('.editMsgForm').find('input').attr('disabled',true);
		$('input[type=button]').addClass('dnone').removeClass('di_block');
		$('.main .editMsgForm label').css({
			'border-bottom': 'none'
		});
	});
	$('.editMsgForm').find('.cancel').click(function() {
		$('#companyName').val(customereMsg.companyName);
		$('#contactName').val(customereMsg.contactName);	
		$('#mobilephone').val(customereMsg.mobilephone);
		$('#telephone').val(customereMsg.telephone);
		$('#mail').val(customereMsg.mail);
		$('#province').val(customereMsg.province);

		$('.editMsgForm').find('input').attr('disabled',true);
		$('input[type=button]').addClass('dnone').removeClass('di_block');
		$('.main .editMsgForm label').css({
			'border-bottom': 'none'
		});
		console.log(customereMsg)
	});
	$("#saveEditCustomer").click(function () {
        $("#editMsgForm").submit();
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
})