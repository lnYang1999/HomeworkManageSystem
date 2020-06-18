package wms.entity;

public class Work {//作业表
	private int w_id;		//作业号
	private String w_title;		//主题
	private String w_content;	//内容
	private String w_deadline;	//截止时间
	private String w_course;	//课程号
	private String w_t_account;	//教师号
	private String w_c_id;		//班级号
	public int getW_id() {
		return w_id;
	}
	public void setW_id(int w_id) {
		this.w_id = w_id;
	}
	public String getW_title() {
		return w_title;
	}
	public void setW_title(String w_title) {
		this.w_title = w_title;
	}
	public String getW_content() {
		return w_content;
	}
	public void setW_content(String w_content) {
		this.w_content = w_content;
	}
	public String getW_deadline() {
		return w_deadline;
	}
	public void setW_deadline(String w_deadline) {
		this.w_deadline = w_deadline;
	}
	public String getW_course() {
		return w_course;
	}
	public void setW_course(String w_course) {
		this.w_course = w_course;
	}
	public String getW_t_account() {
		return w_t_account;
	}
	public void setW_t_account(String w_t_account) {
		this.w_t_account = w_t_account;
	}
	public String getW_c_id() {
		return w_c_id;
	}
	public void setW_c_id(String w_c_id) {
		this.w_c_id = w_c_id;
	}
	
}
