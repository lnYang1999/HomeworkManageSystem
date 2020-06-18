package wms.entity;

public class Notice {//公告表
	private int nt_id;			//公告号
	private String nt_title;	//主题
	private String nt_content;	//内容
	private String nt_time;		//发布时间
	private String nt_t_account;//教师号
	private String nt_c_id;		//班级号
	public int getNt_id() {
		return nt_id;
	}
	public void setNt_id(int nt_id) {
		this.nt_id = nt_id;
	}
	public String getNt_title() {
		return nt_title;
	}
	public void setNt_title(String nt_title) {
		this.nt_title = nt_title;
	}
	public String getNt_content() {
		return nt_content;
	}
	public void setNt_content(String nt_content) {
		this.nt_content = nt_content;
	}
	
	public String getNt_time() {
		return nt_time;
	}
	public void setNt_time(String nt_time) {
		this.nt_time = nt_time;
	}
	public String getNt_t_account() {
		return nt_t_account;
	}
	public void setNt_t_account(String nt_t_account) {
		this.nt_t_account = nt_t_account;
	}
	public String getNt_c_id() {
		return nt_c_id;
	}
	public void setNt_c_id(String nt_c_id) {
		this.nt_c_id = nt_c_id;
	}
	
}
