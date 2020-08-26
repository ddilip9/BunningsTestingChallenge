package com.ui.bunnings.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bunnings.uiframework.BasePage;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {	super(driver);
	}
	
	@FindBy(xpath = "//input[contains(@class, 'search-container_term header_bottom')]")
	public static WebElement searchText;
	
	@FindBy(xpath = "//input[contains(@placeholder, 'Search our products, services & D.I.Y. Advice')]")
	public static WebElement placeHolderText;
	
	@FindBy(xpath = "//button[contains(@class, 'search-container_btn-submit')]")
	public static WebElement searchButton;


}
