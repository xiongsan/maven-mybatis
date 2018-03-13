<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
 request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title id="someTitle">首页 | KARL STORZ Endoskope</title>
	<link rel="stylesheet" href="http://localhost:8080/css/lib/bootstrap-3.3.5/css/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="http://localhost:8080/css/lib/bootstrap-3.3.5/css/bootstrap-responsive.css" type="text/css" />
	<link rel="stylesheet" href="http://localhost:8080/css/lib/jquery.dataTables.css" type="text/css" />
	<link rel="stylesheet" href="http://localhost:8080/css/lib/dataTables.bootstrap.css" type="text/css" />
	<link rel="stylesheet" href="http://localhost:8080/css/lib/zTreeStyle.css" type="text/css" />
	<link rel="stylesheet" href="http://localhost:8080/css/lib/iconfont.css" type="text/css" />
	<link rel="stylesheet" href="http://localhost:8080/css/font-awesome.min.css" type="text/css" />
	<link rel="stylesheet" href="http://localhost:8080/css/lib/jquery.mCustomScrollbar.min.css" type="text/css" />
	<link rel="stylesheet" href="http://localhost:8080/css/lib/autoSelect.css" type="text/css" />
	<link rel="stylesheet" href="http://localhost:8080/css/pages/kscc.css" type="text/css" />
	<link rel="shortcut icon" type="image/x-icon" href="http://localhost:8080/images/icons/logo.png"/>
	<script type="text/javascript" charset="utf-8" src="http://localhost:8080/js/lib/require.js"></script>
	<script type="text/javascript" charset="utf-8" src="http://localhost:8080/js/jquery.js"></script>
	<script type="text/javascript" charset="utf-8" src="http://localhost:8080/js/lib/config.js"></script>
	<script src="http://localhost:8080/js/enclosure.js" type="application/javascript"></script>
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
                    require(["app/liveApprovalApp"],function(page){
                        page.run();
                    })
				</script>
</body>
</html>