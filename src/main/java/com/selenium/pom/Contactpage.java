package com.selenium.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.baseclass.baseclass;
import com.selenium.utility.ReuseableCode;

public class Contactpage extends baseclass {
    public Contactpage() {
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//h2[text()='Get In Touch']")
    WebElement contactpage;
    @FindBy(xpath = "//input[@name='name']")
    WebElement username;
    @FindBy(xpath = "//input[@name='email']")
    WebElement useremail;
    @FindBy(xpath = "//input[@name='subject']")
    WebElement subject;
    @FindBy(xpath = "//textarea[@name='message']")
    WebElement msg;
    @FindBy(xpath = "//input[@type='file']")
    WebElement upload_file;
    @FindBy(xpath = "//input[@name='submit']")
    WebElement submit_button;
    @FindBy(xpath = "//a[@class='btn btn-success']")
    WebElement home_button;
    

    public String verify_contactpage() {
    	return contactpage.getText();
    }
    public void uploadfile() {
    	username.sendKeys("surya");
    	useremail.sendKeys("asfs@gmail.com");
    	subject.sendKeys("first commit");
    	msg.sendKeys("selenium practices");
    	upload_file.sendKeys("C:\\Users\\DELL\\Desktop\\text.txt");
    	submit_button.click();
    	ReuseableCode.alert(driver).accept();
    }
    public Homepage homereturn() {
    	home_button.click();
    	return new Homepage();
    }
}
