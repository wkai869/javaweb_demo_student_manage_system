package com.hua.dao;

import java.util.List;

import com.hua.entity.CourseSchedule;

public interface CourseScheduleDAO {
	public List<CourseSchedule> getAll();
	
	public CourseSchedule get(String studentId);
	
	public void insert(CourseSchedule courseSchedule);
	
	public void update(CourseSchedule courseSchedule);
	
	public void delete(String studentId);
	
	/**
	 * ���غ�studentId��ȵļ�¼��
	 * @param studentId
	 * @return
	 */
	public long getCountWithName(String studentId);
	
	/**
	 * ���غ�studentId��yearTerm��week��ȵļ�¼
	 * @param studentId
	 * @param yearTerm
	 * @param week
	 * @return
	 */
	public List<CourseSchedule> getAllWithYearTerm(String studentId,
			String yearTerm, String week);
}
