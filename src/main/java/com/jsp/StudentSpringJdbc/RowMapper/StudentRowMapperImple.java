package com.jsp.StudentSpringJdbc.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.jsp.StudentSpringJdbc.Entity.Student;
@Component
public class StudentRowMapperImple implements RowMapper<Student>
{

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		 Student s = new Student();
		 s.setsId(rs.getInt("sid"));
		 s.setsName(rs.getString("sname"));
		 s.setsPer(rs.getDouble("per"));
		 s.setsStream(rs.getString("stream"));
		return s;
	}
	
}
