package com.learning.fred.mockdemo;

import com.learning.fred.mockdemo.order.AbstractDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MockDemoApplication {

    @Autowired
    List<AbstractDemo> list;

    public static void main(String[] args) {
        SpringApplication.run(MockDemoApplication.class, args);

//        System.out.println(list.size());
    }

}
