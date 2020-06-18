package wms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import wms.entity.Course;

public class CourseDao implements ICourseDao{

	//引入SessionFactory变量,SessionFactory接口负责初始化Hibernate。它充当数据存储源的代理，并负责创建Session对象
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addCourse(Course course) {//添加课程
		sessionFactory.getCurrentSession().save(course);
	}

	@Override
	public boolean deleteCourse(int id) {//删除课程
		String hql = "delete Course c where c.c_id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		return (query.executeUpdate()>0);	//大于0，删除成功
	}

	@Override
	public boolean updateCourse(Course course) {//修改课程信息,hql语句
		System.out.println("管理员--教师信息--修改:"+course.getC_id()+course.getC_name()+course.getC_credit());
		String hql = "update Course c set c.c_name=?, c.c_credit=? where c.c_id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, course.getC_name());
		query.setInteger(1, course.getC_credit());
		query.setInteger(2, course.getC_id());
		return (query.executeUpdate()>0);
	}

	@Override
	public Course getCourse(int id) {//根据id得到单个教师
		String hql = "from Course c where c.c_id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		return (Course) query.uniqueResult();
	}

	@Override
	public List<Course> getAllCourse() {//查找所有教师信息
		String hql = "from Course";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

}
