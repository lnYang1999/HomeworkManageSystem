package wms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import wms.entity.Course;
import wms.entity.Manager;
import wms.entity.Student;
import wms.entity.Teacher;
import wms.service.ICourseManager;
import wms.service.IManagerService;
import wms.service.IStudentManager;
import wms.service.ITeacherManager;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Resource(name="managerManager")
	private IManagerService managerManager;	//引入管理员services层接口
	
	@Resource(name="teacherManager")
	private ITeacherManager teacherManager;	//引入教师services层接口
	
	@Resource(name="studentManager")
	private IStudentManager studentManager;	//引入学生services层接口
	
	@Resource(name="courseManager")
	private ICourseManager courseManager;	//引入课程services层接口
	
	

/*-------------------------------framework(导航栏)页面操作---------------------------------------------------------------------------------------**/	
	/*
	 * 管理员页面(导航栏)------教师总览-------页面（内嵌）
	 */
	@RequestMapping("/m_teachermanage")
	public String m_teachermanage(Model model,HttpSession session){
		//设置面包屑导航
		List<String> listNav = (List)session.getAttribute("listNav");
		listNav.add("教师总览");
		session.setAttribute("listNav", listNav);
		List<Teacher> teacher1 = teacherManager.getAllTeacher();
		System.out.println("teacher教师总览页面:"+teacher1.get(0).getT_account()+","+teacher1.get(0).getT_name()+","+teacher1.get(0).getT_password());
		model.addAttribute("teacher", teacher1);
		return "manager/m_teachermanage";
	}
	
	/*
	 * 管理员页面(导航栏)------教师添加------按钮(导航栏跳转)
	 */
	@RequestMapping("/m_addteacher")
	public String m_addteacher(){
		return "manager/m_addteacher";
	}
	
	/*
	 * 管理员页面(导航栏)------学生总览-------页面（内嵌）
	 */
	@RequestMapping("/m_studentmanage")
	public String m_studentmanage(Model model){
		List<Student> student1 = studentManager.getAllStudent();
		System.out.println("student:"+student1.get(0).getS_account()+","+student1.get(0).getS_name()+","+student1.get(0).getS_password());
		model.addAttribute("student", student1);
		return "manager/m_studentmanage";
	}
	
	/*
	 * 管理员页面(导航栏)------学生添加------按钮(导航栏跳转)
	 */
	@RequestMapping("/m_addstudent")
	public String m_addstudent(){
		return "manager/m_addstudent";
	}
	
	/*
	 * 管理员页面(导航栏)------课程总览-------页面（内嵌）
	 */
	@RequestMapping("/m_coursemanage")
	public String m_coursemanage(Model model){
		List<Course> course1 = courseManager.getAllCourse();
		System.out.println("管理员页面----课程总览:"+course1.get(0).getC_id()+","+course1.get(0).getC_name()+","+course1.get(0).getC_credit());
		model.addAttribute("course", course1);
		return "manager/m_coursemanage";
	}
	
	/*
	 * 管理员页面(导航栏)------课程添加------按钮(导航栏跳转)
	 */
	@RequestMapping("/m_addcourse")
	public String m_addcourse(){
		return "manager/m_addcourse";
	}
	
	/*
	 * 管理员页面(导航栏)------个人设置------按钮(导航栏跳转)
	 */
	@RequestMapping("/m_personalseting")
	public String m_personalseting(Model model){//@RequestParam("m_name") String m_name,
		/*System.out.println("管理员页面---个人设置---按钮(导航栏跳转)----m_name:"+m_name);
		Manager manager = managerManager.getManagerByName(m_name);*/
		//System.out.println("点击个人设置--->管理员信息:"+manager.getId()+","+manager.getM_name()+","+manager.getM_account()+","+manager.getM_password());
		//model.addAttribute("m", manager);
		return "manager/m_personalseting";
	}
	
