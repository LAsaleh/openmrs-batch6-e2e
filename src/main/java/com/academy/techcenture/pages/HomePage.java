package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private SoftAssert softAssert;

    public HomePage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//li[@class='nav-item identifier']")
    private WebElement iconAccountName;

    @FindBy(xpath = "//h4[contains(text(),'admin')]")
    private WebElement headerAccountName;

    @FindBy(xpath = "//div[@id='navbarSupportedContent']//li")
    private List<WebElement> topOptions;


    @FindBy(xpath = "//div[@id='apps']//a")
    private List<WebElement> homePageFunctionality;





    public void verifyHomeActions() throws InterruptedException {

        String[] functionality = {"Find Patient Record", "Active Visits", "Register a patient", "Capture Vitals"," Appointment Scheduling","Register a patient",
           "Reports", "Data Management","Configure Metadata","System Administration"};

        softAssert.assertEquals(driver.getTitle(), "Home");
        softAssert.assertEquals(iconAccountName.getText().trim().toLowerCase(), "admin");
        softAssert.assertEquals(headerAccountName.getText().trim().toLowerCase(), "admin");
        softAssert.assertEquals(topOptions.size(), 4);


        softAssert.assertEquals(homePageFunctionality.size(), 10);
        for (int i = 0; i < homePageFunctionality.size(); i++) {
            softAssert.assertEquals(homePageFunctionality.get(i).getText(), functionality[i]);

        }

        homePageFunctionality.get(2).click();



    }


}