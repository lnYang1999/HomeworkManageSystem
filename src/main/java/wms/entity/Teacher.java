package wms.entity;

public class Teacher {//教师表
	private int id;			//id号
	private String t_account;	//教师号
	private String t_name;		//教师名
	private String t_sex;		//性别
	private String t_dept;		//所在系
	private String t_password;	//密码
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getT_account() {
		return t_account;
	}
	public void setT_account(String t_account) {
		this.t_account = t_account;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_sex() {
		return t_sex;
	}
	public void setT_sex(String t_sex) {
		this.t_sex = t_sex;
	}
	public String getT_dept() {
		return t_dept;
	}
	public void setT_dept(String t_dept) {
		this.t_dept = t_dept;
	}
	public String getT_password() {
		return t_password;
	}
	public void setT_password(String t_password) {
		this.t_password = t_password;
	}
	
	
}