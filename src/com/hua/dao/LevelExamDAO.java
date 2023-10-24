package com.hua.dao;

import java.util.List;

import com.hua.entity.LevelExam;

public interface LevelExamDAO {
	public List<LevelExam> getAll();
	
	public LevelExam get(String courseId);
	
	public LevelExam get(String courseId, String yearTerm);
	
	public void insert(LevelExam levelExam);
	
	public void update(LevelExam levelExam);
	
	public void delete(String courseId);
	
	/**
	 * ���غ�courseId��ȵļ�¼��
	 * @param courseId
	 * @return
	 */
	public long getCountWithName(String courseId);
	
	/**
	 * ���غ�yearTerm��ȵļ�¼
	 * @param yearTerm
	 * @return
	 */
	public List<LevelExam> getAllWithYearTerm(String yearTerm);
}
