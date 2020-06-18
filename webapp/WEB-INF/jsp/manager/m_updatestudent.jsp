<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
    <!-- 包含头部信息用于适应不同设备 -->
    <meta name="viewport" content="width=device-width, initial-scale=1
    	user-scalable=no">
    <!-- 包含 bootstrap 样式表 -->
    <link rel="stylesheet" href="/WorkManageSystem/BootStrap/css/bootstrap.min.css">
	<title>学生管理-修改</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form class="form-horizontal" action="/WorkManageSystem/manager/updateStudent" method="post" role="form">
					<input type="hidden" name="id" value="${s.id}"  /><!-- 隐藏域，传递教师id -->
					<div class="form-group">
						 <label for="inputEmail3" class="col-sm-2 control-label">账号:</label>
						<div class="col-sm-2">
							<input type="text" name="s_account" class="form-control" id="inputEmail3" value="${s.s_account}" readonly/>
						</div>
					</div>
					<div class="form-group">
						 <label for="inputEmail3" class="col-sm-2 control-label">姓名:</label>
						<div class="col-sm-2">
							<input type="text" name="s_name" class="form-control" id="inputEmail3" value="${s.s_name}"/>
						</div>
					</div>
					<div class="form-group">
						 <label for="inputEmail3" class="col-sm-2 control-label">性别:</label>
						<div class="col-sm-2">
							<input type="text" name="s_sex" class="form-control" id="inputEmail3" value="${s.s_sex}" readonly/>
						</div>
					</div>
					<div class="form-group">
						 <label for="inputEmail3" class="col-sm-2 control-label">班级:</label>
						<div class="col-sm-2">
							<input type="text" name="s_c_id" class="form-control" id="inputEmail3" value="${s.s_c_id}" readonly/>
						</div>
					</div>
					<div class="form-group">
						 <label for="inputEmail3" class="col-sm-2 control-label">密码:</label>
						<div class="col-sm-2">
							<input type="text" name="s_password" class="form-control" id="inputEmail3" value="${s.s_password}"/>
						</div>
					</div>
					<div class="form-group">
						 <label for="inputEmail3" class="col-sm-2 control-label">学院:</label>
						<div class="col-sm-2">
							<input type="text" name="s_dept" class="form-control" id="inputEmail3" value="${s.s_dept}"/>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							 <button type="submit" class="btn btn-default">修改</button>&nbsp;&nbsp;&nbsp;
							 <button type="reset" class="btn btn-default">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
    <!-- 可选: 包含 jQuery 库 -->
    <script src="/WorkManageSystem/BootStrap/js/jquery-3.1.1.js"></script>
    <!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
    <script src="/WorkManageSystem/BootStrap/js/bootstrap.min.js"></script>
</body>
</html>