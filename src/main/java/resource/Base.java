package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver driverInstalization() throws IOException {

		prop = new Properties();
		String propertiesPath = System.getProperty("user.dir") + "\\src\\main\\java\\resource\\requireddata.properties";
		FileInputStream fis = new FileInputStream(propertiesPath);
		prop.load(fis);
		String Browser = prop.getProperty("browser");

		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Dell\\eclipse-workspace\\Log\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (Browser.equalsIgnoreCase("firefox")) {
			System.out.println("FIREFOX BROWSER OPENED");
		} else if (Browser.equalsIgnoreCase("ie browser")) {
			System.out.println("ie broweser opened");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public String takeScreenshot(String testName, WebDriver driver) throws IOException {

		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir") + "\\screenshots\\" + testName + ".png";
		FileUtils.copyFile(SourceFile, new File(destinationFilePath));
		return destinationFilePath;
	}
}
