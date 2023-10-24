package com.hua.dao;

import java.util.List;

import com.hua.entity.LevelExamList;

public interface LevelExamListDAO {
	public List<LevelExamList> getAll();
	
	public List<LevelExamList> getAll(String studentId);
	
	public LevelExamList get(String studentId);
	
	public LevelExamList get(LevelExamList levelExamList);
	
	public void insert(LevelExamList levelExamList);
	
	public void update(LevelExamList levelExamList);
	
	public void delete(String studentId);
	
	/**
	 * ���غ�studentId��ȵļ�¼��
	 * @param studentId
	 * @return
	 */
	public long getCountWithName(String studentId);
	
}
