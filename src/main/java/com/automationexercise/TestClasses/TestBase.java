package com.automationexercise.TestClasses;

import Utils.PropertyReader;

import com.automationexercise.POMClasses.HomePageClass;
import com.automationexercise.POMClasses.LoginPageClass;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;


public class TestBase {
	WebDriver driver;

	 HomePageClass homePage;
	LoginPageClass loginPage;
	
	private static Logger log= LogManager.getLogger(TestBase.class.getTypeName());

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {

			 System.out.println("Step 1:  Chrome opened ");
			 log.info("Chrome opened");
			 WebDriverManager.chromedriver().setup();
		     driver=new ChromeDriver();
		     driver.get(PropertyReader.readKey("website"));
		     driver.manage().window().maximize();
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test(priority=1)
	void LoginTest()

	{    homePage=new HomePageClass(driver);
		 homePage.clickSubmit();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 loginPage=new LoginPageClass(driver);
         loginPage.EnterSignupName();
         loginPage.EnterSignupEmail();
         loginPage.clicksignup();
		 Assert.assertEquals(driver.getTitle(),"Automation Exercise - Signup / Login");
        loginPage.verifySignupMsg();
	}


}
