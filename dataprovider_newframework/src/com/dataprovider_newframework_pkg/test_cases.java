package com.dataprovider_newframework_pkg;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class test_cases {
	
	@BeforeSuite
	public void start()
	{
	comman_operation.openURL();
	}
  @Test(dataProvider="login_data", dataProviderClass=data_repository.class)
  public void login(String userName, String password) 
  {
	  
	  
	    //public By byEmail = By.xpath(".//*[@id='email']");
		//public By byPassword = By.xpath(".//*[@id='password']");
		//public By bySignin = By.xpath(".//*[@id='form']/div[3]/div/button");
		//public By byErroruname = By.id("email_error");
		//public By byErrorpass = By.id("password_error");  
	  comman_operation.driver.findElement(By.xpath(".//*[@id='email']")).clear();
	  comman_operation.driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(userName);
	  comman_operation.driver.findElement(By.xpath(".//*[@id='password']")).clear();
	  comman_operation.driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
	  comman_operation.driver.findElement(By.xpath(".//*[@id='form']/div[3]/div/button")).click();
	  
	  if(userName.equals("kiran@gmail.com"))
		{
		  comman_operation.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@ href='logout.html']")));
			comman_operation.driver.findElement(By.xpath("//a[@ href='logout.html']")).click();
		}
	  
	   By byErroruname = By.id("email_error");
	  By byErrorpass = By.id("password_error");
	  
	  if(!"kiran@gmail.com".equals(userName))
		  
			//if(!userName.equals("kiran@gmail.com"))
			{
		  	comman_operation.wait.until(ExpectedConditions.presenceOfElementLocated(byErroruname));
			String actualErrorDisplayed = comman_operation.driver.findElement(byErroruname).getText();
			String requiredErrorMessage = "Please enter email as kiran@gmail.com";
			Assert.assertEquals(requiredErrorMessage, actualErrorDisplayed);
			}
			if(!"123456".equals(password))
			//if(!password.equals("123456"))
			{
				comman_operation.wait.until(ExpectedConditions.presenceOfElementLocated(byErrorpass));
				String actualErrorDisplayed = comman_operation.driver.findElement(byErrorpass).getText();
				String requiredErrorMessage = "Please enter password 123456";
				Assert.assertEquals(requiredErrorMessage, actualErrorDisplayed);
			}
			
  }
    
  @AfterSuite
	public void tearDown() {
	  comman_operation.closebrowser();
		}
}
