package j.haianh.models;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -4634758611788089802L;
	private int id;
	private String userName;
	private String passWord;
	private String email;
	
	private String fullName;
	
	private String image;
	private int roleid;
	private String phone;
	private Date createdate;
	private String code;
	public User(int id, String userName, String passWord, String email, String fullName, String image, int roleid,
			String phone, Date createdate, String code) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.fullName = fullName;
		this.image = image;
		this.roleid = roleid;
		this.phone = phone;
		this.createdate = createdate;
		this.code = code;
	}
	
	
	
	
	public User(String userName, String passWord, String email, String fullName, String code) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.fullName = fullName;
		this.code = code;
	}




	public User(String userName, String passWord, String email, String fullName, int roleid, String code) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.fullName = fullName;
		this.roleid = roleid;
		this.code = code;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", email=" + email
				+ ", fullName=" + fullName + ", image=" + image + ", roleid=" + roleid + ", phone=" + phone
				+ ", createdate=" + createdate + ", code=" + code + "]";
	}

	

}
