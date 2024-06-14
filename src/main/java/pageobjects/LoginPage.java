package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	private WebElement Emailfield;
	@FindBy(id = "input-password")
	private WebElement passwordfield;
	@FindBy(xpath = "//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]")
	private WebElement loginbutton;

	public WebElement emailfield() {
		return Emailfield;

	}

	public WebElement passwordfiled() {
		return passwordfield;
	}

	public WebElement loginbutton() {
		return loginbutton;
	}
}
