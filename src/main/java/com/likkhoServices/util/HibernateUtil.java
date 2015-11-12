package com.likkhoServices.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.appengine.api.utils.SystemProperty;
import com.likkhoServices.model.User;
import com.likkhoServices.service.UserService;

public class HibernateUtil {
 
	private static EntityManagerFactory entityManagerFactory;
	 
	private static EntityManagerFactory configureEntityManagerFactory() throws HibernateException {
		
		if (entityManagerFactory == null){
			
			entityManagerFactory = Persistence.createEntityManagerFactory("LikkhoServices");
		}
		
		return entityManagerFactory;
	}
	 
	public static EntityManagerFactory getEntityManagerFactory() {
		return configureEntityManagerFactory();
	}
	
	public static void main(String[] args){
		HibernateUtil.getEntityManagerFactory();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
		        "Spring-War.xml");

		    UserService userService = (UserService) ctx.getBean("userService");

		    User user = userService.userById(1l);
		    System.out.println("User Name: " + user.getFullName());
	}
}