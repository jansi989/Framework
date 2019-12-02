package com.gmail.utility;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	public class BrowserFactory 
	{
		
		static WebDriver driver;
		public static WebDriver invokeBrowser(String browser, String url) 
		{
			if(browser.equalsIgnoreCase("Chrome")) 
			{
				System.setProperty("webdriver.chrome.driver",".\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();			
				
			}
			else if(browser.equalsIgnoreCase("firefox")) 
			{
				System.setProperty("webdriver.gecko.driver",".\\Driver\\geckodriver.exe");
				driver = new FirefoxDriver();		
				
			}
			else if(browser.equalsIgnoreCase("ie")) 
			{
				System.setProperty("webdriver.chrome.driver","D:\\STUDY\\selenium\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();		
				
			}
			
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
			
		}

	}

