package genericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class FetchingDataFromProp {
	
	Properties propFile;
	
	public Map fetchData() throws IOException
	{
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
		credentials.put("url",url);
		credentials.put("email",email);
		credentials.put("password",password);
		credentials.put("name",name);
		credentials.put("mobile",mobile);
		
		
		
		return credentials;
	}
	

}
