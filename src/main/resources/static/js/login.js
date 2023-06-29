
layui.use(['layer', 'jquery', 'form'], function () {
    var layer = layui.layer;
    var $ = layui.jquery;
    var form = layui.form;

    form.on('submit(login)', function (data) {
        $.ajax({
            url: '/login',
            type: 'POST',
            data: data.field,
            success: function (response) {
                // console.log(response);
                layer.msg(response.msg)
            }
        });
        // 防止表单跳转
        return false;
    });
});
