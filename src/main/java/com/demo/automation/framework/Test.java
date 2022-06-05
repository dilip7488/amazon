package com.demo.automation.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.epam.healenium.SelfHealingDriver;


public class Test {

	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		String driverPathChrome = projectPath + "" + "/src/main/resources/drivers/mac/chromedriver";
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", driverPathChrome);
		//declare delegate
		WebDriver delegate = new ChromeDriver();
		//create Self-healing driver
		SelfHealingDriver driver = SelfHealingDriver.create(delegate);
		 driver.get("https://www.google.com");
		 Thread.sleep(20000);
		 driver.findElement(By.xpath("//a[text()='Gmail']")).click();
		

	}

}
