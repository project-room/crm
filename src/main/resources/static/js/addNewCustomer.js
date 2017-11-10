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
});


