package com.cbt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginCheck {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HPS\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		//create driver object
		WebDriver driver = new ChromeDriver();
		//2-got to url www.google.com
		//get()---> opens a website
		driver.get("http://testing-ground.scraping.pro/login");
		/**
		 * find element finds element on webpage
		 * locator is way of finding element ona page used by selenium
		 * locators represented in aclass calledby selenium
		 */
		driver.findElement(By.name("usr")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("12345");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		//Thread.sleep(10000);
		
		String expected ="Find a Flight";
		String actual = driver.getTitle();
		
		if(expected.equals(actual)) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
			
		}
		System.out.println("Actual:   "+actual+"\n"+"Expected: "+expected);
		//driver.quit();
	}

}
