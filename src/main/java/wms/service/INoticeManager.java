package wms.service;

import java.util.List;

import wms.entity.Notice;

public interface INoticeManager {

	//*********教师用到的方法*************************************
			//增加一条作业记录
			public void addNotice(Notice notice);
			//增加一条作业记录
			public boolean deleteNotice(int id);
			//修改一条作业记录
			public boolean updateNotice(Notice notice);
			//查询一条作业记录
			public Notice getNotice(int id);
			//查询作业表所有的数据
			public List<Notice> getAllNotice();
			//根据教师账号查询数据
			public List<Notice> getNoticeByTid(String t_id);
}
