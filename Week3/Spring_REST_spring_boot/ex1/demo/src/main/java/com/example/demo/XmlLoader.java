package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlLoader {
    public void loadBeans() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        
        // The IoC container fetches the bean based on the ID we defined in the XML
        Object myService = context.getBean("myService");
        System.out.println("Bean loaded: " + myService.getClass().getName());
    }
}