package test;

import vtigerGenericUtilities.JavaUtils;

public class test1 {

	public static void main(String[] args) {
		
		JavaUtils ju = new JavaUtils();
		int rn = ju.getRandomNumber();
		System.out.println(rn);
		
		String date = ju.getDate();
		System.out.println(date);
		
		String s = ju.getDateFormat();
		System.out.println(s);
	}
}
