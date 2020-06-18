package wms.service;

import java.util.List;

import wms.dao.ITeacherDao;
import wms.entity.Teacher;

public class TeacherManager implements ITeacherManager{

	private ITeacherDao teacherDao;	//引入教师dao层接口
	
	public void setTeacherDao(ITeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		teacherDao.addTeacher(teacher);
	}

	@Override
	public boolean deleteTeacher(String id) {
		return teacherDao.deleteTeacher(id);
	}

	@Override
	public boolean updateTeacher(Teacher teacher) {
		return teacherDao.updateTeacher(teacher);
	}

	@Override
	public Teacher getTeacher(int id) {
		return teacherDao.getTeacher(id);
	}

	@Override
	public List<Teacher> getAllTeacher() {
		return teacherDao.getAllTeacher();
	}

	@Override
	public boolean updateTeacherName(Teacher teacher) {
		return teacherDao.updateTeacherName(teacher);
	}

	@Override
	public Teacher getTeacherLogin(String account) {
		return teacherDao.getTeacherLogin(account);
	}

	@Override
	public boolean updateTeacherAccount(int id, String account) {
		// TODO Auto-generated method stub
		return teacherDao.updateTeacherAccount(id, account);
	}

	@Override
	public boolean updateTeacherName(int id, String name) {
		// TODO Auto-generated method stub
		return teacherDao.updateTeacherName(id, name);
	}

	@Override
	public boolean updateTeacherPassword(int id, String password) {
		// TODO Auto-generated method stub
		return teacherDao.updateTeacherPassword(id, password);
	}
	
}
