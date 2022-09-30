package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTest {

	@Test(retryAnalyzer = vtigerGenericUtilities.RetryAnalyserImpl.class)
	public void testRun()
	{
		System.out.println("Rerun");
		Assert.fail();
	}
}
