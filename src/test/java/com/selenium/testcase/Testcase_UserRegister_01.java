package com.selenium.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.baseclass.baseclass;
import com.selenium.pom.Accountcreatedpage;
import com.selenium.pom.Acoountdeletedpage;
import com.selenium.pom.Homepage;
import com.selenium.pom.Loginpage;
import com.selenium.pom.Newuserregisterpage;

public class Testcase_UserRegister_01 extends baseclass {
	       static Homepage homepage;
	       static Loginpage loginpage;
	       static Newuserregisterpage newuserregisterpage;
	       static Accountcreatedpage accountcreatedpage;
	       static Acoountdeletedpage acoountdeletedpage;
	public Testcase_UserRegister_01() {
		super();	
	}
	@BeforeMethod
	public void setUp() {
		intilization();
		homepage=new Homepage();
		loginpage=new Loginpage();
		newuserregisterpage=new Newuserregisterpage();
		accountcreatedpage=new Accountcreatedpage();
		acoountdeletedpage=new Acoountdeletedpage();
	}
	
	@Test
	public void verifyRegister() {	
		Assert.assertEquals(true, homepage.verifyhomeLogo());
		homepage.login_page();
		Assert.assertEquals(true, loginpage.verify_newuserPage());
		loginpage.addNewuser();
		Assert.assertEquals(newuserregisterpage.verifyuser_page(),"ENTER ACCOUNT INFORMATION");
		newuserregisterpage.adduser_details();
		Assert.assertEquals(accountcreatedpage.accoutDone(),"ACCOUNT CREATED!");	
		accountcreatedpage.createdContinue();
		Assert.assertEquals(homepage.verifyUser(),"surya");
		homepage.accountdelete();
		Assert.assertEquals(acoountdeletedpage.verifyAC_delete(),"ACCOUNT DELETED!");
		acoountdeletedpage.deleteContinue();
		Assert.assertEquals(true, homepage.verifyhomeLogo());
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
