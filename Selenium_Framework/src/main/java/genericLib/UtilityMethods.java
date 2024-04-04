package genericLib;

import java.io.IOException;
import java.sql.Date;
import java.util.Map;

import org.testng.annotations.Test;

public class UtilityMethods {

	@Test
	public void searchDate() throws IOException {
		FetchingDataFromExternal excelData = new FetchingDataFromExternal();
		Map<String, String> testData = excelData.fetchDataXlsx();

		String departure = testData.get("Departure");
		
		String[] date = departure.split("-");
		String day = date[0];
		String month = date[1];
		String year = date[2];
		
		System.out.println(day + " " + month + " " + year);

		//div[@id='depart-cal']//span[contains(text(),"+year+")]//span[text()="+month+"]/../../..//div[text()="+day+" and not (contains(@class,'vc-disabled-cell'))]"
	}
}
