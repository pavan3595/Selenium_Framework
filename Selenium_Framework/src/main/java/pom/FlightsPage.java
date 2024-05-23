package pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericLib.UtilityMethods;


public class FlightsPage {
	 
	private WebDriver driver;
	private By fromField = By.id("source");
	private By toField = By.id("destination");
	private By departureDatePicker = By.id("departure");
	private By returnDatePicker = By.id("return");
	private By searchFlightButton = By.id("search-flight-btn");
	private By oneWayTab = By.className("one-way");
	private By roundTripTab = By.className("round-trip");
	private By selectDate;
	
	public FlightsPage(WebDriver driver) {

		this.driver = driver;
	}

	public void enterFrom(String from)
	{
		driver.findElement(fromField).sendKeys(from);
	}
	
	public void enterTo(String to)
	{
		driver.findElement(toField).sendKeys(to);
	}
	
	public void enterDeparture()
	{
		driver.findElement(departureDatePicker).click();
	}
	
	public void enterReturn()
	{
		driver.findElement(returnDatePicker).click();
	}

	public void clickSearchFlight()
	{
		driver.findElement(searchFlightButton).click();
	}
	
	public void clickOneWay()
	{
		driver.findElement(oneWayTab).click();	
	}
	
	public void clickRoundTrip()
	{
		driver.findElement(roundTripTab).click();
	}
	
	public void selectdate(int sheetIndex,String columnHeader) throws IOException, InterruptedException
	{
		UtilityMethods utility = new UtilityMethods();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
		selectDate= By.xpath(utility.searchDate(sheetIndex,columnHeader));
		WebElement date = driver.findElement(selectDate);
		wait.until(ExpectedConditions.elementToBeClickable(date));
		date.click();
		
	}
	public void navigateDown() throws AWTException
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).perform();;
		action.sendKeys(Keys.ENTER).perform();;
		
	}
	
	
}
