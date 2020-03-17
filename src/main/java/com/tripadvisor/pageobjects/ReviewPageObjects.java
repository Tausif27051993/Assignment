package com.tripadvisor.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ReviewPageObjects {
	
	
	@FindBy(how=How.XPATH, using = "//div[@class='easyClear bigRatingParent']//following-sibling::span[@id='bubble_rating']")
	public WebElement firstReviewGifButton;
	
	@FindBy(how=How.XPATH, using = "//div[@id='DQ_RATINGS']//div[@class='ratingBubbleTable']//div[@class='dq_allTravelers questionRow stripedRow'][1]//div[1]")
	public WebElement secondReviewGifButton;
	
	@FindBy(how=How.XPATH, using = "//div[@id='DQ_RATINGS']//div[@class='ratingBubbleTable']//div[@class='dq_allTravelers questionRow '][1]//div[1]")
	public  WebElement thirdReviewGifButton;

	@FindBy(how=How.XPATH, using ="//div[@id='DQ_RATINGS']//div[@class='ratingBubbleTable']//div[@class='dq_allTravelers questionRow stripedRow'][2]//div[1]")
	public  WebElement fourthReviewGifButton;

	@FindBy(how=How.XPATH, using ="//input[@id='ReviewTitle']")
	public  WebElement reviewTitleTextBox;
	
	@FindBy(how=How.XPATH, using ="//textarea[@id='ReviewText']")
	public  WebElement reviewTextArea;

	@FindBy(how=How.CSS, using ="#noFraud")
	public  WebElement checkBox;
	
	@FindBy(how=How.XPATH, using ="//div[@class='easyClear bigRatingParent']//following-sibling::span[@id='bubble_rating']")
	public  WebElement firstGifButton;
	
	
}
