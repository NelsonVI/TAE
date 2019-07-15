package com.Tests;
import org.testng.annotations.Test;

import com.Base.base;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class ExamTests extends base {
	
public ExamTests(WebDriver driver) {
		super(driver);
	}


@BeforeTest

   public void beforeTest() {
	getDriver();
	setBrowser(null,null);

	
	  
}
@Test
  public void f() {
	  
	  
	  
  }
  

  @AfterTest
  public void afterTest() {
  }

}
