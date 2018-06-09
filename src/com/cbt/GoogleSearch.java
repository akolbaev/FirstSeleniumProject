package com.cbt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
	public static void main(String[] args) {
		//set system properties
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HPS\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		//create driver object
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://bing.com");
	}
}