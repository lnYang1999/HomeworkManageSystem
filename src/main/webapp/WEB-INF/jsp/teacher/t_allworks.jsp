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
    <!-- 可选: 包含 jQuery 库 -->
    <script src="/WorkManageSystem/BootStrap/js/jquery-3.1.1.js"></script>
    <!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
    <script src="/WorkManageSystem/BootStrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
	  //删除作业
		function del(id){
			$.get("/WorkManageSystem/teacher/t_deletework?id=" + id,function(data){
				if("success" == data.result){
					alert("删除成功!");
					window.location.reload(); 
				}else{
					alert("删除失败!");
				}
			});
		}
    </script>
	<title>教师作业总览</title>
	<!--教师的作业总览-->
</head>
<body> 
<%
	int i=1;
	request.setAttribute("i", i);
%>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12" style=" ">
            <table class="table table-hover table-bordered table-striped">
                <thead>
                    <tr>
                        <th>序号</th>
                        <th>主题</th>
                        <th>内容</th>
                        <th>课程</th>
                        <th>班级</th>
                        <th>截止时间</th>
                        <th>查看</th>
                        <th style="width: 45px;"> 删除</th>
                    </tr>
                </thead>
                <tbody>
                	<c:if test="${! empty work }">
                		<c:forEach items="${work }" var="w">
	                			<tr >
	                				<%request.setAttribute("i", i++); %>
			                        <td>${i }</td>
			                        <td>${w.w_title }</td>
			                        <td>${w.w_content }</td>
			                        <td>${w.w_course }</td>
			                        <td>${w.w_c_id }</td>
			                        <td>${w.w_deadline }</td>
			                        <td><a id="modal-1" href="#${w.w_id}" data-toggle="modal">查看</a></td>
			                        <td>
				                        <a type="button" class="close" href = "javascript:del('${w.w_id }')">
											<span class="glyphicon glyphicon-trash"></span>
										</a>
			                        </td>
			                    </tr>
	                </c:forEach>
	             </c:if>
				             
                    
                </tbody>
            </table>
            
            <c:if test="${! empty work }">
                <c:forEach items="${work }" var="w">
		            <!--遮罩窗体-->
		            <!--遮罩窗体111-->
		            <div class="modal fade" id="${w.w_id }" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		                <div class="modal-dialog">
		                    <div class="modal-content">
		                        <div class="modal-header">
		                             <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		                            <h4 class="modal-title" id="myModalLabel">
		                                ${w.w_title}
		                            </h4>
		                        </div>
		                        <div class="modal-body">
		                            ${w.w_content }
		                        </div>
		                        <div class="modal-footer">
		                             <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">保存</button>
		                        </div>
		                    </div>
		                    
		                </div>
		            </div>
		       		</c:forEach>
               </c:if>
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