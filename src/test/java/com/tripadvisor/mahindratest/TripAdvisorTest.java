package com.tripadvisor.mahindratest;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tripadvisor.mahindra.helper.BrowserInstantiator;
import com.tripadvisor.mahindra.pageactions.MahindraSearchActions;
import com.tripadvisor.mahindra.pageactions.MahindraWriteReviewActions;
import com.tripadvisor.mahindra.utils.BrowserUtilties;


public class TripAdvisorTest {

	public static WebDriver driver = null;
	static final Logger logger = Logger.getLogger(TripAdvisorTest.class);
	String amazonPrice = null;
	String flipkartPrice = null;
	String amazonFinalPrice = null;
	String flipkartFinalPrice = null;

	//Data provider for mahindra
	@DataProvider(name = "TestDataMahindra")
	public Object[][] amazonProviderMethod() {
		return new Object[][] { { "Club Mahindra","Some Title" ,"No Comments because the place is awesome","https://www.tripadvisor.in/"}};
	}

	@BeforeMethod(groups = { "MahindraTest" })
	public void DriverInstantiation() throws Exception {
		driver = BrowserInstantiator.returnWebDriver();
	}

	@Test(dataProvider = "TestDataMahindra", groups = { "MahindraTest" })
	public void runAmazonTest(String keywords,String title,String comments,String url) throws Throwable {
		MahindraSearchActions mahindraSearchActions = PageFactory
				.initElements(driver, MahindraSearchActions.class);

		MahindraWriteReviewActions mahindraWriteReviewActions = PageFactory
				.initElements(driver, MahindraWriteReviewActions.class);

		BrowserUtilties browserUtilties = PageFactory
				.initElements(driver, BrowserUtilties.class);

		//Load URl
		mahindraSearchActions.loadURL(url, driver);
		//Search and enter in search bar
		mahindraSearchActions.searchForTitleAndEnterText(keywords, driver);
		//Scroll to write review text
		mahindraSearchActions.javaScriptScroll(driver);
		//Wait for sometime
		browserUtilties.idealwait();
		//click on write a review buttton
		mahindraSearchActions.clickButton(driver);
		//Wait for sometime
		browserUtilties.idealwait();
		//switch to new tab
		mahindraSearchActions.switchTab(driver);

		//width of the entire gif image for reviews
		int logoW = mahindraWriteReviewActions.returnWidth(); 

		//Enter first review
		mahindraWriteReviewActions.loopFirstElement(logoW, driver);

		//Enter title
		mahindraWriteReviewActions.addTitle(driver,title);
		//Enter Review
		mahindraWriteReviewActions.addReview(driver,comments+comments+comments);

		//Other 3 dynamic review star ratings
		List<WebElement> list = mahindraWriteReviewActions.returnRequiredXpaths(driver);
		Iterator<WebElement> it = list.iterator();

		//Loop and hover
		while(it.hasNext())
		{
			mahindraWriteReviewActions.loopWebElements(it.next(),logoW, driver);
		}

		//click on checkbox
		mahindraWriteReviewActions.clickCheckBox(driver);

		//Wait for sometime
		browserUtilties.idealwait();
	}

	@AfterTest
	public void cleanUp()
	{
		driver.switchTo().defaultContent();
		driver.close();
		driver.quit();
	}
}
