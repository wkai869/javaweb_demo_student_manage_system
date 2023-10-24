package com.hua.entity;
/**
 * ѧ��ѡ�α�����Ϣ��
 * @author hua
 *
 */
public class LevelExamList {
	private String studentId; //ѧ��
	
	private String courseId;  //�ѱ����Ŀγ̱��

	public LevelExamList(String studentId, String courseId) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
	}

	public LevelExamList() {
		super();
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "StudentOptCourse [studentId=" + studentId + ", courseId="
				+ courseId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result
				+ ((studentId == null) ? 0 : studentId.hashCode());
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
		LevelExamList other = (LevelExamList) obj;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}
	
	
}
