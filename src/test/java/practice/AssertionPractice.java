package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {

	@Test
	public void assertPractice1()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("Step-1");
		sa.assertTrue(false);
		System.out.println("Step-2");
		sa.assertAll();
		Assert.assertEquals("A", "B"); //hard assert
		
		System.out.println("Step-3");
		System.out.println("Step-4");
		sa.assertAll();
	}
	
	@Test
	public void assertPractice2()
	{
		SoftAssert sa = new SoftAssert();
		
		
		System.out.println("Step-1 script-2");
		sa.assertEquals(true, false);
		System.out.println("Step-2 script-2");
		
		sa.assertTrue(false);
		
		System.out.println("Step-3 script-2");	
		System.out.println("Step-4 script-2");
		sa.assertAll();
	}
}
