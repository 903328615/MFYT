package com.mf.entity;

/**
 * ”√ªß¿‡
 * 
 * @author MXY
 *
 */
public class User {
	private String Id;
	private String Name;
	private String Pwd;
	private String Email;
	private String Sex;
	
	
	public User(String id, String name, String pwd, String email, String sex) {
		super();
		Id = id;
		Name = name;
		Pwd = pwd;
		Email = email;
		Sex = sex;
	}
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public String toString() {
		return "User [Id=" + Id + ", Name=" + Name + ", Pwd=" + Pwd + ", Email=" + Email + ", Sex=" + Sex + "]";
	}



	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String pwd) {
		Pwd = pwd;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}


}
