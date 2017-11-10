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
    })
})