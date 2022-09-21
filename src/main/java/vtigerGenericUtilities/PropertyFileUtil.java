package vtigerGenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains all the generic methods related to property file
 * @author RUTHUPARNA
 *
 */

public class PropertyFileUtil {

	/**
	 * this method will read the data from property file and return the value
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFrmProp(String key) throws IOException
	{
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(IConstant.propertyfilepath);
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
}
