package com.selenium.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.baseclass.baseclass;
import com.selenium.pom.Homepage;
import com.selenium.pom.Productdetailspage;
import com.selenium.pom.Productspage;

public class Testcase_verifysingleproduct_05 extends baseclass {
	public static Homepage homepage;
	public static Productspage productspage;
	public static Productdetailspage productdetailspage;
	public Testcase_verifysingleproduct_05() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		intilization();
		homepage=new Homepage();
		productspage=new Productspage();
		productdetailspage=new Productdetailspage();
	}
	@Test
	public void verifyproducts() {
		Assert.assertEquals(true, homepage.verifyhomeLogo());
		homepage.goProductPage();
		Assert.assertEquals(productspage.verifyproductpage(),"ALL PRODUCTS");
		productspage.viewproduct();
		Assert.assertEquals(productdetailspage.veritfy_detailspagetitle(),"Automation Exercise - Product Details");
		Assert.assertEquals(productdetailspage.verify_productdetails(), true);			
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
