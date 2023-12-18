package org.stepDefinations;

import java.util.Properties;

import org.applicationHooks.AppHooks;
import org.openqa.selenium.WebDriver;
import org.pages.ValidateFilterListPage;
import org.pages.productSearchPage;
import org.testng.Assert;
import org.utilities.BaseUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidateFilterList {
	WebDriver driver;
	Properties prop;
	BaseUtility bu;
	productSearchPage ps;
	ValidateFilterListPage filterpage;

	@Given("the user is on the Amazon homepage")
	public void the_user_is_on_the_amazon_homepage() {
		driver = AppHooks.driver;
		prop = AppHooks.prop;
		bu = AppHooks.bu;
	}

	@When("the user searches for phone as {string}")
	public void the_user_searches_for_phone_as(String string) {
		filterpage = new ValidateFilterListPage(driver);
		filterpage.searchProduct(string);
	}

	@Then("product list of search results is displayed")
	public void product_list_of_search_results_is_displayed() {
		filterpage = new ValidateFilterListPage(driver);
		Assert.assertTrue(filterpage.productList(), "Product list is not displayed");
	}

	@When("the user applies filters for brand, operating system, etc.")
	public void the_user_applies_filters_for_brand_operating_system_etc() {
		filterpage = new ValidateFilterListPage(driver);
		filterpage.clickOnProdBrandFilter();
		filterpage.clickOnProdPriceFilter();
		filterpage.clickOnCellPhoneBrandsFilter();
		filterpage.clickOnMemoryStorageCapFilter();
		filterpage.clickOnDiscountFilter();
	}

	@Then("the filtered product list is displayed")
	public void the_filtered_product_list_is_displayed() {
		filterpage = new ValidateFilterListPage(driver);
		Assert.assertTrue(filterpage.filteredProductListIsDisplayed(), "Filtered Product List is Not Displayed");
	}
}
