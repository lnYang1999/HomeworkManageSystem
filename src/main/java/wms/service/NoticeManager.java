package wms.service;

import java.util.List;

import wms.dao.INoticeDao;
import wms.entity.Notice;

public class NoticeManager implements INoticeManager{

	private INoticeDao noticeDao;	//引入教师dao层接口
	
	public void setNoticeDao(INoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	@Override
	public void addNotice(Notice notice) {
		// TODO Auto-generated method stub
		noticeDao.addNotice(notice);
	}

	@Override
	public boolean deleteNotice(int id) {
		// TODO Auto-generated method stub
		return noticeDao.deleteNotice(id);
	}

	@Override
	public boolean updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		return noticeDao.updateNotice(notice);
	}

	@Override
	public Notice getNotice(int id) {
		// TODO Auto-generated method stub
		return noticeDao.getNotice(id);
	}

	@Override
	public List<Notice> getAllNotice() {
		// TODO Auto-generated method stub
		return noticeDao.getAllNotice();
	}
	
	public List<Notice> getNoticeByTid(String t_id){
		
		return noticeDao.getNoticeByTid(t_id);
	}

}
