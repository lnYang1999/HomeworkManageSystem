<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.*" %>
<%@ page import = "wms.entity.*" %>
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
	<title>教师提交统计</title>
	<script type="text/javascript">
	//班级作业统计
	function show(w_id,c_id){
		$("iframe").attr("src","/WorkManageSystem/teacher/checkwork?w_id="+w_id+"&c_id="+c_id);
	}
	</script>
	
</head>
<body>
<%
	List<Work> work = (List<Work>)session.getAttribute("w");
	for(int i=0; i<work.size(); i++){
		System.out.println("作业表jsp:"+work.get(i).getW_title());
	}
	List<String> clazz = (List<String>)session.getAttribute("c");
	for(int i=0; i<clazz.size(); i++){
		System.out.println("班级号jsp:"+clazz.get(i));
	}
%>
<div class="container" style="min-width: 100%;">
	<div class="row-fluid">
<!--菜单项-->
		<div class="col-md-2 column" style="background-color: #E0FFFF;height: 800px;padding: 0;">
			
			<div class="row clearfix">
					<div class="col-md-12 column">
							<div class="panel-group" id="panel-614308">
								<div class="panel panel-default">
								<%
									for(int i=0; i<clazz.size(); i++){
										%>
											<div class="panel-heading" style="height: 35px;">
												 <a class="panel-title" data-toggle="collapse" data-parent="#panel-614308" href="#<%=clazz.get(i) %>"><%=clazz.get(i) %>
												 <strong class="caret"></strong></a>
											</div>
											<div id="<%=clazz.get(i) %>" class="panel-collapse collapse in"  aria-expanded="false">
										<%
										for(int j=0; j<work.size(); j++){
											if(work.get(j).getW_c_id().equals(clazz.get(i))){
												%>
													<div class="panel-body"> 
														<a href="javascript:void(0)" class="work "  onclick= "show(<%=work.get(j).getW_id() %>,<%=clazz.get(i)%>)"><%=work.get(j).getW_title() %></a> 
													</div>
												<%
											}
										}
										%>
											</div>
										<%
										
									}
								%>
			
								</div>
							</div>
					</div>
			</div>
		
		</div>
<!--显示区-->
		<div class="col-md-10 column" style="background-color: white;height: 1000px;">
			<!--iframe标签-->	
			<iframe src="" frameborder="0"  seamless="seamless" marginheight="0px" marginwidth="0px" width="100%" height="100%"></iframe>
		</div>													<!-- scrolling="no" -->
	</div>
</div>
</body>
</html>
<%-- <!--  动态生成菜单栏-->
							<c:if test="${! empty clazz }">
								<c:forEach items="${clazz }" var="c">
									<div class="panel-heading" style="height: 35px;">
										 <a class="panel-title" data-toggle="collapse" data-parent="#panel-614308" href="#${c }">${c }<strong
											class="caret"></strong></a>
											
									</div>
									<c:if test="${!empty resultWork }">
											<c:forEach items = "${resultWork}" var = "w">
												<div id="${c }" class="panel-collapse collapse in">
													<c:if test="${c  eq w.w_c_id }">
															<div class="panel-body">
																<a href="javascript:void(0)" class="work">${w.w_title }</a> 
															</div> 
													</c:if>
												</div> 
											</c:forEach>
									</c:if>
								</c:forEach>
							</c:if> --%>









							<!-- <div class="panel-heading" style="height: 35px;">
								 <a class="panel-title" data-toggle="collapse" data-parent="#panel-614308" href="#panel-element-1">142011<strong
									class="caret"></strong></a>
							</div>
							<div id="panel-element-1" class="panel-collapse collapse in">
								<div class="panel-body">
									<a href="javascript:void(0)" class="work">Java第一次作业</a> 
								</div>
								<div class="panel-body">
									<a href="javascript:void(0)" class="work">Java第二次作业</a>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" style="height: 35px;">
								 <a class="panel-title" data-toggle="collapse" data-parent="#panel-614308" href="#panel-element-2">142012</a>
							</div>
							<div id="panel-element-2" class="panel-collapse collapse">
								<div class="panel-body">
									<a href="#" class="work">数据结构实验</a>
								</div>
								<div class="panel-body">
									<a href="#" class="work">Java第一次作业</a>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" style="height: 35px;">
								 <a class="panel-title" data-toggle="collapse" data-parent="#panel-614308" href="#panel-element-3">142013</a>
							</div>
							<div id="panel-element-3" class="panel-collapse collapse">
								<div class="panel-body">
									<a href="#" class="work">数据结构实验</a>
								</div>
								<div class="panel-body">
									<a href="#" class="work">Java第一次作业</a>
								</div>
							</div> 
						</div>-->