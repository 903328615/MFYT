package com.mf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DButil {

	public Connection getConnection(){
		Properties prop=new Properties();
		Connection connection=null;
		String driverString=null;
		String urlString=null;
		String usernameString=null;
		String passwordString=null;
		try {
			prop.load(this.getClass().getClassLoader().getResourceAsStream("connDB.properties"));
			driverString=prop.getProperty("DB_CLASS_NAME");
			urlString=prop.getProperty("DB_URL");
			usernameString=prop.getProperty("USERNAME");
			passwordString=prop.getProperty("PASSWORD");
			Class.forName(driverString);
			connection= DriverManager.getConnection(urlString,usernameString,passwordString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (connection==null) {
			System.err.println("连接为空\n"+driverString+"\nurl:"+urlString+"\npassword:"+passwordString);
		}
		return connection;
	}
	public void closeConnection(Connection connection){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
		


