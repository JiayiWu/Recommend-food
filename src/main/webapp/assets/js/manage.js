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
               var tem1 = $("#select_k1 option:selected").val();
                    if (tem1 == "no-carry") {

                        addFood(0);
                    } else {
                        addFood(4);
                    }

            });
    });

    $('#deleteC').click(function(){
        deleteFood();
    })

}



