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
	<title>学生个人设置</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<table class="table">
				<thead>
				</thead>
				<tbody>
					
					<tr class="success">
						<td>
							<a id="modal-1" href="#modal-container-1" class="1" data-toggle="modal" style="clear:both;">修 改 信 息</a>               
						</td>
					</tr>					
					<tr class="warning">
						<td>
							<a id="modal-1" href="#modal-container-4" class="1" data-toggle="modal" style="clear:both;">修 改 密 码</a>               
						</td>
					</tr>					
				</tbody>
			</table>
			<div class="container-fluid">
					<!-- 修改姓名 -->
					<div class="modal fade" id="modal-container-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel">
										修改姓名
									</h4>
								</div>
								<form action="/WorkManageSystem/student/updateStudentName"  method = "post" >
								<div class="modal-body">
									<input type = "hidden" name = "id"  value = "${student.id }"/>								<!--修改内容提示  -->
									<input type = "hidden" name = "s_account"  value = "${student.s_account }"/>
									<input type = "hidden" name = "s_password"  value = "${student.s_password }"/>
									<input type = "hidden" name = "s_c_id"  value = "${student.s_c_id }"/>
									<input type = "hidden" name = "s_sex"  value = "${student.s_sex }"/>
									<input type = "hidden" name = "s_dept"  value = "${student.s_dept }"/>
									原名:&nbsp;<input type="text" name="oldname"  value="${student.s_name }" readonly="readonly"> <br><br>
									新名:&nbsp;<input type="text" name="s_name" value=""/>
								</div>
								<div class="modal-footer">
									 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
									 <button type="submit" class="btn btn-primary">修改</button>
									 <button type="reset" id="reset" class="btn btn-primary">重置</button>
								</div>
								</form>
							</div>
						</div>
					</div>
					<!--修改密码-->
					<div class="modal fade" id="modal-container-4" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel">
										修改密码
									</h4>
								</div>
								<form action="/WorkManageSystem/student/updateStudentPassword" method = "post">
								<div class="modal-body">
									<input type = "hidden" name = "id"  value = "${student.id }"/>								<!--修改内容提示  -->
									<input type = "hidden" name = "s_account"  value = "${student.s_account }"/>
									<input type = "hidden" name = "s_name"  value = "${student.s_name }"/>
									<input type = "hidden" name = "s_c_id"  value = "${student.s_c_id }"/>
									<input type = "hidden" name = "s_sex"  value = "${student.s_sex }"/>
									<input type = "hidden" name = "s_dept"  value = "${student.s_dept }"/>
									原&nbsp;&nbsp;密&nbsp;码:<input type="text" name="oldpaw" value="${ student.s_password}" readonly disabled> <br><br>
									新&nbsp;&nbsp;密&nbsp;码:<input type="password" name="s_password"><br><br>
									确定密码:<input type="password" name="check_newpsw">
								</div>
								<div class="modal-footer">
									 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
									 <button type="submit" class="btn btn-primary">修改</button>
									 <button type="reset" id="reset" class="btn btn-primary">重置</button>
								</div>
								</form>
							</div>
						</div>
					</div>
			</div>
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