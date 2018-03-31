<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<html>
<head>
    <script src="/js/jquery.min.js" type="application/javascript"></script>
    <script src="/js/lib/enclosure.js" type="application/javascript"></script>
    <script src="/js/ht.js" type="application/javascript"></script>
    <link rel="stylesheet" type="text/css"
          href="/css/index.css" />
    <link rel="shortcut icon" type="image/x-icon" href="/img/storz.ico"/>
    <script type="application/javascript">
        $(function () {
            $('#imgLabel').attr("src",sweets.showPic('63b09a03-a5c2-44c0-a2b5-64eed870adc0'))
        })

        function getData() {
            sweets.startService('todoListServiceImpl','getData').then(function (e) {
                var result=e.object;
                $.each(result,function (index, item) {
                    $('#div1').append('<div>'+item.title+'<div>')
                })
            })
        }
        function addData() {
            sweets.startService('todoListServiceImpl','addTodo',{param:{sex:'女'}}).then(function (e) {
                if(e.status==='1'){
                    console.log('addTodo success')
                }
                else{
                    alert(e.tips)
                }
            })
        }
        function upload() {
            sweets.upload('file',function (e) {
                if(e.status==='1'){
                    sweets.startService('fileServiceImpl','addFile',{param:e.object}).then(function (e2) {
                        if(e2.status==='1'){
                            alert('上传成功')
                        }
                        else{
                            console.log('入库失败')
                            //处理事物操作删除之前上传的文件
                            sweets.startService('fileServiceImpl','deleteFile',{param:e.object}).then(function () {
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
        <a href="/hanoi"><span>hanoi</span></a>
        <shiro:hasPermission name="/liveApproval"><a href="/liveApproval"><span>filelist</span></a></shiro:hasPermission>
        <a href="/todolist"><span>todolist</span></a>
        <a href="/picture"><span>picture</span></a>
        <div id="div1"></div>
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
