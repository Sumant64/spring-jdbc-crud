package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
        //INSERT
//        Student student = new Student();
//        student.setId(5);
//        student.setName("John");
//        student.setCity("Lucknow");
//        
//        int result = studentDao.insert(student);
//        
//        System.out.println("Student added " + result);
        
        //Update
//        Student student = new Student();
//        student.setId(5);
//        student.setName("Raj Kumar");
//        student.setCity("Ranchi");
//        
//        int result = studentDao.change(student);
//        System.out.println("data changed" + result);
        
        // DElete
//        int result = studentDao.delete(5);
//        System.out.println("deleted " + result);
        
        
        // get single student
//        Student student = studentDao.getStudent(5);
//        System.out.println(student);
        
        //get all students
        List<Student> students = studentDao.getAllStudents();
        for (Student s : students) {
        	System.out.println(s);
        }
        
        
        
        
        
        
        
    }
}
