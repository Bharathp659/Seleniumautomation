package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.Accountpage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resource.Base;

public class LoginTest extends Base {
	public WebDriver driver;
	Logger log;

	@Test(dataProvider = "datas")
	public void login(String email, String password, String result) throws IOException {

		LandingPage Lp = new LandingPage(driver);
		log.debug("opens landing page");
		Lp.AccountpageDropDown().click();
		log.debug("clicks on acccount page");
		Lp.LoginOption().click();
		log.debug("click on login option");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.emailfield().sendKeys(email);
		log.debug("enters emails in email field");
		loginpage.passwordfiled().sendKeys(password);
		log.debug("enters passswor in filed");
		loginpage.loginbutton().click();
		log.debug("click on login button");
		Accountpage ap = new Accountpage(driver);
		String Actualresult = null;
		try {
			if (ap.verifymyaccount().isDisplayed()) {
				log.debug("User got logged in");
				Actualresult = "pass";
			}
		} catch (Exception e) {
			log.debug("User didn't log in");
			Actualresult = "failure";
		}
		if (Actualresult.equals(result)) {

			log.info("Login Test got passed");

		} else {

			log.error("Login Test got failed");
		}

	}

	@BeforeMethod
	public void openingbrowser() throws IOException {
		log = LogManager.getLogger(LoginTest.class.getName());
		driver = driverInstalization();
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}

	@AfterMethod
	public void closeBrowser() {
		log.debug("Browser got closed");
		driver.quit();
	}

	@DataProvider
	public Object[] datas() {
		Object[][] data1 = { { "bharathp@gmail.com", "Bharathp659@", "pass" } };
		return data1;
	}
}
