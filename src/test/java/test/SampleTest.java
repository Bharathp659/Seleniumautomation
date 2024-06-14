package test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import resource.Base;

public class SampleTest extends Base{
	Logger log;
	public WebDriver driver;
	@BeforeMethod
	public void openingbrowser() throws IOException {
		 log = LogManager.getLogger(LoginTest.class.getName());
		driver = driverInstalization();
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}
	@Test
	public void Sample() {
	LandingPage Lp = new LandingPage(driver);
	log.debug("opens landing page");
	Assert.fail();
}
	@AfterMethod
	public void closeBrowser() {
		log.debug("Browser got closed");
		driver.quit();
	}
}
	
	