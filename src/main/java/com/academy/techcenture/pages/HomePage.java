package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

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


}
