package com.selenium.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.selenium.baseclass.baseclass;
import com.selenium.utility.ReuseableCode;

public class Newuserregisterpage extends baseclass {
	public Newuserregisterpage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//b[text()='Enter Account Information']")
	WebElement enterNewuser_page;
	@FindBy(xpath = "//input[@type='radio' and @value='Mr']")
	WebElement select_male;
	@FindBy(xpath = "//input[@type='radio' and @value='Mrs']")
	WebElement select_female;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "days")
	WebElement days;
	@FindBy(id = "months")
	WebElement months;
	@FindBy(id = "years")
	WebElement years;
	@FindBy(id = "newsletter")
	WebElement newsletter;
	@FindBy(id = "optin")
	WebElement optin;
	@FindBy(id = "first_name")
	WebElement first_name;
	@FindBy(id = "last_name")
	WebElement last_name;
	@FindBy(id = "company")
	WebElement company;
	@FindBy(id = "address1")
	WebElement address1;
	@FindBy(id = "address2")
	WebElement address2;
	@FindBy(id = "country")
	WebElement country;
	@FindBy(id = "state")
	WebElement state;
	@FindBy(id = "city")
	WebElement city;
	@FindBy(id = "zipcode")
	WebElement zipcode;
	@FindBy(id = "mobile_number")
	WebElement mobile_number;
	@FindBy(xpath = "//button[@data-qa='create-account']")
	WebElement create_accountsubmit;
	
	public String verifyuser_page() {
		return enterNewuser_page.getText();
	}

	public Accountcreatedpage adduser_details() {
		select_male.click();
		password.sendKeys("9894455921");
		ReuseableCode.selectbutton(days).selectByVisibleText("10");
		ReuseableCode.selectbutton(months).selectByVisibleText("May");
		ReuseableCode.selectbutton(years).selectByVisibleText("1994");
		newsletter.click();
		optin.click();
		first_name.sendKeys("surya");
		last_name.sendKeys("pathy");
		company.sendKeys("HCL");
		address1.sendKeys("25/B west vandikara street");
		address2.sendKeys("Thanjavur");
		country.sendKeys("India");
		state.sendKeys("Tamilnadu");
		city.sendKeys("chennai");
		zipcode.sendKeys("613001");
		mobile_number.sendKeys("9894455921");
		create_accountsubmit.click();
		return new Accountcreatedpage();
	}

}
