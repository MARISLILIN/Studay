
//捕捉到键盘弹起的事件
/*$(document).ready(function () {

});*/
$(function () {
    $("#word").keyup(function () {
        //获取输入框的值
        // var word = $("#word").val();
        var word = $(this).val();

        if (word == "") {
            $("#div01").hide();
        } else {
            //请求数据
            $.post("/webStudy/FindWordsServlet",{word:word}, function (data, status) {
                $("#div01").show();
                $("#div01").html(data);
            });
        }

    })
});
