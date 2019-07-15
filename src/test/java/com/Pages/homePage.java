package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.Base.base;

public class homePage extends base {
	
	private String flightHeader = "//a[@id=\"primary-header-flight\"]";
	private String hotelsHeader = "//a[@id='primary-header-hotel']";
	private String cruisesHeader = "//*[@id=\"primary-header-cruise\"]";
	private String roundTripOption = "//*[@id=\"flight-type-roundtrip-label-flp\"]";
	private String flightOnlyTab = "//*[@id=\"tab-flight-tab-flp\"]";
	private String flyingFromTextHolder = "//*[@id=\"flight-origin-flp\"]";
	private String flyingToTextHolder = "//*[@id=\"flight-destination-flp\"]";
	private String listOfCities = "//*[@id=\"typeaheadDataPlain\"]";
	private String datePickerDeparting = "//*[@id=\"flight-departing-flp\"]";
	private String datePickerReturning = "//*[@id=\"flight-returning-flp\"]";
	private String nextMonthButton = "//*[@id=\"flight-departing-wrapper-flp\"]/div/div/button[2]";
	private String calendarDeparting = "//*[@id=\"flight-departing-wrapper-flp\"]/div/div/div[2]/table/tbody";
	private String calendarReturning = "//*[@id=\"flight-departing-wrapper-flp\"]/div/div/div[3]/table/tbody";
	private String adultsDP = "//*[@id=\"flight-adults-flp\"]";
	private String searchButton = "//*[@id=\"gcw-flights-form-flp\"]/div[9]/label/button";
	
	public homePage (WebDriver driver) {
		super(driver);
	}
	
	public void exerciseOne_stepOne(String departureCity, String arrivalCity, int dateDeparting, int dateReturning, int adultsnumber) {
		elementPresent(flightHeader);
		clickElement(flightHeader);
		elementPresent(flightOnlyTab);
		elementPresent(roundTripOption);
		sendKeys(flyingFromTextHolder, departureCity);
		for (WebElement city : findWebElements(listOfCities)) {
			if (city.getText().contentEquals(departureCity)){
				city.click();
				break;
			}
		}
		sendKeys(flyingToTextHolder, arrivalCity);
		for (WebElement city : findWebElements(listOfCities)) {
			if (city.getText().contentEquals(arrivalCity)){
				city.click();
				break;
			}
		}
		int monthFuture = 0;
		do {
			clickElement(nextMonthButton);
			monthFuture++;
		}while (monthFuture<2);
		
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(calendarDeparting)));
		for (int i=0; i<findWebElements(calendarDeparting).size();i++) {
			findWebElements(calendarDeparting).get(dateDeparting).click();
		}
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(calendarReturning)));
		for (int i=0; i<findWebElements(calendarReturning).size();i++) {
			findWebElements(calendarReturning).get(dateReturning).click();
		}
		SelectFromDP(adultsDP).selectByIndex(adultsnumber);
		elementPresent(searchButton);
		clickElement(searchButton);	
	}


	
}
