package wms.service;

import java.util.List;

import wms.entity.Work;

public interface IWorkManager {
	
	//*********作业用到的方法*************************************
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
	
	
	//*********学生用到的方法*************************************
	public Work getWorkByWtitle(String Wtitle);
	
	
}
