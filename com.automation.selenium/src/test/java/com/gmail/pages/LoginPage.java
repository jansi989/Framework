package com.gmail.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.gmail.utility.Helper;

	public class LoginPage{
		WebDriver driver;
		Helper hel;
		
		
		
		public LoginPage(WebDriver driver) {
			this.driver=driver;
			hel = new Helper();
		}
			
		@FindBy(how = How.ID,using = "identifierId") 
		WebElement uname;
		
		@FindBy(how = How.XPATH,using = "//input[@name='password']") 
		WebElement pwd;
		
		@FindBy(how = How.XPATH,using = "//*[@id='identifierNext']//child::span[text()='Next']") 
		WebElement UnameNextbtn;
		
		@FindBy(how = How.XPATH,using = "//*[@id='passwordNext']//child::span[text()='Next']") 
		WebElement pwdNextbtn;

		@FindBy(how=How.XPATH,using= "//input[@type='email']//ancestor::div//*[contains(text(),'find your Google')]")
		WebElement usererrmsg;
		
		@FindBy(how=How.XPATH,using = "//*[@id='headingText']/span")
		WebElement welcomemsg;
		
		@FindBy(how=How.XPATH,using="//*[@id='password']/ancestor::div//child::span[contains(text(),'Wrong password')]")
		WebElement pwderrmsg;
		
		public void UserName(String username, String expected, String testcase) {
			
			uname.clear();
			uname.sendKeys(username);
			//UnameNextbtn.click();
			hel.mouseoverandclick(driver, UnameNextbtn);
			if(testcase.equalsIgnoreCase("valid")) {
				if(pwd.isDisplayed()) {
					Assert.assertTrue( true,"Valid UserName");
				}
				
			}else {
				String actual = usererrmsg.getText();
				Assert.assertTrue(actual.contains(expected), "validate messages");
			}
			
		}
		
		
		public void passwordField(String password, String expected, String testcase) {
			
			
			//pwd.clear();
			pwd.sendKeys(password);
			//UnameNextbtn.click();
			hel.mouseoverandclick(driver,pwdNextbtn );

			if(testcase.equalsIgnoreCase("valid")) {
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				String actual = driver.getTitle();
				Assert.assertTrue(actual.contains(expected), "valid password");
				
			}else {
				String actual = pwderrmsg.getText();
				Assert.assertTrue(actual.contains(expected), "validate messages");
			}
			
			
						
		}
	/*	public void LoginGmail(String TestCase,String username,String password,String expected) {
			WebElement errmsg;
			uname.clear();
			uname.sendKeys(username);
			UnameNextbtn.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Utility utl = new Utility();
		/*	if(existsElement(pwd))
					{
				pwd.clear();
				pwd.sendKeys(password);
				utl.mouseoverandclick(driver, pwdNextbtn);
					}
			
			if(TestCase.equalsIgnoreCase("valid")) {
				String actual = driver.getTitle();
				utl.verifyPageTitle(actual,expected);
			}
			else { 
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 errmsg=driver.findElement(By.xpath ("//*[contains(text(),'"+expected+"')]"));
				 utl.VerifyErrorMessage(errmsg.getText(),expected);
				 
			}
			
		} 
		
	/*	public void verifyUsernameField(U
		///@FindBy( id ="identifierId")
		//WebElement logoutbtn;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath ("//*[contains(text(),'Jansi R')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath ("//*[text()='Sign out']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	public boolean existsElement(WebElement pwd) {
	    try {
	        pwd.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	    return true;
	}
		
	}*/

}
