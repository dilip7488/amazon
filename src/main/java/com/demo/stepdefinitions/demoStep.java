package com.demo.stepdefinitions;



import org.junit.Assert;
import org.openqa.selenium.By;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class demoStep extends StepDefinitionInit {

	    
	 @When("^I click on LogIn$")
	    public void i_click_on_login() throws Throwable {
	       demopage.clickonLogin();
	    }
	 @When("^I enter email address$")
	    public void i_enter_email_address() throws Throwable {
	        demopage.enteremailId();
	    }
	  @When("^I enter Password$")
	    public void i_enter_password() throws Throwable {
	       demopage.enterPassword();
	    }
	  @Then("^I click on Login button$")
	    public void i_click_on_login_button() throws Throwable {
	        demopage.clickonLoginButton();
	    }

	    
	    


	//@Given("^The Home page is visible$")
	//public void the_Home_page_is_visible() throws Throwable {

		//demopage.isHomePageVisible();

	//}

	@Then("^Verify the url is as expected$")
    public void verify_the_url_is_as_expected() throws Throwable {
		Assert.assertTrue(demopage.isUrlCorrect());

	}

	@When("^Select any category from the header$")
    public void select_any_category_from_the_header() throws Throwable {
		//Thread.sleep(30000);
		demopage.selectCategory();

	}

	@When("^Select any brand from brand filter$")
	public void select_any_brand_from_brand_filter() throws Throwable {
		demopage.selectBrand();
	}

	@Then("^Verify the options are displayed according the the filter$")
	public void verify_the_options_are_displayed_according_the_the_filter() throws Throwable {

		Assert.assertTrue(demopage.areOptionsAccordingToFilterSet());
	}
	
	@Then("^I check for accessibility$")
    public void i_check_for_accessibility() throws Throwable {
		//demopage.testAccessibility();
    }
	
	@When("^Select the first item from the list$")
    public void select_the_first_item_from_the_list() throws Throwable {
       
		demopage.selectItem();
    }

    @When("^Click on Add to cart button$")
    public void click_on_add_to_cart_button() throws Throwable {
    	demopage.clickOnAddToCart();
    	
    }

    @When("^Click on Cart button$")
    public void click_on_cart_button() throws Throwable {
        
    }
    
    @When("^User login with the Username \"([^\"]*)\"$")
    public void user_login_with_the_username_something(String username) throws Throwable {
        
      demopage.loginWithDifferentUsername(username);  
    }
    
    @When("^User click on Admin View tab$")
    public void user_click_on_admin_view_tab() throws Throwable {
    	demopage.clickOnTab("adminViewtab");  
    }

    @When("^User click on Reader View tab$")
    public void user_click_on_reader_view_tab() throws Throwable {
    	demopage.clickOnTab("readerViewTab");  
    }

    @Then("^Verify user is able to access Admin View$")
    public void verify_user_is_able_to_access_admin_view() throws Throwable {
      
      Assert.assertTrue(demopage.isUserAbleToAccessAdminTab());  
    	
    }

    @Then("^Verify user is not able to access Admin View$")
    public void verify_user_is_not_able_to_access_admin_view() throws Throwable {
    	Assert.assertFalse(demopage.isUserAbleToAccessAdminTab());   
    }

    @And("^Verify user is not able to access Reader View$")
    public void verify_user_is_not_able_to_access_reader_view() throws Throwable {
       
    	Assert.assertFalse(demopage.isUserAbleToAccessReaderTab());  
    	
    }

    @And("^Verify user is able to access Reader View$")
    public void verify_user_is_able_to_access_reader_view() throws Throwable {
    	Assert.assertTrue(demopage.isUserAbleToAccessReaderTab());  
    }
	
    @And("^I verify the accessibility on the web page$")
    public void i_verify_the_accessibility_on_the_web_page() throws Throwable {
    	//demopage.testAccessibility();  
    }
    //starting from below line
    @When("^I select electronics from the category$")
    public void i_select_electronics_from_the_category() throws Throwable {
        demopage.selectElectronics();
    }
    @Then("^I validate the selection is displayed$")
    public void i_validate_the_selection_is_displayed() throws Throwable {
        demopage.isElementDisplayed();
    }

    @When("^I select Brand OnePlus$")
    public void i_select_brand_oneplus() throws Throwable {
        demopage.selectBrandOneplus();
    }

    @When("^I choose a product$")
    public void i_choose_a_product() throws Throwable {
        demopage.chooseProduct();
    }
    @Then("^I validate description of product is displayed$")
    public void i_validate_description_of_product_is_displayed() throws Throwable {
        demopage.descriptionDisplay();
    }

    @Then("^I store the description in properties file$")
    public void i_store_the_description_in_properties_file() throws Throwable {
        demopage.writeProperties();
    }
    @When("^I count all the product description and price$")
    public void i_count_all_the_product_description_and_price() throws Throwable {
        demopage.countProduct();
    }

    @Then("^I store all the product details into an excelfile product and price respectively$")
    public void i_store_all_the_product_details_into_an_excelfile_product_and_price_respectively() throws Throwable {
        demopage.writingExcelFile();
    }

    @When("^I opened in new tab$")
    public void i_opened_in_new_tab() throws Throwable {
        
        demopage.openingNewTab();
    }

    @Then("^I verify descriptionand price same as properties file$")
    public void i_verify_descriptionand_price_same_as_properties_file() throws Throwable {
        
        demopage.verifyingPropertyData();
    }

    @When("^I click on add to cart$")
    public void i_click_on_add_to_cart() throws Throwable {
        
        demopage.clickingAddCart();
    }

    @When("^I click on cart icon$")
    public void i_click_on_cart_icon() throws Throwable {
        
        demopage.selectCart();
    }

    @Then("^I verify right product is added in the cart$")
    public void i_verify_right_product_is_added_in_the_cart() throws Throwable {
        
        demopage.verifyRightProduct();
    }




    
}