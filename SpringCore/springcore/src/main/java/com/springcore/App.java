package com.springcore;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        Student s1 = (Student) context.getBean("student1");
        Student s2 = (Student) context.getBean("student1");

        List<String> l = s1.getCourses();
        System.out.println(l.stream().sorted().collect(Collectors.toList()));
    }
}