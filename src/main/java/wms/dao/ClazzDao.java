package wms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import wms.entity.Clazz;

public class ClazzDao implements IClazzDao{

	//引入SessionFactory变量,SessionFactory接口负责初始化Hibernate。它充当数据存储源的代理，并负责创建Session对象
		private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
	@Override
	public List<Clazz> getAllClazz() {
		// TODO Auto-generated method stub
		String hql = "from Clazz";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	

}
