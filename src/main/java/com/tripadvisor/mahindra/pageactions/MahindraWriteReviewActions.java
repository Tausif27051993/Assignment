package com.tripadvisor.mahindra.pageactions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;

import com.google.common.base.Function;
import com.tripadvisor.mahindra.utils.BrowserUtilties;
import com.tripadvisor.pageobjects.ReviewPageObjects;

public class MahindraWriteReviewActions extends ReviewPageObjects{
	static final Logger logger = Logger.getLogger(MahindraWriteReviewActions.class);
	BrowserUtilties browserUtility = new BrowserUtilties();

	//Load the url
	public void loadURL(String url, WebDriver driver)
			throws Exception {
		driver.get(url);
		browserUtility.idealwait();
	}

	//Prepare Xpaths for dynamic review buttons
	public List<WebElement> returnRequiredXpaths (WebDriver driver)
			throws Exception {

		List<WebElement> element=new ArrayList<WebElement>();
		try {
			logger.info("Return List of WebElements");
			Reporter
			.log("Return List of WebElements");

			//Add elements to a list
			element.add(driver.findElement(By.xpath("//label[@class='visuallyHidden' and contains(text(),'"+secondReviewGifButton.getText()+"'"+")]//following-sibling::span")));
			element.add(driver.findElement(By.xpath("//label[@class='visuallyHidden' and contains(text(),'"+thirdReviewGifButton.getText()+"'"+")]//following-sibling::span")));
			element.add(driver.findElement(By.xpath("//label[@class='visuallyHidden' and contains(text(),'"+fourthReviewGifButton.getText()+"'"+")]//following-sibling::span")));

		} catch (Exception e) {
		}
		return element;
	}

	//switch to new tab
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

	//javascript scroll
	public void javaScriptScroll(WebElement element, WebDriver driver)
			throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			logger.info("Connected to switch tab, to new tab");
			Reporter
			.log("Connected to switch tab to new tab");
			js.executeScript("arguments[0].scrollIntoView(true);",element);	
			browserUtility.idealwait();
		} catch (Exception e) {
			Reporter
			.log("Connected to switch tab, to new tab, Failed");
		}

	}

	//loop into elements 5 because it has 5 review onmousehover
	public void loopWebElements(WebElement element,int width,WebDriver driver)
	{
		int temp = width/5;
		int actualX = -72;
		for(int i=0;i<5;i++) {
			new Actions(driver).moveToElement(element,actualX,0).click().build().perform();
			fluentWait(element,driver);
			actualX=actualX+temp;
		}
	}

	//single mouusehover
	public void loopFirstElement(int width,WebDriver driver)
	{
		int temp = width/5;
		int actualX = -72;
		for(int i=0;i<5;i++) {
			new Actions(driver).moveToElement(firstReviewGifButton,actualX,0).click().build().perform();
			fluentWait(firstReviewGifButton,driver);
			actualX=actualX+temp;
		}
	}

	//return width of the element
	public int returnWidth() {
		return firstReviewGifButton.getSize().getWidth();

	}

	//add title
	public void addTitle(WebDriver driver,String value)
	{
		logger.info("Enter the values for textarea and textbox");
		Reporter
		.log("Enter the values for textarea and textbox");
		try {
			browserUtility.enterValueTextBox(reviewTitleTextBox,value,driver);
		} catch (Exception e) {
		}

	}

	//add review
	public void addReview(WebDriver driver,String value)
	{
		logger.info("Enter the values for textarea and textbox");
		Reporter
		.log("Enter the values for textarea and textbox");
		try {
			browserUtility.enterValueTextBox(reviewTextArea,value,driver);
		} catch (Exception e) {
		}

	}

	//scroll and click on checkbox
	public void clickCheckBox(WebDriver driver)
	{
		try {
			javaScriptScroll(checkBox,driver);
			browserUtility.clickElement(checkBox, driver);
		} catch (Exception e) {
		}
	}

	public WebElement fluentWait(final WebElement elem,WebDriver driver) {
		/*
		fluent wait impementation documentation:
		        http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/support/ui/FluentWait.html
		 */
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		WebElement foo = wait.until(
				new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return elem;
					}
				}
				);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		return foo;
	}
}
