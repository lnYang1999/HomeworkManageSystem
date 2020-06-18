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
	<title>教师提交统计详细</title>
    <script type="text/javascript">
    //panel-check操作
        $(document).ready(function(){
        	//点击批改按钮
            $("a.check").click(function(){
                //alert("没错");
                $("div.panel-check").animate({
                  width:'toggle'
                });
            });
        });
    </script>
	<script type="text/javascript">
		function check(Sno,Sname,W_title,ch_id){
			//alert(Sno+Sname+W_title);
			//动态设置批改对象信息
			$("span.sno").html(Sno+":"+Sname+"------"+W_title);
			//设置隐藏input值
			$("input.ch_id").val(ch_id);
		}
	</script>
</head>
<body>

<%
	int a=0;
	int flag = 0;
	List<CheckWork> chW =(List<CheckWork>) session.getAttribute("checkwork");
	for(int i=0; i<chW.size(); i++){
		System.out.println("jsp123:"+chW.get(i).getCh_s_account());
	}
	List<Student> student = (List<Student>)session.getAttribute("student");
	for(int i=0; i<student.size(); i++){
		System.out.println("jsp456:"+student.get(i).getS_name());
	}
	String c_id = session.getAttribute("c_id").toString();
	String w_title = session.getAttribute("w_title").toString();
	int Wno = Integer.parseInt(session.getAttribute("Wno").toString());
	
	System.out.println("提交统计班级作业点击jsp--班级号:"+c_id);
	System.out.println("提交统计班级作业点击jsp--:作业号"+Wno);
	System.out.println("提交统计班级作业点击jsp--:作业主题"+w_title);
%>


    <div class="container" style=" ">
        <div class="row-fluid">
            <div class="span12">
                <div style="float: left; width: 100%;">
                <table class="table table-hover table-bordered table-striped">
                    <h3><%=c_id %>班:&nbsp;&nbsp;&nbsp;<%=w_title %>----------------提交统计情况</h3>
                    <thead>
                        <tr style="text-algin:center">
                            <th style="width: 45px;">序号</th>
                            <th style="width: 60px;">学号</th>
                            <th style="width: 60px;">姓名</th>
                            <th style="width: 45px;">性别</th>
                            <th style="width: 45px;">得分</th>
                            <th>评语</th>
                            <th style="width: 90px;">是否提交</th>
                            <th style="width: 100px;">提交时间</th>
                            <th style="width: 100px;">批阅时间</th>
                            <th style="width: 90px;">批阅结果</th>
                            <th style="width: 90px;">下载作业</th>
                        </tr>
                    </thead>
                    <tbody>
                    	
                    	<%
								for(int i=0; i<student.size(); i++){
						%>
									<tr >
												<td><%=++a %></td>
					                            <td><%=student.get(i).getS_account() %></td>
					                            <td><%=student.get(i).getS_name() %></td>
					                            <td><%=student.get(i).getS_sex()%></td>
						<%
									for(int j=0; j<chW.size(); j++){ 
										if( student.get(i).getS_account().equals(chW.get(j).getCh_s_account()) ){
						%>				
					                            <td><%=chW.get(j).getCh_score()  %></td>
					                            <td><%=chW.get(j).getCh_mark() %></td>
					                            <td>已提交</td>
					                            <td><%=chW.get(j).getCh_upTime().toString().substring(0,    chW.get(j).getCh_upTime().toString().length()-2) %></td>
					                            <%
					                            	System.out.println("提交时间"+j+"："+chW.get(j).getCh_upTime());
					                            	System.out.println("批改时间"+j+"："+chW.get(j).getCh_checkTime());
					                            		if( chW.get(j).getCh_score() ==0 ){
					                            %>			<td><%=chW.get(j).getCh_checkTime() %></td><!-- 此时为null -->
					                            			<td><a type="button" class="check" onclick="check('<%=student.get(i).getS_account() %>','<%=student.get(i).getS_name() %>','<%=w_title %>','<%=chW.get(j).getCh_id() %>')"  href = "javascript:void(0)">批阅</a></td>
					                            			<td><a href="/WorkManageSystem/teacher/Download?Wno=<%=Wno%>&c_id=<%=c_id%>&Uptime=<%=chW.get(j).getCh_upTime().toString().substring(0,chW.get(j).getCh_upTime().toString().length()-2) %>">下载</a></td>
					                            <%	}
					                            		else{
					                            %>			
					                            			<td><%=chW.get(j).getCh_checkTime().toString().substring(0, chW.get(j).getCh_checkTime().toString().length()-2)  %></td><!-- 此时已有时间 -->
					                            			<td><a style="color:#B23AEE;" type="button" class="check" onclick="check('<%=student.get(i).getS_account() %>','<%=student.get(i).getS_name() %>','<%=w_title %>','<%=chW.get(j).getCh_id() %>')"  href = "javascript:void(0)">已批阅</a></td>
					                            			<td><a href="/WorkManageSystem/teacher/Download?Wno=<%=Wno%>&c_id=<%=c_id%>&Uptime=<%=chW.get(j).getCh_upTime().toString().substring(0,chW.get(j).getCh_upTime().toString().length()-2) %>">下载</a></td>
					                            <%
					                            		}
					                            %>
					                            
					                           
				                        </tr>
						<%			
											flag = 1;
										}
									}
										if( flag==0 ){
						%>
					                            <td></td>
					                            <td></td>
					                            <td style="color:red;">未提交</td>
					                            <td></td>
					                            <td></td>
					                            <td> 无法批阅</td>
					                            <td>无</td>
				                        </tr>
						<%			
											flag = 1;
										}										
										
									flag=0;
								}
						%>
                    </tbody>
                </table>
                </div>
			<!-- 批改面板 -->
                <div class="panel-check" style="background-color: #F0F0F0;width: 100%;height: 100%; position: absolute;display: none;">
                	<form action="/WorkManageSystem/teacher/t_check" method = "post">
                		<!-- 隐藏表单传递批改号 -->
                		<input name = "ch_id" class = "ch_id" type = "hidden" value = "666">
                		<input name = "c_id" class = "c_id" type = "hidden" value = "<%=c_id%>"><!-- 班级号 -->
                		<input name = "Wno" class = "Wno" type = "hidden" value = "<%=Wno%>"><!-- 作业号 -->
                		
	                    <br><span class = "sno" style="margin-left:12%;"> 	&nbsp;&nbsp;&nbsp;&nbsp;</span>
	                    
	                    <!-- <span style="margin-left:280px;"><a type="button" onclick="Download()" href="javascript:void(0)">下载学生作业</a></span> -->
	                    <br><br>
	                    <textarea name = "ch_mark" rows="10" cols="100" style="resize: none;" style = "background-color: #F0F0F0;"></textarea>
	                    <div class="input-group input-group-sm" style="width: 250px;">
	                        <span class="input-group-addon">得分</span>
	                        <input name = "ch_score" type="text" class="form-control" style = "background-color: #F0F0F0;">
	                    </div><br><br>
	                    <div style=" margin-left: 12%;">
	                        <input type="submit" class="btn btn-primary" value="发布">
	                        <a class="check"><input type="button" class="btn btn-primary" value ="返回" style="margin-left: 40px;"></a>
	                    </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
</body>
</html>