package com.mf.daoImpl;

import java.lang.reflect.ParameterizedType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mf.dao.BaseDao;

public class BaseDaoImpl implements BaseDao<T>{

	 /** 操作常量 */
    public static final String SQL_INSERT = "insert";
    public static final String SQL_UPDATE = "update";
    public static final String SQL_DELETE = "delete";
    public static final String SQL_SELECT = "select";
	
    private PreparedStatement statement;
    
    private Class<T> EntityClass; //获取实体类
    
    private String sql;
    
    private Object argType[];
    
    private ResultSet resultSet;
    
    
    
	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) getClass()
                .getGenericSuperclass();      
		EntityClass = (Class<T>) type.getActualTypeArguments()[0];  
        
	}

	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T select(T t) {
		// TODO Auto-generated method stub
		return null;
	}

}
