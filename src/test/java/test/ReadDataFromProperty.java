package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import vtigerGenericUtilities.IConstant;

public class ReadDataFromProperty {

	public static void main(String[] args) throws IOException {
		//Step 1: Load the file location
		FileInputStream fis = new FileInputStream(IConstant.propertyfilepath);
		
		//Step 2: Create object foe properties
		Properties p = new Properties();
		
		//Step 3: Load the data into properties
		p.load(fis);
		
		//Step 4: Use key and value
		String BROWSER = p.getProperty("browser");
		System.out.println(BROWSER);
		
		String URL = p.getProperty("url");
		System.out.println(URL);
	}
	
}
