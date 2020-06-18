package wms.service;

import java.util.List;

import wms.dao.IManagerDao;
import wms.entity.Manager;

public class ManagerService implements IManagerService{

	private IManagerDao managerDao;	//引入学生dao层接口
	
	public void setManagerDao(IManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	//*********登录用到的方法*************************************
	@Override
	public Manager getManagerLogin(String account) {	//获得一个管理员对象 -->(用于登录验证)
		return managerDao.getManagerLogin(account);
	}

	
	//*********管理员用到的方法*************************************
	@Override
	public List<Manager> getAllManager() {		//查询管理员表所有的数据
		return managerDao.getAllManager();
	}

	@Override
	public Manager getManagerByName(String name) {			//查询一条管理员记录----通过名字
		return managerDao.getManagerByName(name);
	}
	
	@Override
	public Manager getManagerById(int id) {					//查询一条管理员记录----通过id
		return managerDao.getManagerById(id);
	}

	@Override
	public boolean updateManagerAccount(int id, String account) {		//修改管理员账号
		return managerDao.updateManagerAccount(id, account);
	}

	@Override
	public boolean updateManagerName(int id, String name) {			//修改管理员姓名
		return managerDao.updateManagerName(id, name);
	}

	@Override
	public boolean updateManagerPassword(int id, String password) {		//修改管理员密码
		return managerDao.updateManagerPassword(id, password);
	}


}
