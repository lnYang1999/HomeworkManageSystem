package wms.entity;

public class Student {//学生表
	private int id;			//id号
	private String s_account;	//学号
	private String s_name;		//姓名
	private String s_sex;		//性别
	private String s_c_id;		//班级号
	private String s_password;	//密码
	private String s_dept;		//所在系
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getS_account() {
		return s_account;
	}
	public void setS_account(String s_account) {
		this.s_account = s_account;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_sex() {
		return s_sex;
	}
	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}
	public String getS_c_id() {
		return s_c_id;
	}
	public void setS_c_id(String s_c_id) {
		this.s_c_id = s_c_id;
	}
	public String getS_password() {
		return s_password;
	}
	public void setS_password(String s_password) {
		this.s_password = s_password;
	}
	public String getS_dept() {
		return s_dept;
	}
	public void setS_dept(String s_dept) {
		this.s_dept = s_dept;
	}
	
	
}
