package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testbase.TestBase;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initializaton();
		loginpage = new LoginPage();
		homepage = new HomePage();
	}
	
	@Test(priority=1)
	public void CRMLogoTest(){
		boolean flag=loginpage.ValidateCRMPROLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void LoginPageTitleTest(){
		String title=loginpage.ValidateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support", 
				"LoginPage title is not matched");
	}
	
	@Test(priority=3)
	public void LoginTest() throws Exception{
		homepage = loginpage.ValidateLoginFunction(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	
	
}
