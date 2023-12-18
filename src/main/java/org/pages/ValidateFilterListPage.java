package org.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseUtility;

public class ValidateFilterListPage {
	private WebDriver driver;
	BaseUtility bu = new BaseUtility();
	@FindBy(css="#twotabsearchtextbox")
	private WebElement searchBox;
	
	@FindBy(css=".a-size-medium.a-color-base.a-text-normal")
	private List <WebElement> productList;
	
	@FindBy(xpath="//*[@id='p_89/Samsung']/span/a/span")
	private WebElement prodBrandFilter;
	
	@FindBy(xpath="//div[@id='priceRefinements']/ul[1]/span[3]")
	private WebElement prodPriceFilter;
	
	@FindBy(xpath="//div[@id='filters']/ul[1]/span/li")
	private WebElement cellPhoneBrandsFilter;
	
	@FindBy(xpath="//*[@id=\"filters\"]/ul[3]/span")
	private WebElement memoryStorageCapFilter;
	
	@FindBy(xpath="//*[@id='p_n_pct-off-with-tax/2665399031']/span/a/span")
	private WebElement discountFilter;
	
	@FindBy(css=".a-size-base-plus.a-color-base.a-text-normal")
	private List <WebElement> filteredProductList;
	
	
	public ValidateFilterListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchProduct(String productName) {
		searchBox.click();
		searchBox.sendKeys(productName);
		searchBox.sendKeys(Keys.ENTER);
	}
	
	public boolean productList() {
		if(productList.size()>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void clickOnProdBrandFilter() {
		bu.waitForVisibiltyOfElementLocated(driver, 10, "xpath", "//*[@id='p_89/Samsung']/span/a/span");
		bu.scrollByByJS(driver, prodBrandFilter);
		bu.clickByJS(driver, prodBrandFilter);
//		prodBrandFilter.click();
	}
	
	public void clickOnProdPriceFilter() {
		bu.scrollByByJS(driver, prodPriceFilter);
		bu.waitForVisibilityOfEle(driver, 10, prodPriceFilter);
		prodPriceFilter.click();
	}
	
	public void clickOnCellPhoneBrandsFilter() {
		bu.scrollByByJS(driver, cellPhoneBrandsFilter);
		bu.waitForVisibilityOfEle(driver, 10, cellPhoneBrandsFilter);
		cellPhoneBrandsFilter.click();
	}
	
	public void clickOnMemoryStorageCapFilter() {
		bu.waitForVisibilityOfEle(driver, 10, memoryStorageCapFilter);
		memoryStorageCapFilter.click();
	}
	
	public void clickOnDiscountFilter() {
		bu.waitForVisibilityOfEle(driver, 10, discountFilter);
		discountFilter.click();
	}
	
	public boolean filteredProductListIsDisplayed() {
		if(filteredProductList.size()>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
}
