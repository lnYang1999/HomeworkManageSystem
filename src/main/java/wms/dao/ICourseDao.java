package wms.dao;

import java.util.List;

import wms.entity.Course;

public interface ICourseDao {
	
	//*********课程用到的方法*************************************
	//增加一条课程记录
	public void addCourse(Course course);  
	//删除一条课程记录
	public boolean deleteCourse(int id); 
	//修改一条课程记录
	public boolean updateCourse(Course course);  
	//查询一条课程记录
	public Course getCourse(int id);
	//查询课程表所有的数据
	public List<Course> getAllCourse();
	
	
}
