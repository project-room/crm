$(function () {
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
});