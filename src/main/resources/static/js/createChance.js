$(function() {
	// $('.main > .baseInfo').width($('.main').width()-60);
	$('.baseInfo div:nth-child(2)').width($('.baseInfo').width() - 321);
	$('.main').height($(window).height() - 60);
	$('.leftContent').height($(window).height());
	$('.main').niceScroll({
		cursorcolor: '#ccc'
	});
})

window.onload = function() {
	var fileInput = document.getElementById('customerLogo');
	var previewImg = document.getElementById('showLogo');
	fileInput.addEventListener('change', function() {
		var file = this.files[0];
		var reader = new FileReader();
		reader.addEventListener('load', function() {
			previewImg.src = reader.result;
		}, false);

		reader.readAsDataURL(file);
	}, false);

	$('.baseInfo select').change(function() {
	    var userId = $(this).val();
	   /* $.ajax({
	        type: 'post',
	        data: {'custId': userId},
	        url: '/cstChance/getCstCustomerCustId',
	        dataType: 'json',
	        success: function(data) {
                console.log(data);
	        },
	        error: function(e) {
	            console.log(e);
	        }
	    })*/
	    $.post("/cstChance/getCstCustomerCustId", {custId: userId}, function(data) {
	        var data = JSON.parse(data);
	        $('.majorId').val(data.linkmanList[0].linkId);
	        $('.majorName').val(data.linkmanList[0].linkName);
	        $('.majorPhone').val(data.linkmanList[0].linkPhone);
	        $('.majorTel').val(data.linkmanList[0].linkLandlinePhone);
	        $('.majorQQ').val(data.linkmanList[0].linkQq);
	        $('.majorMail').val(data.linkmanList[0].linkEmail);
	        $('.majorWechat').val(data.linkmanList[0].linkWechat);
	    })
	})
};