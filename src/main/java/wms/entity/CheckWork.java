package wms.entity;

public class CheckWork {//作业批改表
	private int ch_id;			//作业批改号
	private String ch_s_account;//学号
	private String ch_c_id;		//班级号
	private int ch_w_id;		//作业号
	private int ch_score;		//得分
	private String ch_mark;		//评语
	private java.sql.Timestamp ch_checkTime;//批改时间
	private java.sql.Timestamp ch_upTime;	//提交时间
	private String ch_path;		//答案
	public int getCh_id() {
		return ch_id;
	}
	public void setCh_id(int ch_id) {
		this.ch_id = ch_id;
	}
	public String getCh_s_account() {
		return ch_s_account;
	}
	public void setCh_s_account(String ch_s_account) {
		this.ch_s_account = ch_s_account;
	}
	public String getCh_c_id() {
		return ch_c_id;
	}
	public void setCh_c_id(String ch_c_id) {
		this.ch_c_id = ch_c_id;
	}
	public int getCh_w_id() {
		return ch_w_id;
	}
	public void setCh_w_id(int ch_w_id) {
		this.ch_w_id = ch_w_id;
	}
	public int getCh_score() {
		return ch_score;
	}
	public void setCh_score(int ch_score) {
		this.ch_score = ch_score;
	}
	public String getCh_mark() {
		return ch_mark;
	}
	public void setCh_mark(String ch_mark) {
		this.ch_mark = ch_mark;
	}
	public java.sql.Timestamp getCh_checkTime() {
		return ch_checkTime;
	}
	public void setCh_checkTime(java.sql.Timestamp ch_checkTime) {
		this.ch_checkTime = ch_checkTime;
	}
	public java.sql.Timestamp getCh_upTime() {
		return ch_upTime;
	}
	public void setCh_upTime(java.sql.Timestamp ch_upTime) {
		this.ch_upTime = ch_upTime;
	}
	public String getCh_path() {
		return ch_path;
	}
	public void setCh_path(String ch_path) {
		this.ch_path = ch_path;
	}
	
}
