package org.applicationHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.utilities.BaseUtility;
import org.utilities.ConfigReader;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	public static WebDriver driver;
	public static Properties prop;
	public static BaseUtility bu;
	public static Scenario scn;
	@Before
	public void launchBrowser() {
		ConfigReader cr = new ConfigReader();
		prop = cr.getData();
		bu = new BaseUtility();
		driver = bu.startUp(prop.getProperty("browserName"), prop.getProperty("url"));
	}
	
	@After(order=2)
	public void takesScreenshot(Scenario scn) {
		if(scn.isFailed()) {
			String screenshotName = scn.getName().replaceAll(" ", "");
			byte [] scnPath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scn.attach(scnPath, "image/png", screenshotName);
		}
	}
	
	@After(order=1)
	public void tearDown() {
		driver.quit();
	}
}
