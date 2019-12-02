package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.testbase.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement login_btn;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement CRMPROLogo;
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean ValidateCRMPROLogo(){
		return CRMPROLogo.isDisplayed();
	}
	
	public String ValidateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage ValidateLoginFunction(String un, String pwd) throws Exception{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(5000);
		login_btn.click();
		
		return new HomePage();
	}
		
		

	
	

}
