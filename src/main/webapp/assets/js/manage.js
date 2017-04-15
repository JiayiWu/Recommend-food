/**
 * Created by StevenWu on 17/2/11.
 */


$(function(){
    init();
});

function init(){
    initFood("/food/list?type=0");

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
                $("#select_k1").change(function () {
                    if ($(this).val() == "no-carry") {
                        addFood(0);
                    } else {
                        addFood(4);
                    }
                });
            });
    });

    $('#deleteC').click(function(){
        deleteFood();
    })

}



