package com.mf.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;

	private static final ConnectionFactory factory =  new ConnectionFactory();

	private Connection conn;

	static {
		Properties pp = new Properties();
		try {
			InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			pp.load(in);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("============≈‰÷√Œƒº˛∂¡»°¥ÌŒÛ===========");
		}

		driver = pp.getProperty("driver");
		dburl = pp.getProperty("dburl");
		user = pp.getProperty("user");
		password = pp.getProperty("password");
		System.out.println(driver+" "+dburl+" "+user+" "+password);
	}

	private ConnectionFactory() {

	}

	public static ConnectionFactory getInstance() {
		return (ConnectionFactory) factory;
	}

	public Connection makeConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, user, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
}
