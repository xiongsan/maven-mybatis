;(function ($) {
    //插件所有功能都写在这个函数下

    var serverPath = 'http://' + window.location.host + window.location.pathname;

    var async = true;

    var param = {};

    var api = {
        config: function (opts) {
            //没有参数传入，直接返回默认参数
            if(!opts) return serverPath;
            //有参数传入，通过key将options的值更新为用户的值
            param={}
            for(var key in opts) {
                if(key==='async'){
                    async = opts[async];
                }
                else{
                    param[key] = opts[key];
                }
            }
            return this;
        },
        listen: function listen(elem) {
            //...
            return this;
        },
        startService: function () {
            let url = "/baseController/service"
            $.ajax({
                url: url,
                type: 'POST',
                async: async,
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify(param),
                success: function (data) {
                    param.callback(data)
                }
            })
        },
        upload: function (param,callback) {
            var files=document.getElementById(param).files
            if(!files.length){
                alert('请选择要上传的文件')
                return
            }
            let formData = new FormData();
            formData.append("file", files[0]);
            $.ajax({
                url: "/baseController/upload",
                type: "POST",
                data: formData,
                contentType: false,
                processData: false,
                success: function (e) {
                    callback(e)
                },
                error: function () {
                    alert("上传失败！");
                }
            });
        }
    }
    this.sweets=api
})(jQuery);
