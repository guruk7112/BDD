package Priv_Proc_FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	String path="C:\\Users\\Gurup\\git\\DophaMine\\DophaMine\\src\\main\\resources\\ECD.properties";

	public String getTheDataFromPropertiesFile(String key) throws IOException {
		
		FileInputStream fis=new FileInputStream(path);
		Properties po=new Properties();
		po.load(fis);
	    return po.getProperty(key);
	    
	}
}
