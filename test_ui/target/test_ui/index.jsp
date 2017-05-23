<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <script src="http://localhost:8080/js/jquery.min.js" type="application/javascript"></script>
    <script type="application/javascript">
        $.postJSON = function(url, data, callback) {
            return jQuery.ajax({
                'type' : 'POST',
                'url' : url,
                'contentType' : 'application/json',
                'data' : JSON.stringify(data),
                'dataType' : 'json',
                'success' : callback
            });
        };
        function toController(){
                $.postJSON(
                   "http://localhost:8080/toGet",{name:'超级'},function (data) {
                        $('#div1').append('<div>'+data[0].name+'<div>')
                    }
                )
        }
    </script>
</head>
<body>
<h2>Hello World!</h2>
<div>
    <button onclick="toController()">
        点我
    </button>
    <div id="div1"></div>
</div>
</body>
</html>
