<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <script src="http://localhost:8080/js/jquery.min.js" type="application/javascript"></script>
    <script src="http://localhost:8080/js/enclosure.js" type="application/javascript"></script>
    <script type="application/javascript">
        function getData() {
            fableService("test","getData",function (e) {
                $('#div1').append('<div>'+e.data+'<div>')
            })
        }
    </script>
</head>
<body>
<h2>Hello World!</h2>
<div>
    <button onclick="getData()">
        点我获取数据
    </button>
    <div id="div1"></div>
</div>
</body>
</html>
