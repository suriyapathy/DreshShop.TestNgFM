package com.selenium.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.selenium.baseclass.baseclass;

public class Homepage extends baseclass {
	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='logo pull-left']//img")
	WebElement logo;
	@FindBy(xpath = "//*[text()=' Signup / Login']")
	WebElement login_button;
	@FindBy(xpath = "//a//i//following-sibling::b")
	WebElement user_name;
	@FindBy(xpath = "//a[text()=' Delete Account']")
	WebElement delete_ac;
	@FindBy(xpath = "//a[text()=' Logout']")
	WebElement logout_button;
	@FindBy(xpath = "//a[text()=' Contact us']")
	WebElement contactus_button;
	@FindBy(xpath = "//a[text()=' Products']")
	WebElement Products_button;

	public boolean verifyhomeLogo() {
		return logo.isDisplayed();
	}
	public Loginpage login_page() {
		login_button.click();
		return new Loginpage();	
	}

	public String verifyUser() {
		return user_name.getText();
	}
	public void accountdelete() {
		delete_ac.click();
	}
	public boolean veriflogoutbutton() {
		return logout_button.isDisplayed();
	}
	public Loginpage logout() {
		logout_button.click();
		return new Loginpage();
	}
	public Contactpage contact() {
		contactus_button.click();
		return new Contactpage();
	}
	public Productspage goProductPage() {
		Products_button.click();
		return new Productspage();
	}
	
}
