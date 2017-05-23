<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">

function Circle(r)
	{
	this.r=r;
	}
Circle.PI=3.14159;
Circle.prototype.area=function()
 	{
	return Circle.PI*this.r*this.r;
	};
	
	var c=new Circle(2.0);
	alert(c.area());
	
	//第2种写法  
	var Circle = function() {  
	   var obj = new Object();  
	   obj.PI = 3.14159;  
	     
	   obj.area = function( r ) {  
	       return this.PI * r * r;  
	   };  
	   return obj;  
	};  
	  
	var c = new Circle();  
	alert( c.area( 1.0 ) );  

	//第3种写法  
	var Circle = new Object();  
	Circle.PI = 3.14159;  
	Circle.Area = function( r ) {  
	       return this.PI * r * r;  
	};  
	  
	alert( Circle.Area( 1.0 ) );  

	//第4种写法  
	var Circle={  
	   "PI":3.14159,  
	 "area":function(r){  
	          return this.PI * r * r;  
	        }  
	};  
	alert( Circle.area(1.0) );  

	//第5种写法  
	var Circle = new Function("this.PI = 3.14159;this.area = function( r ) {return r*r*this.PI;}");  
	  
	alert( (new Circle()).area(1.0) );  
</script>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
