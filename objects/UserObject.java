package jsoft.objects;

public class UserObject {
	private int user_id;
	private String user_name;
	private String user_pass;
	private String user_fullname;
	private String user_birthday;
	private String user_mobilephone;
	private String user_homephone;
	private String user_officephone;
	private String user_email;
	private String user_address;
	private String user_jobarea;
	private String user_job;
	private String user_position;
	private short user_applyyear;
	private byte user_permission;
	private String user_notes;
	private String user_roles;
	private short user_logined;
	private String user_created_date;
	private String user_last_modified;
	private String user_last_logined;
	private int user_parent_id;
	private byte user_actions;
	
	public UserObject() {
		
	}

	public int getUser_id() {
		return user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public String getUser_fullname() {
		return user_fullname;
	}

	public String getUser_birthday() {
		return user_birthday;
	}

	public String getUser_mobilephone() {
		return user_mobilephone;
	}

	public String getUser_homephone() {
		return user_homephone;
	}

	public String getUser_officephone() {
		return user_officephone;
	}

	public String getUser_email() {
		return user_email;
	}

	public String getUser_address() {
		return user_address;
	}

	public String getUser_jobarea() {
		return user_jobarea;
	}

	public String getUser_job() {
		return user_job;
	}

	public String getUser_position() {
		return user_position;
	}

	public short getUser_applyyear() {
		return user_applyyear;
	}

	public byte getUser_permission() {
		return user_permission;
	}

	public String getUser_notes() {
		return user_notes;
	}

	public String getUser_roles() {
		return user_roles;
	}

	public short getUser_logined() {
		return user_logined;
	}

	public String getUser_created_date() {
		return user_created_date;
	}

	public String getUser_last_modified() {
		return user_last_modified;
	}

	public String getUser_last_logined() {
		return user_last_logined;
	}

	public int getUser_parent_id() {
		return user_parent_id;
	}

	public byte getUser_actions() {
		return user_actions;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public void setUser_fullname(String user_fullname) {
		this.user_fullname = user_fullname;
	}

	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}

	public void setUser_mobilephone(String user_mobilephone) {
		this.user_mobilephone = user_mobilephone;
	}

	public void setUser_homephone(String user_homephone) {
		this.user_homephone = user_homephone;
	}

	public void setUser_officephone(String user_officephone) {
		this.user_officephone = user_officephone;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public void setUser_jobarea(String user_jobarea) {
		this.user_jobarea = user_jobarea;
	}

	public void setUser_job(String user_job) {
		this.user_job = user_job;
	}

	public void setUser_position(String user_position) {
		this.user_position = user_position;
	}

	public void setUser_applyyear(short user_applyyear) {
		this.user_applyyear = user_applyyear;
	}

	public void setUser_permission(byte user_permission) {
		this.user_permission = user_permission;
	}

	public void setUser_notes(String user_notes) {
		this.user_notes = user_notes;
	}

	public void setUser_roles(String user_roles) {
		this.user_roles = user_roles;
	}

	public void setUser_logined(short user_logined) {
		this.user_logined = user_logined;
	}

	public void setUser_created_date(String user_created_date) {
		this.user_created_date = user_created_date;
	}

	public void setUser_last_modified(String user_last_modified) {
		this.user_last_modified = user_last_modified;
	}

	public void setUser_last_logined(String user_last_logined) {
		this.user_last_logined = user_last_logined;
	}

	public void setUser_parent_id(int user_parent_id) {
		this.user_parent_id = user_parent_id;
	}

	public void setUser_actions(byte user_actions) {
		this.user_actions = user_actions;
	}
	
	
	public String toString() {
		return "ID: "+this.user_id+"\tName: "+this.user_name+"\tBirthDay: "
				+this.user_birthday + "\tLogin: "+this.user_logined;
	}
}
