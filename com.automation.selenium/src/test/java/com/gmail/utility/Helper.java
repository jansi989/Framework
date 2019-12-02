package com.gmail.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

public class Helper {


		 public void mouseoverandclick(WebDriver driver, WebElement nextbutton) {
			 			 
			 Actions act = new Actions(driver);
				act.moveToElement(nextbutton).click().build().perform();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 }


		public void verifyPageTitle(String actual,String expected) {
			Assert.assertEquals(actual, expected);
		}
		
		public void VerifyErrorMessage(String actual,String expected) {
			
			
		}
		
		public String captureScreenShots(WebDriver driver) {
			
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String screenshotpath = System.getProperty("user.dir")+"/ScreenShots/Gmail"+getCurrentdateFormat()+".png";
		    try {
		    	
		    	File topath=new File(screenshotpath);
				FileHandler.copy(src,topath);
				
			} catch (Exception e) {
				System.out.println("unable to take the screenshot"+e.getMessage());
			}
		    
		    return screenshotpath;
			
		}
		
		public String getCurrentdateFormat() {
			DateFormat  customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
			Date currentDate = new Date();
			return customFormat.format(currentDate);
		}
		
		
		
}
