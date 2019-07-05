package com.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	static String driverPath;
	
	public base (WebDriver driver) {
		this.driver=driver;
	}
	private WebDriver getDriver() {
		return driver;
	}
	private WebDriverWait getWait() {
		return wait;
	}
	private void setBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("Webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}else {
			System.out.println("Browser not found");
			
		}
	}
	private void setWebPage (String URL) {
		driver.get(URL);
	}
	private WebElement findElement (String locator) {
		return driver.findElement(By.xpath(locator));
			
	}
	private void clickElement (String locator) {
		findElement(locator).click();
	}
	private void sendKeys (String locator, String typeText) {
		findElement(locator).click();
		findElement(locator).sendKeys(typeText);
		
	}
}