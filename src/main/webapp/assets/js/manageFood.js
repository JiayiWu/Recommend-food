/**
 * Created by StevenWu on 17/4/14.
 */
function addFood(type){
    jQuery.ajax({
        url: 'food/add',
        type: 'post',
        dataType: 'json',
        data:{
          name:$('#foodname').val(),
            type:type
        },
        success: function (data) {
            if (data.result == true) {
                swal("成功", "添加成功", "success");
                $('#foodname').val("");
                $('#tablepool').bootstrapTable('refresh');

            } else {
                swal("失败","出错啦!联系下伍佳艺吧", "error");
            }

        },
        error:function(data){
            swal("OMG", "服务器错误,联系下伍佳艺吧!", "error");
        }
    });


}




function deleteFood(){
    var ids = new Array();
    var objects = $('#tablepool').bootstrapTable('getSelections');
    for (var i = 0; i < objects.length; i++) {
        ids.push(objects[i].id);
    }
    jQuery.ajax({
        url: '/food/delete',
        type: 'post',
        dataType: 'json',
        traditional: true,
        data: {
            'orderid': ids
        },
        success: function (data) {
            if (data.result == true) {
                swal("成功", "你所选的食物已经删除", "success");

            } else {
                swal("删除失败", "出错啦!联系下伍佳艺吧", "error");
            }
            $('#tablepool').bootstrapTable('refresh');
        },
        error: function (data) {
            swal("OMG", "服务器错误,联系下伍佳艺吧!", "error");
        }
    });
}

(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
        (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
    m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
ga('create', 'UA-36708951-1', 'wenzhixin.net.cn');
ga('send', 'pageview');

function initFood(url){
    $('#tablepool').bootstrapTable({
        url: url
    });
}
