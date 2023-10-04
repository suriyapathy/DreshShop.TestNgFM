package com.selenium.testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.baseclass.baseclass;
import com.selenium.pom.Homepage;
import com.selenium.pom.Productspage;

public class Testcase_Verifyfullcode extends baseclass {
	public static Homepage homepage;
	public static Productspage productspage;

	public Testcase_Verifyfullcode() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intilization();
		homepage = new Homepage();
		productspage = new Productspage();

	}

	@Test
	public void endEndTest() {
		Assert.assertEquals(true, homepage.verifyhomeLogo());
		homepage.goProductPage();
		List<WebElement> products = driver.findElements(By.cssSelector(".product-image-wrapper"));
		for (WebElement product : products) {
			Actions action=new Actions(driver);
			action.moveToElement(product);
			if (product.findElement(By.xpath("//div[@class='product-image-wrapper']//div[2]//p")).getText()
					.contains("Green Side Placket Detail T-Shirt")) {
				product.findElement(By.xpath(
						"//div[@class='product-image-wrapper']//div[2]//a[@class='btn btn-default add-to-cart']"))
						.click();
			}
		}
	}
}
