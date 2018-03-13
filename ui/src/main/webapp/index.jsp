<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <script src="http://localhost:8080/js/jquery.min.js" type="application/javascript"></script>
    <script src="http://localhost:8080/js/enclosure.js" type="application/javascript"></script>
    <script src="http://localhost:8080/js/ht.js" type="application/javascript"></script>
    <link rel="stylesheet" type="text/css"
          href="http://localhost:8080/css/index.css" />
    <link rel="shortcut icon" type="image/x-icon" href="http://localhost:8080/img/storz.ico"/>
    <script type="application/javascript">
        $(function () {
            $('#imgLabel').attr("src",sweets.getOptions()+'baseController/showPic/63b09a03-a5c2-44c0-a2b5-64eed870adc0')
        })

        function getData() {
            var param={serviceId:'test',method:'getData'}
            sweets.startService(param).then(function (e) {
                var result=e.data;
                $.each(result,function (index, item) {
                    $('#div1').append('<div>'+item.title+'<div>')
                })
            })
        }
        function addData() {
            var param={serviceId:'test',method:'addTodo',param:{sex:'男'}}
            sweets.startService(param).then(function (e) {
                if(e.status==='1'){
                    alert('添加成功')
                }
                else{
                    alert(e.tips)
                }
            })
        }
        function getPageData() {
            var param={serviceId:'test',method:'getPageData',pageNo:1,pageSize:10,param:{title:'张三'}}
            sweets.startService(param).then(function (e) {
                var result=e.list;
                $.each(result,function (index, item) {
                    $('#div1').append('<div>'+item.title+'<div>')
                })
            })
        }

        function deleteFile() {
            var param={serviceId:'fileService',method:'deleteFile',param:{fileUrl:'75819a54-3f07-46d6-92e1-57419276d2f4'}}
            sweets.startService(param).then(function (e) {
                if(e.status==='1'){
                    alert('删除成功')
                }
                else{
                    alert(e.tips)
                }
            })
        }
        function upload() {
            sweets.upload('file',function (e) {
                console.log(e.data)
                alert('上传成功')
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
        点我获取数据perfect
    </button>
    <button onclick="addData()">
        点我添加数据
    </button>
    <button onclick="getPageData()">
        点我获取分页数据
    </button>
        文件：<input id="file" type="file"/><br/>
    <button onclick="upload()">上传</button>
    <a href="http://localhost:8080/hanoi"><span>hanoi</span></a>
    <a href="http://localhost:8080/liveApproval"><span>liveApproval</span></a>
    <a href="http://localhost:8080/baseController/download/美图.docx/75819a54-3f07-46d6-92e1-57419276d2f4">下载</a>
    <button onclick="deleteFile()">
        删除文件
    </button>
    <img id="imgLabel"/>
    <div id="div1"></div>
</div>
</body>
</html>
