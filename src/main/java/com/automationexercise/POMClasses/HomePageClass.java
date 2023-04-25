package com.automationexercise.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageClass {
    public WebDriver driver;

    //Constructor
    public HomePageClass(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//a[normalize-space()='Signup / Login']")
    WebElement btn_submit;

    public void clickSubmit()
    {
        btn_submit.click();
    }

}


