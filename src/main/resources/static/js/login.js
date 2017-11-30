$(function() {
	var account = localStorage.getItem('userName');
	var accountPsd = localStorage.getItem('userpsd');
	//
	if(account!=null&&accountPsd!=null){
		$.ajax({
			url:'/crm/sysUser/userLogin',
			data:{"username":account,"password":accountPsd},
			type:'POST',
			success:function (data) {
				if(data=='1'){
                    location.href="/crm/getTaskListByUserId";
				}else{
                    location.href="/crm/cstCustomer/toLogin";
				}
            }
		});
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
        $("#loginButton").click(function () {
		var username=$("input[name='username']").val();
		var password=$("input[name='password']").val();
		$.ajax({
			url:'/sysUser/userLogin',
			data:{"username":username,"password":password},
			type:'POST',
			success:function (data) {
                if(data=='1'){
                    location.href="/crm/getTaskListByUserId";
                }else{
                    location.href="/crm/cstCustomer/toLogin";
                }
            }
		});
        });
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

    // //判断用户名是不存在
    // $("input[name='username']").focus();
    // $("input[name='username']").blur(function () {
	 // var userName=$("input[name='username']").val();
	 // $.ajax({
		//  url:"/crm/sysUser/getSysUserByUserName",
		//  data:{"userName":userName},
		//  type:"POST",
		//  success:function (data) {
		// 	if(data=='0'){
		// 		$("input[name='username']").val('用户名不存在');
		// 	}
    //      }
	 // });
    // });
    //
    // $("input[name='username']").focus(function () {
    //     $("input[name='username']").val('');
    // });

});
