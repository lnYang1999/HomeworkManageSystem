package wms.service;

import java.util.List;

import wms.entity.Manager;

public interface IManagerService {

	//*********登录用到的方法*************************************
	//获得一个管理员对象 -->(用于登录验证)
	public Manager getManagerLogin(String account);
		
	
	//*********管理员用到的方法*************************************
	//查询管理员表所有的数据
	public List<Manager> getAllManager();
	//查询一条管理员记录----通过名字
	public Manager getManagerByName(String name);
	//查询一条管理员记录----通过id
	public Manager getManagerById(int id);
	//修改管理员账号
	public boolean updateManagerAccount(int id, String account);
	//修改管理员姓名
	public boolean updateManagerName(int id, String name);
	//修改管理员密码
	public boolean updateManagerPassword(int id, String password);
	
}
