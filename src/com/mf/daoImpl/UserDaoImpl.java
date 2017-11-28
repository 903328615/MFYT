package com.mf.daoImpl;

import java.lang.reflect.ParameterizedType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.mf.dao.UserDao;
import com.mf.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	   private Class<?> EntityClass;

	    private String sql;

	    private PreparedStatement statement;

	    private ResultSet rs;

	    private List<User> list;

	    public UserDaoImpl() {

	        ParameterizedType type = (ParameterizedType) getClass()
	                .getGenericSuperclass();
	        EntityClass = (Class<?>) type.getActualTypeArguments()[0];
	    }
	
}
