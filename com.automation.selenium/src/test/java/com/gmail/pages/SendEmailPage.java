package com.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendEmailPage {
	
	
	WebDriver driver;
 public SendEmailPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	 this.driver = driver;
 }
 
 @FindBy(id="") WebElement composeelement;

}
