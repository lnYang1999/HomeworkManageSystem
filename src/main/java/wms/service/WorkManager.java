package wms.service;

import java.util.List;
 
import wms.dao.IWorkDao;
import wms.entity.Work;

public class WorkManager implements IWorkManager {

	private IWorkDao workDao;	//引入作业dao层接口
	
	public void setWorkDao(IWorkDao workDao) {
		this.workDao = workDao;
	}
	
	@Override
	public void addWork(Work work) {
		workDao.addWork(work);
	}

	@Override
	public boolean deleteWork(int id) {
		return workDao.deleteWork(id);
	}

	@Override
	public boolean updateWork(Work work) {
		return workDao.updateWork(work);
	}

	@Override
	public Work getWork(int id) {
		return workDao.getWork(id);
	}

	@Override
	public List<Work> getAllWork() {
		return workDao.getAllWork();
	}

	//*********学生用到的方法*************************************
	@Override
	public Work getWorkByWtitle(String Wtitle) {
		return workDao.getWorkByWtitle(Wtitle);
	}

}
