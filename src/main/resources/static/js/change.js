$(function () {
    var windowH = $(window).height();
    var windowW = $(window).width();
    $('.leftContent').height(windowH);
    $('.main').height($(window).height() - 100);
    $('.changeDetail .main').niceScroll({
        cursorcolor: '#ccc'
    });

    //点击加号
    $('.img_list').click(function(e){
        $('.add_list_a').css('display','block')
        e.stopPropagation()
    }) ;


    $(".rightSide>ul>li").click(function () {
        $(this).addClass("active").siblings().removeClass("active");
        var index = $(this).index();
        $('.examin').trigger('click');
        $(".progressNavDetail").hide();
        $(".progressNavDetail"+index).show();
    })
    $(".leftSideEdit").click(function () {
        var _span=$('.leftSide .span')
        _span.css('display','block')
       
    })
    $('.leftSide .span').children().click(function(){
        $('.leftSide').find('.span').css('display','none')
    })
    $('.leftSide .span').find('.edit').click(function(){
            var _input = $(".leftSideTable input");
            var _select = $(".leftSideTable select");
            var _disabledShelter = $(".leftSideTable .disabledShelter");
            _input.removeAttr("disabled");
            _select.removeAttr("disabled");
            _disabledShelter.hide();
           $(".leftSideBtn").css('visibility',"visible");
    })
    $(".leftSideBtn button:first").click(function () {
        var _input = $(".leftSideTable input");
        var _select = $(".leftSideTable select");
        var _disabledShelter = $(".leftSideTable .disabledShelter");
        _input.attr("disabled","disabled");
        _select.attr("disabled","disabled");
        _disabledShelter.show();
    })
    $(".leftSideBtn button:last").click(function () {
        var _input = $(".leftSideTable input");
        var _select = $(".leftSideTable select");
        var _disabledShelter = $(".leftSideTable .disabledShelter");
        _input.attr("disabled","disabled");
        _select.attr("disabled","disabled");
        _disabledShelter.show();
        $(".leftSideBtn").css('visibility',"hidden");
    });

    //点击删除图片删除文档附件
    $('.closeRed').click(function(){
        console.log(123)
        $(this).parent('.changeLabel').remove()
    })

    $('.img_del').click(function(){
        $(this).parent('._img').css('visibility','hidden')
    })

    //点击上传附件按钮
    $('.upload_file').click(function(){
          attachment()
          display_upload()
       })
     function attachment(){
            $('.filter_upload').addClass('dblock').removeClass('dnone').css('position','absolute').css('top',0).css('left',0);
            $('.filter_upload .filtermain').css('width',500).css('height',360)
            $('.filter_upload .filtermain .btngroup').css('position','absolute').css('margin','0 auto').css('bottom',0)
            $('.dz-default').remove()
            $('.add_task').addClass('dnone').removeClass('dblock');
     }
    
    
    //切换任务栏.点击任务添加
    $('.rightSideTaskNewBtn').click(function(event){
         $('.filterPop').addClass('dblock').removeClass('dnone').css('top',0).css('left',0).find('h4').text('添加文件')
         .append(' <svg class="fright cancel" viewbox="0 0 20 20"><path d="M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12z"></path>')
         $('.filterPop .filtermain').css('width',500).css('height',360)
         $('.filterPop').find('.text_area').css('position','absolute').css('margin-left',25).css('margin-top',60).css('width',450).css('height',170).find('span').remove().find('a').remove()
         $('.filterPop .filtermain').append("<div class='date'>提醒日期<label class='day' for='day'><input id='day' name='' placeholder='年/月/日' type='text' lay-key='2'></label><img class='xiala_selected' src='img/xiala.png'></div>")
         $('.filterPop .filtermain').find('.date').css('position','absolute').css('margin-top',20).css('margin-left',25)
           .css('color','#ccc').css('border-bottom','1px solid #ccc').css('width',300)
          $('.filterPop .filtermain').find('#day').css('border','none').css('margin-left',85)
          $('.filterPop .filtermain .btngroup .add').val('发布')
          $('.filterPop .filtermain .btngroup').css('position','absolute').css('left',115).css('bottom',0)
          $('.filterPop .filtermain .btngroup ._upload').css('margin-left',50).val('取消').css('color',"#7460ee").css('background',"#fff")
            laydate.render({
                        elem: '.date #day',
                        format: 'yyyy年MM月dd日',
                        theme: '#7460ee'
                    });
            console.log(123)
            display_filter()

    })
    
    
      function display_filter(){
              $('.filterPop').find('.filtermain').find("h4").on('click',"svg",function(){
              $('.filterPop').addClass('dnone').removeClass('dblock');
              $('.filterPop').find(".date").remove().find('.day').remove();
              $('.layui-laydate').remove();
        })
      }

        function display_upload(){
              $('.filter_upload').find('.filtermain').find("h4").on('click',"svg",function(){
              $('.filter_upload').addClass('dnone').removeClass('dblock');
             
        })
      }
    //判断文本有没有超过文本框
    var text_content=800; text_height=$('.customerMsg').height()*2;
    function if_text(){
              if($('.customerMsg').text().length>text_content){
                $('.dropDown').css('display','block')
                $('.dropDown').on("click", function () {
                    $('.customerMsg').css('height',text_height).css('margin-left',0);
                     $('.dropDown').css('display','none')
                      $('.dropDown_again').css('display','block')
                });
                      $('.dropDown_again').on('click',function(){
                            $('.customerMsg').css('height',text_height/2+40)
                            $('.dropDown').css('display','block')
                            $('.dropDown_again').css('display','none')
                       })
              }else{
             $('.dropDown').css('display','none')
        }
    }
    if_text()

//点击添加/拖拽文件上传
    $('#dropz').dropzone({
        url: "handle-upload.php",
        maxFiles: 5,
        maxFilesize: 512,
        acceptedFiles: ".jpg,.jpeg,.doc,.docx,.ppt,.pptx,.txt,.avi,.pdf,.mp3,.zip,.png",
        init:function(){
            this.on("addedfile",function(file){
                $('.dz-success-mark').remove();
                $('.dz-error-mark').remove();
                $('.dz-error-message').remove()
                $('.dz-progress').remove();
                $('.dz-preview').css('min-height',70).append('<img class="close_file" src="img/closeRed.png" style="width:15px;height:15px;position:absolute;right:20px;bottom:0">')
                $('.dropzone').find('span').css("display",'none')
                $('.dz-image').css('width',50).css('height',50)
                $('.dz-image').find('img').css('width',50).css('height',50)
                var fileExtension = file.name.split('.').pop().toLowerCase();
                _jpg();
        function _jpg(){
                    if(fileExtension=='txt'){
                    $('.dz-image').append('<img class="img_txt" src="img/txt.png">')
                    $('.img_txt').css('width',50).css('height',50).css('position','absolute').css('right',0).css('top',0)
                    $('.dz-image') .find('img:nth-of-type(2)').css('zIndex',2)
                    file_src();
                    
                }
                    if(fileExtension=='docx'||fileExtension=='doc'){
                    $('.dz-image').append('<img class="img_doc" src="img/word.png">')
                    $('.img_doc').css('width',50).css('height',50).css('position','absolute').css('right',0).css('top',0)
                    $('.dz-image') .find('img:nth-of-type(2)').css('zIndex',2)
                    file_src();
                }
                    if(fileExtension=='ppt'||fileExtension=='pdf'){
                        $('.dz-image').append('<img class="img_ppt" src="img/ppt3.png">')
                        $('.img_ppt').css('width',50).css('height',50).css('position','absolute').css('right',0).css('top',0)
                        $('.dz-image') .find('img:nth-of-type(2)').css('zIndex',2)
                        file_src();
                }
                    if(fileExtension=='zip'){
                        $('.dz-image').append('<img class="img_zip" src="img/zip.png">')
                        $('.img_zip').css('width',50).css('height',50).css('position','absolute').css('right',0).css('top',0)
                        $('.dz-image') .find('img:nth-of-type(2)').css('zIndex',2)
                        file_src();
                    }
                }
                function file_src(){
                    var if_src=$('.dz-image') .find('img:nth-of-type(1)')
                        if(typeof(if_src.attr('src'))=='undefined' && $('.img_txt').length>0 && $('.img_doc').length==0 && $('.img_ppt').length==0 && $('.img_zip').length==0){
                        if_src.css('zIndex',2)
                            $('.dz-image') .find('.img_txt').css('zIndex',-1)
                            $('.dz-image') .find('.img_doc').remove();
                            $('.dz-image') .find('.img_ppt').remove()
                            $('.dz-image') .find('.img_zip').remove()
                    }
                        if(typeof(if_src.attr('src'))=='undefined' && $('.img_doc').length>0 && $('.img_txt').length==0 && $('.img_ppt').length==0 && $('.img_zip').length==0){
                
                        if_src.css('zIndex',2)
                        $('.dz-image') .find('.img_doc').css('zIndex',-1)
                        $('.dz-image') .find('.img_txt').remove();
                        $('.dz-image') .find('.img_ppt').remove()
                        $('.dz-image') .find('.img_zip').remove()
                    }
                        if(typeof(if_src.attr('src'))=='undefined' && $('.img_ppt').length>0 && $('.img_doc').length==0 && $('.img_txt').length==0 && $('.img_zip').length==0){
                        
                        if_src.css('zIndex',2)
                        $('.dz-image') .find('.img_ppt').css('zIndex',-1)
                        $('.dz-image') .find('.img_doc').remove();
                        $('.dz-image') .find('.img_txt').remove()
                        $('.dz-image') .find('.img_zip').remove()
                    }
                        if(typeof(if_src.attr('src'))=='undefined' && $('.img_zip').length>0 && $('.img_doc').length==0 && $('.img_ppt').length==0 && $('.img_txt').length==0){
                    
                        if_src.css('zIndex',2)
                        $('.dz-image') .find('.img_zip').css('zIndex',-1)
                        $('.dz-image') .find('.img_doc').remove();
                        $('.dz-image') .find('.img_ppt').remove()
                        $('.dz-image') .find('.img_txt').remove()
                    }
            }
                //删除已选择的上传的文件
                $('.dz-preview').click('.close_file',function(event){
                    $(this).remove()
                        event.stopPropagation();
                    })
            });
        }
    });
        

    

   //点击编辑出现编辑框
    $('.rightSideRecord .msg').on('click','.edit_img',function(event){
       event.stopPropagation()
       console.log(123)
      $('.add_task').addClass('dblock').removeClass('dnone').css('top',0).css('left',0).find('h4').text('')
      .append(' <svg class="fright cancel" viewbox="0 0 20 20"><path d="M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12z"></path>')
          $('.add_task').addClass('dblock').removeClass('dnone').find('h5').remove()
          $('.add_task .mission').css('width',500).css('height',360)
          $('.add_task').find('.text_area').css('position','absolute').css('margin-left',25).css('width',450).css('height',210).css("padding","0 20px").find('span').remove().find('a').remove()
          $('.add_task .mission .btngroup').css('position','absolute').css('left',0).css('bottom',0)
          $('.add_task .mission .btngroup ._upload').css('margin-left',50).val('取消').css('color',"#7460ee").css('background',"#fff")
    })
 
    //点击删除
     $('.rightSideRecord .msg').on('click','.del_img',function(event){
         event.stopPropagation()
          $('.rightSideRecord .msg').remove()
     })
    
    $('.filte_mission').click('.info_upload',function(event){
        event.stopPropagation()
        attachment();
        display_upload();
    })

    //发送ajax
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
    // //关联区域
    // $('.leftSide').css('height','760%')
    var l_height=$('.leftSide').height();
    $('.rightSide').height(l_height);
    function area(){
                $('.rightSideRelation').find('li:nth-of-type(1)').click(function(){
                $('.relation').children().hide()
                $('.relevance').css('display','block')
                $('.list_div').css('display','none')
            });
                $('.rightSideRelation').find('li:nth-of-type(2)').click(function(){
                $('.relation').children().hide()
                $('.gathering').css('display','block')
                $('.list_div').css('display','none')
            });
                $('.rightSideRelation').find('li:nth-of-type(3)').click(function(){
                $('.relation').children().hide()
                $('.invoice').css('display','block')
                $('.list_div').css('display','none')
            });
                $('.rightSideRelation').find('li:nth-of-type(4)').click(function(){
                $('.relation').children().hide()
                $('.refund').css('display','block')
                $('.list_div').css('display','none')
            });
                $('.rightSideRelation').find('li:nth-of-type(5)').click(function(){
                $('.relation').children().hide()
                $('.customization').css('display','block')
                $('.list_div').css('display','none')
            });
                $('.rightSideRelation').find('li:nth-of-type(6)').click(function(){
                $('.relation').children().hide()
                $('.response').css('display','block')
                $('.list_div').css('display','none')
            });
                $('.rightSideRelation').find('li:nth-of-type(7)').click(function(){
                $('.relation').children().hide()
                $('.technical').css('display','block')
                $('.list_div').css('display','none')
            });
                $('.rightSideRelation').find('li:nth-of-type(8)').click(function(){
                $('.relation').children().hide()
                $('.project').css('display','block')
                $('.list_div').css('display','none')
            });
                $('.rightSideRelation').find('li:nth-of-type(9)').click(function(){
                $('.relation').children().hide()
                $('.customer').css('display','block')
                $('.list_div').css('display','none')
            });

       }
    area()
       //点击返回图片操作
    $('.examin').click(function(){
         $('.rightSideRelation').show()
         $('.relation').children().show();
         $('.relation').css('display','block')
         $('.relevance').css('display','none');
         $('.gathering').css('display','none');
         $('.invoice').css('display','none');
         $('.refund').css('display','none');
         $('.customization').css('display','none');
         $('.response').css('display','none');
         $('.technical').css('display','none');
         $('.project').css('display','none')
         $('.customer').css('display','none')
         $('.submit').text('提交')
         $('.draf').text('保存草稿')
    })
    //点击新增
    $('.refund').find('div:nth-of-type(6)').find('span').click(function(){
        var _before=$(this).parent().prev()
        $(_before).after(_before.clone());
    })
    var xxxx = {
        '销售合同审批': 0,
        '收款': 1,
        '开票': 2,
        '报销': 3,
        '定制报价': 4,
        '需求答复': 5,
        '技术支持': 6,
        '方案报价': 7,
        '客户拜访': 8,
    }
    //流程列表
    $('.text_click').click(function(){
         $('.list_div').css('display','block')
         $('.list_div > div').eq(xxxx[$(this).text()]).css('display', 'block');
         $('.relation').children().hide();
         $('.rightSideRelation').hide()
    })
    referral();
})

function referral() {
    //单选复选框
    $('.referralmain').find('.forCheckbox').click(function() {
        $(this).parents('tr').siblings().find('.forCheckbox').removeClass('borderPurple');
        $(this).parents('tr').siblings().find('.forCheckbox').find('input').prop('checked', false);
    });
    $('.referral').click(function(event) {
        $('.referralPop').removeClass('dnone');
    });
    $('.referralPop').find('.cancel').click(function() {
        $('.referralPop').addClass('dnone');
    });
    $('.referralPop').find('.canc').click(function() {
        $('.referralPop').addClass('dnone');
    });
    $('.referralPop').find('.sure').click(function() {
        $('.referralPop').addClass('dnone');
    });
}

