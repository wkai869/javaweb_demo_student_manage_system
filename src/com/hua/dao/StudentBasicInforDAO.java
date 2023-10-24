package com.hua.dao;

import java.util.List;

import com.hua.entity.CriterStudent;
import com.hua.entity.StudentBasicInformation;

public interface StudentBasicInforDAO {
	public List<StudentBasicInformation> getAll();
	
	public StudentBasicInformation get(Long studentId);
	
	public void insert(StudentBasicInformation  studentBasicInfor);
	
	public void update(StudentBasicInformation  studentBasicInfor);
	
	public void delete(Long studentId);
	
	/**
	 * ���غ�studentId��ȵļ�¼��
	 * @param name
	 * @return
	 */
	public Integer getCountWithStudentId(Long studentId);
	
	
	public List<StudentBasicInformation> getForListWithCriterStudent(CriterStudent student);
}
