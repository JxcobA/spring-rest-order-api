package com.example.spring.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class OrderManagementApplication {

	public static void main(String[] args) {
		// ApplicationContext Container will be started with the beans (objects)
		// Root path of application : http://localhost:8080
		ApplicationContext context = SpringApplication.run(OrderManagementApplication.class, args);
	   /* String[] beanNames = context.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}*/
	}
}
