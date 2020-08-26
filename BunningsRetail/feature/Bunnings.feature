@bunnings
Feature: Test case to verify bunnings search functionality


@searchAndResultsFeature
Scenario Outline: This scenario is used to test search and results feature
# Landing page
	Given User will launch Landing page using Landing page URL "<LandingURL>"
	And User enters "<ProductName>" in the search form field
	When User clicks on search button and wait for search results
	And User will Verify the "<ProductName>" text in result page
	Then User will print all names of the products appeared in search results 
	Then User will close the window

Examples:
	|LandingURL			        	  	|ProductName| 
	|https://www.bunnings.com.au/ |oil heater | 
	|https://www.bunnings.com.au/ |paint      |
	|https://www.bunnings.com.au/ |cement     |
	|https://www.bunnings.com.au/ |11111111111|
	|https://www.bunnings.com.au/ |#$%^&*(*&^ |