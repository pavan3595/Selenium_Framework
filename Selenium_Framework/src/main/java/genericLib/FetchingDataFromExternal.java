package genericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FetchingDataFromExternal {

	Properties propFile;

	Map xlsxData;

	public Map fetchData() throws IOException {
		File file = new File("src/test/resources/externalData/TestData.properties");
		FileInputStream fis = new FileInputStream(file);
		propFile = new Properties();
		propFile.load(fis);

		String url = propFile.getProperty("url");
		String email = propFile.getProperty("email");
		String password = propFile.getProperty("password");
		String name = propFile.getProperty("name");
		String mobile = propFile.getProperty("mobile");

		Map credentials = new HashMap();

		credentials.put("url", url);
		credentials.put("email", email);
		credentials.put("password", password);
		credentials.put("name", name);
		credentials.put("mobile", mobile);

		return credentials;
	}

	public Map<String, String> fetchDataXlsx() throws IOException {
		File file = new File("src/test/resources/externalData/Via.com.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);

		String sheetName = workbook.getSheetName(0);
		Sheet sheet = workbook.getSheet(sheetName);

		Map<String, String> dataMap = new HashMap<>();

		// First row containing column header
		Row headerRow = sheet.getRow(0);
		for (Row row : sheet) {
			if (row.getRowNum() == 0)
				continue;
			for (Cell cell : row) {
				// Get the column header from the header row
				String columnHeader = headerRow.getCell(cell.getColumnIndex()).getStringCellValue();
				// Get the cell value
				String cellValue = cell.toString();
				System.out.println(cellValue);
				// Add key-value pair to the map
				dataMap.put(columnHeader, cellValue);
			}

		}
		return dataMap;
	}

}
