/**
 * Created by StevenWu on 17/2/11.
 */




function init(type){
    var tem = "/food/list?type="+type;
    initFood(tem);

    $('#add').click(function(){
        $('#myModal').modal('toggle');
        $("#myModal").modal().css({
            "margin-top": function () {
                return ($(this).height() / 5);
            }
        });
        $('#confirmB').unbind('click');
        $('#confirmB').click(
           function(){
               addFood(type);
           }
        )
    });

    $('#deleteC').click(function(){
        deleteFood();
    })

}



