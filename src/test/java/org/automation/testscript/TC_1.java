package org.automation.testscript;

import org.automation.pageobject.HomePage;
import org.automation.testbase.TestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_1  extends TestBase{
	//WebDriver driver;
	HomePage home;
	@BeforeTest
	public void lounch()
	{
		init();
	}
	@Test
	public void TC1_loginWithInvalidCredential()
	{
		home=new HomePage(driver);
		System.out.println("HI");
		home.login("varun","Kumar");
	}

}
