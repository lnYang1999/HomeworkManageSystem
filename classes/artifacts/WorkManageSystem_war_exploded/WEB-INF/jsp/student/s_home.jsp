<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1
    	user-scalable=no">
<!-- 包含 bootstrap 样式表 -->
<link rel="stylesheet"
	href="/WorkManageSystem/BootStrap/css/bootstrap.min.css">
<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
<!-- 可选: 包含 jQuery 库 -->
<script src="/WorkManageSystem/BootStrap/js/jquery-3.1.1.js"></script>
<!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
<script src="/WorkManageSystem/BootStrap/js/bootstrap.min.js"></script>
<title>学生框架</title>
<!--学生的整体框架-->

</head>
<body>
	<!--整个页面栅格-->
	<div class="container-fluid "
		style="background-color: blasck; padding: 0px; margin-left: 4%;">
		<div class="row-fluid">
			<div class="span12">
				<!-- 通知轮转图 -->
				<!--data-ride="carousel" 使轮转图自动轮转-->
				<div class="carousel slide" id="carousel-598343"
					data-ride="carousel"
					style="width: 1200px; height: 200px; background: url(/WorkManageSystem/img/back.jpg); color: white;">
					<ol class="carousel-indicators">
					<c:if test="${!empty notice }">
					<c:forEach items="${notice }" var="n" varStatus="loop">
					<c:choose>
					<c:when test="${loop.count-1==0 }">
						<li class="active" data-slide-to="${loop.count-1 }"	 data-target="#carousel-598343"></li>
					</c:when>
					<c:otherwise>
						<li data-slide-to="${loop.count-1 }"	 data-target="#carousel-598343"></li>
					</c:otherwise>
					</c:choose>
					</c:forEach>
					</c:if>			
					</ol>					
					<div class="carousel-inner">
					<c:if test="${empty notice }">
						<div class="item active">
								<img alt="" src=" " style="width: 100%; height: 200px;" />
								<div class="carousel-caption">
									<h4></h4>
									<h4>暂无公告</h4>
									<p></p>
								</div>
						</div>
					</c:if>
					<c:if  test="${!empty notice }">
					<c:forEach items="${notice }" var="n" varStatus="loop">
					<c:choose>
					<c:when test="${loop.count-1==0 }">
						<div class="item active">
							<img alt="" src=" " style="width: 100%; height: 200px;" />
							<div class="carousel-caption">
								<h4>${n.nt_title }（${ntTName[loop.count-1] }）</h4>
								<h4>内容：${n.nt_content }</h4>
								<p>${n.nt_time }</p>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="item">
							<img alt="" src=" " style="width: 100%; height: 200px;" />
							<div class="carousel-caption">
								<h4>${n.nt_title }（${ntTName[loop.count-1] }）</h4>
								<h4>内容：${n.nt_content }</h4>
								<p>${n.nt_time }</p>
							</div>
						</div>
					</c:otherwise>
					</c:choose>
					</c:forEach>
					</c:if>
					</div>
					<a class="left carousel-control" href="#carousel-598343"
						data-slide="prev"><span
						class="glyphicon glyphicon-chevron-left"></span></a> <a
						class="right carousel-control" href="#carousel-598343"
						data-slide="next"><span
						class="glyphicon glyphicon-chevron-right"></span></a>
				</div>

				<!-- 作业列表 -->
				<div>
				<c:if test="${!empty work }">
				<c:forEach items="${work }" var="w" varStatus="loop">
					<a  id="modal-${loop.count }" href="#modal-container-${loop.count }" class="${loop.count }" data-toggle="modal" style="clear:both;">
					<ul class="thumbnails" style="list-style: none; margin-top: 20px; margin-left: 0px; width: 1200px;">						
						<li class="span4">
							<div class="thumbnail">
								<span class="glyphicon glyphicon-fire" style="font-size: 20px;"></span>

								<div class="caption">
									<h4>
										${w.w_title }（${teachername[loop.count-1] }）
									</h4>
									<p>
										${w.w_course }
									</p>									
										<c:choose>
										<c:when test="${status[loop.count-1] }">
										<p style="margin-left:93%;color:green;font-weight:bold;">
											已提交
										</p>
										</c:when>
										<c:otherwise>
										<p style="margin-left:93%;color:red;font-weight:bold;">
											未提交
										</p>
										</c:otherwise>
										</c:choose>							
									<div class="thumbs-up">
										<span class="glyphicon glyphicon-thumbs-up"
											style="font-size: 20px;"></span>
									</div>
								</div>
							</div>
						</li>
					</ul>
					</a>
					</c:forEach>
					</c:if>
				</div>
				<div class="container-fluid">
				<c:if test="${!empty work }">
				<c:forEach items="${work }" var="w" varStatus="loop">
					<div class="modal fade" id="modal-container-${loop.count }" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel">
										作业内容
									</h4>
								</div>
								<form action="#"  method = "post">
								<div class="modal-body">
									标题:&nbsp;<input type="text" name="title"  value="${w.w_title }" readonly="readonly" style="border:none;"/> <br><br>
									课程:&nbsp;<input type="text" name="deadline" value="${w.w_course }" readonly="readonly" style="border:none;"/><br><br>
									指导教师:&nbsp;<input type="text" name="teacher" value="${teachername[loop.count-1] }" readonly="readonly" style="border:none;"/><br><br>
									内容:&nbsp;<textarea name="content" readonly="readonly" style="display:inline-block;vertical-align:top;resize: none;">${w.w_content }</textarea><br><br>
									截止日期:&nbsp;<input type="text" name="deadline" value="${w.w_deadline }" readonly="readonly" style="border:none;"/><br><br>
								</div>
								<div class="modal-footer">
									 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
								</div>
								</form>
							</div>
						</div>
					</div>
				</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>