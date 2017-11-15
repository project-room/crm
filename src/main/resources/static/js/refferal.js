$(function() {
    allCheck();
    $('.main').niceScroll({
        cursorcolor: '#ccc'
    });
    checkboxClick();
    $('.customerNum span').text($('#table tbody tr').length);
    // $('.pull-right.pagination').append('<ul>1234</ul>')
    forFilter();
    forZhuanjiao();
    forshenpiPop();
    forchehuiPop();
    $('.allOperate .delete').click(function() {
            var dblChoseAlert = simpleAlert({
            "content":"确定删除？",
            "buttons":{
                "确定":function () {
                    $('tbody tr').each(function(index, el) {
                        if ($(this).find('.forCheckbox input').prop('checked') == true) {
                            $(this).remove();
                            //ajax
                        }
                    });
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
    $('#table').find('.follow').width($('#table').width() / 2);
    $('.tag').click(function() {
        event.stopPropagation();
        $(this).find('ul').addClass('dblock').removeClass('dnone');
    });
    $('body').click(function() {
        event.stopPropagation();
        $('.slideEdit').slideUp(100);
        $('.stage .stageYinc').slideUp(100);
        $('.client .clientYinc').slideUp(100);
        slideBool = false;
        $('.tag').find('ul').addClass('dnone').removeClass('dblock');
    });

    $('.zhuanjiaoMain .forCheckbox input').click(function() {
        if($(this).prop('checked') == true) {
            $(this).parents('label').addClass('borderPurple')
        } else {
            $(this).parents('label').removeClass('borderPurple')
        }
        
    });
    

});
window.onload = function() {
    laydate.render({
        elem: '#hour',
        type: 'time',
        range: true,
        theme: '#7460ee',
    });
    laydate.render({
        elem: '#day',
        format: 'yyyy-MM-dd ',
        theme: '#7460ee',
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
    $('tbody').on('click', 'tr .shenpi', function() {
        // alert($(this).parents('tr').attr('data-id'))
        // $(this).parents('tr').remove();
        allOperateShowHide();
    });
    $('tbody').on('click', 'tr input[type=checkbox]', function(event) {
        event.stopPropagation();
        allOperateShowHide();
    });
    $('tbody').on('click', 'tr a', function(event) {
        event.stopPropagation();
    });


    $('body').on('click', '.stage span', function(event) {
        $('.stageYinc').slideUp(100);
        event.stopPropagation();
        $(this).next('ul').slideDown('100');
    });

    $('body').on('click', '.client span', function(event) {
        $('.clientYinc').slideUp(100);
        event.stopPropagation();
        $(this).next('ul').slideDown(100);
    });
}


function forFilter(){
    $('.filter').click(function() {
        $('.filterPop').addClass('dblock').removeClass('dnone');
    });
    $('.filterPop .shelter').click(function(event) {
        $('.layui-laydate').remove();
        $('.filterPop').addClass('dnone').removeClass('dblock');
    });
    $('.filterPop .sure').click(function() {
        $('.layui-laydate').remove();
        $('.filterPop').addClass('dnone').removeClass('dblock');
    });
    $('.filterPop .cancel').click(function() {
        $('.layui-laydate').remove();
        $('.filterPop').addClass('dnone').removeClass('dblock');
    });

    $('.oldSaler').click(function() {
        $('.oldSalerSearch').slideToggle();
    });
    $('.newSaler').click(function() {
        $('.newSalerSearch').slideToggle();
    });
    $('.filterPop ul').click(function() {
        if ($(this).find('span').text() == '+') {
            $(this).find('span').text('-');
            openOrnot = false;
        } else {
            $(this).find('span').text('+');
            openOrnot = true;
        }
        $(this).find('li').slideToggle();
    });
    $('.oldSalerSearch li').click(function(event) {
        event.stopPropagation();
        $('.oldSaler').val($(this).text());
    });

    $('.newSalerSearch li').click(function(event) {
        event.stopPropagation();
        $('.newSaler').val($(this).text());
    });
}
function forZhuanjiao(){
    $('.createZhuanjiao').click(function() {
        $('.zhuanjiao').addClass('dblock').removeClass('dnone');
    });
    $('.zhuanjiao .shelter').click(function(event) {
        $('.zhuanjiao').addClass('dnone').removeClass('dblock');
    });
    $('.zhuanjiao .sure').click(function() {
        $('.zhuanjiao').addClass('dnone').removeClass('dblock');
    });
    $('.zhuanjiao .cancel').click(function() {
        $('.zhuanjiao').addClass('dnone').removeClass('dblock');
    });
}
function forshenpiPop(){
    $('tbody').on('click', '.shenpi', function() {
        $('.shenpiPop').addClass('dblock').removeClass('dnone');
    });
    $('.shenpiPop .shelter').click(function(event) {
        $('.shenpiPop').addClass('dnone').removeClass('dblock');
    });
    $('.shenpiPop .yes').click(function() {
        $('.shenpiPop').addClass('dnone').removeClass('dblock');
    });
    $('.shenpiPop .cancel').click(function() {
        $('.shenpiPop').addClass('dnone').removeClass('dblock');
    });
    $('.shenpiPop .no').click(function() {
        $('.shenpiPop').addClass('dnone').removeClass('dblock');
    });
}
function forchehuiPop(){
    $('tbody').on('click', '.chehui', function() {
        var dblChoseAlert = simpleAlert({
            "content":"是否撤回",
            "buttons":{
                "是":function () {
                    dblChoseAlert.close();
                },
                "否":function () {
                    dblChoseAlert.close();
                }
            }
        });
    });

    // $('tbody').on('click', '.chehui', function() {
    //     $('.chehuiPop').addClass('dblock').removeClass('dnone');
    // });
    // $('.chehuiPop .shelter').click(function(event) {
    //     $('.chehuiPop').addClass('dnone').removeClass('dblock');
    // });
    // $('.chehuiPop .sure').click(function() {
    //     $('.chehuiPop').addClass('dnone').removeClass('dblock');
    // });
    // $('.chehuiPop .cancel').click(function() {
    //     $('.chehuiPop').addClass('dnone').removeClass('dblock');
    // });
}

