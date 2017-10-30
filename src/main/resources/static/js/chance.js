$(function() {
    allCheck();



    $('.main').niceScroll({
        cursorcolor: '#ccc'
    });
//
   
//
    
    checkboxClick();
    $('.customerNum span').text($('#table tbody tr').length);
    
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

    forTable();

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
        alert(1)
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
        for(var i = 0; i < $('tbody').find('tr').length; i++) {
            if($(this).prop('checked') == true) {
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

    

    $('body').on('click', 'tbody tr', function() {
        location.href="editCustomer.html";
    });
}