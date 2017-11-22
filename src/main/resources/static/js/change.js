$(function () {
    $(".rightSide>ul>li").click(function () {
        $(this).addClass("active").siblings().removeClass("active");
        var index = $(this).index();
        $(".progressNavDetail").hide();
        $(".progressNavDetail"+index).show();
    })
    $(".leftSideEdit").click(function () {
        var _input = $(".leftSideTable input");
        var _select = $(".leftSideTable select");
        var _disabledShelter = $(".leftSideTable .disabledShelter");
        _input.removeAttr("disabled");
        _select.removeAttr("disabled");
        _disabledShelter.hide();
        $(".leftSideBtn").show();
    })
    $(".leftSideBtn button:first").click(function () {
        var _input = $(".leftSideTable input");
        var _select = $(".leftSideTable select");
        var _disabledShelter = $(".leftSideTable .disabledShelter");
        _input.attr("disabled","disabled");
        _select.attr("disabled","disabled");
        _disabledShelter.show();
        $(".leftSideBtn").hide();
    })
    $(".leftSideBtn button:last").click(function () {
        var _input = $(".leftSideTable input");
        var _select = $(".leftSideTable select");
        var _disabledShelter = $(".leftSideTable .disabledShelter");
        _input.attr("disabled","disabled");
        _select.attr("disabled","disabled");
        _disabledShelter.show();
        $(".leftSideBtn").hide();
    })

   $('.headerNav').find("li").click(function(){
    var chId=$(tbody).children("input[type=hidden]").val();
        alert(chId);
           $.ajax({
               url:'/crm/CstRecord/getCstRecord/1',
               dataType:'json',
               type:'post',
               data:{},
               success:function(data){
                   console.log(123)
               },
               error:function(){
                   console.log(456)
               }
           })
       });

})