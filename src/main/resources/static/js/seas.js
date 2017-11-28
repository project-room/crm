$(function() {
    allCheck();

    $('.main').niceScroll({
        cursorcolor: '#ccc'
    });
    $('.salerSearch').niceScroll({
        cursorcolor: '#ccc'
    });


    checkboxClick();

    // $('.pull-right.pagination').append('<ul>1234</ul>')
    $('.filter').click(function(){
        $('.filterPop').addClass('dblock').removeClass('dnone');
    });

    $('.shelter').click(function(event) {
        $('.filterPop').addClass('dnone').removeClass('dblock');
    });

    $('.filterPop .sure').click(function() {
        $('.filterPop').addClass('dnone').removeClass('dblock');
    });
    $('.filterPop .cancel').click(function() {
        $('.filterPop').addClass('dnone').removeClass('dblock');
    });

    $('.allOperate .delete').click(function() {
        $('tbody tr').each(function(index, el) {
            if ($(this).find('.forCheckbox input').prop('checked') == true) {
                $(this).remove();
                //ajax
            }
        });
    });

    forDealing();

    forTable();
    fenye();
    //新建客户
    $("#addCstCustomer").click(function () {
        location.href="/crm/cstCustomer/toAddNewCustomer";
    });

    //筛选客户
    $("#confirm").click(function () {
        var custCompany= $("input[name='custCompany']").val();
        var linkName= $("input[name='linkName']").val();
        var linkPhone= $("input[name='linkPhone']").val();
        var linkLandlinePhone= $("input[name='linkLandlinePhone']").val();
        var userName= $("input[name='userName']").val();
        var linkEmail= $("input[name='linkEmail']").val();
        var year= $("input[name='year']").val();
        var minute= $("input[name='minute']").val();
        var currentPageFor= $("input[name='currentPageFor']").val();

        //判断是否为空值
//           year:2017年11月22日
//            minute:09:04:04 - 03:03:03
        if(year==""||year==null){
            year="1880年01月01日";
        }
        if(minute==""||minute==null){
            minute="00:00:00 - 00:00:00";
        }
        // if(userName==""||userName==null){
        //     userName="11111";
        // }
        if(custCompany==null||custCompany==""){
            custCompany="11111";
        }
        if(linkName==null||linkName==""){
            linkName="11111";
        }
        if(linkPhone==null||linkPhone==""){
            linkPhone="11111";
        }
        if(linkLandlinePhone==null||linkLandlinePhone==""){
            linkLandlinePhone="11111";
        }
        if (userName==null||userName==""){
            userName="11111";
        }
        if (linkEmail==null||linkEmail==""){
            linkEmail="11111";
        }

        location.href="/crm/cstCustomer/selectCstCustomersByCondition/"+custCompany+"/"+linkName+"/"+linkPhone+"/"+linkLandlinePhone+"/"+userName+"/"+linkEmail+"/"+year+"/"+minute+"/"+currentPageFor+"/7"

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


    //限制单个分配客户（列表右侧的分配）
    $(".dealing").click(function () {

    });
});


window.onload = function() {
    laydate.render({
        elem: '#hour',
        type: 'time',
        range: true
    });
    laydate.render({
        elem: '#day',
        format: 'yyyy年MM月dd日'
    });
};




function allOperateShowHide() {
    for (var i = 0; i < $('tbody tr').length; i++) {
        if ($('tbody tr').eq(i).find('input[type=checkbox]').prop('checked') === true) {
            $('.allOperate').addClass('dblock').removeClass('dnone');
            break;
        } else {
            $('.allOperate').removeClass('dblock').addClass('dnone');
        }
    }
}


function checkboxClick() {
    $('body').on('click', 'tbody input[type=checkbox]', function() {
        var x = 0;
        var mx = $('tbody tr').length;
        for (var i = 0; i < mx; i++) {
            if ($('tbody tr').eq(i).find('input[type=checkbox]').prop('checked') === true) {
                x++
            }
        }
        if (x != (mx - 1)) {
            $('.allOperate input').prop('checked', false);
        } else {
            $('.allOperate input').prop('checked', true);
        }
    })
}

function allCheck() {
    $('.allOperate input').click(function() {
        for(var i = 0; i < $('tbody').find('tr').length; i++) {
            if($(this).prop('checked') == true) {
                $('tbody').find('input[type=checkbox]').eq(i).prop('checked', true);
                $('tbody .forCheckbox').addClass('borderPurple');
            } else {
                $('tbody').find('input[type=checkbox]').eq(i).prop('checked', false);
                $('tbody .forCheckbox').removeClass('borderPurple');
            }
        }
        allOperateShowHide();
    });
}


function forDealing() {
    var userId="";
    $('body').on('click', '.dealing', function() {
        $('.dealingPop').addClass('dblock').removeClass('dnone');
    });
    $('.dealingPop .shelter').click(function(event) {
        $('.dealingPop').addClass('dnone').removeClass('dblock');
    });
    $('.dealingPop .sure').click(function() {
        $('.dealingPop').addClass('dnone').removeClass('dblock');
        //客户字符串id
        var custIdStr="";
        for(var i = 0; i < $('#table tbody tr').length; i++) {
            if ($('#table tbody tr').eq(i).find('.forCheckbox').find('input[type=checkbox]').prop('checked')) {
                var custId= $('#table tbody tr').eq(i).find('input[type=hidden]').val();
                custIdStr=custIdStr+"-"+custId;
            }
        }
        //分配客户
        $.ajax({
            url:"/crm/cstCustomer/distributeCstCustomer",
            type:"POST",
            data:{"userId":userId,"custIdStr":custIdStr},
            success:function (data) {
                location.href="/crm/cstCustomer/getPage/1/7"
            }
        });

    });

    //测试


    $('.dealingPop .cancel').click(function() {
        $('.dealingPop').addClass('dnone').removeClass('dblock');
    });
    $('tbody').on('click', '.dealing', function() {
        $('.dealingPop').addClass('dblock').removeClass('dnone');
    });

    $('.dealingPop .saler').click(function() {
        $('.salerSearch').slideToggle();

    });

    $('.salerSearch ul').click(function() {
        if ($(this).find('span').text() == '+') {
            $(this).find('span').text('-');
            openOrnot = false;
        } else {
            $(this).find('span').text('+');
            openOrnot = true;
        }
        $(this).find('li').slideToggle();
    });

    $('.salerSearch li').click(function(event) {
        event.stopPropagation();
        var text = $(this).text();
        $('.saler').val(text);
        //获取销售员id
        userId= $(this).attr('name');
    });
}

function forTable() {
    var slideBool = false;
    $('tbody').on('click', 'tr .delete', function() {
        $(this).parents('tr').remove();
        allOperateShowHide();
    });

    // $('tbody').on('click', 'tr input[type=checkbox]', function(event) {
    //     event.stopPropagation();
    //     allOperateShowHide();
    // });
    $('tbody').on('click', '.forCheckbox', function(event) {
        event.stopPropagation()
        setTimeout(forDel, 10);
        function forDel() {
            var userIdStr="";
            var x = 0;
            var mx = $('tbody tr').length;
            for (var i = 0; i < mx; i++) {
                if ($('#table tbody tr').eq(i).find('input[type=checkbox]').prop('checked') == true) {
                    x++;
                    //获取批量用户id
                    var userId= $('#table tbody tr').eq(i).find('input[type=hidden]').val().toString();
                    userIdStr=userIdStr+"-"+userId;
                }
            }

            //点击删除按钮
            $(".delete").click(function () {
                location.href="/crm/cstCustomer/deleteAllCustomer/"+userIdStr;
            });
            //点击编辑按钮
            $(".edit").click(function () {
                location.href="/crm/cstCustomer/lookCstCustomerInfo/"+userIdStr;
            });


            if (x > 1) {
                $('.allOperate').find('.edit').addClass('dnone');
            } else {
                $('.allOperate').find('.edit').removeClass('dnone');
            }

            if (x != mx) {
                $('.allOperate input').prop('checked', false);
                $('.allOperate .forCheckbox').removeClass('borderPurple');
            } else {
                $('.allOperate input').prop('checked', true);
                $('.allOperate .forCheckbox').addClass('borderPurple');
            }
            allOperateShowHide();
        }
    })

    $('tbody').on('click', 'tr a', function(event) {
        event.stopPropagation();
    });

    $('tbody').on('click', '.modify', function(event) {
        event.stopPropagation();
        $('.slideEdit').slideUp(100);
        if (!slideBool) {
            $(this).siblings('.slideEdit').slideDown(100);
            slideBool = true;
        } else {
            slideBool = false;
        }
    });

    $('body').click(function() {
        event.stopPropagation();
        $('.slideEdit').slideUp(100);
        slideBool = false;
    });

    //单击单条记录获取该条记录的信息
    $('tbody').on('click', 'tr', function() {
        var custId= $(this).children("input[type=hidden]").val().toString();
        location.href="/crm/cstCustomer/lookCstCustomerInfo/"+custId;
    });

    //公海普通跳转到页面
    $('body').on('change', '.dumppage', function() {
        var val = $(this).val();
        window.location.pathname = '/crm/cstCustomer/getPage/' + val + '/7';

    });



    // //公海筛选跳转到页面
    $('body').on('change', '.dumppagescreen', function() {
        var val = $(this).val();
        var custCompany=$("input[name='custCompanyscreen']").val();
        var linkName=$("input[name='linkNamescreen']").val();
        var linkPhone=$("input[name='linkPhonescreen']").val();
        var linkLandlinePhone=$("input[name='linkLandlinePhonescreen']").val();
        var userName=$("input[name='userNamescreen']").val();
        var linkEmail=$("input[name='linkEmailscreen']").val();
        var year=$("input[name='yearscreen']").val();
        var minute=$("input[name='minutescreen']").val();
        location.href = '/crm/cstCustomer/selectCstCustomersByCondition/'+custCompany+'/'+linkName+'/'+linkPhone+'/'+linkLandlinePhone+'/'+userName+'/'+linkEmail+'/'+year+'/'+minute+'/'+val+'/7';

    });
}