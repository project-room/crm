$(function () {
    $(".mainHeaderDropDownTitle").click(function () {
        $(".mainHeaderDropDowning").toggle();
    })
    $(".editAndDeleteBtn .selectAll").change(function () {
        if($(this).is(":checked")){
            $('.mainTable td input[type="checkbox"]').attr("checked", "true")
        }else {
            $('.mainTable td input[type="checkbox"]').removeAttr("checked", "true")
            $(".editAndDeleteBtn").hide();
        }
    })
    $('.mainTable td input[type="checkbox"]').click(function () {
        var num = $('.mainTable td input[type="checkbox"]:checked').length;
        if(num){
            $(".editAndDeleteBtn").show();
        }else {
            $(".editAndDeleteBtn").hide();
        }
    })
    $('.approvalDetailCheckbox input[type="checkbox"]').click(function () {
        var num = $(".approvalDetailCheckbox input:checked").length;
        if(num){
            $(".editAndDeleteBtn").show();
        }else {
            $(".editAndDeleteBtn").hide();
        }
    })
    $(".editAndDeleteBtn .selectAll").change(function () {
        if($(this).is(":checked")){
            $('.approvalDetailCheckbox input[type="checkbox"]').attr("checked", "true")
        }else {
            $('.approvalDetailCheckbox input[type="checkbox"]').removeAttr("checked", "true")
            $(".editAndDeleteBtn").hide();
        }
    })
    var cantDeleteTipIsShow = false;
    $(".editAndDeleteBtn .delete").click(function () {
        if(!cantDeleteTipIsShow){
            cantDeleteTipIsShow = true;
            $(".cantDeleteTip").fadeIn();
            setTimeout(function () {
                $(".cantDeleteTip").fadeOut();
                cantDeleteTipIsShow = false;
            },3000)
        }
    })
    $(".mainRightSideNav li").click(function () {
        $(this).addClass("active").siblings().removeClass("active");
        var index = $(this).index();
        $(".navDetail").hide();
        $(".navDetail"+index).show();
    })
    $(".approvalDetailTop .more").click(function () {
        $(this).parents("li").find(".approvalDetailTip").toggle();
    })
    $(".approvalDetailBody").click(function () {
        $(this).siblings(".approvalDetailMoreMsg").toggle();
    })
    $(".advancedScreening .advancedScreeningClose").click(function () {
        $(".advancedScreening").hide().prev().hide();
    });

        /**/
    // sheeep

    $(".mainLeftSideTable .operation").click(function () {
        if ($(this).find('ul').hasClass('dnone')) {
            $(this).find('ul').removeClass('dnone');
        } else {
            $(this).find('ul').addClass('dnone');
        }
    })
    // sheeep

    $(".mainLeftSideTable .operation .editMsg").click(function (e) {
        e.stopPropagation();
        var _input = $(".mainLeftSideTable input");
        var _select = $(".mainLeftSideTable select");
        var _disabledShelter = $(".mainLeftSideTable .disabledShelter");
/*        _input.removeAttr("disabled");
        _select.removeAttr("disabled");*/
        $(".width100per").removeAttr("disabled","disabled");
        _disabledShelter.hide();
        $(".mainLeftSideTable .cancel").show();
        $(".mainLeftSideTable .save").show();

        $(this).parent().addClass('dnone')
        $(".mainLeftSideTable .operation").addClass('dnone')
    })
    $(".mainLeftSideTable button:first").click(function () {
        var _input = $(".mainLeftSideTable input");
        var _select = $(".mainLeftSideTable select");
        var _disabledShelter = $(".mainLeftSideTable .disabledShelter");
/*        _input.attr("disabled","disabled");
        _select.attr("disabled","disabled");*/
        $(".width100per").attr("disabled","disabled");
        _disabledShelter.show();
        $(".mainLeftSideTable .cancel").hide();
        $(".mainLeftSideTable .save").hide();
    })
    $(".mainLeftSideTable button:last").click(function () {
        var _input = $(".mainLeftSideTable input");
        var _select = $(".mainLeftSideTable select");
        var _disabledShelter = $(".mainLeftSideTable .disabledShelter");
/*        _input.attr("disabled","disabled");
        _select.attr("disabled","disabled");*/
        $(".width100per").attr("disabled","disabled");
        _disabledShelter.show();
        $(".mainLeftSideTable .cancel").hide();
        $(".mainLeftSideTable .save").hide();
    })
    $(".mainRightSideChart .hoverBox .edit3").click(function () {
        $(".mainRightSideChart").hide();
        $(".mainRightSideReceivables").hide();
        $(".navDetail .editMain").show();
    })
    $(".mainRightSideChart .hoverBox .delete3").click(function () {
        var _this = $(this);
        var delete3 = simpleAlert({
            "content":"是否删除该条收款进度？",
            "buttons":{
                "确定":function () {
                    _this.parents("li").remove();
                    delete3.close();
                },
                "取消":function () {
                    delete3.close();
                }
            }
        })
    })
    $(".navDetail .editMain .btns button").eq(0).click(function () {
        $(".mainRightSideChart").show();
        $(".mainRightSideReceivables").show();
        $(".navDetail .editMain").hide();
    })
    $(".navDetail .editMain .btns button").eq(1).click(function () {
        $(".mainRightSideChart").show();
        $(".mainRightSideReceivables").show();
        $(".navDetail .editMain").hide();
    });


    

   


    //sheeep
    forIndex();
    forTable();
    fenye();
    checkboxClick();
    allCheck();

    detailLeft();
    contractApproval();
    createDetail();
});
function allOperateShowHide() {
    for (var i = 0; i < $('.contractContent #table tbody tr').length; i++) {
        if ($('.contractContent #table tbody tr').eq(i).find('input[type=checkbox]').prop('checked') == true) {
            $('.allOperate').removeClass('dnone');
            break;
        } else {
            $('.allOperate').addClass('dnone');
        }
    }
}


