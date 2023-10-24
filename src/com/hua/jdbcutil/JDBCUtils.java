package com.hua.jdbcutil;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * JDBC�����Ĺ�����
 * @author hua
 *
 */
public class JDBCUtils {
	private static DataSource dataSource = null;
	
	static{
		//����Դֻ�ܱ�����һ��
		dataSource = new ComboPooledDataSource("hua.project");
	}
	
	/**
	 * 
	 * @return ����Դ��һ��Connection����
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	/**
	 * �ر�Connection����
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
