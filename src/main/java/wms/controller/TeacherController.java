package wms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import wms.entity.CheckWork;
import wms.entity.Clazz;
import wms.entity.Course;
import wms.entity.Notice;
import wms.entity.Student;
import wms.entity.Teacher;
import wms.entity.Work;
import wms.service.ICheckWorkManager;
import wms.service.IClazzManager;
import wms.service.ICourseManager;
import wms.service.INoticeManager;
import wms.service.IStudentManager;
import wms.service.ITeacherManager;
import wms.service.IWorkManager;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Resource(name="teacherManager")
	private ITeacherManager teacherManager;	//引入教师services层接口
	@Resource(name="workManager")
	private IWorkManager workManager;
	@Resource(name="noticeManager")
	private INoticeManager noticeManager;
	@Resource(name="clazzManager")
	private IClazzManager clazzManager;
	@Resource(name="courseManager")
	private ICourseManager courseManager;
	@Resource(name="checkWorkManager")
	private ICheckWorkManager checkWorkManager;
	@Resource(name="studentManager")
	private IStudentManager studentManager;
	
	/**********************************framework(导航栏)页面操作*************************************************/
	
	/*
	 * 教师界面(导航栏)----我的作业---总览--页面（内嵌）
	 */
	@RequestMapping("/t_allworks")
	public String t_allworks(@RequestParam("t_account") String t_account,Model model){
		List<Work> work = workManager.getAllWork();
		List<Work> resuletWork = new ArrayList<Work>();
		for(int i=0; i<work.size(); i++){
			if(work.get(i).getW_t_account().equals(t_account)){
				resuletWork.add(work.get(i));
			}
		}
		model.addAttribute("work", resuletWork); 
		return "teacher/t_allworks";
	}
	
	/*
	 * 教师界面(导航栏)----我的作业---发布作业--页面（内嵌）
	 */
	@RequestMapping("/t_publishwork")
	public String t_publishwork(Model model){
		
		List<Clazz> clazz = clazzManager.getAllClazz();
		List<Course> course = courseManager.getAllCourse();
		/*List<Teacher> teacher1 = teacherManager.getAllTeacher();
		System.out.println("teacher教师总览页面:"+teacher1.get(0).getT_account()+","+teacher1.get(0).getT_name()+","+teacher1.get(0).getT_password());
		model.addAttribute("teacher", teacher1);*/
		model.addAttribute("clazz", clazz);
		model.addAttribute("course", course);
		return "teacher/t_publishwork";
	}
	
	/*
	 * 教师界面(导航栏)----我的公告---总览--页面（内嵌）
	 */
	@RequestMapping("/t_allnotice")
	public String t_allnotice(@RequestParam("t_account") String t_account, Model model){
		System.out.println("t_account:"+t_account);
		/*List<Notice> notice = notice teacherManager.getAllNotice();
		System.out.println("teacher教师总览页面:"+teacher1.get(0).getT_account()+","+teacher1.get(0).getT_name()+","+teacher1.get(0).getT_password());
		model.addAttribute("teacher", teacher1);*/
		List<Notice> notice = noticeManager.getNoticeByTid(t_account);
		model.addAttribute("n", notice);
		return "teacher/t_allnotice";
	}
	
	/*
	 * 教师界面(导航栏)----我的公告---发布公告--页面（内嵌）
	 */
	@RequestMapping("/t_publishnotice")
	public String t_publishnotice(Model model,HttpSession session){
		List<Clazz> clazz = clazzManager.getAllClazz();
		model.addAttribute("clazz", clazz);
		return "teacher/t_publishnotice";
	}
	
	/*
	 * 教师界面(导航栏)----提交统计---按钮页面（内嵌）
	 */
	@RequestMapping("/t_statistics")
	public String t_statistics(@RequestParam("t_account") String t_account, Model model,HttpSession session){
		//获取所有作业
		List<Work> work = workManager.getAllWork();
		List<Work> resultWork = new ArrayList<Work>();
		List<Work> result = new ArrayList<Work>();
		List<String> clazz = new ArrayList<String>();
		//获取该账号对应的作业
		for(int i=0,j=0; i<work.size(); i++){
			if(work.get(i).getW_t_account().equals(((Teacher)session.getAttribute("teacher")).getT_account())){
					resultWork.add(work.get(i));
					System.out.println("提交统计:"+resultWork.get(j).getW_content()+resultWork.get(j++).getW_c_id());
			}
		}
		//传递该账号对应的作业
		for(int i=0; i<resultWork.size(); i++){
			result.add(resultWork.get(i));
		}
	//result = resultWork;
		model.addAttribute("resultWork", result);
		//删除作业表中该教师所对应的班级的重复值
		for  ( int  i  =   0 ; i  <  resultWork.size(); i ++ )   { 
		    for  ( int  j  =  resultWork.size()  -   1 ; j  >  i; j -- )   { 
		      if  (resultWork.get(j).getW_c_id().equals(resultWork.get(i).getW_c_id()))   { 
		    	  resultWork.remove(j); 
		      } 
		    } System.out.println(resultWork.get(i).getW_content()+resultWork.get(i).getW_c_id());
		  } 
		//获取该账号对应的班级
		for(int i=0; i<resultWork.size(); i++){
			clazz.add(resultWork.get(i).getW_c_id());
			System.out.println(clazz.get(i));
		}
		//传递该账号对应的班级
		model.addAttribute("clazz", clazz);
		
		session.setAttribute("c", clazz);
		session.setAttribute("w", result);
		
		//将作业按班级分类传递到页面
		for(int i=0; i<clazz.size(); i++){
			List<Work> workByClazz = new ArrayList<Work>();
			for(int j=0; j<result.size(); j++){
				if(result.get(j).getW_c_id().equals(clazz.get(i).toString())){
					workByClazz.add(result.get(j));
				}
			}
			model.addAttribute("workByClazz",workByClazz);
		}
		return "teacher/t_statistics";
	}
	
	/*
	 * 教师界面(导航栏)----个人设置---按钮页面（内嵌）
	 */
	@RequestMapping("/t_personalseting")
	public String t_personalseting(Model model){
		/*List<Teacher> teacher1 = teacherManager.getAllTeacher();
		System.out.println("teacher教师总览页面:"+teacher1.get(0).getT_account()+","+teacher1.get(0).getT_name()+","+teacher1.get(0).getT_password());
		model.addAttribute("teacher", teacher1);*/
		return "teacher/t_personalseting";
	}
	
	/**********************************iframe内嵌页面操作*************************************************/	
	//作业总览删除操作
	@RequestMapping("/t_deletework")
	public void t_deletework(int id,HttpServletResponse response){
		String result = "{\"result\":\"error\"}";
		if( workManager.deleteWork(id) ){
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
	
	//公告总览删除操作
		@RequestMapping("/t_deletenotice")
		public void t_deletenotice(int id,HttpServletResponse response){
			String result = "{\"result\":\"error\"}";
			if( noticeManager.deleteNotice(id) ){
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
	
		//发布作业点击发布按钮
		@RequestMapping("t_publishWork")
		public String t_publishWork(@RequestParam("w_title") String w_title,@RequestParam("w_content") String w_content,
				@RequestParam("w_deadline") String w_deadline,@RequestParam("w_course") String w_course,@RequestParam("w_c_id") String w_c_id,HttpSession session){
			Teacher teacher = (Teacher)session.getAttribute("teacher");
			Work work = new Work();
			work.setW_c_id(w_c_id);
			work.setW_content(w_content);
			work.setW_course(w_course);
			work.setW_deadline(w_deadline);
			work.setW_t_account(teacher.getT_account());
			work.setW_title(w_title);
			workManager.addWork(work);
			return "redirect:/teacher/t_allworks?t_account="+teacher.getT_account();
		}
		
		//发布公告点击发布按钮
	@RequestMapping("t_publishNotice")
	public String t_publishNotice(@RequestParam("nt_title") String nt_title,@RequestParam("nt_content") String nt_content,
			@RequestParam("nt_time") String nt_time,@RequestParam("nt_c_id") String nt_c_id,HttpSession session){
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		Notice notice = new Notice();
		notice.setNt_title(nt_title);
		notice.setNt_content(nt_content);
		notice.setNt_c_id(nt_c_id);
		notice.setNt_t_account(teacher.getT_account());
		notice.setNt_time(nt_time);
		noticeManager.addNotice(notice);
		return "redirect:/teacher/t_allnotice?t_account="+teacher.getT_account();
	}
	
	
		
	//提交统计班级作业点击
	@RequestMapping("/checkwork")
	public String checkwork(@RequestParam("w_id")int w_id,@RequestParam("c_id")String c_id,HttpSession session,Model model){
		System.out.println("作业号,班级号:"+w_id+","+c_id);
		int Wno = w_id;
		String clazz = c_id;
		//根据w_id和c_id查询批改表中的对应记录
		List<CheckWork> checkwork = checkWorkManager.getCheckWorkByWnoClno(w_id, c_id);
		for(int i=0; i<checkwork.size(); i++){
			System.out.println("提交统计班级作业点击123:"+checkwork.get(i).getCh_s_account());
		}
		//根据c_id查询学生表中的对应记录
		List<Student> student = studentManager.getStudentByCLno(c_id);
		Work work = workManager.getWork(w_id);
		session.setAttribute("checkwork", checkwork);
		session.setAttribute("student",student );
		session.setAttribute("Wno",Wno );
		session.setAttribute("c_id",clazz );
		System.out.println("提交统计班级作业点击--班级号:"+clazz);
		System.out.println("提交统计班级作业点击--:作业号"+Wno);
		session.setAttribute("w_title",work.getW_title() );
		return "teacher/t_statistics_details";
	}
	
	
	/*
	 * 管理员页面（内嵌页面）------个人设置-->修改账号-------（信息修改）
	 */
	@RequestMapping("/updateTeacherAccount")
	public String updateTeacherAccount(int id, String account, HttpSession request){
		System.out.println("教师个人设置修改账号:"+id+","+account);
		if( teacherManager.updateTeacherAccount(id , account) ){
			Teacher teacher = teacherManager.getTeacher(id);
			request.setAttribute("teacher", teacher);
			request.setAttribute("msg", "账号修改成功");
			/*String name = manager.getM_name();
			System.out.println("管理员个人设置修改账号name:"+name);
			
			model.addAttribute("m_name", manager.getM_name());*/
			//return "redirect:/manager/m_personalseting";	//修改成功后--重定向到-->个人设置页面（内嵌）
			//model.addAttribute("msg", "账号修改成功");
			return "redirect:/teacher/t_personalseting";	//修改成功后--重定向到-->个人设置页面（内嵌）
		}else{
			request.setAttribute("msg", "教师账号修改出错了！！");
			return "redirect:/teacher/t_personalseting";	//修改出错后--重定向到-->个人设置页面（内嵌）
		}
	}
	
	/*
	 * 管理员页面（内嵌页面）------个人设置-->修改姓名-------（信息修改）
	 */
	@RequestMapping("/updateTeacherName")
	public String updateTeacherName(int id, String name, HttpSession request){
		System.out.println("教师个人设置修改姓名:"+id+","+name);
		if( teacherManager.updateTeacherName(id , name) ){
			Teacher teacher = teacherManager.getTeacher(((Teacher)request.getAttribute("teacher")).getId());
			/*model.addAttribute("m_name", manager.getM_name());
			return "redirect:/manager/m_personalseting";	//修改成功后--重定向到-->个人设置页面（内嵌）
*/			request.setAttribute("teacher", teacher);
			request.setAttribute("msg", "姓名修改成功");
			return "redirect:/teacher/t_personalseting";	//修改成功后--重定向到-->个人设置页面（内嵌）

		}else{
			/*model.addAttribute("error", "管理员姓名修改出错了！！");
			return "redirect:/manager/m_personalseting";	//修改出错后--重定向到-->个人设置页面（内嵌）
*/			request.setAttribute("msg", "管理员姓名修改出错了！！");
			return "redirect:/teacher/t_personalseting";	//修改出错后--重定向到-->个人设置页面（内嵌）
		}
	}
	
	/*
	 * 教师页面（内嵌页面）------个人设置-->修改密码-------（信息修改）
	 */
	@RequestMapping("/updateTeacherPassword")
	public String updateTeacherPassword(int id, String password, HttpSession request){	//RedirectAttributes model--->重定向传递参数
		System.out.println("教师个人设置修改密码:"+id+","+password);
		if( teacherManager.updateTeacherPassword(id, password) ){
			Teacher teacher = teacherManager.getTeacher(id);
			/*model.addAttribute("m_name", manager.getM_name());
			return "redirect:/manager/m_personalseting";	//修改成功后--重定向到-->个人设置页面（内嵌）
*/			request.setAttribute("teacher", teacher);
			request.setAttribute("msg", "密码修改成功");
			return "redirect:/teacher/t_personalseting";	//修改成功后--重定向到-->个人设置页面（内嵌）
		}else{
			/*model.addAttribute("error", "管理员密码修改出错了！！");
			return "redirect:/manager/m_personalseting";	//修改出错后--重定向到-->个人设置页面（内嵌）
*/			request.setAttribute("msg", "教师密码修改出错了！！");
			return "redirect:/teacher/t_personalseting";	//修改出错后--重定向到-->个人设置页面（内嵌）
		}
	}
	
	/**********************************iframe内嵌iframe内嵌页面操作*************************************************/
	//提交批改操作
	@RequestMapping("/t_check")
	public  String t_check(@RequestParam("ch_mark") String ch_mark,@RequestParam("ch_score") int ch_score,@RequestParam("ch_id") int ch_id,@RequestParam("c_id") String c_id,@RequestParam("Wno") int Wno,RedirectAttributes model){
		System.out.println("提交批改操作："+ch_id+","+ch_mark+","+ch_score+","+Wno+","+c_id);
		checkWorkManager.Check(ch_mark, ch_score, ch_id);
		model.addAttribute("w_id", Wno);
		model.addAttribute("c_id", c_id);
		return "redirect:/teacher/checkwork";	//重定向到-->提交统计班级作业点击
	}
	
	
	
	
	//下载作业
	@RequestMapping("/Download")
	public String Download(@RequestParam("Wno")int Wno,@RequestParam("c_id")String c_id,@RequestParam("Uptime") String Uptime,RedirectAttributes model,HttpServletResponse response) throws IOException{
		System.out.println("下载作业："+Wno+","+c_id+","+Uptime);
		//String pathY = "F:\\DownloadWork\\";
		String path = "F:/";	//下载文件的文件夹路径
		//解析时分秒
		String years = Uptime.substring(0,4);
		String month = Uptime.substring(5,7);
		String day = Uptime.substring(8,10);
		String hour = Uptime.substring(11,13);
		String minute = Uptime.substring(14,16);
		String seconds = Uptime.substring(17,19);
		String UptimeFileName = years +"."+ month +"."+ day + "-" + hour +"."+ minute +"."+ seconds;//文件中显示的时间格式
		System.out.println("********************************************************************************************************");
		System.out.println("下载作业--文件中显示的时间格式："+years+"."+month+"."+day+ "-"+hour+":"+minute+":"+seconds+"---"+UptimeFileName);
		File files1 = new File(path);
		String [] names1 = files1.list();
		String FileName = "";	//有后缀
		for( String s:names1 ){
			if( new File(files1.getAbsolutePath()+s).isFile() ){//判断是否有文件
				if( s.contains(UptimeFileName) ){	//判断是否有 包含此字段 的文件
					System.out.println("***1***当前下载作业的文件名是："+s);
					FileName = s;			//去后缀   s.substring(s.indexOf("/"), s.length());
				}
				if(s.startsWith("142011")){
					System.out.println("***2***当前下载作业的文件名是："+s);
				}
			}
			
		}
		String fileNameTemp = path + FileName; 	//文件路径+名称+文件类型    
		//download(response,fileNameTemp); 
		
		//获取所要下载文件的路径  
    	String path1 = fileNameTemp;
        String realPath = path1.substring(path1.lastIndexOf("\\")+1);  //真正的文件名+扩展名
      
        //告诉浏览器是以下载的方法获取到资源  
        //告诉浏览器以此种编码来解析URLEncoder.encode(realPath, "utf-8"))  
        response.setHeader("content-disposition","attachment; filename="+URLEncoder.encode(realPath, "utf-8"));  
        //获取到所下载的资源  
        FileInputStream fis = new FileInputStream(path1);    
        OutputStream out = response.getOutputStream();
        //FileInputStream fis = new FileInputStream("F:\\temp\\myfile.txt");  
        int len = 0;  
        byte [] buf = new byte[1024];  
        while((len=fis.read(buf))!=-1){  
        	out.write(buf,0,len);  
        } 
        //关闭输入流
        fis.close();
        //关闭输出流
        out.close();
		
		
		
		
		
		
		
		
		/*File files = new File("F:/");    //创建File对象,指向F盘根目录
        String[] names = files.list();    //获取F盘根目录所有文件和路径,并以字符串数组返回
        for(String s:names){    //遍历字符串数组
            boolean a = s.startsWith("ja");    //文件名前缀带有ja的返回true,没有则返回false
            boolean b = (new File(files.getAbsolutePath()+s)).isFile();    //判断本次循环的字符串所指向的内容是否是文件,是则返回true.否则返回false
            boolean c = s.contains("va");    //文件名是否包含"va",包含则返回true,否则false
            if(a&&b){    //此处条件根据需要进行修改
                System.out.println(s);    //打印出符合条件的文件
            }
        }*/
		
		model.addAttribute("w_id", Wno);
		model.addAttribute("c_id", c_id);
		return "redirect:/teacher/checkwork";	//重定向到-->提交统计班级作业点击
	}
	
	 //下载文件操作
    public void download(HttpServletResponse response,String fileNameTemp ) throws IOException{  
    	
        //获取所要下载文件的路径  
    	String path1 = fileNameTemp;
    	//String path = this.getServletContext().getRealPath(/WEB-INF/web.xml); //从项目路径下找  
        String realPath = path1.substring(path1.lastIndexOf("\\")+1);  
      
        //告诉浏览器是以下载的方法获取到资源  
        //告诉浏览器以此种编码来解析URLEncoder.encode(realPath, "utf-8"))  
        response.setHeader("content-disposition","attachment; filename="+URLEncoder.encode(realPath, "utf-8"));  
        //获取到所下载的资源  
        FileInputStream fis = new FileInputStream(path1);    
        OutputStream out = response.getOutputStream();
        //FileInputStream fis = new FileInputStream("F:\\temp\\myfile.txt");  
        int len = 0;  
        byte [] buf = new byte[1024];  
        while((len=fis.read(buf))!=-1){  
        	out.write(buf,0,len);  
        } 
        //关闭输入流
        fis.close();
        //关闭输出流
        out.close();
    }
	
	
	
}
