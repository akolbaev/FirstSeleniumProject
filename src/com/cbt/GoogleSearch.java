package com.cbt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
	public static void main(String[] args) {
		//set system properties
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HPS\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		//create driver object
		WebDriver driver = new ChromeDriver();
		//2-got to url www.google.com
		//get()---> opens a website
		driver.get("https://google.com");
		//3- vertify title
		// getTitle() ---> gets the title of the tab
		String expected ="Bing";
		String actual = driver.getTitle();
		
		if(expected.equals(actual)) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
			
		}
		System.out.println("Actual:   "+actual+"\n"+"Expected: "+expected);
		driver.quit();
	}
}