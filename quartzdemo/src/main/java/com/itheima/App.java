package com.itheima;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author JinLu
 */
public class App {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring-jobs.xml");
    }
}
