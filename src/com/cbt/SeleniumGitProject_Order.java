package com.cbt;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumGitProject_Order {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HPS\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();

		Thread.sleep(500);
		// driver.quit();
		driver.findElement(By.xpath("//a[@href='Process.aspx']")).click();

		int randInt = (int) (Math.random() * 100);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(String.valueOf(randInt));

		String name = "";
		name = name.concat("JOHN ");
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String middle = "";
		Random randMiddle = new Random();
		for (int i = 0; i < 4; i++) {
			char c = characters.charAt(randMiddle.nextInt(26));
			middle += c;
		}
		name = name.concat(middle);
		name = name.concat(" SMITH");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(name);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any St");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Houston");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("TX");
		int zip = 0;

		Random randZip = new Random();
		for (int i = 0; i < 5; i++) {
			int x = randZip.nextInt(10000);
			zip += x;
		}
		System.out.println(zip);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(String.valueOf(zip));
		// .linkText("Process.aspx")).click();
		// webDriver.findElement(By.xpath("//a[@href='/docs/configuration']")).click();

		List<WebElement> options = driver
				.findElements(By.xpath("//*[starts-with(@id, 'ctl00_MainContent_fmwOrder_cardList')]"));
		Random random = new Random();
		int index = random.nextInt(options.size());
		options.get(index).click();

		long randV = (long) (Math.random() * 10000000000000L);
		long visa = 4000000000000000L + randV;

		long randM = (long) (Math.random() * 10000000000000L);
		long master = 5000000000000000L + randM;

		long randA = (long) (Math.random() * 10000000000000L);
		long amex = 3000000000000000L + randA;

		if (index == 1) {
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(String.valueOf(visa));

		} else if (index == 2) {
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(String.valueOf(master));

		} else {
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(String.valueOf(amex));

		}
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("02/19");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		
		String actual = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")).getText();
		String expexted ="New order has been successfully added.";
		
		if(actual.equals(expexted)) {
			System.out.println("passed!");
		}else {
			System.out.println("failed!");
		}
//		if(driver.findElement(By.xpath("//*[contains(text(), 'New order has been successfully added')]")).isDisplayed()==true) {
//			System.out.println("PASSED!");
//		}else {
//			System.out.println("FAILED!");
//		}
		
		Thread.sleep(10000);
		driver.close();
	}

}
