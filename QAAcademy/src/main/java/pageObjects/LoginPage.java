package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	By email = By.id("user_email");
	By pword = By.id("user_password");
	By login = By.xpath("//input[@type='submit']");
	By fpword =By.xpath("//a[@class='link-below-button']");
	By foottext =By.xpath("//footer[@class='bottom-menu bottom-menu-inverse']/div/div/div/p");
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement emailId() {
		return driver.findElement(email);
	}

	public WebElement password() {
		return driver.findElement(pword);
	}
	public WebElement loginButton() {
		return driver.findElement(login);	
		}
	public WebElement forgotPWord() {
		return driver.findElement(fpword);
	}
	
	public WebElement footertext() {
		return driver.findElement(foottext);
}
}