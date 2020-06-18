package wms.dao;

import java.util.List;

import wms.entity.CheckWork;
import wms.entity.Notice;
import wms.entity.Student;
import wms.entity.Work;

public interface IStudentDao {
	
	//*********管理员用到的方法************************************************************
	//增加一条学生记录
	public void addStudent(Student student);  
	//删除一条学生记录
	public boolean deleteStudent(String id); 
	//修改一条学生记录
	public boolean updateStudent(Student student);  
	//查询一条学生记录
	public Student getStudent(int id);
	//查询学生表所有的数据
	public List<Student> getAllStudent();
	
	
	//*********登录用到的方法************************************************************
	//获得一个学生对象 -->(用于登录验证)
	public Student getStudentLogin(String account);
	
	
	//*********学生用到的方法************************************************************
	//修改一个学生姓名
	public boolean updateStudentName(Student student);  
	
	//修改一个学生的密码
	public boolean updateStudentPassword(Student student);
	//获得学生的公告
	public List<Notice> getAllNotice(String c_id);
	//获得学生的所有作业
	public List<Work> getAllWork(String w_c_id);
	//获得学生的作业批改状态
	public boolean getCheckWorkStatus(int ch_w_id,String s_account);
	//获得作业的教师姓名
	public String getWork_TeacherName(String t_account);
	//获得批阅列表
	public List<CheckWork> getAllCheckWork(String s_account);
	//获得已提交作业
	public Work getWorkBycheckwork(int ch_w_id);
	
	
	
	//根据学号获取班级号(上传作业，学号-->班级号-->作业主题)
	public String getClazzBySno(String Sno);
	
	public String getTeacherNameByAccount(String t_account);
	//***************教师用到的方法******************************************
	//通过班级号查询一条学生记录
	public List<Student> getStudentByCLno(String CLno);
	
}
