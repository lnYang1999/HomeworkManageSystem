package wms.service;

import java.util.List;

import wms.dao.IClazzDao;
import wms.entity.Clazz;

public class ClazzManager implements IClazzManager {

	private IClazzDao clazzDao;
	
	public void setClazzDao(IClazzDao clazzDao) {
		this.clazzDao = clazzDao;
	}
	@Override
	public List<Clazz> getAllClazz() {
		// TODO Auto-generated method stub
		
		return clazzDao.getAllClazz();
	}

}
