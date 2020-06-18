<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1 user-scalable=no">
<title>教师框架</title>

<!-- 包含 bootstrap 样式表 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/BootStrap/css/bootstrap.min.css">
<!-- 可选: 包含 jQuery 库 -->
<script src="<%=request.getContextPath()%>/BootStrap/js/jquery-2.1.1.min.js"></script>
<script src="<%=request.getContextPath()%>/BootStrap/js/bootstrap.min.js"></script>

<!--教师的整体框架-->
<script type="text/javascript">
	$(document).ready(function() {

		//作业总览
		$("a.allworks").click(function() {
			/* alert($("iframe").attr("src")); */
			$("iframe").attr("src", "/WorkManageSystem/teacher/t_allworks?t_account=${teacher.t_account  }");
			//面包屑导航
			$("ol.breadcrumb").html("<li><a href='javascript:void(0)''>首页</a></li>"+"<li class='active'>作业总览</li>");
		});

		//发布作业
		$("a.publish").click(function() {
			/* alert($("iframe").attr("src")); */
			$("iframe").attr("src", "/WorkManageSystem/teacher/t_publishwork");
			//面包屑导航
			$("ol.breadcrumb").html("<li><a href='javascript:void(0)''>首页</a></li>"+"<li class='active'>发布作业</li>");
		});

		//公告总览
		$("a.allnotice").click(function() {
			/* alert($("iframe").attr("src")); */
			$("iframe").attr("src", "/WorkManageSystem/teacher/t_allnotice?t_account=${teacher.t_account  }");
			//面包屑导航
			$("ol.breadcrumb").html("<li><a href='javascript:void(0)''>首页</a></li>"+"<li class='active'>公告总览</li>");
		});

		//发布公告
		$("a.notice").click(function() {
			/* alert($("iframe").attr("src")); */
			$("iframe").attr("src", "/WorkManageSystem/teacher/t_publishnotice");
			//面包屑导航
			$("ol.breadcrumb").html("<li><a href='javascript:void(0)''>首页</a></li>"+"<li class='active'>发布公告</li>");
		});

		//提交统计
		$("a.statistics").click(function() {
			/* alert($("iframe").attr("src")); */
			$("iframe").attr("src", "/WorkManageSystem/teacher/t_statistics?t_account=${teacher.t_account  }");
			//面包屑导航
			$("ol.breadcrumb").html("<li><a href='javascript:void(0)''>首页</a></li>"+"<li class='active'>提交统计</li>");
		});

		//个人设置
		$("a.t_personalseting").click(function() {
			/* alert($("iframe").attr("src")); */
			$("iframe").attr("src", "/WorkManageSystem/teacher/t_personalseting");
			//面包屑导航
			$("ol.breadcrumb").html("<li><a href='javascript:void(0)''>首页</a></li>"+"<li class='active'>个人设置</li>");
		});
		
	});
</script>
</head>
<body>

	<!--整个页面栅格-->
	<div class="container-fluid"
		style="background-color: whitesmoke; margin-left: 100px; margin-right: 100px; padding-top: 0px;">
		<div class="row-fluid">
			<div class="span12">

				<!--系统头部-->
				<div class="page-header"
					style="margin-top: 0px; height: 42px; ">
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
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#"><span
							class="glyphicon glyphicon-pencil" style="font-size: 25px;"></span></a>
					</div>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">作业管理<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a href="#" class="allworks">总览</a></li>
									<li><a href="#" class="publish">发布作业</a></li>
									<li class="divider"></li>
									<li><a href="#" class="allworks">删 除</a></li>
								</ul></li>

							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">我的公告<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a href="#" class="allnotice">总览</a></li>
									<li><a href="#" class="notice">发布公告</a></li>
									<li class="divider"></li>
									<li><a href="#" class="allnotice">删 除</a></li>
								</ul></li>

							<li class="dropdown"><a href="#"
								class="dropdown-toggle statistics" data-toggle="dropdown">提交统计</a>

							</li>

						</ul>

						<ul class="nav navbar-nav navbar-right">
							<li>
								<!-- <a href="#"><span class="glyphicon glyphicon-envelope" style="font-size: 20px;"></a>
								--> <img src="<%=request.getContextPath()%>/img/header.gif" class="img-circle"
								style="width: 40px; height: 40px;">
							</li>
							<li><strong><span style="line-height:55px;">教师:&nbsp;${teacher.t_name  }</span></strong></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"><span
									class="glyphicon glyphicon-user" style="font-size: 20px;"></span><strong
									class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a href="#">教师： &nbsp;${teacher.t_name  }</a></li>
									<li><a href="#" class="t_personalseting">个人设置</a></li>
									<li class="divider"></li>
									<li><a href="logout"><span class="glyphicon glyphicon-off"></span>注 销</a></li>
								</ul></li>
						</ul>

					</div>
				</nav>

				<!--面包屑导航-->
				<ol class="breadcrumb">
					<li><a href="javascript:void(0)">主页</a></li>
				</ol>

				<!--iframe框架内容-->
				<div class="row-fluid">
					<div class="span12">
						<div style="height: 1000px;">
							<iframe src="/WorkManageSystem/teacher/t_allworks?t_account=${teacher.t_account  }" frameborder="0"
								seamless="seamless" scrolling="no" marginheight="0px" marginwidth="0px"
								width="100%" height="100%"></iframe>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

</body>
</html>