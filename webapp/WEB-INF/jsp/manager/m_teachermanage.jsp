<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
    <!-- 包含头部信息用于适应不同设备 -->
    <meta name="viewport" content="width=device-width, initial-scale=1
    	user-scalable=no">
    <!-- 包含 bootstrap 样式表 -->
    <link rel="stylesheet" href="/WorkManageSystem/BootStrap/css/bootstrap.min.css">
	<title>教师管理</title>
	
	<script type="text/javascript">
		//删除教师
		function del(id){
			$.get("/WorkManageSystem/manager/delTeacher?id=" + id,function(data){
				if("success" == data.result){
					alert("删除成功!");
					window.location.reload(); 
				}else{
					alert("删除失败!");
				}
			});
		}
		
		//若教师信息修改有错-->则提示教师信息修改出错
		function error(){	
			var error = "${error}";		//如果不等于空，说明返回来时出错
			if(error.value!=null){
				alert(error.value);
			}
		}
		window.onload = error;
		
		//面包屑导航
		function setbreadcrumb(){
			$("ol.breadcrumb",parent.document).html("<li><a href='javascript:void(0)''>首页</a></li>"+"<li class='active'>修改教师</li>");
		}

	</script>
</head>
<body>

	<%
		int a = 0;
	%>
	
	<div class="text-center">
		<strong style="font-size:20px;">教师总览</strong>
	</div>
	<table class="table table-hover table-bordered table-striped">
		<thead>
			<tr>
				<th>序号</th>
				<th>教师工号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>系部</th>
				<th>密码</th>
				<th>修改</th>
				<th style="width: 45px;">删除</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${!empty teacher}" > 
				<c:forEach items="${teacher}" var="t" varStatus="status">
					<c:if test="${status.count%2==0 } ">
						<tr class="success" style="color:#98FB98; font-size:20px;">
					</c:if>
					<c:if test="${status.count%2!=0 }" >
						<tr>
					</c:if>
						<td><%=++a %></td>
						<td>${ t.t_account }</td>
						<td>${ t.t_name }</td>
						<td>${ t.t_sex }</td>
						<td>${ t.t_dept }</td>
						<td>${ t.t_password }</td>
						<td><a href="/WorkManageSystem/manager/updateTeacher_jsp?id=${t.id }" onclick="setbreadcrumb()">修改</a></td>
						<td>
							<a type="button" class="close" href = "javascript:del('${t.id }')">
								<span class="glyphicon glyphicon-trash"></span>
								<span class="sr-only">关闭</span>
							</a>
						</td>
					</tr>
					
				</c:forEach>
			</c:if>
		</tbody>
	</table>

<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
    <!-- 可选: 包含 jQuery 库 -->
    <script src="/WorkManageSystem/BootStrap/js/jquery-3.1.1.js"></script>
    <!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
    <script src="/WorkManageSystem/BootStrap/js/bootstrap.min.js"></script>
</body>
</html>