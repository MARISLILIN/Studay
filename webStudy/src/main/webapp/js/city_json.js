
$(function () {
    //找到省份的元素
    $("#province").change(function () {
        //一旦里面的值发生了改变，去请求该省份的城市
        var pid = $(this).val();

        /*[
            {
                "cname":"深圳",
                "pid":1,
                "id":1
             },
            {
                "cname":"广州",
                "pid":1,
                "id":2
             },
            {
                "cname":"惠州",
                "pid":1,
                "id":3
             }
          ]
            */
        $.post("/webStudy/CityServlet02", {pid:pid}, function (data) {
            $("#city").html("<option value='" + "' >-请选择-</option>");

            $(data).each(function (index, c) {
                $("#city").append("<option value='" + c.id + "' >" + c.cname + "</option>");
            });
        }, "json");


    });

});
