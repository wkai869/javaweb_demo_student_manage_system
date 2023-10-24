package com.hua.dao;

import java.util.List;

import com.hua.entity.LevelExamination;

public interface LevelExaminationDAO {
	
	public List<LevelExamination> getAllWithYearTerm(String studentId,String yearTerm);
	
	public List<LevelExamination> getAllLevelWithStudentId(String studentId);
	
	public void insert(LevelExamination  levalExamination);
	
	public void update(LevelExamination  levalExamination);
	
	public void delete(Long studentId);
	
	/**
	 * ���غ�studentId��ȵļ�¼��
	 * @param name
	 * @return
	 */
	public Integer getCountWithStudentId(Long studentId);
}
