package com.jsp.StudentSpringJdbc;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.StudentSpringJdbc.Dao.StudentDaoImple;
import com.jsp.StudentSpringJdbc.Entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    private static ApplicationContext context;
	private static Scanner sc;

	public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        context = new AnnotationConfigApplicationContext(StudentClassConfig.class);
        StudentDaoImple std = context.getBean("studentDaoImple",StudentDaoImple.class);
        
        sc = new Scanner(System.in);
        System.out.println("==========================STUDENT DETAILS======================");
        System.out.println("Enter 1 for inserting new student details ");
        System.out.println("Enter 2 for fetching data by stream : ");
        System.out.println("Enter 3 fro fetching data by id :");
        System.out.println("Enter 4 for fecthing data by percentage : ");
        System.out.println("Enter 5 for update stream by sid : ");
        int key = sc.nextInt();
        
       switch (key) {
	case 1:{
		std.insertStudent();
		System.out.println("Record inserted.....!!");
		break;
	}
	case 2: {
		List<Student> l1 = std.fetchByStream();
		Iterator<Student> i = l1.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
			System.out.println("================================");
		}
		break;
	}
	case 3 :{
		Student s1 = std.fetcById();
		if (s1!=null) {
			System.out.println(s1);
		}
		break;
	}
	case 4 : {
		List<Student> l2 = std.fetchByPercentage();
		if (l2!=null) {
			Iterator<Student> i1 = l2.iterator();
			while (i1.hasNext()) {
				Student student = (Student) i1.next();
				System.out.println(student);
			}
		}
		break;
	}
	case 5 : {
		std.updateStreambyStuId();
		System.out.println("Record updated....!!");
		break;
	}
	default:
		System.out.println("Enter proper details...!!");
		break;
	}
    }
}
