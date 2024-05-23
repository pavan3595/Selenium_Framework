package genericLib;

import java.io.IOException;
import java.sql.Date;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UtilityMethods {

	/**
	 * 
	 * @param sheetIndex
	 * @return
	 * @throws IOException
	 */
	public String searchDate(int sheetIndex,String columnHeader) throws IOException {
		FetchingDataFromExternal excelData = new FetchingDataFromExternal();
		Map<String, String> testData = excelData.fetchDataXlsx(sheetIndex);

		String dateValue = testData.get(columnHeader);
		
		String[] date = dateValue.split("-");
		String day = date[0];
		String month = date[1];
		String year = date[2];
		
		//System.out.println(day + " " + month + " " + year);
		String xpath="";
		if(columnHeader.equals("Departure"))
		{
		xpath =  "//div[@id='depart-cal']//span[contains(text(),'"+year+"')]//span[text()='"+month+"']/../../..//div[text()="+day+" and not (contains(@class,'vc-disabled-cell'))]";
		}
		
		else if(columnHeader.equals("Return"))
		{
			xpath =  "//div[@id='return-cal']//span[contains(text(),'"+year+"')]//span[text()='"+month+"']/../../..//div[text()="+day+" and not (contains(@class,'vc-disabled-cell'))]";
		}
		return xpath;
	}
	
	
	public void assertPage(WebDriver driver,String expectedTitle)
	{
		String title = driver.getTitle();
		Assert.assertEquals(title,expectedTitle);
	}
}
