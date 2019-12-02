package com.gmail.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.gmail.utility.BrowserFactory;
import com.gmail.utility.ConfigDataProvider;
import com.gmail.utility.ExcelDataProvider;
import com.gmail.utility.Helper;


public class BaseClass {

		public WebDriver driver;
		public ExcelDataProvider datareader;
		public  ConfigDataProvider configDataObject;
		public Helper helper;
		public ExtentReports reports;
		public ExtentTest logger;
			
			
			@BeforeSuite
			public void setupSuite() {
				datareader =new ExcelDataProvider();
				configDataObject = new ConfigDataProvider();
				helper = new Helper();
				reports = new ExtentReports();
				
				ExtentHtmlReporter extent = new ExtentHtmlReporter(
						new File(System.getProperty("user.dir")+"/Reports/Gmail"+helper.getCurrentdateFormat()+".html"));
				reports.attachReporter(extent);
						
			}
			
			@BeforeClass
			public void setup() {
				
				String browser =  configDataObject.getBrowserData();
				driver = BrowserFactory.invokeBrowser(browser,configDataObject.geturl());
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
			}
			
			@AfterClass
			public void tearDown() {
				
				driver.quit();
			}
			
			@AfterMethod
			public void tearDownMethod(ITestResult result) {
				if(result.getStatus()== ITestResult.FAILURE) {
					
					try {
						logger.fail("failed",
								MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenShots(driver)).build());
					} catch (IOException e) {
						logger.info(e.getMessage());
					}
				}if(result.getStatus()== ITestResult.SUCCESS) {
						try {
							logger.pass("pass",
									MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenShots(driver)).build());
						} catch (IOException e) {
							logger.info(e.getMessage());
						}
				}
				reports.flush();
			}
			
			
		}



