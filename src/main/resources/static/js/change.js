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

   $('.headerNav').find("li:nth-of-type(2)").click(function(){
    var chId=$(".chId").children("input[type=hidden]").val();
           $.ajax({
//               url:'/crm/CstRecord/getCstRecord/'+chId,
//               dataType:'json',
//               type:'post',
//               data:{},
//               success:function(data){
//                  console.log(data)
//               },
//               error:function(){
//                   console.log(456)
//               }
               url:'/crm/CstRecord/getCstRecord/'+chId,
               dataType:'json',
               type:'post',
               data:{},
               success:function(data){
                   var str = '<ul>';
                   for (var i = 0; i < data.RecordList.length; i++) {
                       var record = data.RecordList[i];
                       str += "<li><div><img src=\"/crm/img/edit.png\" alt=\"\"><img src=\"/crm/img/delete.png\" alt=\"\"></div><p>" + record.reContent + "</p><p >" + (record.reDate.year + 1900) + "/" + (record.reDate.month + 1) + "/" + record.reDate.date + " " + record.chance.sysUser.userName + "</p> <p>\u6DFB\u52A0\u9644\u4EF6<img src=\"/crm/img/word3.png\" height=\"17\" width=\"18\"/>\u9700\u6C42\u5206\u6790\u6587\u6863\u4E00<img src=\"/crm/img/ppt3.png\" height=\"18\" width=\"18\"/>\u9700\u6C42\u5206\u6790\u6587\u6863\u4E8C</p></li>";
                   }
                   str += '</ul>';
                   $('.msg').html(str);
                  console.log(data.RecordList)

               },
               error:function(){
                   console.log(456)
               }
           })
       });
        $('.headerNav').find("li:nth-of-type(6)").click(function(){
           var chId=$(".chId").children("input[type=hidden]").val();
                  $.ajax({
                      url:'/crm/UserTask/getUserTask/'+chId,
                      dataType:'json',
                      type:'post',
                      data:{},
                      success:function(data){
                          var strDone = '';
                          var strUndone = '';
                          console.log(data.userTasksList.length)
                          for (var i = 0; i < data.userTasksList.length; i++) {
                             var record = data.userTasksList[i];
                             console.log(record.taskStatus)
                             if(record.taskStatus == 0){
                                 strUndone = "<li><div class=\"fl\"><div class=\"forCheckbox\"><input type=\"checkbox\"/></div></div><div class=\"fl\" ><p>" + record.taskContent + "</p><span>" + (record.taskDate.year + 1900) + "/" + (record.taskDate.month + 1) + "/" + record.taskDate.date + "</span>\u6267\u884C</div></li>";
                                 $('.undone').html(strUndone);
                             } else {
                                 strDone = "<li><div class=\"fl\"><img class=\"checkedPic\" src=\"/crm/img/checked.png\" height=\"14\" width=\"14\"/></div><div class=\"fl\" ><p>" + record.taskContent + "</p><span>" + (record.taskDate.year + 1900) + "/" + (record.taskDate.month + 1) + "/" + record.taskDate.date + "</span>\u6267\u884C</div></li>";
                                 $('.done').html(strDone);
                             }
                         }
                      },
                      error:function(){
                          console.log(456)
                      }
                  })
              });
                $('.fabu').click(function(){
                    var recordTextareaVal = $('.recordTextarea').val();
                    var chId=$(".chId").children("input[type=hidden]").val();
                        $.ajax({
                            url:'/crm/CstRecord/addCstRecord',
                            dataType:'json',
                            type:'post',
                            data:{"chId":chId,"recordTextareaVal":recordTextareaVal},
                            success:function(data){
                                alert('发布成功');
                                $('.recordTextarea').val('');
                                $('.headerNav').find('.active').trigger('click');
                            },
                            error:function(){
                                alert('网络错误，请重新发送');
                            }
                        })
                });
})