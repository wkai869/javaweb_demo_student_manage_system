package com.hua.dao;

import java.util.List;

import com.hua.entity.Teacher;

public interface TeacherDAO {
	public List<Teacher> getAll();
	
	public Teacher get(String teacherId);
	
	public void insert(Teacher teacher);
	
	public void update(Teacher teacher);
	
	public void delete(String teacherId);
	
	/**
	 * ���غ�teacherId��ȵļ�¼��
	 * @param teacherId
	 * @return
	 */
	public long getCountWithName(String teacherId);

}
