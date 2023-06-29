//start ====================上传文件====================
$('#uploadImage').click(function () {
    // 设置上传密码，防止恶意上传
    layer.prompt({
        formType: 1
        ,title: '请输入上传密钥'
        ,area: ['150px', '30px']
        ,resize: false
    }, function (value, index, elem) {
        if (checkPassword(value)) {
            var categoryId = document.getElementById("categoryId").innerText
            layui.upload.render({
                elem: '#uploadImage'
                ,url: '/upload/img/' + categoryId/*+ categoryId*/ //此处用的是第三方的 http 请求演示，实际使用时改成您自己的上传接口即可。
                ,method: 'post'
                ,field: 'files'
                ,multiple: true
                ,auto: true
                ,size: '100M'
                ,number: 10
                ,accept: 'images'
                ,acceptMime: 'image/*'
                ,exts: 'jpg|png|jpeg'
                ,done: function(res, index, upload){
                    layer.msg(res.msg);
                }
                ,error: function (index, upload) {
                    layer.msg(res.msg);
                }
            });
            // 关闭弹框
            layer.close(index);
        } else {
            layer.msg("密钥错误");
        }
    });
})
function checkPassword(password) {
    // 异步验证密码，callback 参数接收验证结果
    // 省略具体实现
    return password === '123456'
}

//end ====================上传文件====================