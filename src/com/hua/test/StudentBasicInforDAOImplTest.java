package com.hua.test;

import org.junit.Test;

import com.hua.entity.CriterStudent;
import com.hua.entity.StudentBasicInformation;
import com.hua.impl.StudentBasicInforDAOImpl;

public class StudentBasicInforDAOImplTest {
	StudentBasicInforDAOImpl sbi = new StudentBasicInforDAOImpl();
	StudentBasicInformation studentBasicInfor = new StudentBasicInformation(3115001256l,
			"Tan","��","2015��","15(1)��","�Զ���ѧԺ",
			"������Ϣרҵ","��ѧ��У��","15622365566","�㶫ʡտ����ϼɽ��������");
	@Test
	public void testGetAll() {
		System.out.println(sbi.getAll());
	}

	@Test
	public void testGetLong() {
		System.out.println(sbi.get(3115001256l));
	}

	@Test
	public void testInsert() {
		sbi.insert(studentBasicInfor);
	}

	@Test
	public void testUpdateStudentBasicInformation() {
		StudentBasicInformation studentBasicInfor1 = new StudentBasicInformation(3115001256l,
				"Tan","��","2015��","15(2)��","�Զ���ѧԺ",
				"������Ϣרҵ","��ѧ��У��","15622369988","�㶫ʡտ����ϼɽ��������");
		sbi.update(studentBasicInfor1);
	}

	@Test
	public void testDelete() {
		sbi.delete(3115001256l);
	}

	@Test
	public void testGetCountWithName() {
		CriterStudent student = new CriterStudent(null, "������Ϣ����", null, null, null);
		
		System.out.println(sbi.getForListWithCriterStudent(student));
	}

}
