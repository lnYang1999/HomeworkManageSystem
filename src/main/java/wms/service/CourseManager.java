package wms.service;

import java.util.List;

import wms.dao.ICourseDao;
import wms.entity.Course;

public class CourseManager implements ICourseManager{

	private ICourseDao courseDao;
	

	public void setCourseDao(ICourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Override
	public void addCourse(Course course) {
		courseDao.addCourse(course);
	}

	@Override
	public boolean deleteCourse(int id) {
		return courseDao.deleteCourse(id);
	}

	@Override
	public boolean updateCourse(Course course) {
		return courseDao.updateCourse(course);
	}

	@Override
	public Course getCourse(int id) {
		return courseDao.getCourse(id);
	}

	@Override
	public List<Course> getAllCourse() {
		return courseDao.getAllCourse();
	}

}
