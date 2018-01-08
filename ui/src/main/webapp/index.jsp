<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <script src="http://localhost:8080/js/jquery.min.js" type="application/javascript"></script>
    <script src="http://localhost:8080/js/enclosure.js" type="application/javascript"></script>
    <link rel="stylesheet" type="text/css"
          href="http://localhost:8080/css/index.css" />
    <script type="application/javascript">
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
    <div class="ellipse common"></div>
    <div class="ellipse1 common"></div>
    <div class="ellipse2 common"></div>
    <div id="div1"></div>
</div>
</body>
</html>
