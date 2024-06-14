package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	private WebElement AccountPageDropDown;
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement LoginOption;

	public WebElement AccountpageDropDown() {
		return AccountPageDropDown;

	}

	public WebElement LoginOption() {
		return LoginOption;
	}
}