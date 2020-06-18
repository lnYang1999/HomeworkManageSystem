<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page import="java.util.*" %>
<%@ page import="wms.entity.*" %>
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
	<title>查看批阅</title>
	<!--学生的整体框架-->

</head>
<body>

	<%
		int a = 0;
	%>

<!--整个页面栅格-->
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12" >
            <table class="table table-hover table-bordered table-striped">
                <thead>
                    <tr>
                        <th>序号</th>
                        <th>主题</th> 
                        <th>课程</th>
                        <th>截止时间</th>
                        <th>得分</th>
                        <th>评语</th>
                        <th>批阅状态</th>
                    </tr>
                </thead>
                <tbody>
                <c:if test="${!empty work }">
				<c:forEach items="${work }" var="w" varStatus="loop">
                    <tr >
                        <td><%=++a %></td>
                        <td>${w.w_title }</td>
                        <td>${w.w_course }</td>
                        <td>${w.w_deadline }</td>
                        <th>${checkwork[loop.count-1].ch_score }</th>
                        <td>
                            <a id="modal-${checkwork[loop.count-1].ch_id }" href="#${checkwork[loop.count-1].ch_id }" data-toggle="modal">查看</a>
                        </td>
                       <c:choose>
                       	<c:when test="${checkwork[loop.count-1].ch_score == 0 }">
                       		<td>未批阅</td>
                       	</c:when>
                       	<c:otherwise>
                       		<td style="color:green;">已批阅</td>
                       	</c:otherwise>
                       </c:choose>
                       
                        
                    </tr>
                </c:forEach>  
                </c:if>           
                </tbody>
            </table>
            <!--遮罩窗体-->
            <!--遮罩窗体111-->
            <c:if test="${!empty checkwork }">
            <c:forEach items="${checkwork }" var="cw" varStatus="loop">
            <div class="modal fade" id="${cw.ch_id }" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                             <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">
                                ${work[loop.count-1].w_title }
                            </h4>
                        </div>
                        <div class="modal-body">
                            ${cw.ch_mark }
                        </div>
                        <div class="modal-footer">
                             <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </div>
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