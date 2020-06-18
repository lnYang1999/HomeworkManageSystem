package wms.service;

import java.util.List;

import wms.dao.IStudentDao;
import wms.entity.CheckWork;
import wms.entity.Notice;
import wms.entity.Student;
import wms.entity.Work;

public class StudentManager implements IStudentManager{

	private IStudentDao studentDao;	//引入学生dao层接口
	
	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}

	@Override
	public boolean deleteStudent(String id) {
		return studentDao.deleteStudent(id);
	}

	@Override
	public boolean updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	@Override
	public Student getStudent(int id) {
		return studentDao.getStudent(id);
	}

	@Override
	public List<Student> getAllStudent() {
		return studentDao.getAllStudent();
	}

	@Override
	public boolean updateStudentName(Student student) {
		return studentDao.updateStudentName(student);
	}

	@Override
	public Student getStudentLogin(String account) {
		return studentDao.getStudentLogin(account);
	}

	@Override
	public boolean updateStudentPassword(Student student) {
		return studentDao.updateStudentPassword(student);
	}

	@Override
	public List<Notice> getAllNotice(String c_id) {
		return studentDao.getAllNotice(c_id);
	}

	@Override
	public List<Work> getAllWork(String w_c_id) {
		return studentDao.getAllWork(w_c_id);
	}

	@Override
	public boolean getCheckWorkStatus(int ch_w_id,String s_account) {
		return studentDao.getCheckWorkStatus(ch_w_id,s_account);
	}

	@Override
	public String getWork_TeacherName(String t_account) {
		return studentDao.getWork_TeacherName(t_account);
	}

	@Override
	public List<CheckWork> getAllCheckWork(String s_account) {
		return studentDao.getAllCheckWork(s_account);
	}

	@Override
	public Work getWorkBycheckwork(int ch_w_id) {
		return studentDao.getWorkBycheckwork(ch_w_id);
	}
	
	@Override
	public List<Student> getStudentByCLno(String CLno) {
		return studentDao.getStudentByCLno(CLno);
	}

	@Override
	public String getTeacherNameByAccount(String t_account) {
		return studentDao.getTeacherNameByAccount(t_account);
	}

	@Override
	public String getClazzBySno(String Sno) {
		return studentDao.getClazzBySno(Sno);
	}
}
