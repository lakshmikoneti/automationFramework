package Selenium.QaClickAcademy;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.TestBase;

public class HomePageTest extends TestBase {
	public WebDriver driver;
	private static final Logger logger = LogManager.getLogger(HomePageTest.class.getName());

	@Test
	public void basePageNavigation() throws IOException, InterruptedException {

		LandingPage l = new LandingPage(driver);
		l.closepop().click();
		l.getlogin().click();
	}

	@DataProvider
	@Test(dependsOnMethods = { "basePageNavigation" }, dataProvider = "getdata")

	public void loginToQaAcademy(String uname, String pword) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(5000);
		logger.info("login page is displayed");
		lp.emailId().sendKeys(uname);
		lp.password().sendKeys(pword);
		lp.loginButton().click();
		Thread.sleep(3000);
		logger.info("login done");
		System.out.println("Done");

	}

	@Test(dependsOnMethods = { "loginToQaAcademy" })
	public void forgotlink() {
		LoginPage lp = new LoginPage(driver);
		logger.info("forgot link is present");
		lp.forgotPWord().click();
		// System.out.println("NAvigate to forgot password page");
		logger.info("able to click forgeo link");

	}

	@DataProvider
	public Object[][] getdata() {
		Object[][] data = new Object[2][2];
		data[0][0] = "abc@123";
		data[0][1] = "a123";
		data[1][0] = "cde@234";
		data[1][1] = "b456j";
		return data;
	}

	@BeforeTest
	public void initialization() throws IOException, InterruptedException {
		logger.info("HOmepagetest initialization method..... ");
		driver = initializeDriver();
		//Log.info("driver is initialize");
		driver.get(prop.getProperty("url"));
		Thread.sleep(10000);

	}
	
	@AfterSuite
	public void cup() {
		driver.close();
	}

}
