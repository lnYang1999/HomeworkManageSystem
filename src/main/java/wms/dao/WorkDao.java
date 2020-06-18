package wms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import wms.entity.Work;

public class WorkDao implements IWorkDao {

	//引入SessionFactory变量,SessionFactory接口负责初始化Hibernate。它充当数据存储源的代理，并负责创建Session对象
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addWork(Work work) {
		sessionFactory.getCurrentSession().save(work);
	}

	@Override
	public boolean deleteWork(int id) {
		String hql = "delete Work w where w.w_id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		return (query.executeUpdate()>0);	//大于0，删除成功
	}

	@Override
	public boolean updateWork(Work work) {
//		private int w_id;		//作业号
//		private String w_title;		//主题
//		private String w_content;	//内容
//		private String w_deadline;	//截止时间
//		private String w_course;	//课程号
//		private String w_t_account;	//教师号
//		private String w_c_id;		//班级号
		//System.out.println("222222:"+work.getId()+teacher.getT_account()+teacher.getT_name()+teacher.getT_sex()+teacher.getT_dept()+teacher.getT_password());
		String hql = "update Work w set w.w_title=?, w.w_content=?, w.w_deadline=?, w.w_course=?, w.w_t_account=? ,w.w_c_id=? where w.w_id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, work.getW_title());
		query.setString(1, work.getW_content());
		query.setString(2, work.getW_deadline());
		query.setString(3, work.getW_course());
		query.setString(4, work.getW_t_account());
		query.setString(5,work.getW_c_id());
		query.setInteger(6, work.getW_id());
		return (query.executeUpdate()>0);
	}

	@Override
	public Work getWork(int id) {
		String hql = "from Work w where w.w_id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		return (Work) query.uniqueResult();
	}

	@Override
	public List<Work> getAllWork() {
		String hql = "from Work";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	//*********学生用到的方法*************************************
	@Override
	public Work getWorkByWtitle(String Wtitle) {
		String hql = "from Work w where w.w_title=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, Wtitle);
 		return (Work) query.uniqueResult();
	}

}
