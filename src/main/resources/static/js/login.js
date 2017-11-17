$(function() {
	var account = localStorage.getItem('userName');
	var accountPsd = localStorage.getItem('userpsd');
	//
	if(account!=null&&accountPsd!=null){
		location.href="/crm/sysUser/userLogin?username="+account+"&&password="+accountPsd;
	}
	// $.post('/crm/sysUser/userLogin',{username:account,password:accountPsd},function() {
	// 	console.log(1)
	// });

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
        var userName = $('#loginForm').find('input[name=username]').val();
        var userpsd = $('#loginForm').find('input[name=password]').val();
        $.ajax({
			url:"/crm/sysUser/getSysUserByUserName",
			type:"POST",
			data:{"userName":userName},
			success:function (data) {

				var data = JSON.parse(data);
				console.log(data.userPassword)
				if (data.userPassword == userpsd) {
                    if ($('.forCheckbox').find('input').prop('checked') == true) {
                        localStorage.setItem('userName', userName);
                        localStorage.setItem('userpsd', userpsd);
                    }

				}
            },fail:function (e) {
                console.log(e)
				alert(e)
			}
		});
        $("#loginForm").submit();
    });

	//获取短信验证码
	$("#sendCaptcha").click(function () {
	var phone=$("input[name='phone']").val();
	if(phone==null||phone==""){
        location.href="/crm/cstCustomer/toFindPsd";
	}else{
        location.href="/crm/sysUser/sendSmsCaptcha/"+phone;
	}
    });
	//提交短信验证码
    $("#commitCaptcha").click(function () {
	  var phone=	$("input[name='phone']").val();
      var captCha=	$("input[name='captCha']").val();
      if(phone==""||phone==null||captCha==""||captCha==null){
          location.href="/crm/cstCustomer/toFindPsd";
	  }else{
          location.href="/crm/sysUser/findByPhoneAndCaptCha/"+phone+"/"+captCha;
	  }

    });
	//新密码
	$("#newPsdCommit").click(function () {
	 var newPsd=$("input[name='newPsd']").val();
	 var againNewPsd=$("input[name='againNewPsd']").val();
	 if(newPsd==""||newPsd==null||againNewPsd==null||againNewPsd==""){
	 	location.href="/crm/cstCustomer/toNewPsd";
	 }else{
         location.href="/crm/sysUser/createNewPassword/"+newPsd;
	 }

    });


	// //下次自动登录
	// var userName=$("type[name='userName']").val();
	// if(userName==null){
	// 	// location.href="/crm/cstCustomer/toLogin";
	// }else{
     //    $.ajax({
     //        url:"/crm/sysUser/remenberLogin",
     //        data:{"userName":userName},
     //        type: "POST",
     //        success: function (data) {
     //            if(data==true){
     //                alert("data.result:"+data.result);
     //                location.href="/crm/cstCustomer/toIndex"
     //            }else{
     //                location.href="/crm/cstCustomer/toLogin"
     //            }
    //
     //        }, fail: function (data) {
     //        }
     //    });
	// }
});
