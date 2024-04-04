package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
	
	private WebDriver driver;

	private By signIn = By.id("SignIn");
	private By signUp = By.className("signUpBtn");
	private By emailField = By.id("emailIdSignUp");
	private By passwordField = By.id("passwordSignUp");
	private By nameField = By.id("nameSignUp");
	private By mobileField = By.id("mobileNoSignUp");
	private By createAccount = By.id("signUpValidate");
	
	public SignUpPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void clickSignIn()
	{
		driver.findElement(signIn).click();
	}
	
	
	public void clickSignUp()
	{
		driver.findElement(signUp).click();
	}
	
	public void enterEmail(String email)
	{
		driver.findElement(emailField).sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void enterName(String name)
	{
		driver.findElement(nameField).sendKeys(name);
	}
	
	public void enterMobile(String mobile) 
	{
		driver.findElement(mobileField).sendKeys(mobile);
	}
	
	public void clickCreateAccount()
	{
		driver.findElement(createAccount).click();
	}
	
}
