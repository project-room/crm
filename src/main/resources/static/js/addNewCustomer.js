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
	$('.cancel').click(function(){
		location.href = 'seas.html';
	}) 
});


// 编辑客户信息
$(function() {
	$('.editMsg').click(function() {
		// for (var i = 0; i < $('form label').length; i++) {

		// }
		$('input').attr('disabled',false)
		$('input[type=button]').addClass('di_block').removeClass('dnone');
	});
	$('.editMsgForm').find('.save').click(function() {
		$('.editMsgForm').find('input').attr('disabled',true);
		$('input[type=button]').addClass('dnone').removeClass('di_block');
	});
	$('.editMsgForm').find('.cancel').click(function() {
		$('.editMsgForm').find('input').attr('disabled',true);
		$('input[type=button]').addClass('dnone').removeClass('di_block');
	});
})