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
            $('#imgLabel').attr("src",sweets.config()+'baseController/showPic/63b09a03-a5c2-44c0-a2b5-64eed870adc0')
        })
        function getData() {
            sweets.config({serviceId:'test',method:'getData',callback:function (e) {
                var result=e.data;
                $.each(result,function (index, item) {
                    $('#div1').append('<div>'+item.title+'<div>')
                })
            }}).startService()
        }
        function addData() {
            sweets.config({serviceId:'test',method:'addTodo',param:{sex:'男'},callback:function (e) {
                if(e.status==='1'){
                    alert('添加成功')
                }
                else{
                    alert(e.tips)
                }
            }}).startService()
        }
        function getPageData() {
            sweets.config({serviceId:'test',method:'getPageData',pageNo:1,pageSize:10,param:{title:'张三'},callback:function (e) {
                var result=e.list;
                $.each(result,function (index, item) {
                    $('#div1').append('<div>'+item.title+'<div>')
                })
            }}).startService()
        }

        function deleteFile() {
            sweets.config({serviceId:'fileService',method:'deleteFile',param:{fileUrl:'4f773423-4bfb-483a-ac73-3d729d9a600a'},callback:function (e) {
                if(e.status==='1'){
                    alert('删除成功')
                }
                else{
                    alert(e.tips)
                }
            }}).startService()
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
        点我获取数据
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
    <a href="http://localhost:8080/baseController/download/美图.png/7ce9e88a-4c61-4a04-b04c-b506dc3ad694">下载</a>
    <button onclick="deleteFile()">
        删除文件
    </button>
    <img id="imgLabel"/>
    <div id="div1"></div>
</div>
</body>
</html>
