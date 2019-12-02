package com.gmail.testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gmail.pages.LoginPage;

public class GmailLoginTestcases extends BaseClass{
	
	LoginPage page;
	
	@BeforeMethod
	public void  initialiseElements() {
		page  = PageFactory.initElements(driver, LoginPage.class);
		logger = reports.createTest("Login to Gmail");
	}

	
	//test case for valid username
	@Test(groups = "usename",priority = 2)
	public void verifyUserNameCase2() {
		
		logger.info("perform Login with valid username");
		
		String uname = datareader.getStringData("Login",1,0);
		String expected = datareader.getStringData("Login",1,2);
		String testCase=datareader.getStringData("Login",1,3);
		page.UserName(uname,expected,testCase);
	}
	//test case for invalid password
	@Test(groups = "password",dependsOnGroups = "usename",priority = 3)
	public void verifyPasswordCase1() {
		
		logger.info("perform Login with invalid password");
		
		String pwd = datareader.getStringData("Login",2,1);
		String expected = datareader.getStringData("Login",2,2);
		String testCase=datareader.getStringData("Login",2,3);
		page.passwordField(pwd,expected,testCase);
	}
	//test case for valid password
	@Test(groups = "password",priority = 4)
	public void verifyPasswordCase2() {
		
		logger.info("perform Login with valid password");
		String pwddata = datareader.getStringData("Login",1,1);
		String expected = datareader.getStringData("Login",1,2);
		String testCase=datareader.getStringData("Login",1,3);
		page.passwordField(pwddata,expected,testCase);
		logger.info("Login Completed");
	}
	//test case for invalid username
	@Test(groups = "usename", priority = 1)
	public void verifyUserNameCase1() {
		logger.info("perform Login with invalid usename");
		String uname = datareader.getStringData("Login",0,0);
		String expected = datareader.getStringData("Login",0,2);
		String testCase=datareader.getStringData("Login",0,3);
		page.UserName(uname,expected,testCase);
	
	}
	

	
}

