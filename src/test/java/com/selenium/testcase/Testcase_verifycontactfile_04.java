package com.selenium.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.baseclass.baseclass;
import com.selenium.pom.Contactpage;
import com.selenium.pom.Homepage;

public class Testcase_verifycontactfile_04 extends baseclass {
	public static Homepage homepage;
	public static Contactpage contactpage;

	public Testcase_verifycontactfile_04() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intilization();
		homepage = new Homepage();
		contactpage = new Contactpage();
	}

	@Test
	public void verify_contact() {
		Assert.assertEquals(true, homepage.verifyhomeLogo());
		homepage.contact();
		Assert.assertEquals(contactpage.verify_contactpage(), "GET IN TOUCH");
		contactpage.uploadfile();
		contactpage.homereturn();
		Assert.assertEquals(true, homepage.verifyhomeLogo());	
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
