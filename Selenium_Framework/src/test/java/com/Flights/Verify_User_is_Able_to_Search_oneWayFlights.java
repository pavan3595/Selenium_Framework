package com.Flights;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.FetchingDataFromExternal;
import genericLib.UtilityMethods;
import pom.FlightsPage;
import pom.SignInPage;

public class Verify_User_is_Able_to_Search_oneWayFlights extends BaseClass {
	
	@Test()
	public void searchOneWayFlight() throws IOException, InterruptedException, AWTException
	{
		FlightsPage flight = new FlightsPage(driver);
		FetchingDataFromExternal externalFile = new FetchingDataFromExternal();
		Map<String, String> testdata = externalFile.fetchDataXlsx(0);
		
		flight.enterFrom(testdata.get("From"));
		Thread.sleep(3000);
		flight.navigateDown();
		flight.enterTo(testdata.get("To"));
		flight.enterDeparture();
		flight.selectdate(0,"Departure");
		flight.clickSearchFlight();
		
		Thread.sleep(10000);
		
	
	}
}
