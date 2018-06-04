<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>maven-mybatis-redux</title>
</head>
<body>
<div id="app"></div>
<script>
    var host=window.location.host;//主机名加端口号
    var path='http://'+host;
    var clientIp='<%=request.getRemoteHost()%>';
</script>
<script type="text/javascript" charset="utf-8" src = "http://localhost:3000/dist/main.bundle.js"></script>
</body>
</html>
