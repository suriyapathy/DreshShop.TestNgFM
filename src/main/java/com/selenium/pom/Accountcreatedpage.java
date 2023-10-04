package com.selenium.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.baseclass.baseclass;

public class Accountcreatedpage  extends baseclass{
	
	public Accountcreatedpage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(tagName = "b")
	WebElement account_success;
	@FindBy(xpath = "//a[@data-qa='continue-button']")
	WebElement createdAC_continue;
	public String accoutDone() {
		return account_success.getText();
	}
	public Homepage createdContinue() {
		createdAC_continue.click();
		return new Homepage();
	}

}
