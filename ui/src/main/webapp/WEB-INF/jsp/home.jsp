<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<html>
<head>
    <script src="/abc/js/jquery.min.js" type="application/javascript"></script>
    <script src="/abc/js/lib/enclosure.js" type="application/javascript"></script>
    <script src="/abc/js/ht.js" type="application/javascript"></script>
    <link rel="stylesheet" type="text/css"
          href="/abc/css/index.css" />
    <link rel="shortcut icon" type="image/x-icon" href="/img/storz.ico"/>
    <script type="application/javascript">
        $(function () {
            $('#imgLabel').attr("src",sweets.showPic('d6e163b4-7e30-4c70-b97c-f34ab00f1ec0'))
        })

        function getData() {
//            sweets.startService('todoListServiceImpl','getData').then(function (e) {
//                var result=e.object;
//                $.each(result,function (index, item) {
//                    $('#div1').append('<div>'+item.title+'<div>')
//                })
//            })
            var url="ws://"+sweets.getOptions().substr(7)+"/websocket";
//            if(ws){
//                ws.close();
//            }
                    var ws=new WebSocket(url);
                    ws.onmessage=function (e) {
                        console.log(e.data)
                    }
                    ws.onclose=function (e) {
                        console.log("websocket is closed")
                    }
        }
        function addData() {
            sweets.startService({
                serviceId: 'todoListServiceImpl',
                method: 'addTodoTest',
                param: {sex: '女'}
            }).then(function (e) {
                if (e.status === '1') {
                    console.log('addTodo success')
                }
                else {
                    alert(e.tips)
                }
            })
        }
        function upload() {
            sweets.upload('file',function (e) {
                console.log(e,'e================')
                if(e.status==='1'){
                    sweets.startService({serviceId:'fileServiceImpl',method:'addFile',param:e.data}).then(function (e2) {
                        if(e2.status==='1'){
                            alert('上传成功')
                        }
                        else{
                            console.log('入库失败')
                            //处理事物操作删除之前上传的文件
                            sweets.startService({serviceId:'fileServiceImpl',method:'deleteFile',param:e.data}).then(function () {
                                if(e.status==='1'){
                                    alert('事务：处理删除文件成功')
                                }
                                else{
                                    alert('事务：处理删除文件失败')
                                }
                            })
                        }
                    })
                }
            })
        }
    </script>
    <style type="text/css">
        *{
            padding:0;
            margin:0;
        }
        .images-content{
            position: absolute;
            z-index: 1;
            left: 50px;
            top: 0;
            color: #fff;
            overflow: hidden;
        }
        .images-wrapper{
            height: 100%;
            position: relative;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div class="images-wrapper">
    <img id="imgLabel"/>
    <div class="images-content">
        <h2>Hello World!</h2>
        <button onclick="getData()">
            点我获取数据
        </button>
        <button onclick="addData()">
            点我添加数据
        </button>
        文件：<input id="file" type="file"/><br/>
        <button onclick="upload()">上传</button>
        <a href="/abc/baseController/toView/hanoi"><span>hanoi</span></a>
        <shiro:hasPermission name="/liveApproval"><a href="/abc/baseController/toView/liveApproval"><span>filelist</span></a></shiro:hasPermission>
        <a href="/abc/baseController/toView/todolist"><span>todolist</span></a>
        <a href="/abc/baseController/toView/picture"><span>picture</span></a>
        <div id="div1"></div>
<%--        <video width="352" height="264" controls >--%>
<%--            <source src="/abc/img/diezhongdie.mp4" type='video/mp4; codecs="avc1.42E01E, mp4a.40.2"'/>--%>
<%--        </video>--%>
    </div>
</div>
<script type="application/javascript">
    var height=document.body.clientHeight;
    var width=height*0.75
    $('#imgLabel').css({height:height,width:width})
    $('.images-wrapper').css({width:width})
</script>
</body>
</html>
