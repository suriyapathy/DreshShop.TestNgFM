package com.selenium.utility;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class ReuseableCode {
	
	public static String randomString() {
		String random_email=RandomStringUtils.randomAlphabetic(5);
		return random_email;	
	}
   public static Select selectbutton(WebElement element) {
	  Select select=new Select(element);
	  return select;
  }
   public static Alert alert (WebDriver driver) {
	  Alert alert=driver.switchTo().alert();
	  return alert;
   }
}
 