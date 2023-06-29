//初始化Markdown编辑器
$(function() {
    var editor = editormd("md-content", {
        width: "80%",
        height: "800px",
        path : "/lib/",  //选中editormd下的lib下的所有文件
        emoji: true,
        placeholder: '',
    });
});

