package com.klu.skill_4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext obj =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Student s = (Student) obj.getBean("stu");

        s.display();
    }
}