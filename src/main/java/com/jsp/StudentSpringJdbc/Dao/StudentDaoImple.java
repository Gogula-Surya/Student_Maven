package com.jsp.StudentSpringJdbc.Dao;

import java.util.List;
import java.util.Scanner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.jsp.StudentSpringJdbc.Entity.Student;

@Component
public class StudentDaoImple implements StudentDao
{
	Scanner sc = new Scanner(System.in);
	@Autowired
	JdbcTemplate template;
	@Autowired
	RowMapper<Student> rowMapper;
	
	String query;
	int res;
	
	public int insertStudent() {
		query = "insert into students values(?,?,?,?)";
		Student s = new Student();
		System.out.println("Enter student id : ");
		s.setsId(sc.nextInt());
		System.out.println("Enter student name : ");
		s.setsName(sc.next());
		System.out.println("Enter student percentage : ");
		s.setsPer(sc.nextDouble());
		System.out.println("Enter student stream : ");
		s.setsStream(sc.next());
		res = template.update(query,s.getsId(),s.getsName(),s.getsPer(),s.getsStream());
		return res;
	}
	public List<Student> fetchByStream()
	{
		String query = "select * from students where stream = ?";
		
		System.out.println("Enter student stream : ");
		String stream = sc.next();
		List<Student> ls = template.query(query,rowMapper,stream);
		return ls;
	}
	public Student fetcById()
	{
		String query = "select * from students where sid=?";
		System.out.println("Enter student id : ");
		int sid = sc.nextInt();
		try {
			Student s1 = template.queryForObject(query, rowMapper,sid);
			return s1;
		} catch (Exception e) {
			System.out.println("Required student id is not there....!!");
		}
		return null;
	}
	public List<Student> fetchByPercentage()
	{
		String query = "select * from students where per=?";
		System.out.println("Enter student percentage : ");
		double per = sc.nextDouble();
		try {
			List<Student> s2 = template.query(query, rowMapper,per);
			return s2;
		} catch (Exception e) {
			System.out.println("Required student percentage is not there....!!");
		}
		return null;
	}
	public int updateStreambyStuId() {
		query = "update students set stream=? where sid = ?";
		System.out.println("Enter Student stream : ");
		String stream = sc.next();
		System.out.println("Enter student sid : ");
		int sid = sc.nextInt();
		res = template.update(query,stream,sid);
		return 0;
	}
}
