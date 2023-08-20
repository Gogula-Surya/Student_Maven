package com.jsp.StudentSpringJdbc;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configurable
@ComponentScan(basePackages = "com.jsp.StudentSpringJdbc")
public class StudentClassConfig {
	
	@Bean
	public DriverManagerDataSource getDriverManagerDataSourceObject()
	{
		DriverManagerDataSource dm = new DriverManagerDataSource();
		dm.setDriverClassName("com.mysql.cj.jdbc.Driver"); // `com.mysql.jdbc.Driver'
		dm.setUrl("jdbc:mysql://localhost:3306/tejm35");
		dm.setUsername("root");
		dm.setPassword("12345");
		return dm;
	}
	@Bean
	public JdbcTemplate getJdbcTemplateObject()
	{
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDriverManagerDataSourceObject());
		return template;
	}

}
