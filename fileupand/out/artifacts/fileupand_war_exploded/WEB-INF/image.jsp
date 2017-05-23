<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'image.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.min.js"></script>
  <script type="text/javascript">
  $(function(){
	  
	  $("a").click(function()
			  {
		  $("#codeImage").attr("src","${pageContext.request.contextPath }/getImage?a="+new Date().getTime());
			  });
	  
  });
  </script>
  </head>
  
  <body>
    <a href="javascript:;"><img id="codeImage" src="${pageContext.request.contextPath}/getImage"/></a><br />
    <a href="javascript:;">换一张</a>
  </body>
</html>
