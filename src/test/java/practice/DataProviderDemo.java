package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	@Test(dataProvider = "getData")
	public void demoTest(String phone, int price)
	{
		System.out.println(phone);
		System.out.println(price);
	}
	
	@DataProvider //(name ="demodata")
	public Object [][] getData()
	{
		Object [][] obj = new Object[3][2];
		
		obj[0][0] = "Samsung";
		obj[0][1] = 12000;
		
		obj[1][0] = "Nokia";
		obj[1][1] = 10000;
		
		obj[2][0] = "Iphone";
		obj[2][1] = 25000;
		
		return obj;
	}
}
