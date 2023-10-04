package com.selenium.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.baseclass.baseclass;

public class Productspage extends baseclass {
	
	public Productspage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//h2[text()='All Products']")
	WebElement allproduct;
	
	@FindBy(xpath = "(//a[text()='View Product'])[1]")
	WebElement viewproduct;
	
	public String verifyproductpage() {
		return allproduct.getText();
	}
	public Productdetailspage viewproduct() {
		viewproduct.click();
		return new Productdetailspage();
	}

}
