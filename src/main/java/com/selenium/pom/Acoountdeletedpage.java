package com.selenium.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.baseclass.baseclass;

public class Acoountdeletedpage extends baseclass{

	public Acoountdeletedpage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(tagName = "b")
	WebElement account_deletesuccess;
	@FindBy(xpath = "//a[@data-qa='continue-button']")
	WebElement deleteAC_continue;
	
	public Homepage deleteContinue() {
		deleteAC_continue.click();
		return new Homepage();
	}
	public String verifyAC_delete() {
		return account_deletesuccess.getText();
	}
}
