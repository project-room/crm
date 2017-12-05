$(function() {
        //点击加号
    $('.img_list').click(function(e){
        console.log(123)
        $('.add_list_a').css('display','block')
    }) ;
    allCheck();

    $('.main').height($(window).height() - 60);
    $('.chanceContent').css({
        'min-height': $(window).height() - 135 + 'px',
        'margin-bottom': '25px'
    });

    $('.main').niceScroll({
        cursorcolor: '#ccc'
    });

    
    checkboxClick();
    // $('.customerNum span').text($('#table tbody tr').length);
    
    // $('.pull-right.pagination').append('<ul>1234</ul>')
    $('.filter').click(function(){
        $('.filterPop').addClass('dblock').removeClass('dnone');
        $('.laydate-btns-clear').trigger('click');
    });

    $('.shelter').click(function(event) {
        $('.filterPop').addClass('dnone').removeClass('dblock');
        $('.laydate-btns-clear').trigger('click');
    });

    $('.filterPop .sure').click(function() {
        $('.filterPop').addClass('dnone').removeClass('dblock');
        $('.laydate-btns-clear').trigger('click');
    });
    $('.filterPop .cancel').click(function() {
        $('.filterPop').addClass('dnone').removeClass('dblock');
        $('.laydate-btns-clear').trigger('click');
    });

 $('.allOperate .delete').click(function() {
        var chIdArr = [];
         var dblChoseAlert = simpleAlert({
             "content":"确定删除？",
             "buttons":{
                 "确定":function () {
                     $('tbody tr').each(function(index, el) {
                         if ($(this).find('.forCheckbox input').prop('checked') == true) {
                             chIdArr.push($(this).find('input[type=hidden]').val());
                             alert($(this).find('input[type=hidden]').val())
                             $(this).remove();
                             //ajax
                         }
                     });
                    for(var i=0;i<chIdArr.length;i++){
                     $.ajax({
                        url:'/crm/cstChance/deleteCstChance/1/10',
                        data: {chId:chIdArr[i]},
                        success: function() {
                          location.href = '/crm/cstChance/getCstChance/1/10'
                        }
                     })
                     }
                     dblChoseAlert.close();
                 },
                 "取消":function () {
                     dblChoseAlert.close();
                 }
             }
         });
     });

    forTable();
    fenye();
    fenye2();
    $('#table').find('.follow').width($('#table').width() / 2);

    $('.tag').click(function() {
        event.stopPropagation();
        $(this).find('ul').addClass('dblock').removeClass('dnone');
    });


    $('body').click(function() {
        event.stopPropagation();
        $('.slideEdit').slideUp(100);
        slideBool = false;
        $('.tag').find('ul').addClass('dnone').removeClass('dblock');
    });

    $('#table').on('click', 'tr',function() {
        var chId=$(this).children("input[type=hidden]").val();
        location.href ="/crm/cstChance/getCstChanceId/"+chId;
    });


    referral();


});


window.onload = function() {
    laydate.render({
        elem: '#hour',
        type: 'time',
        range: true,
        theme: '#7460ee'
    });
    laydate.render({
        elem: '#day',
        format: 'yyyy年MM月dd日',
        theme: '#7460ee'
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
    $('tbody').on('click', '.forCheckbox', function(event) {
        event.stopPropagation()
        setTimeout(forDel, 10);
        function forDel() {
            var x = 0;
            var mx = $('tbody tr').length;
            for (var i = 0; i < mx; i++) {
                if ($('tbody tr').eq(i).find('input[type=checkbox]').prop('checked') == true) {
                    x++;
                }
            }
            if (x != mx) {
                $('.allOperate input').prop('checked', false);
                $('.allOperate .forCheckbox').removeClass('borderPurple');
            } else {
                $('.allOperate input').prop('checked', true);
                $('.allOperate .forCheckbox').addClass('borderPurple');
            }
        }
    })
}

function allCheck() {
    $('.allOperate input').click(function() {
        for(var i = 0; i < $('tbody').find('tr').length; i++) {
            if($(this).prop('checked') == true) {
                $(this).parents('label').addClass('borderPurple');
                $('tbody').find('input[type=checkbox]').eq(i).prop('checked', true).parents('.forCheckbox').addClass('borderPurple');
            } else {
                $(this).parents('label').removeClass('borderPurple');
                $('tbody').find('input[type=checkbox]').eq(i).prop('checked', false).parents('.forCheckbox').removeClass('borderPurple');
            }
        }
        allOperateShowHide();
    });
}

function forTable() {
   var slideBool = false;
       $('tbody').on('click', 'tr .delete', function() {
          var chId = $(this).parents('tr').find('input[type=hidden]').val();
           var $this = $(this);
           var dblChoseAlert = simpleAlert({
               "content":"确定删除？",
               "buttons":{
                   "确定":function () {
                       $this.parents('tr').remove();
                       location.href='/crm/cstChance/deleteCstChance/'+chId+'/1/10';
                       dblChoseAlert.close();
                   },
                   "取消":function () {
                       dblChoseAlert.close();
                   }
               }
           });
           allOperateShowHide();
       });
    $('tbody').on('click', 'tr input[type=checkbox]', function(event) {
        event.stopPropagation();
        allOperateShowHide();
    });

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
}


function referral() {
    var chanceId =[],
         newXXX;
    //单选复选框
    $('.referralmain').find('.forCheckbox').click(function() {
        $(this).parents('tr').siblings().find('.forCheckbox').removeClass('borderPurple');
        $(this).parents('tr').siblings().find('.forCheckbox').find('input').prop('checked', false);
    });

    //table中的referral

    $('.slideEdit .referral').click(function() {
        $('.referralPop').removeClass('dnone');
        chanceId.push($(this).parents('tr').find('input[type=hidden]').val());
    })

//    $('#table').on('click','.referral', function(event) {
//        $('.referralPop').removeClass('dnone');
//        alert(2);
//        chanceId.push($(this).parents('tr').find('input[type=hidden]').val());
//    });

    //allOperate的referral
    $('.allOperate').find('.referral').click(function() {
        $('.referralPop').removeClass('dnone');
        console.log($('#table tbody tr').length)
        for (var x = 0; x < $('#table tbody tr').length; x++) {
            if ($('#table tbody tr').eq(x).find('input[type=checkbox]').prop('checked') == true){
                chanceId.push($('#table tbody tr').eq(x).find('input[type=hidden]').val())
            }
        }
    })
    $('.referralPop').find('.cancel').click(function() {
        $('.referralPop').addClass('dnone');
        chanceId = [];
    });
    $('.referralPop').find('.canc').click(function() {
        $('.referralPop').addClass('dnone');
        chanceId = [];
    });
    $('.referralPop').find('.sure').click(function() {
        $('.referralPop').addClass('dnone');
    });

    $('.referralSearch').click(function() {
        var salerName = $('.referralName').val();
        console.log(chanceId, salerName)
//        $.ajax({
//            url:,
//            data:{salerName:salerName},
//            success:function() {
//
//            }
//        })
    });

    $('.referralList').on('click', '.forCheckbox', function() {
         userToId= $(this).find('input[type=checkbox]').val();
    })

    $('.referralmain').find('.sure').click(function() {
        for(var i=0;i<chanceId.length;i++){
          /*chanceId=chanceId[i];*/
        $.ajax({
            url:'/crm/cstChance/addToChance',
            data:{
             chanceId:chanceId[i],
             userToId:userToId
            },
            success: function() {
                location.href = '/crm/cstChance/getCstChanceUserId/1/10'
            }
         })
        }
    });

}