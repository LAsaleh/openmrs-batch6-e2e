package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private SoftAssert softAssert;

    public LoginPage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//legend[@class='w-auto']")
    private WebElement pageTitle;

    @FindBy(xpath = "//label[@for='username']")
    private WebElement usernameLabel;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(xpath = "//label[@for='password']")
    private WebElement passLabel;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//label[@for='sessionLocation']")
    private WebElement locationTitleLabel;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(xpath = "//ul[@id='sessionLocation']//li")
    private List<WebElement> sessionLocations;

    @FindBy(id = "cantLogin")
    private WebElement cantLogin;


    private void verifyLoginCheck(){
        softAssert.assertEquals(driver.getTitle(), "Login");
        softAssert.assertTrue(passLabel.isDisplayed(),"Password label is not displayed!");
        softAssert.assertTrue(usernameLabel.isDisplayed(),"User Label is not displayed!");
        softAssert.assertTrue(locationTitleLabel.isDisplayed(),"User Label is not displayed!");
        softAssert.assertTrue(usernameInput.isEnabled(), "Username input is not displayed");
        softAssert.assertTrue(passwordInput.isEnabled(), "Password input is not displayed");
        softAssert.assertEquals(sessionLocations.size(),6);

        String[] sessionLoc = {"Inpatient Ward", "Isolation Ward", "Laboratory", "Outpatient Clinic", "Pharmacy", "Registration Desk"};

        for (int i = 0; i < sessionLocations.size(); i++) {
            softAssert.assertEquals( sessionLocations.get(i).getText().trim(), sessionLoc[i]);
        }

        softAssert.assertTrue(loginButton.isEnabled(), "Login Button is not enabled!");
        softAssert.assertTrue(cantLogin.isDisplayed(), "Can't login is not displayed ");


    }


    public void logIn(){

        verifyLoginCheck();

        usernameInput.sendKeys(ConfigReader.getProperty("username"));
        passwordInput.sendKeys(ConfigReader.getProperty("password"));
        sessionLocations.get(2).click();
        loginButton.click();

    }













}
