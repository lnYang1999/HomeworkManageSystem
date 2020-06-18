package wms.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import wms.entity.CheckWork; 

public class CheckWorkDao implements ICheckWorkDao{

	//引入SessionFactory变量,SessionFactory接口负责初始化Hibernate。它充当数据存储源的代理，并负责创建Session对象
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void addCheckWork(CheckWork checkwork) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(checkwork);
	}

	@Override
	public boolean deleteCheckWork(int id) {
		// TODO Auto-generated method stub
		String hql = "delete CheckWork ch where ch.ch_id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		return (query.executeUpdate()>0);	//大于0，删除成功
	}

	@Override
	public boolean updateCheckWork(CheckWork checkwork) {
		// TODO Auto-generated method stub
		String hql = "update CheckWork ch set ch._s_account=?, ch.ch_w_id=?, ch.ch_score=?, ch.ch_mark=?, ch.ch_checkTime=? ,ch.ch_upTime=?,ch.ch_path where ch.ch_id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, checkwork.getCh_s_account());
		query.setInteger(1, checkwork.getCh_w_id());
		query.setInteger(2, checkwork.getCh_score());
		query.setString(3, checkwork.getCh_mark());
		query.setTimestamp(4, checkwork.getCh_checkTime());
		query.setTimestamp(5,checkwork.getCh_upTime());
		query.setString(6,checkwork.getCh_path());
		query.setInteger(7, checkwork.getCh_id());
		return (query.executeUpdate()>0);
	}

	@Override
	public CheckWork getCheckWork(int id) {
		// TODO Auto-generated method stub
		String hql = "from CheckWork ch where ch.ch_id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		return (CheckWork) query.uniqueResult();
	}

	@Override
	public List<CheckWork> getAllCheckWork() {
		// TODO Auto-generated method stub
		String hql = "from CheckWork";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	
	
	
	
	//通过作业号和班级号查找一条批改作业记录
	@Override
	public List<CheckWork> getCheckWorkByWnoClno(int wno, String CLno) {
		System.out.println("1111111作业号,班级号:"+wno+"  "+CLno);
//			String hql = "select *from CheckWork where CheckWork.ch_w_id=? and CheckWork.ch_c_id=?";
//			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql);
		String hql = "from CheckWork ch where ch.ch_w_id=? and ch.ch_c_id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, wno);
		query.setString(1, CLno);
		
		for(int i=0; i<query.list().size(); i++){
			System.out.println("提交统计班级作业点击asdas123:"+((CheckWork) query.list().get(i)).getCh_s_account());
		}
		return query.list();
	}
	
	@Override
	public boolean Check(String ch_mark, int ch_score, int ch_id) {
		// TODO Auto-generated method stub
		String hql  = "update CheckWork ch set ch.ch_mark=?,ch.ch_score=? ,ch.ch_checkTime=? where ch.ch_id=?";
//		String sql  = "update CheckWork set ch_mark="+ch_mark+",ch_score="+ch_score+" ,ch_checkTime="+"now()"+" where ch_id="+ch_id;
		
		Date date = new Date();
		String time =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		System.out.println(time);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, ch_mark);
		query.setInteger(1, ch_score);
		query.setString(2,  time);
		query.setInteger(3, ch_id);
		return (query.executeUpdate()>0);
		
	}
	
	
	
	//上传文件时向提交表（CheckWork）中插入数据
	@Override
	public boolean addCheckWorkByFile(String Sno, String clazz, int Wno, String Uptime, String path) {
		String sql = "insert into CheckWork(ch_s_account,ch_c_id,ch_w_id,ch_score,ch_mark,ch_checkTime,ch_upTime,ch_path) values(?,?,?,?,?,?,?,?)";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setString(0, Sno);
		query.setString(1, clazz);
		query.setInteger(2, Wno);
		query.setInteger(3, 0);
		query.setString(4, null);
		query.setString(5, null);
		query.setString(6, Uptime);
		query.setString(7, path);
		return (query.executeUpdate() > 0);
	}
		
	//上传文件时向提交表（CheckWork）中---更新数据
	public boolean updateCheckWorkByFile(String Sno,String clazz, int Wno, String Uptime, String path){
		String sql = "update CheckWork set CheckWork.ch_upTime=?, CheckWork.ch_path=? where CheckWork.ch_s_account=? and CheckWork.ch_w_id=? ";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setString(0, Uptime);
		query.setString(1, path);
		query.setString(2, Sno);
		query.setInteger(3, Wno);
		return (query.executeUpdate() > 0);
	}
		
	
	//通过作业号和学号查找一条批改作业记录
	public CheckWork getCheckWorkByWnoSno(int wno, String Sno){
		String hql = "from CheckWork ch where ch.ch_w_id=? and ch.ch_s_account=? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, wno);
		query.setString(1, Sno);
		
		if( query.uniqueResult() != null ){
			return (CheckWork) query.uniqueResult();
		}
		return null;
	}
	
	/*//通过id号判断是否有成绩和评语，若有则表示教师已批改过，否则未批改过。
	public boolean getCheckResult(int id){
		String hql = "from CheckWork ch where ch.ch_id = ?";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql);
		query.setInteger(0, id);
		
		
		return true;
	}*/
	
}
