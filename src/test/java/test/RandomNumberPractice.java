package test;

import java.util.Random;

public class RandomNumberPractice {

	public static void main(String[] args) {
		
		Random r = new Random();
		int num = r.nextInt(1000);
		System.out.println(num);
	}
}
