package com.selenium.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.selenium.baseclass.baseclass;
import com.selenium.pom.Homepage;
import com.selenium.pom.Loginpage;

public class Testcase_Verifylogin_02 extends baseclass{
	  public static Homepage homepage;
      public static Loginpage loginpage;
	public Testcase_Verifylogin_02() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		intilization();
		homepage=new Homepage();
		loginpage=new Loginpage();
	}
	
	@Test
   public void verifyLogin() {
		Assert.assertEquals(true, homepage.verifyhomeLogo());
		homepage.login_page();
		Assert.assertEquals(true, loginpage.verify_userloginPage());
		loginpage.verifylogin_P();
		Assert.assertEquals(true, homepage.veriflogoutbutton());
		homepage.logout();
		Assert.assertEquals(true, loginpage.verify_userloginPage());
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
