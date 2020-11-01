package com.yezhinao;

import com.yezhinao.dao.DepartmentDao;
import com.yezhinao.dao.EmployeeDao;
import com.yezhinao.pojo.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

@SpringBootTest
class Springboot02ApplicationTests {

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private EmployeeDao employeeDao;

	@Test
	void contextLoads() {
		Department department = new Department(1,"123");
		System.out.println(department);
	}

	@Test
	void test01(){
		Collection<Department> departments = departmentDao.getDepartments();
		for (Department department:departments
			 ) {
			System.out.println(department);
		}


	}

}
