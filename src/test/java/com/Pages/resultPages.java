package com.Pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.Base.base;

public class resultPages extends base {

	private String sortByDP = "//*[@id=\"sortDropdown\"]";
	private String resultOfTheSearching = "//div[@class='grid-container standard-padding']";
	private String selectButttonOntheResults = "//div[@class='uitk-col standard-col-l-margin all-col-shrink display-larger-screens-only']";
	private String durationTime = "//span[@class='duration-emphasis']";
	private String detailsAndBaggageFees = "//div[@class='details-container standard-t-margin secondary-content link-style display-larger-screens-only']";
	
	
	public resultPages(WebDriver driver) {
		super(driver);
	}
	public void execiseOne_stepTwo() {//Verifications
		
		//a.There is a box that allow you to order by Price, Departure, Arrival and Duration.
		String [] DPSortByExpOptions = {"Price (Lowest)","Price (Highest)","Duration (Shortest)","Duration (Longest)","Departure (Earliest)","Departure (Latest)","Arrival (Earliest)","Arrival (Latest)"};
		//Try to avoid this hard code part 
		elementPresent(sortByDP);
		Select DPSortBy = SelectFromDP(sortByDP);
		List <WebElement> listOptionSortBySelect = DPSortBy.getOptions();	
		for (int i=0;i<listOptionSortBySelect.size();i++) {
			Assert.assertEquals(listOptionSortBySelect.get(i).getText(), DPSortByExpOptions[i]);
		}
		//b. The select button is present on every result	
		getWait().until(ExpectedConditions.visibilityOfAllElements(findWebElements(resultOfTheSearching)));
		Assert.assertEquals(findWebElements(resultOfTheSearching).size(), findWebElements(selectButttonOntheResults).size());
		//I create two list with a total of offers and the total of select button must appear per offer.
		
		//c. Flight duration is present on every result
		getWait().until(ExpectedConditions.visibilityOfAllElements(findWebElements(resultOfTheSearching)));
		Assert.assertEquals(findWebElements(resultOfTheSearching).size(), findWebElements(durationTime).size());
		//Doing the same as b. 
		
		//d. The flight detail and baggage fees is present on every result
		getWait().until(ExpectedConditions.visibilityOfAllElements(findWebElements(resultOfTheSearching)));
		Assert.assertEquals(findWebElements(resultOfTheSearching).size(), findWebElements(detailsAndBaggageFees).size());
		//Doing the same as b and c. 
		
	}


	public void execiseOne_stepThree(String sortByChoose) {
		
		SelectFromDP(sortByDP).selectByVisibleText(sortByChoose);
		
	}
}