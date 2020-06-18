<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1
    	user-scalable=no">
<!-- 包含 bootstrap 样式表 -->
<link rel="stylesheet" href="BootStrap/css/bootstrap.min.css">
<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
<!-- 可选: 包含 jQuery 库 -->
<script src="BootStrap/js/jquery-3.1.1.js"></script>
<!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
<script src="BootStrap/js/bootstrap.min.js"></script>
<title>学生框架</title>
<!--学生的整体框架-->
<script type="text/javascript">
	$(document).ready(function() {

		//主页
		$("a.navbar-brand").click(function() {
			$("iframe").attr("src", "/WorkManageSystem/student/s_home?c_id=${student.s_c_id }&s_account=${student.s_account }");
			//面包屑导航
			$("ol.breadcrumb").html("<li><a href='javascript:void(0)''>首页</a></li>"); 
		});

		//个人设置
		$("a.personalseting").click(function() {
			$("iframe").attr("src", "/WorkManageSystem/student/s_personalseting");
			//面包屑导航
			$("ol.breadcrumb").html("<li><a href='javascript:void(0)''>首页</a></li>"+"<li class='active'>个人设置</li>");
		});

		//上传作业
		$("a.upload").click(function() {
			$("iframe").attr("src", "/WorkManageSystem/student/s_uploadwork_jsp?s_account=${student.s_account }");
			//面包屑导航
			$("ol.breadcrumb").html("<li><a href='javascript:void(0)''>首页</a></li>"+"<li class='active'>上传作业</li>");
		});

		/* //下载作业
		$("a.download").click(function() {
			$("iframe").attr("src", "/WorkManageSystem/student/s_downloadwork");
			//面包屑导航
			$("ol.breadcrumb").html("<li><a href='javascript:void(0)''>首页</a></li>"+"<li class='active'>下载作业</li>");
		}); */

		//查看批阅
		$("a.showcheck").click(function() {
			$("iframe").attr("src", "/WorkManageSystem/student/s_showcheck?s_account=${student.s_account }");
			//面包屑导航
			$("ol.breadcrumb").html("<li><a href='javascript:void(0)''>首页</a></li>"+"<li class='active'>查看批阅</li>");
		});
	});
</script>
</head>
<body>
	<%-- <%
	if(session.getAttribute("visited") == null) {
		out.print("<script language='javascript'>alert('请先登录系统！');window.location = 'login.jsp';</script>");
	}
	%> --%>
	<!--整个页面栅格-->
	<div class="container-fluid"
		style="background-color: blasck; margin-left: 100px; margin-right: 100px; padding-top: 0px;">
		<div class="row-fluid">
			<div class="span12">

				<!--系统头部-->
				<div class="page-header"
					style="margin-top: 0px; height: 42px; clear: all;">
					<h1 class="text-center">
						<span><strong>作业管理系统</strong></span>
						<!-- <img src="img/bom.gif" style="margin-left: 12%;"> -->
					</h1>
				</div>

				<!--菜单栏-->
				<nav class="navbar navbar-default" role="navigation">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span><span
								class="icon-bar"></span><span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#"><span
							class="glyphicon glyphicon-pencil" style="font-size: 25px;"></span></a>
					</div>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="#" class="dropdown-toggle upload">上传作业</a></li>
							<!-- <li><a href="#" class="dropdown-toggle download">下载作业</a></li> -->
							<li><a href="#" class="dropdown-toggle showcheck">查看批阅</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li>
								<!-- <a href="#"><span class="glyphicon glyphicon-envelope" style="font-size: 20px;"></a>
								--> <img src="img/header.gif" class="img-circle"
								style="width: 40px; height: 40px;">
							</li>
							<li><strong><span style="line-height:55px;">学生:&nbsp;${student.s_name  }</span></strong></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"><span
									class="glyphicon glyphicon-user" style="font-size: 20px;"></span><strong
									class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a href="#">学生：&nbsp;${student.s_name  }</a></li>
									<li><a href="#" class="personalseting">个人设置</a></li>
									<li class="divider"></li>
									<li><a href="logout"><span class="glyphicon glyphicon-off"></span>注 销</a></li>
								</ul></li>
						</ul>
					</div>

				</nav>
			

				<!--面包屑导航-->
				<ol class="breadcrumb">
					<li><a href="javascript:void(0)">首页</a></li>
				</ol>
	
				<!--iframe框架内容-->
				<div class="row-fluid">
					<div class="span12">
						<div style="height: 1000px;">
							<iframe src="/WorkManageSystem/student/s_home?c_id=${student.s_c_id }&s_account=${student.s_account}" frameborder="0"
								seamless="seamless" marginheight="0px" marginwidth="0px"
								width="100%" height="100%""></iframe>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>