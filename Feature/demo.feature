Feature: Verify the Login feature of Naukri.com

@demo
Scenario: Verify the login button of Naukri.com
	When I click on LogIn
	When I enter email address
	When I enter Password
	Then I click on Login button
	

@demo1
Scenario: Verify the brand filter
	When User login with the Username "Administrator"
	When User click on Admin View tab
	Then Verify user is able to access Admin View
	When User click on Reader View tab
	And Verify user is not able to access Reader View
	

@demo2
Scenario: Verify the brand filter
	When User login with the Username "nimit"
	When User click on Admin View tab
	Then Verify user is not able to access Admin View
	When User click on Reader View tab
	And Verify user is able to access Reader View
	
@demo3
Scenario: Verify the brand filter
	When User login with the Username "Cobus"
	When User click on Admin View tab
	Then Verify user is not able to access Admin View
	When User click on Reader View tab
	And Verify user is not able to access Reader View
	@demo4
	Scenario: Verify add to cart amazon
	  When I select electronics from the category
	  Then I validate the selection is displayed
	  When I select Brand OnePlus
	  When I choose a product
	  Then I validate description of product is displayed
	  Then I store the description in properties file 
	  When I count all the product description and price
	  Then I store all the product details into an excelfile product and price respectively
	  When I opened in new tab
	  Then I verify descriptionand price same as properties file
	  When I click on add to cart
	  When I click on cart icon
	  Then I verify right product is added in the cart 