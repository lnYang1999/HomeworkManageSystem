<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登录界面(Login)</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
		
        <!-- CSS -->
        <link type="text/css" rel="stylesheet" href="login/assets/css/reset.css">
        <link type="text/css" rel="stylesheet" href="login/assets/css/supersized.css">
        <link type="text/css" rel="stylesheet" href="login/assets/css/style.css">

		<script type="text/javascript">
			function Reset(){
				//调用form表单的reset()函数
				document.getElementById("login").reset();
				//获取获取错误显示信息对象
				var errMsg = document.getElementById("errMsg");
				//重置错误信息对象内容
				errMsg.innerHTML = "";
			}
		</script>

    </head>
	<body>
		<div class="page-container">
            <h1>作业管理系统</h1>
            <form id="login" action="login" method="get">
                <input type="text" name="account" class="account" placeholder="请输入您的账号！">
                <input type="password" name="password" class="password" placeholder="请输入您的用户密码！"><br><br>
                <strong>类型：</strong>
				<select  name = "type" id = "type" style="background: transparent;color:white;">
					<option name = "type" value = "type" style="background-color: #AAAAAA">== &nbsp;类型  &nbsp;==</option>
					<option name = "type" value = "Manager" style="background-color: #AAAAAA">管理员</option>
					<option name = "type" value = "Teacher"  style="background-color: #AAAAAA">教师</option>
					<option name = "type" value = "Student"  style="background-color: #AAAAAA">学生</option>
				</select><br/><br/>
				<h2><font id="errMsg" color="red">${errMsg}</font></h2>
                <button type="submit" class="submit_button">登 录</button>&nbsp;&nbsp;
                <button type="button" class="submit_button" onclick = "Reset()">重 置</button><br><br><br>
                <div class="error"><span>+</span></div>
                
            </form>
		</div>
		
		<!-- Javascript -->
        <script src="login/assets/js/jquery-1.8.2.min.js" ></script>
        <script src="login/assets/js/supersized.3.2.7.min.js" ></script>
        <script src="login/assets/js/supersized-init.js" ></script>
        <script src="login/assets/js/scripts.js" ></script>
		
	</body>
</html>