package vtigerGenericUtilities;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

/**
 * this class ontains all general utility methods related to java
 * @author RUTHUPARNA
 *
 */

public class JavaUtils {

	public int getRandomNumber()
	{
		Random r = new Random();
		int num = r.nextInt(1000);
		return num;
	}
	
	public String getDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	
	public String getDateFormat()
	{
		Date d = new Date();
		String[] s = d.toString().split(" ");
		String date = s[2];
		String mon = s[1];
		String year = s[5];
		String time = s[3].replaceAll(":", "-");
		String formatdate = date+"-"+mon+"-"+year+"-"+time;
		return formatdate;
	}
}
