package Selenium.QaClickAcademy;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.TestBase;

public class ValidateTitleTest extends TestBase {
	public WebDriver driver;
	private static final Logger logger = LogManager.getLogger(ValidateTitleTest.class.getName());

	
	//public static Logger log = LogManager.getLogger(base.class.getName());
	@Test
	public void validateTitle() throws IOException, InterruptedException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		Thread.sleep(10000);
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		Assert.assertTrue(l.getTitle().isDisplayed());
		logger.info("Header is displaying");
}
	@AfterTest
	public void cleanDriver() {
		driver.close();
		logger.info("driver is closed");
	}
}
