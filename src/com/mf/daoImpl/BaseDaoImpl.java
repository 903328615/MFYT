package com.mf.daoImpl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mf.dao.BaseDao;
import com.mf.util.JdbcDaoHelper;

public class BaseDaoImpl<T> implements BaseDao<T>{

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
    
    
    /**
     * 构造函数获取传入泛型类型
     */
    @SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) getClass()
                .getGenericSuperclass();  
		
		EntityClass = (Class<T>) type.getActualTypeArguments()[0];  
        /*
         * type==>com.mf.daoImpl.BaseDaoImpl<com.mf.entity.User>
		EntityClass==>class com.mf.entity.User
         * */
		System.out.println("type==>"+type+"\nEntityClass==>"
				+EntityClass);
	}

    

	
	/* (non-Javadoc)
	 * @see com.mf.dao.BaseDao#add(java.lang.Object)
	 */
	@Override
	public void add(T t) {
		  sql = this.getSql(SQL_INSERT);   //获取sql.
	        // 赋值.
	        try {
	            argType = setArgs(t, SQL_INSERT);
	            statement = JdbcDaoHelper.getPreparedStatement(sql);  //实例化PreparedStatement.
	            //为sql语句赋值.
	            statement = JdbcDaoHelper.setPreparedStatementParam(statement,argType);
	            statement.executeUpdate(); //执行语句.
	        } catch (Exception e) {
	        
	            e.printStackTrace();
	        } finally {
	            JdbcDaoHelper.release(statement, null);  //释放资源.
	        }
		
	}


	@Override
	public void delete(T t) {
		
		sql=this.getSql(SQL_DELETE);
		

		
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
	
	/**
	 * 拼接Sql语句
	 * @param operator
	 * @return
	 */
	private String getSql(String operator) {
		StringBuffer sqlBuffer =new StringBuffer();
		//通过反射获取实体类中的所有变量
		Field[] fields =EntityClass.getDeclaredFields();
		
		//插入操作
		if (operator.equals(SQL_INSERT)) {
			sqlBuffer.append("inster into "+EntityClass.getSimpleName());
			sqlBuffer.append("(");
			for (int  i = 0;fields!=null&&i < fields.length;  i++) {
				fields[i].setAccessible(true);//设置访问权限
				String column =fields[i].getName();
				sqlBuffer.append(column).append(",");
			}
			sqlBuffer=sqlBuffer.deleteCharAt(sql.length()-1);
			sqlBuffer.append(")values(");
			for (int i = 0;fields!=null&& i < fields.length; i++) {
				sqlBuffer.append("?,");
			}

			sqlBuffer.deleteCharAt(sql.length()-1);
			sqlBuffer.append(")");//注意是否需要添加分号
		}else if (operator.equals(SQL_UPDATE)) {
			
			sqlBuffer.append("update "+EntityClass.getSimpleName()+" set");
			for (int i = 0;fields!=null&& i < fields.length; i++) {
				fields[i].setAccessible(true);//设置访问权限
				String column = fields[i].getName();
				if (column.equals("id")) {
					continue;
				}
				sqlBuffer.append(column).append("=").append("?,");
			}
		
			sqlBuffer.deleteCharAt(sql.length()-1);
			
			sqlBuffer.append(" where id=?");
		}else if (operator.equals(SQL_DELETE)) {
			sqlBuffer.append("delete from "+EntityClass.getSimpleName()+" where id=?");
		}else if(operator.equals(SQL_SELECT)){
			sqlBuffer.append("select * from "+EntityClass.getSimpleName()+" where id=?");
		}
		
		return sqlBuffer.toString();
	}

	/**
	 * 获取参数
	 * @param t
	 * @param sqlInsert
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	private Object[] setArgs(T entity, String operator) throws IllegalArgumentException, IllegalAccessException {
		
		Field[] fields = EntityClass.getDeclaredFields();
		
		if (operator.equals(SQL_INSERT)) {
			Object[] objects=new Object[fields.length];
			for (int i = 0;objects!=null&& i < objects.length; i++) {
				fields[i].setAccessible(true);
				objects[i]=fields[i].get(entity);
			}
			
			return objects;
		}else if (operator.equals(SQL_UPDATE)) {
			Object tempObject[] = new Object[fields.length];
			for (int i = 0;tempObject!=null&& i < tempObject.length; i++) {
				fields[i].setAccessible(true);
				tempObject[i]=fields[i].get(entity);
			}
			Object[] objects =new Object[fields.length];
			//数组间复制
			System.arraycopy(tempObject, 1, objects, 0, tempObject.length-1);
			objects[objects.length-1]=tempObject[0];
			return objects;
		}else if (operator.equals(SQL_DELETE)) {
			Object[] objects=new Object[1];
			fields [0].setAccessible(true);
			objects[0]=fields[0].get(entity);
			return objects;
		}else if (operator.equals(SQL_SELECT)) {
			Object[] objects=new Object[1];
			fields[0].setAccessible(true);
			objects[0]=fields[0].get(entity);
			return objects;
		}
		
		return null;
	}

    
    
}
