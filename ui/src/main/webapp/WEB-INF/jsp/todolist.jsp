<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
 request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title id="someTitle">首页 | KARL STORZ Endoskope</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lib/bootstrap-3.3.5/css/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lib/bootstrap-3.3.5/css/bootstrap-responsive.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lib/jquery.dataTables.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lib/dataTables.bootstrap.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lib/zTreeStyle.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lib/iconfont.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lib/jquery.mCustomScrollbar.min.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lib/autoSelect.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pages/kscc.css" type="text/css" />
	<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/icons/logo.png"/>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/lib/require.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/lib/config.js"></script>
	<style>
		.noBtn {width: 80px;} .yesBtn{width: 80px;}
		#filedownload {
			margin-top: -42px;
			margin-left: 432px;
		}
		#addText{
			height: 182px;
		}
	</style>
</head>
<body>
			    <div class="mt-10" id="tLive">
				    <table id="tblLiveApproval" class="table table-striped kscc-grid"></table>
				</div>
				<script>
                    require(["app/todolist"],function(page){
                        page.run();
                    })
				</script>
</body>
</html>