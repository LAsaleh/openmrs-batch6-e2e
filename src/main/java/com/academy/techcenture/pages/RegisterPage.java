package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class RegisterPage {


    private WebDriver driver;
    private WebDriverWait wait;
    private SoftAssert softAssert;
    public RegisterPage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);

    }
    @FindBy(className="logo")
    private WebElement logoIcon;
    @FindBy( id="fr3887-field")
    private WebElement givenName;
    @FindBy(id="fr4760-field")
    private WebElement familyName;
    @FindBy(xpath = "//label[@for='fr1942-field']")
    private WebElement givenLabel;
    @FindBy(id = "fr1942-field")
    private WebElement givenInput;
    @FindBy(id="checkbox-unknown-patient")
    private WebElement boxCheck;
    @FindBy(xpath =" //label[@for='checkbox-unknown-patient]")
    private WebElement unidentifiedPatient;
    @FindBy(id="next-button")
    private WebElement greenBtn;
    @FindBy(id="gender-field")
    private WebElement genderField;

    private void fillOutDemographics(){

    }


    private void fillOutAddressInfo(){

    }

    private void fillOutRelationshipInfo(){

    }

    public void fillOutPatientInfo(){

    }







}
