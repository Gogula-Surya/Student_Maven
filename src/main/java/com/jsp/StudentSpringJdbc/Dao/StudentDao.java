package com.jsp.StudentSpringJdbc.Dao;

import java.util.List;

import com.jsp.StudentSpringJdbc.Entity.Student;

public interface StudentDao
{
	// update
	int insertStudent();
	// queryforObject()
	Student fetcById();
	// query() 
	List<Student> fetchByStream();
	// query()
	List<Student> fetchByPercentage();
	// update
	int updateStreambyStuId();
	
}
