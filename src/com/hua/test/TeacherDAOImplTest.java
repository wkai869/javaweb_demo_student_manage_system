package com.hua.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hua.entity.Teacher;
import com.hua.impl.TeacherDAOImpl;

public class TeacherDAOImplTest {
	
	TeacherDAOImpl tdi = new TeacherDAOImpl();
	Teacher t = new Teacher("123456", "��Ӣ", "��", "��Ա", "����", "�����ѧԺ", "�������ѧ�뼼��",
			"�㶫����", "15626438856","123th@126.com", "������Խ����");
	
	@Test
	public void testGetAll() {
		System.out.println(tdi.getAll());
	}

	@Test
	public void testGetString() {
		System.out.println(tdi.get("123456"));;
	}

	@Test
	public void testInsert() {
		tdi.insert(t);
	}

	@Test
	public void testUpdateTeacher() {
		t.setGender("Ů");
		tdi.update(t);
	}

	@Test
	public void testDelete() {
		tdi.delete("123456");
	}

	@Test
	public void testGetCountWithName() {
		fail("Not yet implemented");
	}

}
