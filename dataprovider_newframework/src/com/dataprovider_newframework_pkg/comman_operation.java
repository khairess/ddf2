package com.dataprovider_newframework_pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait; 



public class comman_operation {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	static String appURL = "file:///G:/mobile%20app%20testing/---------------------excel%20property%20file/offline%20website/index.html";
	
		public static void openURL()
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
		driver.navigate().to(appURL);
			}
	
	
	
	public static void closebrowser()
	{
		driver.quit();
	}
	
	
}
