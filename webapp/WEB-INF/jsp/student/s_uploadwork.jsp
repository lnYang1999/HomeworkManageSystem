<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
    <!-- 包含头部信息用于适应不同设备 -->
    <meta name="viewport" content="width=device-width, initial-scale=1
    	user-scalable=no">
    <!-- 包含 bootstrap 样式表 -->
    <link rel="stylesheet" href="/WorkManageSystem/BootStrap/css/bootstrap.min.css">
    <!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
    <!-- 可选: 包含 jQuery 库 -->
    <script src="/WorkManageSystem/BootStrap/js/jquery-3.1.1.js"></script>
    <!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
    <script src="/WorkManageSystem/BootStrap/js/bootstrap.min.js"></script>
	<title>上传作业</title>
	<!--学生的整体框架-->

	<script type="text/javascript">
		$(document).ready(function(){
			flag(<%=session.getAttribute("flag")%>);
		});	
		function flag(f){
			var flag = f;
			if( flag == 1 ){
				alert("上传成功");
			}else if( flag == 2 ){
				alert("上传失败！！！教师已批改，不可重复提交。");
			}else if( flag == 3 ){
				alert("上传成功！已覆盖提交");
			}else if( flag != 0 ){
				alert("上传失败");
			}
		}
	</script>

</head>
<body>
	<%
		String s_account = session.getAttribute("s_account").toString();
		String clazz = session.getAttribute("clazz").toString();
	%>
	<!--整个页面栅格-->
	<div class="container-fluid " style="background-color: blasck;padding: 0px;margin-left: 4%;">
		<div class="row-fluid">
			<div class="span12">
				<form action="/WorkManageSystem/student/s_uploadwork?s_account=<%=s_account%>&clazz=<%=clazz%>&w_title=${w_title}"  method = "post" enctype="multipart/form-data">
					<div class=" " style="margin-left:40%;margin-top: 10%;">
						 <div class="input-group input-group-sm" style="width: 200px;">
						 	<%-- <input type="hidden" name="Sno" value="<%=s_account%>" />
						 	<input type="hidden" name="Clazz" value="<%=clazz%>" /> --%>
	                        <span class="input-group-addon">作业</span>
	                        <select class="form-control" name="w_title">
		                        <c:if test="${!empty w_title }">
									<c:forEach items="${w_title }" var="w" varStatus="loop">
										<option>${w_title[loop.count-1]}</option>
									</c:forEach>
								</c:if>
	                        </select>
	                    </div>
					</div>
					<div class="" style="margin-left:40%;margin-top: 5%;">
						<label >选择文件：</label>
						<input type="file" name="fileUpload" id="fileUpload" accept="application/msword,text/plain" /><br/><br/><!-- application/zip, -->
					</div>
					<div class=" " style="padding-left:40%;">
						<input type="submit" name="submit" class="btn-primary" id="submit" value="上传"/>
					</div>
	
				</form>
				
			</div>
		</div>
	</div>














<%-- <!--整个页面栅格-->
<div class="container-fluid " style="background-color: blasck;padding: 0px;margin-left: 4%;">
	<div class="row-fluid">
		<div class="span12">
			<form action="/WorkManageSystem/student/s_uploadwork"  method = "post" enctype="application/form-data">
				<div class=" " style="margin-left:45%;margin-top: 5%;">
					<label >选择作业：</label>
					<select class="form-control" name="work" >
						<c:if test="${!empty ch_w_id }">
							<c:forEach items="${ch_w_id }" var="w" varStatus="loop">
								<option>${ch_w_id.[loop.count]}</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
				<div class=" " style="margin-left:45%;margin-top: 5%;">
					<label >选择文件：</label>
					<input type="file" name="fileUpload" id="fileUpload" accept="application/msword,text/plain" /><br/><br/><!-- application/zip, -->
				</div>
				<div class=" " style="padding-left:45%;">
					<input type="submit" name="submit" class="btn-primary" id="submit" value="上传"/>
				</div>
			</form>
		</div>
	</div>
</div> --%>
</body>
</html>