package org.stepDefinations;

import java.util.Properties;

import org.applicationHooks.AppHooks;
import org.openqa.selenium.WebDriver;
import org.pages.productSearchPage;
import org.testng.Assert;
import org.utilities.BaseUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ProductPurchase {
	WebDriver driver;
	Properties prop;
	BaseUtility bu;
	productSearchPage ps;
	
	@Given("the user is on the Amazon home page")
	public void the_user_is_on_the_amazon_home_page() {
		driver = AppHooks.driver;
		prop = AppHooks.prop;
		bu = AppHooks.bu;
	}

	@When("the user searches for {string}")
	public void the_user_searches_for(String string) {
		ps = new productSearchPage(driver);
		ps.searchProduct(string);
		bu.waitForVisibiltyOfElementLocated(driver, 5, "cssSelector", ".a-size-medium.a-color-base.a-text-normal");
	}

	@Then("a list of search results is displayed")
	public void a_list_of_search_results_is_displayed() {
		ps = new productSearchPage(driver);
		Assert.assertTrue(ps.productList(), "Product list is not displayed");
	}

	@When("the user selects product from the list")
	public void the_user_selects_product_from_the_list() {
		ps = new productSearchPage(driver);
		Assert.assertTrue(ps.selectProduct(), "Wrong Product Number");
	}

	@Then("the user is on the product details page")
	public void the_user_is_on_the_product_details_page() {
		ps = new productSearchPage(driver);
		Assert.assertTrue(ps.userIsOnProdDetailPage(), "Product Detail Page is Not Displayed");
	}

	@When("the user retrieves the price of the iPhone and stores it in a variable")
	public void the_user_retrieves_the_price_of_the_i_phone_and_stores_it_in_a_variable() {
		ps = new productSearchPage(driver);
		System.out.println("\"Price of the Product\": "+ps.retrieveProductPrice());
	}

	@When("the user adds the iPhone to the cart")
	public void the_user_adds_the_i_phone_to_the_cart() {
		ps = new productSearchPage(driver);
		ps.addProdToCart();
	}

	@Then("the iPhone should be added to the cart successfully")
	public void the_i_phone_should_be_added_to_the_cart_successfully() {
		ps = new productSearchPage(driver);
		Assert.assertTrue(ps.productAtCartIsDisplayed(), "\"Product is not added to Cart\"");
	}
}