function checkboxClick() {
    $('tbody').on('click', '.forCheckbox', function(event) {
        event.stopPropagation()
        setTimeout(forDel, 10);
        function forDel() {
            var x = 0;
            var mx = $('#table tbody tr').length;
            for (var i = 0; i < mx; i++) {
                if ($('#table tbody tr').eq(i).find('input[type=checkbox]').prop('checked') == true) {
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
        for (var i = 0; i < $('tbody').find('tr').length; i++) {
            if ($(this).prop('checked') == true) {
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
    $('#table').on('click', 'tr .delete', function() {
        $(this).parents('tr').remove();
        allOperateShowHide();
    });

    $('#table').on('click', 'tr input[type=checkbox]', function(event) {
        event.stopPropagation();
        allOperateShowHide();
    });

    $('#table').on('click', 'tr a', function(event) {
        event.stopPropagation();
    });

    $('#table').on('click', '.modify', function(event) {
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

//合同首页
function forIndex() {
    $('.allOperate .delete').click(function() {
        // var _this = $(this);
        var alldelete = simpleAlert({
            "content":"是否删除？？？",
            "buttons":{
                "确定":function () {
                    console.log($('.tbody tr').length)
                    $('#table tbody tr').each(function() {
                        if($(this).find('input[type="checkbox"]').prop('checked') == true) {
                            $(this).remove();
                        }
                    })
                    alldelete.close();
                },
                "取消":function () {
                    alldelete.close();
                }
            }
        });
    });


}

// detail

function detailLeft() {
    $('.relationBubbleP').click(function() {
        $('.relationBubble').removeClass('dnone');
    });

    $('.contract .relationBubble').find('.sure').click(function(e) {
        e.stopPropagation();
        $('.relationBubble').addClass('dnone');
    });

    $('.contract .relationBubble').find('.canc').click(function(e) {
        e.stopPropagation()
        $('.relationBubble').addClass('dnone');
    });

    $('.addReceivables').click(function() {
        $('.navDetail0 .mainRightSideReceivables').hide().next().hide();
        $('.editMain').show();
    });


    $('.turnback').click(function() {
        $('.mainRightSideReceivables').show().next().show();
        $('.editMain').hide();
    });

    $('.mainLeftSide').height($('.main').height() - 60);
    $('.mainRightSide').height($('.main').height() - 60);
    $('.mainLeftSide').find('input').width($('.mainLeftSide').width() - 185);
    $('.mainLeftSide').find('input.selectDate').width(($('.mainLeftSide').width() - 185)/2);
    $('.mainLeftSide').find('select').width($('.mainLeftSide').width() - 185);



    $('.operate').click(function() {
        $(this).find('ul').slideToggle();
    });
    $('.operate').find('.edit').click(function() {
        $('.mainLeftSide form label').find('input').attr('disabled', false);
        $('.mainLeftSide form label').find('select').attr('disabled', false).removeClass('bgNone');
        $('.mainLeftSide form label').find('input.selectDate').removeClass('bgNone');
        $('.mainLeftSide ul li.mayHide').addClass('dnone');
        $('.mainLeftSide .btngroup').removeClass('dnone');
        $('.mainLeftSide label').addClass('borderBottom');
    });

    $('.mainLeftSide form>.btngroup').find('input').click(function() {
        $('.mainLeftSide ul li.mayHide').removeClass('dnone');
        $('.mainLeftSide .btngroup').addClass('dnone');
        $('.mainLeftSide label').removeClass('borderBottom');
    });

    $('.connectChance').click(function() {
        $('.relationBubble').removeClass('dnone');
    });

    $('.contractDetail .btns').find('button').click(function(e) {
        e.preventDefault();
        e.stopPropagation();
        $('.relationBubble').addClass('dnone');
    });
}

// createDetail
function createDetail() {
     $('.createContract .guanlian').click(function() {
        $('.relationBubble').removeClass('dnone');
    })
     $('.createContract .relationBubble').find('.sure').click(function(e) {
        e.stopPropagation();
        $('.relationBubble').addClass('dnone');
    });

    $('.createContract .relationBubble').find('.canc').click(function(e) {
        e.stopPropagation()
        $('.relationBubble').addClass('dnone');
    });


    lay('.selectDate').each(function(){
        laydate.render({
            elem: this
            ,trigger: 'click'
            ,theme: '#7460ee'
        });
    });
}

// contractApproval
function contractApproval() {

    //全选存在bug
    $('.contractApproval').find('.forCheckbox').find('input[type="checkbox"]').click(function() {
        var x = 0,
            mx = $('.contractApprovalDetail').find('li').length;
        for (var i = 0; i < mx; i++) {
            if ($('.contractApprovalDetail').find('li').eq(i).find('.forCheckbox').find('input[type="checkbox"]').prop('checked') == true) {
                x++
            }
        }
        
        if (x != 0) {
            $('.allOperate').removeClass('dnone');
        } else {
            $('.allOperate').addClass('dnone');
        }

        if (x == mx) {
            $('.allOperate input').prop('checked', 'checked');
            $('.allOperate .forCheckbox').addClass('borderPurple');
        } else {
            $('.allOperate input').prop('checked', false);
            $('.allOperate .forCheckbox').removeClass('borderPurple');
        }
    });

    $('.allOperate').find('.forCheckbox').click(function(e) {
        e.stopPropagation();
        if ($(this).find('input[type="checkbox"]').prop('checked') == true) {
            mx = $('.contractApprovalDetail').find('li').length;
            for (var i = 0; i < mx; i++) {
                $('.contractApprovalDetail').find('li').eq(i).find('.forCheckbox').find('input[type="checkbox"]').prop('checked',true);
            }
        } else {
            mx = $('.contractApprovalDetail').find('li').length;
            for (var i = 0; i < mx; i++) {
                $('.contractApprovalDetail').find('li').eq(i).find('.forCheckbox').find('input[type="checkbox"]').prop('checked',false);
            }
        }
    });

    $('.filterBtn').click(function() {
        $('.filterPop').removeClass('dnone');
    });
    $('.filterPop .cancel').click(function() {
        $('.filterPop').addClass('dnone')
    });
    $('.filterPop .sure').click(function() {
        $('.filterPop').addClass('dnone')
    });

    $('.shenpiBtn').click(function() {
        $(this).find('ul').slideToggle()
    });
    $('.shenpiBtn li').click(function() {
        $('.shenpiBtn').find('span').text($(this).text())
    });

    $('.contractApprovalDetail').find('.pass').click(function() {
        var dblChoseAlert = simpleAlert({
            "content":"确定通过？",
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
    $('.contractApprovalDetail').find('.unPass').click(function() {
        var dblChoseAlert = simpleAlert({
            "content":"确定不通过？",
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

    $('.allOperate').find('.pass').click(function() {
        var dblChoseAlert = simpleAlert({
            "content":"确定通过？",
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
    $('.allOperate').find('.unPass').click(function() {
        var dblChoseAlert = simpleAlert({
            "content":"确定不通过？",
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
}