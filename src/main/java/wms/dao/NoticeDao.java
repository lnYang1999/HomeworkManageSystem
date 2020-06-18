package wms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import wms.entity.Notice;

public class NoticeDao implements INoticeDao{

	//引入SessionFactory变量,SessionFactory接口负责初始化Hibernate。它充当数据存储源的代理，并负责创建Session对象
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addNotice(Notice notice) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(notice);
	}

	@Override
	public boolean deleteNotice(int id) {
		// TODO Auto-generated method stub
		String hql = "delete Notice n where n.nt_id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		return (query.executeUpdate()>0);	//大于0，删除成功
	}

	@Override
	public boolean updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		String hql = "update Notice n set n.nt_title=?, n.nt_content=?, n.nt_time=?, n.nt_t_account=? ,n.nt_c_id=? where n.nt_id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, notice.getNt_title());
		query.setString(1, notice.getNt_content());
		query.setString(2, notice.getNt_time());
		query.setString(3, notice.getNt_t_account());
		query.setString(4, notice.getNt_c_id());
		query.setInteger(5, notice.getNt_id());
		return (query.executeUpdate()>0);
	}

	@Override
	public Notice getNotice(int id) {
		// TODO Auto-generated method stub
		String hql = "from Notice n where n.nt_id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		return (Notice) query.uniqueResult();
	}

	@Override
	public List<Notice> getAllNotice() {
		// TODO Auto-generated method stub
		String hql = "from Notice";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	public List<Notice> getNoticeByTid(String t_account){
		System.out.println("t_account123:"+t_account);
		String hql = "from Notice n where n.nt_t_account=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, t_account);
		List<Notice> notice = query.list();
		for( int i=0;i<notice.size(); i++ ){
			System.out.println("1111111111"+notice.get(i).getNt_content());
		}
		return query.list();
	}
}
