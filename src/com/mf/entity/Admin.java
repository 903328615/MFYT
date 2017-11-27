package com.mf.entity;

/**
 * @author MXY
 *
 */
public class Admin {

	/**
	 * 管理员类
	 * @author MXY
	 */

	private char AdId;
	private char AdName;
	private char AdPwd;
	private char AdEmail;
	private char AdPhone;
	private char AdAdress;
	private char AdSex;
	
	
	public char getAdId() {
		return AdId;
	}
	public void setAdId(char adId) {
		AdId = adId;
	}
	public char getAdName() {
		return AdName;
	}
	public void setAdName(char adName) {
		AdName = adName;
	}
	public char getAdPwd() {
		return AdPwd;
	}
	public void setAdPwd(char adPwd) {
		AdPwd = adPwd;
	}
	public char getAdEmail() {
		return AdEmail;
	}
	public void setAdEmail(char adEmail) {
		AdEmail = adEmail;
	}
	public char getAdPhone() {
		return AdPhone;
	}
	public void setAdPhone(char adPhone) {
		AdPhone = adPhone;
	}
	public char getAdAdress() {
		return AdAdress;
	}
	public void setAdAdress(char adAdress) {
		AdAdress = adAdress;
	}
	public char getAdSex() {
		return AdSex;
	}
	public void setAdSex(char adSex) {
		AdSex = adSex;
	}
	
	@Override
	public String toString() {
		return "Admin [AdId=" + AdId + ", AdName=" + AdName + ", AdPwd=" + AdPwd + ", AdEmail=" + AdEmail + ", AdPhone="
				+ AdPhone + ", AdAdress=" + AdAdress + ", AdSex=" + AdSex + "]";
	}
	
	public Admin() {
		super();
	}
	public Admin(char adId, char adName, char adPwd, char adEmail, char adPhone, char adAdress, char adSex) {
		super();
		AdId = adId;
		AdName = adName;
		AdPwd = adPwd;
		AdEmail = adEmail;
		AdPhone = adPhone;
		AdAdress = adAdress;
		AdSex = adSex;
	}
	
	
}
