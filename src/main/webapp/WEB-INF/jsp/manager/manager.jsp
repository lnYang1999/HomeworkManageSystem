<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<!-- 包含头部信息用于适应不同设备 -->
    <meta name="viewport" content="width=device-width, initial-scale=1 user-scalable=no">
    <title>管理员界面</title>
    
    <!-- 包含 bootstrap 样式表 -->
    <link rel="stylesheet" href="/WorkManageSystem/BootStrap/css/bootstrap.min.css">
    <!-- 可选: 包含 jQuery 库 -->
    <script src="/WorkManageSystem/BootStrap/js/jquery-2.1.1.min.js"></script>
    <script src="/WorkManageSystem/BootStrap/js/bootstrap.min.js"></script>
    
    <!--管理员的整体框架-->
	<script type="text/javascript">
		
/************************************************************************************/
		$(document).ready(function(){
			
			//教师总览，删除，修改
			$("a.allT").click(function(){
				$("iframe").attr("src","/WorkManageSystem/manager/m_teachermanage");
				//面包屑导航
				$("ol.breadcrumb").html("<li><a href='javascript:void(0)''>首页</a></li>"+"<li class='active'>教师总览</li>");
			});
			
			//教师添加
			$("a.addT").click(function(){
				$("iframe").attr("src","/WorkManageSystem/manager/m_addteacher");
				//面包屑导航
				$("ol.breadcrumb").html("<li><a href='javascript:void(0)''>首页</a></li>"+"<li class='active'>教师添加</li>");
			});
			
			//学生总览，删除，修改
			$("a.allS").click(function(){
				$("iframe").attr("src","/WorkManageSystem/manager/m_studentmanage");
				//面包屑导航
				$("ol.breadcrumb").html("<li><a href='javascript:void(0)''>首页</a></li>"+"<li class='active'>学生总览</li>");
			});
			
			//学生添加
			$("a.addS").click(function(){
				$("iframe").attr("src","/WorkManageSystem/manager/m_addstudent");
				//面包屑导航
				$("ol.breadcrumb").html("<li><a href='javascript:void(0)''>首页</a></li>"+"<li class='active'>学生添加</li>");
			});
			
			//课程总览，删除，修改
			$("a.allC").click(function(){
				$("iframe").attr("src","/WorkManageSystem/manager/m_coursemanage");
				//面包屑导航
				$("ol.breadcrumb").html("<li><a href='javascript:void(0)''>首页</a></li>"+"<li class='active'>课程总览</li>");
			});
			
			//课程添加
			$("a.addC").click(function(){
				$("iframe").attr("src","/WorkManageSystem/manager/m_addcourse");
				//面包屑导航
				$("ol.breadcrumb").html("<li><a href='javascript:void(0)''>首页</a></li>"+"<li class='active'>课程添加</li>");
			});
			
			//个人设置
			$("a.m_personalseting").click(function(){
				$("iframe").attr("src","/WorkManageSystem/manager/m_personalseting");//?m_name=${manager.m_name}
				//面包屑导航
				$("ol.breadcrumb").html("<li><a href='javascript:void(0)''>首页</a></li>"+"<li class='active'>个人设置</li>");
			});
			
			
		});
	</script>
	
</head>
<body>

	<%-- <%
		//获取面包屑导航
		List<String> listNav = (List)session.getAttribute("listNav");
		for(int i=0; i<listNav.size(); i++){
			System.out.print("dkjf jdjfjdasfjadsfsdalkjf:"+listNav.get(i));
		}
	%> --%>
	<div class="container-fluid" style="background-color: whitesmoke; margin-left:100px;margin-right:100px; padding-top: 0px;">
		<div class="row-fluid">
			<div class="span12">
			<!-- 顶部 -->
			<div class="page-header" style="margin-top: 0px;height: 42px;">
				<h1 class="text-center" ><strong>作业管理系统</strong></h1>
			</div>
			
			<!-- 菜单栏 -->
			<nav class="navbar navbar-default" role="navigation"><!-- style="background:yellow; -->
				<div class="container-fluid">
				
					<div class="navbar-header">
						<a class="navbar-brand" href="#"><span class="glyphicon glyphicon-pencil" style="font-size: 25px;"></span></a>
					</div>
					
					<div>
						<ul class="nav navbar-nav">
							<li class="dropdown">
							  <a class="dropdown-toggle" data-toggle="dropdown" href="#">
								教师管理<span class="caret"></span>
							  </a>
							  <ul class="dropdown-menu">
								<li><a href="#" class="allT">总 览</a></li>
								 <li class="divider"></li>
								<li><a href="#" class="addT">添 加</a></li>
								<li><a href="#" class="allT">删 除</a></li>
								<li><a href="#" class="allT">修 改</a></li>
							  </ul>
							</li>
	
							<li class="dropdown">
							  <a class="dropdown-toggle" data-toggle="dropdown" href="#">
								班级管理<span class="caret"></span>
							  </a>
							  <ul class="dropdown-menu">
								<li><a href="#" class="allS">总 览</a></li>
								 <li class="divider"></li>
								<li><a href="#" class="addS">添 加</a></li>
								<li><a href="#" class="allS">删 除</a></li>
								<li><a href="#" class="allS">修 改</a></li>
							  </ul>
							</li>
							
							<li class="dropdown">
							  <a class="dropdown-toggle" data-toggle="dropdown" href="#">
								课程管理<span class="caret"></span>
							  </a>
							  <ul class="dropdown-menu">
								<li><a href="#" class="allC">总 览</a></li>
								 <li class="divider"></li>
								<li><a href="#" class="addC">添 加</a></li>
								<li><a href="#" class="allC">删 除</a></li>
								<li><a href="#" class="allC">修 改</a></li>
							  </ul>
							</li>
							
						</ul>
					</div>
					
					<ul class="nav navbar-nav navbar-right">
						<li>
							<!-- <a href="#"><span class="glyphicon glyphicon-envelope" style="font-size: 20px;"></a> -->
							<img src="/WorkManageSystem/img/header.gif" class = "img-circle" style="width: 40px;height: 40px;">
						</li>
						<li><strong><span style="line-height:55px;">管理员:&nbsp;${manager.m_name  }</span></strong></li>
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">
							 		<span class="glyphicon glyphicon-user" style="font-size: 20px;"></span>
							 		<strong class="caret"></strong>
							 </a>
							<ul class="dropdown-menu">
								<li><a href="#">管理员:&nbsp;${manager.m_name  } </a></li>
								<li><a href="#" class="m_personalseting">个人设置</a></li>
								<li class="divider"></li>
								<li><a href="logout"><span class="glyphicon glyphicon-off"></span>注 销</a></li>
							</ul>
						</li>
					</ul>
					
				</div>	
			</nav>
			
			<!--面包屑导航-->
				<ol class="breadcrumb">
					<li><a href="javascript:void(0)">主页</a></li>
				</ol>
			<hr>
			
			<!--iframe框架内容-->
			<div class="row-fluid" ><!--m_teachermanage.html   -->
				<div class="span12">
					<div style="height: 1000px;"><!-- seamless="seamless" 无边框或滚动条 -->
					    <iframe src="/WorkManageSystem/manager/m_teachermanage" frameborder="0" seamless="seamless" marginheight="0px" marginwidth="0px" width="100%" height="100%"></iframe>
						
					</div>
				</div>
			</div> 
			<%-- <jsp:forward page="m_teachermanage.jsp"></jsp:forward> --%>
			
			</div>
		</div>
	</div>
	
</body>
</html>