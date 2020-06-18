package wms.service;

import java.util.List;

import wms.entity.CheckWork;

public interface ICheckWorkManager {

	//*********教师用到的方法*************************************
	//增加一条作业记录
	public void addCheckWork(CheckWork checkwork);
	//增加一条作业记录
	public boolean deleteCheckWork(int id);
	//修改一条作业记录
	public boolean updateCheckWork(CheckWork checkwork);
	//查询一条作业记录
	public CheckWork getCheckWork(int id);
	//查询作业表所有的数据
	public List<CheckWork> getAllCheckWork();
	
	//通过作业号和班级号查找一条批改作业记录
	public List<CheckWork> getCheckWorkByWnoClno(int wno, String CLno);
	
	
	
	//批改-添加评语和分数
	public boolean Check(String ch_mark,int ch_score,int ch_id);
	
	
	//*********学生用到的方法*************************************
	//上传文件时向提交表（CheckWork）中插入数据
	public boolean addCheckWorkByFile(String Sno,String clazz, int Wno, String Uptime, String path);
	
	//上传文件时向提交表（CheckWork）中更新数据
	public boolean updateCheckWorkByFile(String Sno,String clazz, int Wno, String Uptime, String path);
		
	
	//通过作业号和学号查找一条批改作业记录
	public CheckWork getCheckWorkByWnoSno(int wno, String Sno);
		
	/*//通过id号判断是否有成绩和评语，若有则表示教师已批改过，否则未批改过。
	public boolean getCheckResult(int id);*/
	
}
