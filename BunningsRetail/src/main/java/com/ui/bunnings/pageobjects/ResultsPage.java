package com.ui.bunnings.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bunnings.uiframework.BasePage;

public class ResultsPage extends BasePage {
	
	public ResultsPage(WebDriver driver) {	super(driver);
	}
	
	@FindBy(xpath = "//h1[contains(@class, 'responsive-search-title')]")
	public static WebElement searchResultTitle;
	
	@FindBy(xpath = "//span[contains(@class, 'responsive-search-title__search-term')]")
	public static WebElement searchResultText;
	
	
	@FindBy(xpath = "//*[@class='responsive-search-title__count']")
	public static WebElement resultCount;
	
	
	@FindBy(xpath = "//*[@class='responsive-search-title__search-term']")
	public static WebElement searchTerm;
	
	
	@FindBy(xpath = "//*[@id='main']/div[6]/div[1]/div/div[2]/div[2]/div/div/section/article")
	public static WebElement searchResult;
	
}
