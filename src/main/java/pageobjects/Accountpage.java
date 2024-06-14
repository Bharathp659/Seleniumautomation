package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountpage {
	WebDriver driver;

	public Accountpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	private WebElement VerifyMyaccount;

	public WebElement verifymyaccount() {
		return VerifyMyaccount;
	}
}
