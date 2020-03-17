package com.tripadvisor.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TripAdvisorHomePageObjects {

	@FindBy(how=How.XPATH, using = "//input[@title='Search']")
	public WebElement searchTextBox;
	
	@FindBy(how=How.XPATH, using = "//div[@data-test-attribute='typeahead-results']//a[1]")
	public WebElement firstSearchElement;
	
	@FindBy(how=How.XPATH, using = "//span[@class='ui_icon pencil-paper hotels-community-content-common-TabAboveHeader__icon--z0-Ex']")
	public WebElement writeReviewScroll;

	@FindBy(how=How.XPATH, using ="//a[@class='ui_button primary' and contains(text(),'Write a review')]")
	public WebElement writeReviewButton;
}
