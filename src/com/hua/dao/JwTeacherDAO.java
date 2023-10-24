package com.hua.dao;

import java.util.List;

import com.hua.entity.JwTeacher;

public interface JwTeacherDAO {
	public List<JwTeacher> getAll();
	
	public JwTeacher get(String teacherId);
	
	public void insert(JwTeacher teacher);
	
	public void update(JwTeacher teacher);
	
	public void delete(String teacherId);
	
	/**
	 * ���غ�teacherId��ȵļ�¼��
	 * @param teacherId
	 * @return
	 */
	public long getCountWithName(String teacherId);

}
