package wms.dao;

import java.util.List;

import wms.entity.Notice;

public interface INoticeDao {

	//增加一条公告记录
	public void addNotice(Notice notice);
	//删除一条公告记录
	public boolean deleteNotice(int id);
	//修改一条公告记录
	public boolean updateNotice(Notice notice);
	//查询一条公告记录
	public Notice getNotice(int id);
	//查询公告表所有的数据
	public List<Notice> getAllNotice();
	//根据教师ID查公告数据
	public List<Notice> getNoticeByTid(String t_id);
	
	/*
	 	//增加一条作业记录
	public void addWork(Work work);
	//增加一条作业记录
	public boolean deleteWork(int id);
	//修改一条作业记录
	public boolean updateWork(Work work);
	//查询一条作业记录
	public Work getWork(int id);
	//查询作业表所有的数据
	public List<Work> getAllWork();
	  
	  */
}
