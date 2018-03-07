;(function ($) {
    //插件所有功能都写在这个函数下

    const options={
        async:true,
        serverPath:'http://' + window.location.host + window.location.pathname
    }

    const ajaxService=function (param,callback,failCallback) {
        let url = "/baseController/service"
        $.ajax({
            url: url,
            type: 'POST',
            async: options.async,
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(param),
            success: function (data) {
                callback(data)
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(`数据获取失败:${url}`)
                failCallback ? failCallback(errorThrown) : void (0)
            }
        })
        /*options.async如果被设置成false，在生命周期内，就永远为false，不方便之后代码调用*/
        !options.async?options.async=true:void(0)
    }

    this.sweets = {
        config: function (opts) {
            //没有参数传入，直接返回默认参数
            if(!opts) return this;
            //有参数传入，通过key将options的值更新为用户的值
            for(var key in opts) {
              options[key]=opts[key]
            }
            return this;
        },
        listen: function listen(elem) {
            //...
            return this;
        },
        getOptions:function () {
            return options.serverPath
        },
        startService: function (param) {
            return new Promise(function (resolve, reject) {
                return ajaxService(param, resolve, reject);
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
})(jQuery);
