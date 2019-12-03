package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.pages.ContactsPage;
import com.qa.pages.DealsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.TasksPage;
import com.qa.testbase.TestBase;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage taskspage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception{
		initializaton();
		loginpage = new LoginPage();
		homepage = new HomePage();
		contactspage = new ContactsPage();
		dealspage = new DealsPage();
		taskspage = new TasksPage();
		homepage = loginpage.ValidateLoginFunction(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void HomePageTitleTest() {
		String HomePageTitle = homepage.ValidateHomePageTitle();
		Assert.assertEquals(HomePageTitle, "CRMPRO", "HomePage Title is not matched");
	}
	
	@Test(priority=2)
	public void UsernameTest(){
		boolean flag = homepage.ValidateUsername();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void VerifyContactsLinkTest(){
		contactspage = homepage.ClickOnContactsLink();
		String ContactsPageTitle = driver.getTitle();
		System.out.println("ContactsPage title is "+ContactsPageTitle);
	}
	
	@Test(priority=4)
	public void VerifyDealsPageTest(){
		dealspage = homepage.ClickOnDealsLink();
		String DealsPageTitle = driver.getTitle();
		System.out.println("Deals Page title is "+DealsPageTitle);
	}
	
	@Test(priority=5)
	public void VerifyTasksPageTest(){
		taskspage = homepage.ClickOnTasksLink();
		String TasksPageTitle = driver.getTitle();
		System.out.println("Tasks page title is "+TasksPageTitle);
	}
	
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	

}
