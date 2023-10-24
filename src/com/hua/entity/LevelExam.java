package com.hua.entity;

public class LevelExam {
	private String yearTerm;  //ѧ��ѧ��
	
	private String courseId;    //�����γ̱��
	
	private String courseName;   //�����γ�����
	
	private String applyTime;   //����ʱ��
	
	private String examTime;   //����ʱ��
	
	private String examCost;  //���Ի���


	public LevelExam() {
		super();
	}


	public LevelExam(String yearTerm, String courseId, String courseName,
			String applyTime, String examTime, String examCost) {
		super();
		this.yearTerm = yearTerm;
		this.courseId = courseId;
		this.courseName = courseName;
		this.applyTime = applyTime;
		this.examTime = examTime;
		this.examCost = examCost;
	}


	public String getYearTerm() {
		return yearTerm;
	}


	public void setYearTerm(String yearTerm) {
		this.yearTerm = yearTerm;
	}


	public String getCourseId() {
		return courseId;
	}


	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getApplyTime() {
		return applyTime;
	}


	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}


	public String getExamTime() {
		return examTime;
	}


	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}


	public String getExamCost() {
		return examCost;
	}


	public void setExamCost(String examCost) {
		this.examCost = examCost;
	}


	@Override
	public String toString() {
		return "LevelExam [yearTerm=" + yearTerm + ", courseId=" + courseId
				+ ", courseName=" + courseName + ", applyTime=" + applyTime
				+ ", examTime=" + examTime + ", examCost=" + examCost + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((applyTime == null) ? 0 : applyTime.hashCode());
		result = prime * result
				+ ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result
				+ ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result
				+ ((examCost == null) ? 0 : examCost.hashCode());
		result = prime * result
				+ ((examTime == null) ? 0 : examTime.hashCode());
		result = prime * result
				+ ((yearTerm == null) ? 0 : yearTerm.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LevelExam other = (LevelExam) obj;
		if (applyTime == null) {
			if (other.applyTime != null)
				return false;
		} else if (!applyTime.equals(other.applyTime))
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (examCost == null) {
			if (other.examCost != null)
				return false;
		} else if (!examCost.equals(other.examCost))
			return false;
		if (examTime == null) {
			if (other.examTime != null)
				return false;
		} else if (!examTime.equals(other.examTime))
			return false;
		if (yearTerm == null) {
			if (other.yearTerm != null)
				return false;
		} else if (!yearTerm.equals(other.yearTerm))
			return false;
		return true;
	}

	
}
