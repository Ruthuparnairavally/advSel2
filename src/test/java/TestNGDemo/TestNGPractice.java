package TestNGDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {

	@Test(invocationCount = 1 )
	public void createCutomer()
	{
		//Assert.fail();
		System.out.println("Customer created");
	}
	
	@Test(enabled = false)
	public void customerModified()
	{
		//Assert.fail();
		System.out.println("Customer Modified");
	}
	
	@Test()
	public void customerDeleted()
	{
		//Assert.fail();
		System.out.println("customer Deleted");
	}
} 