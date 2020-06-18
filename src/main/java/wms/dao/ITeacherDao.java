package wms.dao;

import java.util.List;

import wms.entity.Teacher;

public interface ITeacherDao {
	
	//*********管理员用到的方法*************************************
	//增加一条教师记录
	public void addTeacher(Teacher teacher);  
	//删除一条教师记录
	public boolean deleteTeacher(String id); 
	//修改一条教师记录
	public boolean updateTeacher(Teacher teacher);  
	//查询一条教师记录
	public Teacher getTeacher(int id);
	//查询教师表所有的数据
	public List<Teacher> getAllTeacher();
	
	
	//修改教师账号
	public boolean updateTeacherAccount(int id, String account);
	//修改教师姓名
	public boolean updateTeacherName(int id, String name);
	//修改教师密码
	public boolean updateTeacherPassword(int id, String password);
	
	
	
	//*********登录用到的方法*************************************
	//获得一个教师对象 -->(用于登录验证)
	public Teacher getTeacherLogin(String account);
	
	
	//*********教师用到的方法*************************************
	//修改一条教师姓名
	public boolean updateTeacherName(Teacher teacher);  
	
	
}
