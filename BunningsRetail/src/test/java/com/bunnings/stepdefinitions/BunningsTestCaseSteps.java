package com.bunnings.stepdefinitions;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bunnings.uiframework.HybridDriver;
import com.ui.bunnings.pageobjects.HomePage;
import com.ui.bunnings.pageobjects.ResultsPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BunningsTestCaseSteps extends HybridDriver {

	@BeforeClass
	public void beforeClass() {

		try {
			driver = setDriver();
		} catch (Exception e) {
			System.out.println("Error....." + e.getMessage());
		}
	}

	@Given("^User will launch Landing page using Landing page URL \"([^\"]*)\"$")
	public void user_will_launch_Landing_page_using_Landing_page_URL(String url) throws Throwable {
		driver = setDriver();
		new HomePage(driver);
		new ResultsPage(driver);

		launchURL(url);
	}

	@And("^User enters \"([^\"]*)\" in the search form field$")
	public void user_enters_in_the_search_form_field(String ProductName) throws Throwable {
		enterValue(HomePage.searchText, ProductName);
	}

	@When("^User clicks on search button and wait for search results$")
	public void user_clicks_on_search_button_and_wait_for_search_results() throws Throwable {
		clickElement(HomePage.searchButton);
	}

	@And("^User will Verify the \"([^\"]*)\" text in result page$")
	public void user_Verify_the_text_in_result_page(String ProductName) throws Throwable {

		// Printing the count of Products in Console for related search Item

		String count = getText(ResultsPage.resultCount);
		String searchTerm = getText(ResultsPage.searchResultText);
		System.out.println(count + " found for -> " + searchTerm);

	}

	@Then("^User will close the window$")
	public void user_will_close_the_window() throws Throwable {
		closeWindow();
	}

	@Then("^User will print all names of the products appeared in search results$")
	public void user_will_print_all_names_of_the_products_appeared_in_search_results() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		if (isVisible(ResultsPage.searchResult)) {

			waitForPageLoad("//*[@id='main']/div[6]/div[1]/div/div[2]/div[2]/div/div/section/article");
			List<WebElement> list = driver
					.findElements(By.xpath("//*[@id='main']/div[6]/div[1]/div/div[2]/div[2]/div/div/section/article"));
			String elementName = "";
			System.out.println("----------- List of Elements for the search Results  ------");

			for (int i = 1; i < list.size()-1; i++) {
				elementName = driver.findElement(
						By.xpath("//*[@id=\"main\"]/div[6]/div[1]/div/div[2]/div[2]/div/div/section/article[" + i
								+ "]/a/div/div[2]/div[2]/p/span/span[1]"))
						.getText();
				System.out.println(elementName);
			}

		} else {
			System.out.println("No search Results for the enter product in search bar");
		}

	}

}