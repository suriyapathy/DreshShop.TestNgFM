package com.selenium.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.selenium.baseclass.baseclass;

public class Productdetailspage extends baseclass{
	public Productdetailspage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class='product-information']")
	WebElement product_details;
	
	
	public boolean verify_productdetails() {
		return product_details.isDisplayed();
	}
	public String veritfy_detailspagetitle() {
		String title=driver.getTitle();
		return title;
	}
	
}
