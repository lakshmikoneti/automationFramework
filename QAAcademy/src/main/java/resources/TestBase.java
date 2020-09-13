
package resources;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.LandingPage;

public class TestBase {
	private static final Logger logger = LogManager.getLogger(LandingPage.class);

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\naga\\eclipse-workspace\\QaClickAcademy\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser");
		//String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			logger.info("Base class with initializerDriver method with chrome ..");
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32 (2)//chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equals("firefox")) {
			// logger.info("Base class with initializerDriver method with firefox ..");
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();
		}

		else if (browserName.equals("ie")) {
			// logger.info("Base class with initializerDriver method with IE ..");
			System.setProperty("webdriver.ie.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// logger.info("Base class with initializerDriver method : END ..");
		return driver;
	}

	public void getScreenshotPath(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		org.apache.commons.io.FileUtils.copyFile(src, new File(destination));
	
		
	}}
