package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.utilities.BaseUtility;


public class AmazonRegPage {
	private WebDriver driver;
	
	@FindBy(css="#nav-link-accountList")
	private WebElement signInOpt;
	
	@FindBy(id="createAccountSubmit")
	private WebElement createYourAmzAccOpt;
	
	@FindBy(css="#ap_customer_name")
	private WebElement nameField;
	
	@FindBy(css="#ap_phone_number")
	private WebElement mobNoField;
	
	@FindBy(css="#ap_email")
	private WebElement emailField;
	
	@FindBy(css="#ap_password")
	private WebElement pwdField;
	
	@FindBy(css="#continue")
	private WebElement verifyMobNumOpt;
	
	@FindBy(css="#auth-pv-enter-code")
	private WebElement enterOTP;
	
	@FindBy(css="#auth-verify-button")
	private WebElement createAmzAccOpt;
	
	@FindBy(css="#cvf-aamation-challenge-iframe")
	private WebElement parentFrame;
	
	@FindBy(css="#aacb-arkose-frame")
	private WebElement childFrame_1;
	
	@FindBy(css=".r34K7X1zGgAi6DllVF3T.show.active.inline")
	private WebElement childFrame_2;
	
	@FindBy(css="#game-core-frame")
	private WebElement childFrame_3;
	
	@FindBy(css=".sc-nkuzb1-0.sc-d5trka-0.eZxMRy.button")
	private WebElement startPuzzleOpt;
	
	
	
	public AmazonRegPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openAmzRegPage() {
		signInOpt.click();
		createYourAmzAccOpt.click();
	}
	
	public void verifyRegPageTitle(String expTitle) {
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
	}
	
	public boolean nameFieldIsDisplayed() {
		return nameField.isDisplayed();
	}
	
	public boolean mobNoFieldIsDisplayed() {
		return mobNoField.isDisplayed();
	}
	
	public boolean emailFieldIsDisplayed() {
		return emailField.isDisplayed();
	}
	
	public boolean pwdFieldIsDisplayed() {
		return pwdField.isDisplayed();
	}
	
	public boolean verifyMobNumOptIsDisplayed() {
		return verifyMobNumOpt.isDisplayed();
	}
	
	public void enterYourName(String name) {
		nameField.sendKeys(name);
	}
	
	public void enterMobNo(String mobNo) {
		mobNoField.sendKeys(mobNo);
	}
	
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void enterPwd(String pwd) {
		pwdField.sendKeys(pwd);
	}
	
	public void clickOnVerifyMobNumOpt() {
		verifyMobNumOpt.click();
	}
	
	public void waitUntilPuzzleSolve() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.switchTo().frame(parentFrame);
		driver.switchTo().frame(childFrame_1);
		driver.switchTo().frame(childFrame_2);
		driver.switchTo().frame(childFrame_3);
		
		BaseUtility bu = new BaseUtility();
		startPuzzleOpt.click();
		
	}
	
	public void waitToEnterOTP() throws InterruptedException {
		Thread.sleep(10000);
	}
	
	public void clickOnCreateAmzAccOpt() {
		createAmzAccOpt.click();
	}
	
	
	
	
	
	
	
	
}
