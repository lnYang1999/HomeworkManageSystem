package wms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import wms.entity.Teacher;

public class TeacherDao implements ITeacherDao{

	//引入SessionFactory变量,SessionFactory接口负责初始化Hibernate。它充当数据存储源的代理，并负责创建Session对象
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addTeacher(Teacher teacher) {//添加教师
		sessionFactory.getCurrentSession().save(teacher);
	}

	@Override
	public boolean deleteTeacher(String id) {//删除教师
		String hql = "delete Teacher t where t.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		
		return (query.executeUpdate()>0);	//大于0，删除成功
	}

	@Override
	public boolean updateTeacher(Teacher teacher) {//修改教师信息,hql语句
		System.out.println("管理员--教师信息--修改:"+teacher.getId()+teacher.getT_account()+teacher.getT_name()+teacher.getT_sex()+teacher.getT_dept()+teacher.getT_password());
		String hql = "update Teacher t set t.t_account=?, t.t_name=?, t.t_sex=?, t.t_dept=?, t.t_password=? where t.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, teacher.getT_account());
		query.setString(1, teacher.getT_name());
		query.setString(2, teacher.getT_sex());
		query.setString(3, teacher.getT_dept());
		query.setString(4, teacher.getT_password());
		query.setInteger(5, teacher.getId());
		return (query.executeUpdate()>0);
	}

	@Override
	public Teacher getTeacher(int id) {//根据id得到单个教师
		String hql = "from Teacher t where t.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		return (Teacher) query.uniqueResult();
	}

	@Override
	public List<Teacher> getAllTeacher() {//查找所有教师信息
		String hql = "from Teacher";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	
	@Override
	public boolean updateTeacherAccount(int id, String account) {		//修改教师账号
		// TODO Auto-generated method stub
		String hql = "update Teacher t set t.t_account=? where t.id=? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, account);
		query.setInteger(1, id);
		return (query.executeUpdate()>0);
	}

	@Override
	public boolean updateTeacherName(int id, String name) {				//修改教师姓名
		// TODO Auto-generated method stub
		String hql = "update Teacher t set t.t_name =? where t.id=? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		query.setInteger(1, id);
		return (query.executeUpdate()>0);
	}

	@Override
	public boolean updateTeacherPassword(int id, String password) {		//修改教师密码
		// TODO Auto-generated method stub
		String hql = "update Teacher t set t.t_password=? where t.id=? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, password);
		query.setInteger(1, id);
		return (query.executeUpdate()>0);
	}
	
	
	@Override
	public boolean updateTeacherName(Teacher teacher) {//修改一条教师姓名
		String hql = "update Teacher t set t.t_name=? where t.t_account=?";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setString(0, teacher.getT_name());
		query.setString(1, teacher.getT_account());
		return (query.executeUpdate() > 0);
	}

	@Override
	public Teacher getTeacherLogin(String account) {//获得一个教师对象 -->(用于登录验证)
		String hql = "from Teacher t where t.t_account=?";
		Query query = sessionFactory.openSession().createQuery(hql).setString(0,account);
		return (Teacher)query.uniqueResult();
	}

}
