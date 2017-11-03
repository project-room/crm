$(function() {
	var windowH = $(window).height();
	var windowW = $(window).width();
	var imgH;
	$('img').load(function() {
		imgH = $(this).height();
		$('.logMsg').height(imgH);
		$('.content').css({'margin-top':(windowH-imgH) / 2 + 'px'});
	});
	
	//登录
	$("#loginButton").click(function () {
		$("#loginForm").submit();
    });

	//下次自动登录
	var userName=$("type[name='userName']").val();
	if(userName==null){
		location.href="/crm/cstCustomer/toLogin";
	}else{
        $.ajax({
            url:"/crm/sysUser/remenberLogin",
            data:{"userName":userName},
            type: "POST",
            success: function (data) {
                if(data==true){
                    alert("data.result:"+data.result);
                    location.href="/crm/cstCustomer/toIndex"
                }else{
                    location.href="/crm/cstCustomer/toLogin"
                }

            }, fail: function (data) {
            }
        });
	}

});
