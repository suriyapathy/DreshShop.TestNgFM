package com.selenium.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.baseclass.baseclass;
import com.selenium.utility.ReuseableCode;

public class Loginpage extends baseclass {
	
	public  Loginpage() {
		PageFactory.initElements(driver, this);	
	}
	@FindBy(name = "name")
	WebElement username_button;
	@FindBy(xpath = "(//input[@placeholder='Email Address'])[2]")
	WebElement email_button;
	@FindBy(xpath = "//button[@data-qa='signup-button']")
	WebElement signup_button;
	@FindBy(xpath = "//h2[text()='New User Signup!']")
	WebElement newuser_page;
	@FindBy(xpath = "//div[@class='login-form']//h2")
	WebElement userlogin_page;
	@FindBy(xpath = "(//input[@placeholder='Email Address'])[1]")
	WebElement loginemail;
	@FindBy(name = "password")
	WebElement loginpassword;
	@FindBy(xpath = "//button[@data-qa='login-button']")
	WebElement login_button;
	@FindBy(xpath = "//p[contains(text(),'incorrect!')]")
	WebElement login_incorrect;
	
	public boolean verify_newuserPage() {
		return newuser_page.isDisplayed();
	}
	public boolean verify_userloginPage() {
		return userlogin_page.isDisplayed();
	}
	public Newuserregisterpage addNewuser() {
		username_button.sendKeys("surya");
		String random_wood=ReuseableCode.randomString();
		email_button.sendKeys(random_wood+"@gmail.com");
		signup_button.click();
		return new Newuserregisterpage();
	}
	public void verifylogin_N() {
		loginemail.sendKeys("adhg@gmail.com");
		loginpassword.sendKeys("23456234");
		login_button.click();
	}
	public String verify_loginincorrectmsg() {
		return login_incorrect.getText();
	}
	public Homepage verifylogin_P() {
		loginemail.sendKeys("suriyaece46@gmail.com");
		loginpassword.sendKeys("9894455921");
		login_button.click();
		return new Homepage();
	}
}
