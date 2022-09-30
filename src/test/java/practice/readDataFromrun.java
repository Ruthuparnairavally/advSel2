package practice;

import org.testng.annotations.Test;

public class readDataFromrun {

	@Test
	public void tc1()
	{
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("user");
		String PASSWORD = System.getProperty("pass");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
	}
}
