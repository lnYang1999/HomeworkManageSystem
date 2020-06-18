package wms.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import wms.entity.CheckWork;
import wms.entity.Notice;
import wms.entity.Student;
import wms.entity.Work;
import wms.service.ICheckWorkManager;
import wms.service.IStudentManager;
import wms.service.IWorkManager;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Resource(name="studentManager")
	private IStudentManager studentManager;
	@Resource(name="workManager")
	private IWorkManager workManager;
	@Resource(name="checkWorkManager")
	private ICheckWorkManager checkWorkManager;
	
	@RequestMapping("/updateStudentName")
	public String updateStudentName(Student student,HttpSession request){
		if (studentManager.updateStudentName(student)){
			student = studentManager.getStudentLogin(student.getS_account());
			request.setAttribute("student", student);
		}
		
		return "/student/s_personalseting";
	}
	
	@RequestMapping("/updateStudentPassword")
	public String updateStudentPassword(Student student,HttpSession request){
		if (studentManager.updateStudentPassword(student)){
			student = studentManager.getStudentLogin(student.getS_account());
			request.setAttribute("student", student);
		}
		
		return "/student/s_personalseting";
	}
	
	@RequestMapping("/getAllNotice")
	public String getAllNotice(Student student,HttpSession request){
		if (studentManager.updateStudentPassword(student)){
			student = studentManager.getStudentLogin(student.getS_account());
			request.setAttribute("student", student);
		}
		
		return "/student/s_personalseting";
	}
	
	@RequestMapping(value="/s_home")
	public String s_home(String c_id,String s_account,HttpSession request){
		List<Notice> notice = studentManager.getAllNotice(c_id);
		System.out.println("home--公告主题，内容:"+notice.get(0).getNt_title()+","+notice.get(0).getNt_content());
		List<Work> work = studentManager.getAllWork(c_id);
		boolean[] status = new boolean[work.size()];
		String[] teachername = new String[work.size()];
		String[] ntTName = new String[notice.size()];
		for (int i=0;i<ntTName.length;i++){
			ntTName[i] = studentManager.getTeacherNameByAccount(notice.get(i).getNt_t_account());
		}
		for (int n=0;n<status.length;n++){
			System.out.println("home1--作业主题，内容"+n+":"+work.get(n).getW_title()+","+work.get(n).getW_content());
			status[n] = studentManager.getCheckWorkStatus(work.get(n).getW_id(),s_account);
		}
		for (int m=0;m<teachername.length;m++){
			teachername[m] = studentManager.getWork_TeacherName(work.get(m).getW_t_account());
			System.out.println("教师姓名："+teachername[m].toString());
			System.out.println("home2--作业主题，内容"+m+":"+work.get(m).getW_title()+","+work.get(m).getW_content());
		}
		request.setAttribute("ntTName", ntTName);
		request.setAttribute("notice", notice);
		request.setAttribute("work", work);
		request.setAttribute("status", status);
		request.setAttribute("teachername", teachername);
		return "student/s_home";
	}
	
	@RequestMapping(value="/s_personalseting")
	public String s_personalseting(){
		return "student/s_personalseting";
	}
	
	@RequestMapping(value="/s_downloadwork")
	public String s_downloadwork(){
		return "student/s_downloadwork";
	}
	
	@RequestMapping(value="/s_showcheck")
	public String s_showcheck(String s_account,HttpSession request){
		List<CheckWork> checkwork = studentManager.getAllCheckWork(s_account);
		List<Work> work = new ArrayList<Work>(checkwork.size());
		for (int n=0;n<checkwork.size();n++){
			work.add(n, studentManager.getWorkBycheckwork(checkwork.get(n).getCh_w_id()));
		}
		request.setAttribute("work", work);
		request.setAttribute("checkwork", checkwork);
		return "student/s_showcheck";
	}
	
	//到达上传页面
	@RequestMapping("/s_uploadwork_jsp")
	public String s_uploadwork_jsp(String s_account,HttpSession session){
		System.out.println("上传页面的学号:"+s_account);
		String clazz = studentManager.getClazzBySno(s_account);
		System.out.println("上传页面的班级号:"+clazz);
		List<Work> work = studentManager.getAllWork(clazz);
		String[] w_title  = new String[work.size()];
		for (int m=0;m<w_title.length;m++){
			w_title[m] = work.get(m).getW_title();
			System.out.println("批改表中学生--对应的作业主题："+w_title[m]);
		}
		session.setAttribute("w_title", w_title);
		session.setAttribute("s_account", s_account);
		session.setAttribute("clazz", clazz);
		session.setAttribute("flag", 0);	
		return "student/s_uploadwork";
	}
	
	
	//上传文件
	@RequestMapping(value="/s_uploadwork")
	public String s_uploadwork(@RequestParam("s_account") String s_account,@RequestParam("clazz") String clazz,@RequestParam("w_title") String w_title,  HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IllegalStateException, IOException{
		System.out.println("上传文件页面:提交时间="+s_account+","+clazz+","+w_title);//学号，
		//创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		//设置编码  
		multipartResolver.setDefaultEncoding("utf-8");
		//判断 request 是否有文件上传,即多部分请求...
		if( multipartResolver.isMultipart(request) ){//获取文件解析器，判断是否是文件
			//转换成多部分request 
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) (request);
			Iterator<String> iter = multiRequest.getFileNames();//获取所有文件名字
			while( iter.hasNext() ){//遍历所有文件
				// file 是指 文件上传标签的 name=值  
			    // 根据 name 获取上传的文件... 
				MultipartFile file = multiRequest.getFile((String)iter.next());
				if( file != null ){
					//获取服务器当前时间 
			    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss"); 
			        Date date = new Date(); 
			        String time = simpleDateFormat.format(date); //当前提交时间 (做文件名)
			        String Uptime =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//（插入数据库）
			        System.out.println("上传页面:提交时间(做文件名)="+time);
			        System.out.println("上传页面:提交时间（插入数据库）="+Uptime);
			        
					String fileName = s_account+"提交作业："+ time +"_"+file.getOriginalFilename();
					System.out.println("fileName:"+fileName);
					//String path = "F:\\UploadWork\\" + fileName;		//提交路径(用于磁盘写入文件)
					//String Upath = "F:\\UploadWork\\";				//提交路径(保存到数据库)
					String path = "F:\\" + fileName;		//提交路径(用于保存文件到磁盘)
					String Upath = "F:\\";					//提交路径(保存到数据库)
					/*File localFile = new File(path);
					file.transferTo(localFile);//上传文件 
*/					
					String Wtitle = w_title.trim();
					Work work = workManager.getWorkByWtitle(Wtitle);
					System.out.println("内容Wno:"+work.getW_content());//作业
					System.out.println("Wno:"+work.getW_id());//作业号
					
					//上传之前先判断是否已上传，即checkwork表中有相同的学号(ch_s_account)和作业号（ch_w_id）。如果有表示已上传过 ,则更新当前表
					if( checkWorkManager.getCheckWorkByWnoSno(work.getW_id(), s_account) != null ){		//如果不等于空，表示已提交过
						CheckWork chw  = checkWorkManager.getCheckWorkByWnoSno(work.getW_id(), s_account);
						if( (chw.getCh_score() != 0) && (chw.getCh_mark() != null) && (chw.getCh_checkTime() != null) ){//判断教师是否批改过,如果不等于空表示教师已批改过，不可重复提交
							session.setAttribute("flag", 2);//返回参数判断是否上传成功
						}else{//如果等于空表示教师还未批改过，可重复提交
							if(checkWorkManager.updateCheckWorkByFile(s_account, clazz, work.getW_id(), Uptime, Upath)){
								File localFile = new File(path);
								file.transferTo(localFile);//上传文件 
								
								System.out.println("上传成功，上传数据成功插入数据库表,---重复提交，更新数据");
								
							}
							session.setAttribute("flag", 3);//返回参数判断是否上传成功
						}
					}else{//表示未上传过 ,即第一次上传次作业
						if(checkWorkManager.addCheckWorkByFile(s_account, clazz, work.getW_id(), Uptime, Upath)){
							File localFile = new File(path);
							file.transferTo(localFile);//上传文件 
							
							System.out.println("上传成功，上传数据成功插入数据库表,---第一次上传");
						}
						session.setAttribute("flag", 1);//返回参数判断是否上传成功
					}
					
					
					/*if(checkWorkManager.addCheckWorkByFile(s_account, clazz, work.getW_id(), Uptime, Upath)){
						System.out.println("上传成功，上传数据成功插入数据库表");
					}
					session.setAttribute("flag", 1);//返回参数判断是否上传成功
					*/
				}
			}
		}
		
		return "student/s_uploadwork";
	}
}
