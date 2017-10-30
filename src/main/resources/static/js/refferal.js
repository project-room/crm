$(function() {
    allCheck();
    $('.main').niceScroll({
        cursorcolor: '#ccc'
    });
    //
//     var tableTitle = [{
//         field: "select",
//         title: "",
//         formatter: function() {
//             c = "<label class='forCheckbox'><input type='checkbox'></label>";
//             return c;
//         }
//     }, {
//         class: "origin",
//         field: "origin",
//         title: "原始负责人",
//     }, {
//         class: "newMan",
//         field: "newMan",
//         title: "新负责人",
//     }, {
//         class: "client",
//         field: "client",
//         title: "客户",
//     }, {
//         class: "stage",
//         field: "stage",
//         title: "阶段",
//     }, {
//         class: "current",
//         field: "current",
//         title: "当前步骤"
//     }, {
//         class: "createTime",
//         field: "createTime",
//         title: "创建时间"
//     }, {
//         field: "operate",
//         title: "",
//     }];
// //
//     var tableData = [{
//         "id": 0,
//         "select": "",
//         "origin": "<p>汤姆斯</p>",
//         "newMan": "<p>汤姆斯</p>",
//         "client": "<p>广州润普网络科技有限公司</p><span> · · · </span><ul class='dnone clientYinc'><li>广州润普网络科技有限公司</li><li>广州润普网络科技有限公司</li></ul>",
//         "stage": "<ul><li>一二三四</li><li>一二三四</li></ul><span> · · · </span><ul class='dnone stageYinc'><li>一二三四</li><li>一二三四</li></ul>",
//         "current": '<p>待审批（水水水）</p>',
//         "createTime": "<p>2101-11-11 11-11</p>",
//         "operate": '<button class="shenpi">审批</button>',
//     }];
// //
//     $('#table').bootstrapTable('destroy').bootstrapTable({
//         columns: tableTitle,
//         data: tableData,
//         pagination: true,
//         paginationPreText: '上一页',
//         paginationNextText: '下一页',
//         paginationLoop: false,
//         // showToggle: true,
//         formatLoadingMessage: function() {
//                 return null;
//             }
//             // url: 'js/data.json'
//     });
    checkboxClick();
    $('.customerNum span').text($('#table tbody tr').length);
    // $('.pull-right.pagination').append('<ul>1234</ul>')
    forFilter();
    forZhuanjiao();
    forshenpiPop();
    forchehuiPop();
    $('.allOperate .delete').click(function() {
        $('tbody tr').each(function(index, el) {
            if ($(this).find('.forCheckbox input').prop('checked') == true) {
                $(this).remove();
                //ajax
            }
        });
    });
    forTable();
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
    $('tbody').on('click', 'input[type=checkbox]', function() {
        var x = 0;
        var mx = $('tbody tr').length;
        for (var i = 0; i < mx; i++) {
            if ($('tbody tr').eq(i).find('input[type=checkbox]').prop('checked') == true) {
                x++;
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
        for (var i = 0; i < $('tbody').find('tr').length; i++) {
            if ($(this).prop('checked') == true) {
                $('tbody').find('input[type=checkbox]').eq(i).prop('checked', true);
            } else {
                $('tbody').find('input[type=checkbox]').eq(i).prop('checked', false);
            }
        }
        allOperateShowHide();
    });
}

function forTable() {
    var slideBool = false;
    $('tbody').on('click', 'tr .delete', function() {
        $(this).parents('tr').remove();
        allOperateShowHide();
    });
    $('tbody').on('click', 'tr input[type=checkbox]', function(event) {
        event.stopPropagation();
        allOperateShowHide();
    });
    $('tbody').on('click', 'tr a', function(event) {
        event.stopPropagation();
    });
    // $('tbody').on('click', '.modify', function(event) {
    //     event.stopPropagation();
    //     $('.slideEdit').slideUp(100);
    //     if (!slideBool) {
    //         $(this).siblings('.slideEdit').slideDown(100);
    //         slideBool = true;
    //     } else {
    //         slideBool = false;
    //     }
    // });


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
    // $('body').on('click', 'tbody tr', function() {
    //     location.href = "editCustomer.html";
    // });
}


function forFilter(){
    $('.filter').click(function() {
        $('.filterPop').addClass('dblock').removeClass('dnone');
    });
    $('.filterPop .shelter').click(function(event) {
        $('.filterPop').addClass('dnone').removeClass('dblock');
    });
    $('.filterPop .sure').click(function() {
        $('.filterPop').addClass('dnone').removeClass('dblock');
    });
    $('.filterPop .cancel').click(function() {
        $('.filterPop').addClass('dnone').removeClass('dblock');
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
        $('.chehuiPop').addClass('dblock').removeClass('dnone');
    });
    $('.chehuiPop .shelter').click(function(event) {
        $('.chehuiPop').addClass('dnone').removeClass('dblock');
    });
    $('.chehuiPop .sure').click(function() {
        $('.chehuiPop').addClass('dnone').removeClass('dblock');
    });
    $('.chehuiPop .cancel').click(function() {
        $('.chehuiPop').addClass('dnone').removeClass('dblock');
    });
}