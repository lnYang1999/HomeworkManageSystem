package wms.entity;

public class Course {//课程表
	private int c_id;			//id号
	private String c_name;		//课程名
	private int c_credit;	//学分
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public int getC_credit() {
		return c_credit;
	}
	public void setC_credit(int c_credit) {
		this.c_credit = c_credit;
	}
	
	
}
