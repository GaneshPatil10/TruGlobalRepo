package org.stepDefinations;

import java.util.Properties;

import org.applicationHooks.AppHooks;
import org.openqa.selenium.WebDriver;
import org.pages.AmazonRegPage;
import org.utilities.BaseUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonRegistration {
	WebDriver driver;
	Properties prop;
	BaseUtility bu;
	AmazonRegPage regPage;
	
	@Given("the user is on the Amazon registration page")
	public void the_user_is_on_the_amazon_registration_page() {
		driver = AppHooks.driver;
		prop = AppHooks.prop;
		bu = AppHooks.bu;
		regPage = new AmazonRegPage(driver);
		regPage.openAmzRegPage();
	}

	@Then("registration page title is displayed as {string}")
	public void registration_page_title_is_displayed_as(String string) {
		regPage = new AmazonRegPage(driver);
		regPage.verifyRegPageTitle(string);
	}

	@Then("your name field is displayed")
	public void your_name_field_is_displayed() {
		regPage = new AmazonRegPage(driver);
		regPage.nameFieldIsDisplayed();
	}

	@Then("Mobile number field is displayed")
	public void mobile_number_field_is_displayed() {
		regPage = new AmazonRegPage(driver);
		regPage.mobNoFieldIsDisplayed();
	}

	@Then("Email field is displayed")
	public void email_field_is_displayed() {
		regPage = new AmazonRegPage(driver);
		regPage.emailFieldIsDisplayed();
	}

	@Then("Password field is displayed")
	public void password_field_is_displayed() {
		regPage = new AmazonRegPage(driver);
		regPage.pwdFieldIsDisplayed();
	}

	@Then("Verify Mobile Number button is displayed")
	public void verify_mobile_number_button_is_displayed() {
		regPage = new AmazonRegPage(driver);
		regPage.verifyMobNumOptIsDisplayed();
	}

	@When("user enters First and Last name as {string}")
	public void user_enters_first_and_last_name_as(String string) {
		regPage = new AmazonRegPage(driver);
		regPage.enterYourName(string);
	}

	@When("user enters mobile number")
	public void user_enters_mobile_number() {
		regPage = new AmazonRegPage(driver);
		regPage.enterMobNo(prop.getProperty("mobileNo"));
	}

	@When("user enters Email")
	public void user_enters_email() {
		regPage = new AmazonRegPage(driver);
		regPage.enterEmail(prop.getProperty("email"));
	}

	@When("user enters password")
	public void user_enters_password() {
		regPage = new AmazonRegPage(driver);
		regPage.enterPwd("password");
	}

	@When("click on Verify Mobile Number button")
	public void click_on_verify_mobile_number_button() throws Exception  {
		regPage = new AmazonRegPage(driver);
		regPage.clickOnVerifyMobNumOpt();
	}
	
	@When("wait until puzzle solve")
	public void wait_until_puzzle_solve() {
	 // Solve Puzzle manually
		regPage = new AmazonRegPage(driver);
		regPage.waitUntilPuzzleSolve();
	}

	@When("user enters OTP")
	public void user_enters_otp() throws Exception {
	// Enter OTP manually
		regPage = new AmazonRegPage(driver);
		regPage.waitToEnterOTP();
	}

	@When("click on Create your Amazon account option")
	public void click_on_Create_your_Amazon_account_option() {
		regPage = new AmazonRegPage(driver);
		regPage.clickOnCreateAmzAccOpt();
	}
}
