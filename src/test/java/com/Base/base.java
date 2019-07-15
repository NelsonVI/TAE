package com.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {
	
	private WebDriver driver;
	private WebDriverWait wait;

	
	public base (WebDriver driver) {
		this.driver=driver;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebDriverWait getWait() {
		return new WebDriverWait (driver,5);
	}
	
	public void setBrowser(String browser, String driverPath) {
		//Due a just gonna be used one browser i create a "IF" condition. Must change in case to use several browsers.
		//The chrome driver is include onto one folder of the proyect. 
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("Webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		}else {
			System.out.println("Browser not found");
			
		}
	}
	public void setWebPage (String URL) {
		driver.get(URL);
	}
	public WebElement findElement (String locator) {
		return driver.findElement(By.xpath(locator));
	}
	public List<WebElement> findWebElements (String locator){
		return driver.findElements(By.xpath(locator));
	}
	public void elementPresent(String locator) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}
	public void clickElement (String locator) {
		findElement(locator).click();
	}
	public void sendKeys (String locator, String typeText) {
		findElement(locator).click();
		findElement(locator).clear();
		findElement(locator).sendKeys(typeText);
	}
	public void switchToIframe (String locator) {
		driver.switchTo().frame(locator);
	}
	public void switchToParentFrame (String locator) {
		driver.switchTo().parentFrame();
		
	}
	public Select SelectFromDP (String locator) {
		return new Select(driver.findElement(By.xpath(locator)));
		
	}
	
	


}