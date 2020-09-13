package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	private static final Logger logger = LogManager.getLogger(LandingPage.class);

	public WebDriver driver;
	By cross = By.xpath("//*[text()='NO THANKS']");
	By signin = By.xpath("//*[text()='Login']");
	By title = By.xpath("//section[@id='content']/div/div/h2");

	public LandingPage(WebDriver driver) {
		//logger.info("LandingPage constructer...");
		this.driver = driver;
	}

	public WebElement closepop() {
		//logger.info("LandingPage closepop method...");
		return driver.findElement(cross);

	}

	public WebElement getlogin() {
		return driver.findElement(signin);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
}
