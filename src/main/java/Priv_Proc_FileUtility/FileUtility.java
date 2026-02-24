package Priv_Proc_FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String getTheDataFromPropertiesFile(String key) throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Gurup\\eclipse-workspace\\DophaMine\\src\\main\\resources\\ECD.properties");
		Properties po=new Properties();
		po.load(fis);
	    return po.getProperty(key);
	    
	}
}
