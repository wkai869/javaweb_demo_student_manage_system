package com.hua.dao;

import java.util.List;

import com.hua.entity.OptionalCourse;

public interface OptionalCourseDAO {
	public List<OptionalCourse> getAll();
	
	public OptionalCourse get(String courseId);
	
	public OptionalCourse get(String courseId, String yearTerm);
	
	public void insert(OptionalCourse optionalCourse);
	
	public void update(OptionalCourse optionalCourse);
	
	public void delete(String courseId);
	
	/**
	 * ���غ�studentId��ȵļ�¼��
	 * @param courseId
	 * @return
	 */
	public long getCountWithName(String courseId);
	
	/**
	 * ���غ�yearTerm��ȵļ�¼
	 * @param yearTerm
	 * @return
	 */
	public List<OptionalCourse> getAllWithYearTerm(String yearTerm);
}
