package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
	
	private WebDriver driver;

	private By signIn = By.id("SignIn");
	private By emailField = By.id("loginIdText");
	private By passwordField = By.id("passwordText");
	private By signInButton = By.id("loginValidate");
	
	
	public SignInPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickSignIn()
	{
		driver.findElement(signIn).click();
	}
	
	public void enterEmail(String email)
	{
		driver.findElement(emailField).sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickSignInButton()
	{
		driver.findElement(signInButton).click();
	}
}
