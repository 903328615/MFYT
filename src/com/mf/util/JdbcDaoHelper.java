package com.mf.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDaoHelper {

	


	private static Connection con;

	
	public static Connection getConnection(){
		
		DButil dButil=new DButil();
		
		con=dButil.getConnection();
		
		return con;
		
	}
	
	
	public static PreparedStatement setPreparedStatementParam(PreparedStatement statement, Object[] argType) throws SQLException {
		for (int i = 0; i < argType.length; i++) {
			statement.setObject(i+1, argType[i]);
		}
		return statement;
	}

	public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
		
			return getConnection().prepareStatement(sql);
	
	}

	public static void release(PreparedStatement statement, ResultSet resultSet) {
		
			try {
				if (con!=null) {
					con.close();
					con=null;
				}
				if (statement!=null) {
					statement.close();
					statement=null;
				}
				if (resultSet!=null) {
					resultSet.close();
					resultSet=null;
				}
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}



}
