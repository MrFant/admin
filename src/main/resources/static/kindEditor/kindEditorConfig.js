// var _kindEditor_;
// KindEditor.ready(function(K) {
//     _kindEditor_ = K.create('#kindEditorContent', {
//         uploadJson : '/kindEditor/uploadFile',//上传图片
//         allowFileManager : true,//true或false，true时显示浏览服务器图片功能。
//         afterBlur: function () { this.sync(); }//数据同步
//     });
// });
var editor;
KindEditor.options.filterMode = false;
KindEditor.ready(function (K) {
    editor = K.create('textarea[name="content"]', {
        uploadJson: '/kindEditor/uploadFile',
        allowFileManager: true,
        afterBlur: function () {
            this.sync();
        }
    });
    prettyPrint();
});