package com.mf.test;

import com.mf.daoImpl.BaseDaoImpl;
import com.mf.daoImpl.UserDaoImpl;
import com.mf.entity.User;

public class Test {
	public static void main(String[] args) {
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		User user=new User();
		user.setId("1");
		user.setName("ÕÅÈý");
		user.setSex("ÄÐ");
		user.setEmail("1321@qq.com");
		user.setPwd("123456");
		userDaoImpl.add(user);
	}
}