/*---------------------------------------------iframe内嵌页面操作-----------------------------------------------------------------------***/	
	/*
	 * 管理员页面（内嵌页面）------添加教师
	 */
	@RequestMapping("/addTeacher")
	public String addTeacher(Teacher teacher,Model model){
		System.out.println("管理员页面（内嵌页面）------添加教师:"+teacher.getT_account()+","+teacher.getT_name()+","+teacher.getT_password());
		teacherManager.addTeacher(teacher);
		model.addAttribute("teacher", teacher);
		return "redirect:/manager/m_teachermanage";	//重定向到-->教师总览页面（内嵌）
	}
	
	/*
	 * 管理员页面（内嵌页面）------添加学生
	 */
	@RequestMapping("/addStudent")
	public String addStudent(Student student,Model model){
		System.out.println("管理员页面（内嵌页面）------添加学生:"+student.getS_account()+","+student.getS_name()+","+student.getS_password());
		studentManager.addStudent(student);
		model.addAttribute("student", student);
		return "redirect:/manager/m_studentmanage"; //重定向到-->学生总览页面（内嵌）
	}
	
	/*
	 * 管理员页面（内嵌页面）------添加课程
	 */
	@RequestMapping("/addCourse")
	public String addCourse(Course course,Model model){
		System.out.println("管理员页面（内嵌页面）------添加课程:"+course.getC_id()+","+course.getC_name()+","+course.getC_credit());
		courseManager.addCourse(course);
		model.addAttribute("course", course);
		return "redirect:/manager/m_coursemanage"; //重定向到-->课程总览页面（内嵌）
	}
	
	/*
	 * 管理员页面（内嵌页面）------得到教师表
	 */
	@RequestMapping("/getAllTeacher")
	public String getAllTeacher(Model model){
		List<Teacher> teacher = teacherManager.getAllTeacher();
		model.addAttribute("teacher", teacher);
		return "/manager/manager";
	}
	
	/*
	 * 管理员页面（内嵌页面）------删除教师
	 */
	@RequestMapping("/delTeacher")
	public void delTeacher(String id,HttpServletResponse response){
		String result = "{\"result\":\"error\"}";
		if( teacherManager.deleteTeacher(id) ){
			result = "{\"result\":\"success\"}";
		}
		response.setContentType("application/json");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 管理员页面（内嵌页面）------删除学生
	 */
	@RequestMapping("/delStudent")
	public void delStudent(String id,HttpServletResponse response){
		String result = "{\"result\":\"error\"}";
		if( studentManager.deleteStudent(id) ){
			result = "{\"result\":\"success\"}";
		}
		response.setContentType("application/json");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 管理员页面（内嵌页面）------删除课程
	 */
	@RequestMapping("/delCourse")
	public void delCourse(int id,HttpServletResponse response){
		String result = "{\"result\":\"error\"}";
		if( courseManager.deleteCourse(id) ){
			result = "{\"result\":\"success\"}";
		}
		response.setContentType("application/json");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 管理员页面（内嵌页面）------(点击修改教师按钮)-->挑转到教师修改页面
	 */
	@RequestMapping("/updateTeacher_jsp")
	public String updateTeacher_jsp(int id ,Model model){
		System.out.println("教师："+id);
		Teacher teacher = teacherManager.getTeacher(id);
		model.addAttribute("t", teacher);
		return "manager/m_updateteacher";
	}
	
	/*
	 * 管理员页面（内嵌页面）------修改教师信息
	 */
	@RequestMapping("/updateTeacher")
	public String updateTeacher(Teacher teacher,Model model){
		System.out.println("管理员页面（内嵌页面）------修改教师信息:"+teacher.getId()+","+teacher.getT_account()+","+teacher.getT_name()+","+teacher.getT_sex()+","+teacher.getT_dept()+","+teacher.getT_password());
		if( teacherManager.updateTeacher(teacher) ){
			teacher = teacherManager.getTeacher(teacher.getId());
			model.addAttribute("teacher", teacher);
			return "redirect:/manager/m_teachermanage";	//修改成功后--重定向到-->教师总览页面（内嵌）
		}else{
			model.addAttribute("error", "教师信息修改出错了！！");
			return "redirect:/manager/m_teachermanage";	//修改出错后--重定向到-->教师总览页面（内嵌）
		}
	}
	
	/*
	 * 管理员页面（内嵌页面）------(点击修改学生按钮)-->挑转到学生修改页面
	 */
	@RequestMapping("/updateStudent_jsp")
	public String updateStudent_jsp(int id ,Model model){
		System.out.println("学生："+id);
		Student student = studentManager.getStudent(id);
		model.addAttribute("s", student);
		return "manager/m_updatestudent";
	}
	
	/*
	 * 管理员页面（内嵌页面）------修改学生信息
	 */
	@RequestMapping("/updateStudent")
	public String updateStudent(Student student,Model model){
		System.out.println("管理员页面（内嵌页面）------修改学生信息:"+student.getId()+","+student.getS_account()+","+student.getS_name()+","+student.getS_sex()+","+student.getS_c_id()+","+student.getS_password()+","+student.getS_dept());
		if( studentManager.updateStudent(student) ){
			student = studentManager.getStudent(student.getId());
			model.addAttribute("student", student);
			return "redirect:/manager/m_studentmanage";	//修改成功后--重定向到-->学生总览页面（内嵌）
			
		}else{
			model.addAttribute("error", "学生信息修改出错了！！");
			return "redirect:/manager/m_studentmanage";	//修改出错后--重定向到-->学生总览页面（内嵌）
		}
	}
	
	
	
	
	/*
	 * 管理员页面（内嵌页面）------(点击修改课程按钮)-->挑转到课程修改页面
	 */
	@RequestMapping("/updateCourse_jsp")
	public String updateCourse_jsp(int id ,Model model){
		System.out.println("修改课程的课程号："+id);
		Course course = courseManager.getCourse(id);
		System.out.println("修改课程的课程名："+course.getC_name());
		model.addAttribute("c", course);
		return "manager/m_updatecourse";
	}
	
	/*
	 * 管理员页面（内嵌页面）------修改课程信息
	 */
	@RequestMapping("/updateCourse")
	public String updateCourse(Course course,Model model){
		System.out.println("管理员页面（内嵌页面）------修改课程信息:"+course.getC_id()+","+course.getC_name()+","+course.getC_credit());
		if( courseManager.updateCourse(course) ){
			course = courseManager.getCourse(course.getC_id());
			model.addAttribute("course", course);
			return "redirect:/manager/m_coursemanage";	//修改成功后--重定向到-->课程总览页面（内嵌）
			
		}else{
			model.addAttribute("error", "课程信息修改出错了！！");
			return "redirect:/manager/m_coursemanage";	//修改出错后--重定向到-->课程总览页面（内嵌）
		}
	}
	
	
	
	
	/*
	 * 管理员页面（内嵌页面）------个人设置-->修改账号-------（信息修改）
	 */
	@RequestMapping("/updateManagerAccount")
	public String updateManagerAccount(int id, String account, HttpSession request){
		System.out.println("管理员个人设置修改账号:"+id+","+account);
		if( managerManager.updateManagerAccount(id , account) ){
			Manager manager = managerManager.getManagerById(id);
			request.setAttribute("manager", manager);
			request.setAttribute("msg", "账号修改成功");
			/*String name = manager.getM_name();
			System.out.println("管理员个人设置修改账号name:"+name);
			
			model.addAttribute("m_name", manager.getM_name());*/
			//return "redirect:/manager/m_personalseting";	//修改成功后--重定向到-->个人设置页面（内嵌）
			//model.addAttribute("msg", "账号修改成功");
			return "redirect:/manager/m_personalseting";	//修改成功后--重定向到-->个人设置页面（内嵌）
		}else{
			request.setAttribute("msg", "管理员账号修改出错了！！");
			return "redirect:/manager/m_personalseting";	//修改出错后--重定向到-->个人设置页面（内嵌）
		}
	}
	
	/*
	 * 管理员页面（内嵌页面）------个人设置-->修改姓名-------（信息修改）
	 */
	@RequestMapping("/updateManagerName")
	public String updateManagerName(int id, String name, HttpSession request){
		System.out.println("管理员个人设置修改姓名:"+id+","+name);
		if( managerManager.updateManagerName(id , name) ){
			Manager manager = managerManager.getManagerByName(name);
			/*model.addAttribute("m_name", manager.getM_name());
			return "redirect:/manager/m_personalseting";	//修改成功后--重定向到-->个人设置页面（内嵌）
*/			request.setAttribute("manager", manager);
			request.setAttribute("msg", "姓名修改成功");
			return "redirect:/manager/m_personalseting";	//修改成功后--重定向到-->个人设置页面（内嵌）

		}else{
			/*model.addAttribute("error", "管理员姓名修改出错了！！");
			return "redirect:/manager/m_personalseting";	//修改出错后--重定向到-->个人设置页面（内嵌）
*/			request.setAttribute("msg", "管理员姓名修改出错了！！");
			return "redirect:/manager/m_personalseting";	//修改出错后--重定向到-->个人设置页面（内嵌）
		}
	}
	
	/*
	 * 管理员页面（内嵌页面）------个人设置-->修改密码-------（信息修改）
	 */
	@RequestMapping("/updateManagerPassword")
	public String updateManagerPassword(int id, String password, HttpSession request){	//RedirectAttributes model--->重定向传递参数
		System.out.println("管理员个人设置修改密码:"+id+","+password);
		if( managerManager.updateManagerPassword(id, password) ){
			Manager manager = managerManager.getManagerById(id);
			/*model.addAttribute("m_name", manager.getM_name());
			return "redirect:/manager/m_personalseting";	//修改成功后--重定向到-->个人设置页面（内嵌）
*/			request.setAttribute("manager", manager);
			request.setAttribute("msg", "密码修改成功");
			return "redirect:/manager/m_personalseting";	//修改成功后--重定向到-->个人设置页面（内嵌）
		}else{
			/*model.addAttribute("error", "管理员密码修改出错了！！");
			return "redirect:/manager/m_personalseting";	//修改出错后--重定向到-->个人设置页面（内嵌）
*/			request.setAttribute("msg", "管理员密码修改出错了！！");
			return "redirect:/manager/m_personalseting";	//修改出错后--重定向到-->个人设置页面（内嵌）
		}
	}
	
	/*
	 * 管理员页面(导航栏)------个人设置------信息修改之后-->跳转到当前页面
	 */
	/*@RequestMapping("/m_personalseting_jsp")
	public String m_personalseting_jsp(Model model){
		return "manager/m_personalseting";
	}*/
	
}
