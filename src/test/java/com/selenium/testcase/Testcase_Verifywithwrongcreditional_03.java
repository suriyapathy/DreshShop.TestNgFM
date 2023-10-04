package com.selenium.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.baseclass.baseclass;
import com.selenium.pom.Homepage;
import com.selenium.pom.Loginpage;

public class Testcase_Verifywithwrongcreditional_03 extends baseclass{
             public static Homepage homepage;
             public static Loginpage loginpage;
	public Testcase_Verifywithwrongcreditional_03() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		intilization();
		homepage=new Homepage();
		loginpage=new Loginpage();
	}
	@Test
	public void verify_loginNegative() {
		System.out.println("IM learning");
		Assert.assertEquals(true, homepage.verifyhomeLogo());
		homepage.login_page();
		Assert.assertEquals(true, loginpage.verify_userloginPage());
		loginpage.verifylogin_N();
		Assert.assertEquals(loginpage.verify_loginincorrectmsg(),"Your email or password is incorrect!");
	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();;
	}

}

