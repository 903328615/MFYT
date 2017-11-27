package com.mf.entity;

/**
 * ”√ªß¿‡
 * 
 * @author MXY
 *
 */
public class User {
	private String UserId;
	private String UserName;
	private String UserPwd;
	private String UserEmail;
	private String Sex;

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserPwd() {
		return UserPwd;
	}

	public void setUserPwd(String userPwd) {
		UserPwd = userPwd;
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public User(String userId, String userName, String userPwd, String userEmail, String sex) {
		super();
		UserId = userId;
		UserName = userName;
		UserPwd = userPwd;
		UserEmail = userEmail;
		Sex = sex;
	}

	public User() {
		super();
	}

}
