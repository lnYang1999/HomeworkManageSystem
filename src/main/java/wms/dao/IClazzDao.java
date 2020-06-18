package wms.dao;

import java.util.List;

import wms.entity.Clazz;

public interface IClazzDao {

	//*********教师用到的方法*************************************
	//获取全部班级
	public List<Clazz> getAllClazz();
	
}
