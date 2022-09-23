package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClass1 {

	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("BeforeSuit");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("AfterSuit");
	}
	
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("Before method");
	}
	
	@AfterMethod
	public void amConfig()
	{
		System.out.println("After method");
	}
	
	@BeforeClass
	public void bc()
	{
		System.out.println("Before class");
	}
	
	@AfterClass
	public void ac()
	{
		System.out.println("After class");
	}
	
	@Test
	public void demotest()
	{
		System.out.println("demotest");
	}
}
