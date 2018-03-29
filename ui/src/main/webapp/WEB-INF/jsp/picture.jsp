<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
 request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title id="someTitle">任务列表</title>
	<link rel="stylesheet" href="/css/lib/bootstrap-3.3.5/css/bootstrap.min.css" type="text/css" />
	<link rel="shortcut icon" type="image/x-icon" href="/images/icons/logo.png"/>
	<script type="text/javascript" charset="utf-8" src="/js/lib/require.js"></script>
	<script type="text/javascript" charset="utf-8" src="/js/jquery.js"></script>
	<script type="text/javascript" charset="utf-8" src="/js/lib/bootstrap.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="/js/lib/config.js"></script>
</head>
<body>
<div id="myCarousel" class="carousel slide" style="width: 60%;height:100%;margin: 0 auto;overflow: hidden;">
	<!-- 轮播（Carousel）指标 -->
	<ol class="carousel-indicators">
	</ol>
	<!-- 轮播（Carousel）项目 -->
	<div class="carousel-inner">
	</div>
	<!-- 轮播（Carousel）导航 -->
	<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		<span class="sr-only">Previous</span>
	</a>
	<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		<span class="sr-only">Next</span>
	</a>
</div>
<script>
    require(["app/picture"],function(page){
        page.run();
    })
</script>
</body>
</html>