package wms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import wms.entity.Manager;

public class ManagerDao implements IManagerDao{

	//引入SessionFactory变量,SessionFactory接口负责初始化Hibernate。它充当数据存储源的代理，并负责创建Session对象
	private SessionFactory sessionFactory;
		
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//*********登录用到的方法*************************************
	//获得一个管理员对象 -->(用于登录验证)
	public Manager getManagerLogin(String account){
		String hql = "from Manager m where m.m_account=?";
		Query query = sessionFactory.openSession().createQuery(hql).setString(0,account);
		return (Manager)query.uniqueResult();
	}

	//*********管理员用到的方法*************************************
	@Override
	public List<Manager> getAllManager() {	//查询管理员表所有的数据
		String hql = "from Manager";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public Manager getManagerByName(String name) {	//查询一条管理员记录----通过名字
		String hql = "from Manager m where m.m_name = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		return (Manager) query.uniqueResult();
	}
	
	@Override
	public Manager getManagerById(int id) {		//查询一条管理员记录----通过id
		String hql = "from Manager m where m.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (Manager) query.uniqueResult();
	}

	@Override
	public boolean updateManagerAccount(int id, String account) {	//修改管理员账号
		String hql = "update Manager m set m.m_account=? where m.id=? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, account);
		query.setInteger(1, id);
		return (query.executeUpdate()>0);
	}

	@Override
	public boolean updateManagerName(int id, String name) {	//修改管理员姓名
		String hql = "update Manager m set m.m_name =? where m.id=? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		query.setInteger(1, id);
		return (query.executeUpdate()>0);
	}

	@Override
	public boolean updateManagerPassword(int id, String password) {	//修改管理员密码
		String hql = "update Manager m set m.m_password=? where m.id=? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, password);
		query.setInteger(1, id);
		return (query.executeUpdate()>0);
	}

	
	
}
