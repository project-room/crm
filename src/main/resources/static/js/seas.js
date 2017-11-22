$(function() {
    allCheck();

    $('.main').niceScroll({
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

   // //根据客户名来模糊搜所客户信息
   //  $("#search").click(function () {
   //   var custCompany=$("#searchName").val();
   //   location.href="/crm/cstCustomer/selectCstCustomerByName/"+custCompany+"/1/7"
   //  });

    //筛选客户
    $("#confirm").click(function () {
        $("#filterForm").submit();
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
    $('body').on('click', '.dealing', function() {
        $('.dealingPop').addClass('dblock').removeClass('dnone');
    });
    $('.dealingPop .shelter').click(function(event) {
        $('.dealingPop').addClass('dnone').removeClass('dblock');
    });
    $('.dealingPop .sure').click(function() {
        $('.dealingPop').addClass('dnone').removeClass('dblock');
    });
    $('.dealingPop .cancel').click(function() {
        $('.dealingPop').addClass('dnone').removeClass('dblock');
    });
    $('tbody').on('click', '.dealing', function() {
        $('.dealingPop').addClass('dblock').removeClass('dnone');
    });

    $('.dealingPop .saler').click(function() {
        $('.salerSearch').slideToggle()
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
                if ($('tbody tr').eq(i).find('input[type=checkbox]').prop('checked') == true) {
                    x++;
                    //获取批量用户id
                    var userId= $('tbody tr').eq(i).find('input[type=hidden]').val().toString();
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

    //跳转到页面
    $('body').on('change', '.dumppage', function() {
        var val = $(this).val();
        window.location.pathname = '/crm/cstCustomer/getPage/' + val + '/7';

    });
}