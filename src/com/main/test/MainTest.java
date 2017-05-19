package com.main.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class MainTest {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.chrome.driver","D:/Softwares/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	@AfterTest
	public void shutDown(){
		driver.quit();
	}

}
