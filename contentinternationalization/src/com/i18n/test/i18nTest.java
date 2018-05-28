package com.i18n.test;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class i18nTest {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/i18n/common/application-context.xml");
		
		//String message=context.getMessage("savingsaccount.welcomeNote", null, Locale.getDefault());	
		//String message=context.getMessage("savingsaccount.welcomeNote", null, Locale.SIMPLIFIED_CHINESE);
		
		/**
		 * context.getMessage(String key, Object params, Locale locale);
		 * object param example : field.invalid={0} cannot be blank
		 * {0} : new Object[]{"accountno"}
		 * 
		 */
		
		String message=context.getMessage("field.invalid", new Object[]{"account no"}, Locale.getDefault());
		System.out.println(message);
	}

}
