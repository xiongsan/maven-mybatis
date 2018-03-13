;(function ($) {
    //插件所有功能都写在这个函数下

    const options={
        async:true,
        serverPath:'http://' + window.location.host + window.location.pathname
    }

    /**
     * 对Date的扩展，将 Date 转化为指定格式的String
     * 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
     * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
     * 例子：
     * (new Date()).Format("YYYY-MM-DD HH:mm:S") ==> 2006-07-02 08:09:04
     * (new Date()).Format("YYYY-M-D H:m:S")      ==> 2006-7-2 8:9:4
     * @param fmt
     * @returns {*}
     */
    Date.prototype.format = function (fmt) {
        var o = {
            "M+": this.getMonth() + 1,                 //月份
            "D+": this.getDate(),                    //日
            "H+": this.getHours(),                   //小时
            "m+": this.getMinutes(),                 //分
            "S+": this.getSeconds(),                 //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "s": this.getMilliseconds()             //毫秒
        };
        if (/(Y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }

    /**
     * 字符串转日期,参数里面填,默认是YYYY-MM-DD
     * @param pattern
     * @returns {Date}
     */
    String.prototype.toDate = function (pattern = 'YYYY-MM-DD') {
        let date = new Date()
        if (pattern.indexOf("YYYY") > -1) {
            const yearIndex = pattern.indexOf("YYYY")
            date.setFullYear(this.substring(yearIndex,yearIndex+4))
        }
        if(pattern.indexOf("MM")>-1){
            const monthIndex = pattern.indexOf("MM")
            date.setMonth(this.substring(monthIndex,monthIndex+2)-1)
        }
        if(pattern.indexOf("DD")>-1){
            const dayIndex = pattern.indexOf("DD")
            date.setDate(this.substring(dayIndex,dayIndex+2))
        }
        if(pattern.indexOf("HH")>-1){
            const hourIndex = pattern.indexOf("HH")
            console.log('hehe')
            date.setHours(this.substring(hourIndex,hourIndex+2))
        }
        if(pattern.indexOf("mm")>-1){
            const minutesIndex = pattern.indexOf("mm")
            date.setMinutes(this.substring(minutesIndex,minutesIndex+2))
        }
        if(pattern.indexOf("SS")>-1){
            const secondsIndex = pattern.indexOf("SS")
            date.setSeconds(this.substring(secondsIndex,secondsIndex+2))
        }
        return date
    }


    const ajaxService=function (serviceId,method,param,callback,failCallback) {
        let url = `/baseController/service?serviceId=${serviceId}&method=${method}`
        $.ajax({
            url: url,
            type: 'POST',
            async: options.async,
            dataType: 'json',
            data:{param:JSON.stringify(param)},
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
        startService: function (serviceId,method,param) {
            return new Promise(function (resolve, reject) {
                return ajaxService(serviceId,method,param, resolve, reject);
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
