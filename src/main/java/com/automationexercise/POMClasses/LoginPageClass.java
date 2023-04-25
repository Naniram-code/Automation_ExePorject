package com.automationexercise.POMClasses;

import Utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass {
	public WebDriver driver;
	@FindBy(xpath="//input[@placeholder='Name']")private WebElement signupName;
	@FindBy(xpath="//input[@data-qa='signup-email']")private WebElement signupEmail;
	@FindBy(xpath=" //button[normalize-space()='Signup']")private WebElement signup;

	@FindBy(xpath=" //input[@data-qa='login-email']")private WebElement loginMail;
	@FindBy(xpath="//input[@data-qa='login-password']")private WebElement loginPassword;
	@FindBy(xpath="//button[normalize-space()='Login']")private WebElement login;

	@FindBy(css="input#susbscribe_email")private WebElement subscribeMail;
	@FindBy(css="button#subscribe")private WebElement subscribeButton;
	@FindBy(xpath="//h2[text()='New User Signup!']")private WebElement signupMsg;
	
	public LoginPageClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void EnterSignupName() {
		signupName.sendKeys(PropertyReader.readKey("name"));
	}
	
	public void EnterSignupEmail() {
		signupEmail.sendKeys(PropertyReader.readKey("mailid"));
	}
	
	public void clicksignup() {
		Actions actions=new Actions(driver);

		actions.moveToElement(signup).build().perform();
	}
	
	public boolean verifySignupMsg() {

		boolean result=signupMsg.isDisplayed();
		return result;
		
	}
	

}
