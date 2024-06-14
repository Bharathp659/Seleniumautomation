package stepdefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Accountpage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resource.Base;

public class Login extends Base   {
WebDriver driver;
LoginPage loginpage;
    @Given("^Open any Browser$")
    public void openAnyBrowser() throws IOException {
    	driver = driverInstalization();
    }

    @And("^Navigate to Login page$")
    public void navigateToLoginPage() {
    	driver.get(prop.getProperty("url"));
    	LandingPage Lp = new LandingPage(driver);
    	Lp.AccountpageDropDown().click();
    	Lp.LoginOption().click();
    	
    }

    @When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
    public void enterUsernameAndPassword(String email, String password) {
    	 loginpage = new LoginPage(driver);
		loginpage.emailfield().sendKeys(email);
		loginpage.passwordfiled().sendKeys(password);
    }

    @And("^User clicks on Login button$")
    public void clickLoginButton() {
    	loginpage.loginbutton().click();    }

    @Then("^Verify user is able to successfully login$")
    public void verifySuccessfulLogin() {
    	Accountpage ap = new Accountpage(driver);
    	Assert.assertTrue(ap.verifymyaccount().isDisplayed());
    }
    @After
    public void closeBrowser() {
    	driver.quit();
    }
}