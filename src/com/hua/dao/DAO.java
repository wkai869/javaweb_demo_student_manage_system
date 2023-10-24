package com.hua.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hua.jdbcutil.JDBCUtils;

/**
 * ��װ�˻�����CRUD�ķ������Թ�����̳�ʹ��
 * ��ǰDAOֱ���ڷ����л�ȡ���ݿ����ӡ�
 * ����DAO����DBUtils���������
 * @author hua
 *
 */
public class DAO<T> {
	private QueryRunner qr = new QueryRunner();
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public DAO(){
		Type superClass = getClass().getGenericSuperclass();
		
		if(superClass instanceof ParameterizedType){
			ParameterizedType pt = (ParameterizedType)superClass;
			
			Type[] typeArgs = pt.getActualTypeArguments();
			if(typeArgs != null && typeArgs.length > 0){
				if(typeArgs[0] instanceof Class){
					clazz = (Class<T>)typeArgs[0];
				}
			}
		}
	}
	
	/**
	 * ���ض�Ӧ��T��һ��ʵ����Ķ���
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql, Object...args){
		Connection conn = null;
		
		try {
			conn = JDBCUtils.getConnection();
			return qr.query(conn, sql,new BeanHandler<>(clazz),args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeConnection(conn);
		}
		
		return null;	
	}
	
	/**
	 * ����T��Ӧ��List
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getForList(String sql, Object...args){
		Connection conn = null;
			
		try {
			conn = JDBCUtils.getConnection();
			return qr.query(conn, sql, new BeanListHandler<>(clazz), args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeConnection(conn);
		}
		
		return null;
	}
	
	/**
	 * �÷�����װ��Insert��Delete��Update����
	 * @param sql : SQL���
	 * @param args
	 */
	public void update(String sql, Object...args){
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			qr.update(conn, sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeConnection(conn);
		}
	}
	
	/**
	 * ����ĳ���ֶε�ֵ�����緵��ĳһ����¼��customerName���򷵻����ݱ����ж�������¼
	 * @param sql
	 * @param args
	 * @return
	 */
	public <E> E getForValue(String sql, Object...args){
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			return qr.query(conn, sql,new ScalarHandler<E>(),args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeConnection(conn);
		}
		
		return null;	
	}
}
