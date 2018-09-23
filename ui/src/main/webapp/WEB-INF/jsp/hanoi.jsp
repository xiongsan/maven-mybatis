<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>汉诺塔</title>
    <style>
        html, body {
            padding: 0px;
            margin: 0px;
        }
        .main {
            margin: 0px;
            padding: 0px;
            position: absolute;
            top: 0px;
            bottom: 0px;
            left: 0px;
            right: 0px;
        }
    </style>
    <link rel="stylesheet" type="text/css"
          href="/abc/css/hanoi.css" />
    <script src="/abc/js/jquery.min.js" type="application/javascript"></script>
    <script src="/abc/js/ht.js" type="application/javascript"></script>
    <script src="/abc/js/randomColor.js" type="application/javascript"></script>
    <script src="/abc/js/easing.js" type="application/javascript"></script>
    <script src="/abc/js/index.js" type="application/javascript"></script>

</head>
<body onload="init()">
<div class="count-container">
    <div class="count">
        <div id="num6" class="num">0</div>
    </div>
    <div class="count">
        <div id="num5" class="num">0</div>
    </div>
    <div class="count">
        <div id="num4" class="num">0</div>
    </div>
    <div class="count">
        <div id="num3" class="num">0</div>
    </div>
    <div class="count">
        <div id="num2" class="num">0</div>
    </div>
    <div class="count">
        <div id="num1" class="num">0</div>
    </div>
    <div class="count">
        <div id="num0" class="num">0</div>
    </div>
</div>
</body>
</html>
