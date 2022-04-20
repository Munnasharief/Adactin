package org.tcs.excel;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

public class testread {
	
	public static void main(String[] args) {
				
		try {
			
			FileReader fd = new FileReader(new File("C:\\Users\\HP 15\\eclipse-Sample\\Sample1\\src\\File.Properties"));
			
			Properties prop = new Properties();
			prop.load(fd);
			System.out.println(prop.getProperty("username"));
			System.out.println(prop.getProperty("password"));
			
			} catch (Exception e) {
			
		}
		

		try {
			Properties prop = new Properties();
			prop.setProperty("username", "AIITE");
			prop.setProperty("password", "12345");
			prop.setProperty("1.c", "12345");
			prop.setProperty("2.a", "12345");
			prop.store(new FileWriter(new File("C:\\Users\\HP 15\\eclipse-Sample\\Sample1\\src\\File.Properties")), "username and password entered");
			
			
		} catch (Exception e) {
			
		}
		
		}
		
	}

