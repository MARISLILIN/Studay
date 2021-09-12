
$(function () {
    //找到省份的元素
    $("#province").change(function () {
        //一旦里面的值发生了改变，去请求该省份的城市
        var pid = $(this).val();
        /*
        * <list>
                <city>
                    <id>1</id>
                    <pid>1</pid>
                    <cname>深圳</cname>
                </city>
                <city>
                    <id>2</id>
                    <pid>1</pid>
                    <cname>广州</cname>
                </city>
                <city>
                    <id>3</id>
                    <pid>1</pid>
                    <cname>惠州</cname>
                </city>
          </list>*/
        $.post("/webStudy/CityServlet", {pid:pid}, function (data) {
            //先清空以前的值
            $("#city").html("<option value='" + "' >-请选择-</option>");

            //遍历，先找出所有的city，遍历所有的city
            $(data).find("city").each(function () {
                //取孩子
                var id = $(this).children("id").text();
                var cname = $(this).children("cname").text();

                $("#city").append("<option value='" + id + "' >" + cname + "</option>");
            });
        });


    });

});
