package wms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import wms.entity.CheckWork;
import wms.entity.Notice;
import wms.entity.Student;
import wms.entity.Work;

public class StudentDao implements IStudentDao{

	//引入SessionFactory变量,SessionFactory接口负责初始化Hibernate。它充当数据存储源的代理，并负责创建Session对象
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//*********管理员用到的方法*************************************************************************************************************
	@Override
	public void addStudent(Student student) {	//增加学生
		sessionFactory.getCurrentSession().save(student);
	}

	@Override
	public boolean deleteStudent(String id) {//删除学生
		String hql = "delete Student s where s.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		
		return (query.executeUpdate()>0);	//大于0，删除成功
	}

	@Override
	public boolean updateStudent(Student student) {//修改学生信息,hql语句
		System.out.println("管理员--学生信息--修改:"+student.getId()+student.getS_account()+student.getS_name()+student.getS_sex()+student.getS_c_id()+student.getS_password()+student.getS_dept());
		String hql = "update Student s set s.s_account=?, s.s_name=?, s.s_sex=?, s.s_c_id=?, s.s_password=?, s.s_dept=? where s.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, student.getS_account());
		query.setString(1, student.getS_name());
		query.setString(2, student.getS_sex());
		query.setString(3, student.getS_c_id());
		query.setString(4, student.getS_password());
		query.setString(5, student.getS_dept());
		query.setInteger(6, student.getId());
		return (query.executeUpdate()>0);
	}

	@Override
	public Student getStudent(int id) {//根据id得到单个学生
		String hql = "from Student s where s.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		return (Student) query.uniqueResult();
	}

	@Override
	public List<Student> getAllStudent() {//查找所有学生信息
		String hql = "from Student";		//------针对实体表Student
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	//*********登录用到的方法************************************************************
	@Override
	public Student getStudentLogin(String account) {	//获得一个学生对象 -->(用于登录验证)
		String hql = "from Student s where s.s_account=?";
		Query query = sessionFactory.openSession().createQuery(hql).setString(0,account);
		return (Student)query.uniqueResult();
	}
	
	//*********学生用到的方法************************************************************
	@Override
	public boolean updateStudentName(Student student) {	//修改一条学生姓名
		String hql = "update Student s set s.s_name=? where s.s_account=?";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setString(0, student.getS_name());
		query.setString(1, student.getS_account());
		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateStudentPassword(Student student) {	
		String hql = "update Student s set s.s_password=? where s.s_account=?";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setString(0, student.getS_password());
		query.setString(1, student.getS_account());
		return (query.executeUpdate() > 0);
	}

	@Override
	public List<Notice> getAllNotice(String c_id) {
		String hql = "from Notice n where n.nt_c_id=?";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setString(0, c_id);		
		return query.list();
	}

	@Override
	public List<Work> getAllWork(String w_c_id) {
		String hql = "from Work w where w.w_c_id=?";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setString(0, w_c_id);
		return query.list();
	}

	@Override
	public boolean getCheckWorkStatus(int ch_w_id,String s_account) {
		String hql = "from CheckWork cw where cw.ch_w_id=? and cw.ch_s_account=?";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setInteger(0, ch_w_id);
		query.setString(1, s_account);
		return (query.uniqueResult()!=null);
	}

	@Override
	public String getWork_TeacherName(String t_account) {
		String sql = "select t_name from teacher where t_account=?";
		SQLQuery sqlquery = sessionFactory.openSession().createSQLQuery(sql);
		sqlquery.setString(0, t_account);
		return (String)sqlquery.uniqueResult();
	}

	@Override
	public List<CheckWork> getAllCheckWork(String s_account) {
		String hql = "from CheckWork cw where cw.ch_s_account=?";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setString(0, s_account);
		return query.list();
	}

	@Override
	public Work getWorkBycheckwork(int ch_w_id) {
		String hql = "from Work w where w.w_id=?";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setInteger(0, ch_w_id);
		return (Work)query.uniqueResult();
	}
	
	
	//根据学号获取班级号(上传作业，学号-->班级号-->作业主题)
	@Override
	public String getClazzBySno(String Sno){
		String sql = "select s_c_id from Student where Student.s_account=?";
		SQLQuery query = sessionFactory.openSession().createSQLQuery(sql);
		query.setString(0, Sno);
		return (String)query.uniqueResult();
	}
	
	

	//教师用到的方法******************************************************************
	@Override
	public List<Student> getStudentByCLno(String CLno) {
		String hql = "from Student s where s.s_c_id = ?";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setString(0, CLno);
		
		return query.list();
	}
	@Override
	public String getTeacherNameByAccount(String t_account) {
		String sql = "select t_name from teacher where t_account=?";
		SQLQuery sqlquery = sessionFactory.openSession().createSQLQuery(sql);
		sqlquery.setString(0, t_account);
		return (String)sqlquery.uniqueResult();
	}

}
