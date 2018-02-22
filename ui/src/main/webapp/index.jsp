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
            $('#imgLabel').attr("src",serverPath+'showPic/63b09a03-a5c2-44c0-a2b5-64eed870adc0')
        })
        function getData() {
            fableService("test","getData",function (e) {
                var result=e.data;
                $.each(result,function (index, item) {
                    $('#div1').append('<div>'+item.title+'<div>')
                })

            })
        }
        function addData() {
            fableService("test","addTodo",{sex:'男'},function (e) {
                if(e.status==='1'){
                    alert('添加成功')
                }
            })
        }
        function getPageData() {
            fableService("test","getPageData",{pageNo:1,pageSize:4},function (e) {
                var result=e.data.data;
                $.each(result,function (index, item) {
                    $('#div1').append('<div>'+item.title+'<div>')
                })
            })
        }

        function deleteFile() {
            fableService("fileService","deleteFile",{fileUrl:'123'},function (e) {
               if(e.status==='1'){
                   alert('删除成功')
               }
               else{
                   alert(e.tips)
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
    <button onclick="getPageData()">
        点我获取分页数据
    </button>
        文件：<input id="file" type="file"/><br/>
    <button onclick="upload('file')">上传</button>
    <a href="http://localhost:8080/hanoi"><span>hanoi</span></a>
    <a href="http://localhost:8080/download/美图.png/7ce9e88a-4c61-4a04-b04c-b506dc3ad694">下载</a>
    <button onclick="deleteFile()">
        删除文件
    </button>
    <img id="imgLabel"/>
    <div id="div1"></div>
</div>
</body>
</html>
