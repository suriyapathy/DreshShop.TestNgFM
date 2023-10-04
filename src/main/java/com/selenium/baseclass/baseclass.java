package com.selenium.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class baseclass {
	public static Properties prop;
	public static WebDriver driver;


	public baseclass() {
		try {

			FileInputStream file = new FileInputStream(
					"C:\\Users\\DELL\\eclipse-workspace\\Com.Selenium." + "Framework\\config\\configure.properties");
		    prop = new Properties();
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void intilization() {
		String browser = prop.getProperty("browser");
		//WebDriverManager.chromedriver().setup();
		//ChromeOptions option=new ChromeOptions();
		//option.addArguments("--remote-allow-origins=*");
		//option.addArguments("--headless=new");
		//option.addArguments("--disable notifications");
		//DesiredCapabilities dc= new DesiredCapabilities();
		//dc.setCapability(ChromeOptions.CAPABILITY, option);
		//option.merge(dc);
		if (browser.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("fireboxdriver")) {
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}
	public String getScreenshot(String testCaseName,WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File des= new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		try {
			FileUtils.copyFile(source, des);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}


}
