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
	<title>管理员-个人设置</title>
	
	<!-- 验证的包 -->
	<script src="/WorkManageSystem/js/jQuery_Validate/jquery-validation-1.14.0/lib/jquery.js"></script>
	<script src="/WorkManageSystem/js/jQuery_Validate/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
	<script src="/WorkManageSystem/js/jQuery_Validate/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
	
	<script type="text/javascript">
		/* window.onload=function(){
			function msg(){	
				var msg = "${msg}";
				if( msg.length != 0 ){	//如果不等于空，说明返回来时出错
					alert("${msg}");
				}
			} 
		} */
		/* window.onload = msg;
		//若管理员信息修改有错-->则提示管理员信息修改出错
		function msg(){	
			var msg = "${msg}";
			if(msg!=null){	//如果不等于空，说明返回来时出错
				alert("${msg}");
			}
		} */
		
		$.validator.setDefaults({
			
		});
		$().ready(function() {
			// 在键盘按下并释放及提交后验证提交表单
			  $("#form3").validate({
				  
				  rules: {
				      psw: {
				        required: true,
				        minlength: 5
				      },
				      password: {
				        required: true,
				        minlength: 5,
				        equalTo: "#psw"
				      }
				      
				  },
				  messages: {
					  psw: {
				        required: "请输入密码",
				        minlength: "密码长度不能小于 5 个字母"
				      },
				      password: {
				        required: "请输入密码",
				        minlength: "密码长度不能小于 5 个字母",
				        equalTo: "两次密码输入不一致"
				      }
				  }
			  });
		});
	</script>
	<style>
		.error{
			color:red;
		}
	</style>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<table class="table table-hover table-bordered table-striped">
					<thead>
						<tr>
							<th>编 号</th>
							<th>类 别</th>
							<th>信 息</th>
							<th>操 作</th>
							<th>    </th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${!empty manager}">
							<tr class="success">
								<td>1</td>
								<td>账 号</td>
								<td>${manager.m_account }</td>
								<td><a id="modal-1" href="#modal-container-1" class="1" data-toggle="modal" style="clear:both;">修 改</a></td>
								<td></td>
							</tr>
							<tr class="active">
								<td>2</td>
								<td>姓 名</td>
								<td>${manager.m_name }</td>
								<td><a id="modal-2" href="#modal-container-2" class="2" data-toggle="modal" style="clear:both;">修 改</a></td>
								<td></td>
							</tr>
							<tr class="warning">
								<td>3</td>
								<td>密 码</td>
								<td>${manager.m_password }</td>
								<td><a id="modal-3" href="#modal-container-3" class="3" data-toggle="modal" style="clear:both;">修 改</a></td>
								<td></td>
							</tr>
						</c:if>
					</tbody>
				</table>
			<div class="container-fluid">
					<!-- 修改账号 -->
					<div class="modal fade" id="modal-container-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel">修改账号</h4>
								</div>
								<form action="/WorkManageSystem/manager/updateManagerAccount" method = "post">
								<div class="modal-body">
									<input type="hidden" name="id" value="${manager.id }"/>		<!--修改内容提示  -->
									原账号:<input type="text" name="oldaccount" value="${manager.m_account }" readonly="readonly" disabled > <br><br>
									新账号:<input type="text" name="account" />
								</div>
								<div class="modal-footer">
									 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
									 <button type="submit" class="btn btn-primary">修改</button>
									 <button type="reset" class="btn btn-primary">重置</button>
								</div>
								</form>
							</div>
						</div>
					</div>
					<!-- 修改姓名 -->
					<div class="modal fade" id="modal-container-2" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel">修改姓名</h4>
								</div>
								<form action="/WorkManageSystem/manager/updateManagerName" method = "post">
								<div class="modal-body">
									<input type="hidden" name="id" value="${manager.id }"/>		<!--修改内容提示  -->
									原名:<input type="text" name="oldname" value="${manager.m_name }" readonly="readonly" disabled > <br><br>
									新名:<input type="text" name="name"/>
								</div>
								<div class="modal-footer">
									 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
									 <button type="submit" class="btn btn-primary">修改</button>
									 <button type="reset" class="btn btn-primary">重置</button>
								</div>
								</form>
							</div>
						</div>
					</div>
					<!--修改密码-->
					<div class="modal fade" id="modal-container-3" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel">
										修改密码
									</h4>
								</div>
								<form class="cmxform" id="form3" action="/WorkManageSystem/manager/updateManagerPassword" method = "post">
									<div class="modal-body">
										<p><input type="hidden" name="id" value="${manager.id }" /></p>		<!--修改内容提示  -->
											<!-- <label >原&nbsp;&nbsp;密&nbsp;码:</label> -->
											原&nbsp;&nbsp;密&nbsp;码:<input type="text" name="oldpaw" value="${manager.m_password }" readonly="readonly" disabled > <br><br>
											<!-- <label for="psw">新&nbsp;&nbsp;密&nbsp;码:</label> -->
											新&nbsp;&nbsp;密&nbsp;码:<input type="password" id="psw" name="psw" ><br><br>
											<!-- <label>确定密码:</label> -->
											确定密码:<input type="password" id="password" name="password" ><br><br><br>
										
									</div>
									<div class="modal-footer">
											<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
											<button type="submit" id="submit" class="btn btn-primary">修改</button>
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