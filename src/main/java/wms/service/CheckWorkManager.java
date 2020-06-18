package wms.service;

import java.util.List;

import wms.dao.ICheckWorkDao;
import wms.entity.CheckWork;

public class CheckWorkManager implements ICheckWorkManager {

	private ICheckWorkDao checkWorkDao;	//引入教师dao层接口
	
	public void setCheckWorkDao(ICheckWorkDao checkWorkDao) {
		this.checkWorkDao = checkWorkDao;
	}
	@Override
	public void addCheckWork(CheckWork checkwork) {
		// TODO Auto-generated method stub
		checkWorkDao.addCheckWork(checkwork);
	}

	@Override
	public boolean deleteCheckWork(int id) {
		// TODO Auto-generated method stub
		return checkWorkDao.deleteCheckWork(id);
	}

	@Override
	public boolean updateCheckWork(CheckWork checkwork) {
		// TODO Auto-generated method stub
		return checkWorkDao.updateCheckWork(checkwork);
	}

	@Override
	public CheckWork getCheckWork(int id) {
		// TODO Auto-generated method stub
		return checkWorkDao.getCheckWork(id);
	}

	@Override
	public List<CheckWork> getAllCheckWork() {
		// TODO Auto-generated method stub
		return checkWorkDao.getAllCheckWork();
	}
	
	@Override
	public List<CheckWork> getCheckWorkByWnoClno(int wno, String CLno) {
		return checkWorkDao.getCheckWorkByWnoClno(wno, CLno);
	}
	
	//*********学生用到的方法*************************************
	//上传文件时向提交表（CheckWork）中插入数据
	@Override
	public boolean addCheckWorkByFile(String Sno, String clazz, int Wno, String Uptime, String path) {
		return checkWorkDao.addCheckWorkByFile(Sno, clazz, Wno, Uptime, path);
	}
	
	
	
	//批改-添加评语和分数
	@Override
	public boolean Check(String ch_mark, int ch_score, int ch_id) {
		return checkWorkDao.Check(ch_mark, ch_score, ch_id);
	}
	
	//通过作业号和学号查找一条批改作业记录
	public CheckWork getCheckWorkByWnoSno(int wno, String Sno){
		return checkWorkDao.getCheckWorkByWnoSno(wno, Sno);
	}
	
	//上传文件时向提交表（CheckWork）中更新数据
	public boolean updateCheckWorkByFile(String Sno,String clazz, int Wno, String Uptime, String path){
		return checkWorkDao.updateCheckWorkByFile(Sno, clazz, Wno, Uptime, path);
	}
		
	
	/*//通过id号判断是否有成绩和评语，若有则表示教师已批改过，否则未批改过。
	public boolean getCheckResult(int id){
		return checkWorkDao.getCheckResult(id);
	}*/
	
}
