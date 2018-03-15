<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js" type="application/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/lib/enclosure.js" type="application/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/ht.js" type="application/javascript"></script>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/index.css" />
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/storz.ico"/>
    <script type="application/javascript">
        $(function () {
            $('#imgLabel').attr("src",sweets.showPic('63b09a03-a5c2-44c0-a2b5-64eed870adc0'))
        })

        function getData() {
            sweets.startService('test','getData').then(function (e) {
                var result=e.object;
                $.each(result,function (index, item) {
                    $('#div1').append('<div>'+item.title+'<div>')
                })
            })
        }
        function addData() {
            sweets.startService('test','addTodo',{param:{sex:'女'}}).then(function (e) {
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
                    sweets.startService('fileService','addFile',{param:e.object}).then(function (e2) {
                        if(e2.status==='1'){
                            alert('上传成功')
                        }
                        else{
                            console.log('入库失败')
                            //处理事物操作删除之前上传的文件
                            sweets.startService('fileService','deleteFile',{param:e.object}).then(function () {
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
</head>
<body>
<h2>Hello World!</h2>
<div>

</div>
<div>
    <button onclick="getData()">
        点我获取数据
    </button>
    <button onclick="addData()">
        点我添加数据
    </button>
        文件：<input id="file" type="file"/><br/>
    <button onclick="upload()">上传</button>
    <a href="${pageContext.request.contextPath}/hanoi"><span>hanoi</span></a>
    <a href="${pageContext.request.contextPath}/liveApproval"><span>filelist</span></a>
    <a href="${pageContext.request.contextPath}/todolist"><span>todolist</span></a>
    <img id="imgLabel"/>
    <div id="div1"></div>
</div>
</body>
</html>
