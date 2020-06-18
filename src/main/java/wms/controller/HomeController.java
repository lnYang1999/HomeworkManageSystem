package wms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wms.entity.Manager;
import wms.entity.Student;
import wms.entity.Teacher;
import wms.service.IManagerService;
import wms.service.IStudentManager;
import wms.service.ITeacherManager;

@Controller
public class HomeController {
	
	/*@Autowired
	private LabService labService;*/
	
	@Resource(name="managerManager")
	private IManagerService managerManager;
	
	@Resource(name="teacherManager")
	private ITeacherManager teacherManager;
	
	@Resource(name="studentManager")
	private IStudentManager studentManager;
	
	/**
	 * 请求登录页面
	 */
	@RequestMapping("/")
	public String index(){
		return "login";
	}
	
	/**
	 * 登录操作
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(String account,String password,String type,HttpSession session){
		System.out.println("输入的账号和姓名："+account+","+password);
		List<String> listNav = new ArrayList<String>();
		listNav.add("首页");//设置面包屑导航
		session.setAttribute("listNav", listNav);
		if( type.equals("Manager") ){//如果类型等于管理员
			//通过账号得到一个教师对象，判断 (账号是否为空)-和-(密码是否正确) 
			Manager manager = managerManager.getManagerLogin(account);	
			if( manager != null ){	//如果不等于空说明账号正确
				if( manager.getM_password().equals(password) ){
					session.setAttribute("manager",manager);
					return "manager/manager";
				}else{
					session.setAttribute("errMsg","密码错误！！");
					return "login";
				}
			}else{//账号错误
				session.setAttribute("errMsg","账号或密码错误！！");	//账号不存在！
				return "login";
			}
			
		}else if( type.equals("Teacher") ){//如果类型等于教师
			//通过账号得到一个教师对象，判断 (账号是否为空)-和-(密码是否正确) 
			Teacher teacher = teacherManager.getTeacherLogin(account);	
			if( teacher != null ){	//如果不等于空说明账号正确
				if( teacher.getT_password().equals(password) ){
					session.setAttribute("teacher",teacher);
					return "teacher/teacher";
				}else{
					session.setAttribute("errMsg","密码错误！！");
					return "login";
				}
			}else{//账号错误
				session.setAttribute("errMsg","账号或密码错误！！");
				return "login";
			}
			
		}else if( type.equals("Student") ){//如果类型等于学生
			//通过账号得到一个学生对象，判断 (账号是否为空)-和-(密码是否正确) 
			Student student = studentManager.getStudentLogin(account);
			if( student != null ){	//如果不等于空说明账号正确
				if( student.getS_password().equals(password) ){
					session.setAttribute("student",student);
					return "student/student";
				}else{
					session.setAttribute("errMsg","密码错误！");
					return "login";
				}
			}
			else{//账号错误
				session.setAttribute("errMsg","账号或密码错误！");
				return "login";
			}
			
		}else
			session.setAttribute("errMsg","未选择类型错误！！");
		return "login";
		
		
	}
	
	/**
	 * 注销操作
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		//session.invalidate();
		return "login";
	}
	
}
