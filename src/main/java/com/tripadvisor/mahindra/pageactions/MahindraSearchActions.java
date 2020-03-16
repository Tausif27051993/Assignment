package com.tripadvisor.mahindra.pageactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.tripadvisor.mahindra.utils.BrowserUtilties;
import com.tripadvisor.pageobjects.TripAdvisorHomePageObjects;


public class MahindraSearchActions extends TripAdvisorHomePageObjects {

	static final Logger logger = Logger.getLogger(MahindraSearchActions.class);
	BrowserUtilties browserUtility = new BrowserUtilties();

	
	public void loadURL(String url, WebDriver driver)
			throws Exception {
		driver.get(url);
		browserUtility.idealwait();
	}
	/**
	 * @author tausif.sayed.basha
	 * @param title
	 * @param driver
	 * @throws Exception
	 * Description: search for an item provided
	 */
	
	public void searchForTitleAndEnterText(String title, WebDriver driver)
			throws Exception {

		try {
			logger.info("Checking for the Search Bar of TripAdvisor Home Page");
			Reporter
			.log("Checking for the Search Bar of TripAdvisor Home Page");

			//Wait for search bar to load
			browserUtility.waitForPageToLoad(searchTextBox, driver);

			//Enter the value
			browserUtility.enterValueTextBox(searchTextBox,title,driver);

			//Wait for search bar to load
			browserUtility.idealwait();
			
			//Click on search icon
			browserUtility.clickElement(firstSearchElement,driver);

			logger.info("Clicked on search icon with required text");
			Reporter
			.log("Clicked on search icon with required text");

		} catch (Exception e) {
		}

	}
	
	public void switchTab(WebDriver driver)
			throws Exception {

		try {
			logger.info("Connected to switch tab, to new tab");
			Reporter
			.log("Connected to switch tab to new tab");
			for (String winHandle : driver.getWindowHandles()) { //Gets the new window handle
				driver.switchTo().window(winHandle);        // switch focus of WebDriver to the next found window handle (that's your newly opened window)              
			}
			
		} catch (Exception e) {
			Reporter
			.log("Connected to switch tab, to new tab, Failed");
		}

	}
	
	public void javaScriptScroll(WebDriver driver)
			throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			logger.info("Connected to switch tab, to new tab");
			Reporter
			.log("Connected to switch tab to new tab");
			js.executeScript("arguments[0].scrollIntoView();",writeReviewScroll);	
			browserUtility.idealwait();
		} catch (Exception e) {
			Reporter
			.log("Connected to switch tab, to new tab, Failed");
		}

	}

	public void javaScriptScroll(WebElement elem,WebDriver driver)
			throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			logger.info("Connected to switch tab, to new tab");
			Reporter
			.log("Connected to switch tab to new tab");
			js.executeScript("arguments[0].scrollIntoView();",elem);	
			browserUtility.idealwait();
		} catch (Exception e) {
			Reporter
			.log("Connected to switch tab, to new tab, Failed");
		}

	}
	public int returnWidth(WebElement element) {
		return element.getSize().getWidth();
		
	}

	//scroll and click on write review button
	public void clickButton(WebDriver driver)
	{
		try {
			javaScriptScroll(writeReviewButton,driver);
			browserUtility.clickElement(writeReviewButton, driver);
		} catch (Exception e) {
		}
	}
	
}
