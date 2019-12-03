package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.testbase.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contacts_btn;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement deals_btn;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasks_btn;
	
	@FindBy(xpath="//td[contains(text(),'User: hem sunder')]")
	WebElement Username_field;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean ValidateUsername(){
		driver.switchTo().frame("mainpanel");
		return Username_field.isDisplayed();
	}
	
	public ContactsPage ClickOnContactsLink(){
		driver.switchTo().frame("mainpanel");
		contacts_btn.click();
		return new ContactsPage();
	}
	
	public DealsPage ClickOnDealsLink(){
		driver.switchTo().frame("mainpanel");
		deals_btn.click();
		return new DealsPage();
	}
	
	public TasksPage ClickOnTasksLink(){
		driver.switchTo().frame("mainpanel");
		tasks_btn.click();
		return new TasksPage();
	}

}
