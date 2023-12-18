package org.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseUtility;

public class productSearchPage {
	private WebDriver driver;
	
	//WebElements
	@FindBy(tagName="body")
	private WebElement scrollPage;
	
	@FindBy(css="#twotabsearchtextbox")
	private WebElement searchBox;

	@FindBy(css=".a-size-medium.a-color-base.a-text-normal")
	private List <WebElement> productList;

	@FindBy(id="productTitle")
	private WebElement productDetailPage;

	@FindBy(xpath="//*[@id='corePriceDisplay_desktop_feature_div']/div[1]/span[3]/span[2]")
	private WebElement productPrice;

	@FindBy(xpath="(//span[@class='a-price-symbol'])[5]")
	private WebElement currencySymbol;

	@FindBy(id="add-to-cart-button")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id='attach-view-cart-button-form']/span/span/input")
	private WebElement cartBtn;
	
	@FindBy(css=".a-row.sc-list-item.sc-java-remote-feature")
	private WebElement productaddedAtCart;



	public productSearchPage(WebDriver driver) {
		this.driver=driver;
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

	public boolean selectProduct() {
		int productNo = 1;

		if(productNo>=0) {
			productList.get(productNo).click();
			return true;
		}else {
			return false;
		}
	}

	public boolean userIsOnProdDetailPage() {
		String parentID = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();

		for(String obj : allIds) {
			if(obj.equals(parentID)) {
				continue;
			}
			driver.switchTo().window(obj);
		}
		return productDetailPage.isDisplayed();
	}

	public String retrieveProductPrice() {
		BaseUtility bu = new BaseUtility();
		bu.waitForVisibiltyOfElementLocated(driver, 15, "xpath", "//*[@id='corePriceDisplay_desktop_feature_div']/div[1]/span[3]/span[2]");
		return productPrice.getText(); 
	}

	public void addProdToCart() {
		BaseUtility bu = new BaseUtility();
		bu.clickByJS(driver, addToCartBtn);
		bu.waitForElementToBeClickable(driver, 20, cartBtn);
		cartBtn.click();
	}
	
	public boolean productAtCartIsDisplayed() {
		try {
			return productaddedAtCart.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
}
