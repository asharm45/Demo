package com.main.test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.ReadExcelSheetsData;


public class CommonMethodsClass extends ReadExcelSheetsData{
	
	public WebElement getElementDynimacly(WebDriver driver,int timeOut, By by){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	public List<WebElement> getElementsDynimacly(WebDriver driver,int timeOut, By by){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}
	
		
	protected final void navigate_to(WebDriver driver,String url){
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	protected final void switchtodefaultcontent(WebDriver driver){
		driver.switchTo().defaultContent();
	}
	protected final void click_Element(WebDriver driver,String locatorType, String locatorValue){
		switch(locatorType){
		case "id":
			By getValueById = By.id(locatorValue);
			WebElement valueById = getElementDynimacly(driver, 20, getValueById);
			valueById.click();
			break;
		case "xpath":
			By getValueByXpath = By.xpath(locatorValue);
			WebElement valueByXpath = getElementDynimacly(driver, 20, getValueByXpath);
			valueByXpath.click();
			break;
		case "linkText":
			By getValueByLinkText = By.linkText(locatorValue);
			WebElement valueByLinkText = getElementDynimacly(driver, 20, getValueByLinkText);
			valueByLinkText.click();
			break;
		}
	}
	protected final void send_Keys(WebDriver driver,String locatorType, String locatorValue, String param){
		switch(locatorType){
		case "id":
			By getValueById = By.id(locatorValue);
			WebElement valueById = getElementDynimacly(driver, 20, getValueById);
			valueById.sendKeys(param);
			break;
		case "xpath":
			By getValueByXpath = By.xpath(locatorValue);
			WebElement valueByXpath = getElementDynimacly(driver, 20, getValueByXpath);
			valueByXpath.sendKeys(param);
			break;
		case "linkText":
			By getValueByLinkText = By.linkText(locatorValue);
			WebElement valueByLinkText = getElementDynimacly(driver, 20, getValueByLinkText);
			valueByLinkText.sendKeys(param);
			break;
		}
	}
	protected final void switchtoIframe(WebDriver driver,String locatorType, String locatorValue){
		switch(locatorType){
		case "id":
			By getframeById = By.id(locatorValue);
			driver.switchTo().frame(getElementDynimacly(driver,20,getframeById));
			break;
		case "xpath":
			By getframeByXpath = By.xpath(locatorValue);
			driver.switchTo().frame(getElementDynimacly(driver,20,getframeByXpath));
			break;
		case "linkText":
			By getframeByLinkText = By.linkText(locatorValue);
			driver.switchTo().frame(getElementDynimacly(driver,20,getframeByLinkText));
			break;
		}
	}

}
