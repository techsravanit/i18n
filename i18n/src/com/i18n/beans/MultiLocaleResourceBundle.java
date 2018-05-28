package com.i18n.beans;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

public class MultiLocaleResourceBundle {
	/* public static void main(String[] args) {

	      // create a new ResourceBundle with specified locale
	      ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.getDefault());

	      System.out.println("" + bundle.getString("savingsaccount.welcomeNote"));

	      // get the keys
	      Enumeration<String> enumeration = bundle.getKeys();

	      // print all the keys
	      while (enumeration.hasMoreElements()) {
	    	  // print the text assigned to key "savingsaccount.welcomeNote"
	         System.out.println("" + bundle.getString(enumeration.nextElement()));
	      }
	   }*/
	 
		private static MultiLocaleResourceBundle instance=null;

		private Map<Locale,Properties> localeProperties;
		private String[] baseNames;
		
		
		//singleton class constructor must be private
		private MultiLocaleResourceBundle(String[] baseNames) {
			localeProperties=new HashMap<>();
			this.baseNames = baseNames;
		}

		public static MultiLocaleResourceBundle getBundle(String[] baseNames){
			MultiLocaleResourceBundle mlrb=null;

			//check if the object is already created or not, 
			//if it is not created then create the object of mlrb by passing the parameters as basenames.
			if(instance==null){
				mlrb=new MultiLocaleResourceBundle(baseNames);
			}
			return mlrb;
		}

		public String getMessage(String key, Locale locale) {
			Properties lprops=null;
			ResourceBundle rb=null;
			String message=null;

			//check the data is already existed into the map or not, if not put that data into map.
			if(localeProperties.containsKey(locale)==false){
				lprops=new Properties();
				for(String baseName: baseNames){
					rb=ResourceBundle.getBundle(baseName,locale);

					/*for(String key:rb.getKeys()){
						message=rb.getMessage(key);
						lprops.put(key,message);
					}*/

					// get the keys
					Enumeration<String> enumeration = rb.getKeys();

					// print all the keys
					while (enumeration.hasMoreElements()) {
						// print the text assigned to key "savingsaccount.welcomeNote"
						String keys=enumeration.nextElement();
						message=rb.getString(keys);
						lprops.put(keys,message);
						
						/*message=rb.getString(enumeration.nextElement());
						System.out.println("message: "+message);
						lprops.put(enumeration.nextElement(),message);
						System.out.println("---"+lprops.getProperty(enumeration.nextElement()));*/
					}
				}

				localeProperties.put(locale,lprops);

			}else{
				lprops=localeProperties.get(locale);
			}
			return lprops.getProperty(key);
		}
}
