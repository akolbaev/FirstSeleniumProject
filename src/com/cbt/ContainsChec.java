package com.cbt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContainsChec {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//set system properties
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\HPS\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
				//create driver object
				WebDriver driver = new ChromeDriver();
				//navigate().to() ==get()
				driver.navigate().to("http://www.google.com");
				
				//3- vertify title
				// getTitle() ---> gets the title of the tab
				String expected ="cybertekschool";
				//getCurrentUrl() --> gets the url of the current tab
				String actual = driver.getCurrentUrl();
				
				if(actual.contains(expected)) {
					System.out.println("Passed");
				}else {
					System.out.println("Failed");
					
				}
				System.out.println("  Actual: "+actual+"\n"+"Expected: "+expected);
				
				//goes new page
				driver.navigate().to("http://bing.com");
				Thread.sleep(1000);
				//navigate back to previous page
				driver.navigate().back();
				Thread.sleep(1000);
				//navigate forward in browsing hisotry
				driver.navigate().forward();
				Thread.sleep(1000);
				//to refresh the current page
				driver.navigate().refresh();
				Thread.sleep(1000);
				driver.quit();
				//driver.close();
				/**
				 * we can still use the webdriver object
				 * 
				 * quite closes all tabs and windows
				 * ends the session. == we cannot use the same webdriver object again 
				 * we need to instanciate 
				 */

	}

}
