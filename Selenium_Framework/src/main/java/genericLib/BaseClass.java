package genericLib;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import pom.SignInPage;

public class BaseClass {
	
	public WebDriver driver;
	public Map credentials;
	public String url;
	public String email;
	public String password;
	public String name;
	public String mobile;
	
	@BeforeSuite
	public void fetchData() throws IOException
	{
		FetchingDataFromExternal prop = new FetchingDataFromExternal();
		credentials=prop.fetchData();
		url=(String) credentials.get("url");
		email=(String) credentials.get("email");
		password=(String) credentials.get("password");
		name=(String) credentials.get("name");
		mobile=(String) credentials.get("mobile");
	}
	
	@BeforeTest
	public void setUp()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(url); 
	}
	
	

//	@AfterTest
//	public void closeBrowser()
//	{
//		driver.close();
//	}
	
	@BeforeMethod
	public void signIn()
	{
		SignInPage signIn = new SignInPage(driver);
		signIn.clickSignIn();
		signIn.enterEmail(email);
		signIn.enterPassword(password);
		signIn.clickSignInButton();
	}
}
