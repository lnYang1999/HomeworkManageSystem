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
    <!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
    <!-- 可选: 包含 jQuery 库 -->
    <script src="/WorkManageSystem/BootStrap/js/jquery-3.1.1.js"></script>
    <!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
    <script src="/WorkManageSystem/BootStrap/js/bootstrap.min.js"></script>
	<title>下载作业</title>
	<!--学生的整体框架-->

</head>
<body>
<!--整个页面栅格-->
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12" style=" ">
            <table class="table table-hover table-bordered table-striped">
                <thead>
                    <tr>
                        <th>序号</th>
                        <th>主题</th>
                        <th>课程</th>
                        <th>班级</th>
                        <th>截止时间</th>
                        <th>内容</th>
                        <th style="width: 45px;">
                            下载
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr >
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <th></th>
                        <td>
                            <a id="modal-1" href="#1" data-toggle="modal">查看</a>
                        </td>
                        <th>
                            <a type="button" class=" " href = "#">下载</a>
                        </th>
                    </tr>
                    <tr >
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <th></th>
                        <td>
                            <a id="modal-2" href="#2" data-toggle="modal">查看</a>
                        </td>
                        <th>
                            <a type="button" class=" " href = "#">下载</a>
                        </th>
                    </tr>
                    <tr >
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <th></th>
                        <td>
                            <a id="modal-3" href="#3" data-toggle="modal">查看</a>
                        </td>
                        <th>
                            <a type="button" class=" " href = "#">下载</a>
                        </th>
                    </tr>
                </tbody>
            </table>
            <!--遮罩窗体-->
            <!--遮罩窗体111-->
            <div class="modal fade" id="1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                             <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">
                                作业主题1
                            </h4>
                        </div>
                        <div class="modal-body">
                            内容...
                        </div>
                        <div class="modal-footer">
                             <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">保存</button>
                        </div>
                    </div>
                    
                </div>
            </div>
            <!--遮罩窗体222-->
            <div class="modal fade" id="2" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                             <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">
                                作业主题2
                            </h4>
                        </div>
                        <div class="modal-body">
                            内容...
                        </div>
                        <div class="modal-footer">
                             <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">保存</button>
                        </div>
                    </div>
                    
                </div>
                
            </div>
            <!--遮罩窗体333-->
            <div class="modal fade" id="3" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                             <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">
                                作业主题2
                            </h4>
                        </div>
                        <div class="modal-body">
                            内容...
                        </div>
                        <div class="modal-footer">
                             <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">保存</button>
                        </div>
                    </div>
                    
                </div>
                
            </div>
        </div>
    </div>

</div>
</body>
</html>