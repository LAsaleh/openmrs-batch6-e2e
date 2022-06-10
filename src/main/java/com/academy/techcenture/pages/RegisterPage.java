package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Map;

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

    @FindBy(id="birthdateDay-field")
    private WebElement birthday;

    @FindBy( id="birthdateMonth-field" )
    private WebElement birthdayMonth;

    @FindBy( id="birthdateYear-field")
    private WebElement birthdayYear;

    @FindBy( id="birthdateYears-field" )
    private WebElement estimatedYears;

    @FindBy( id="birthdateMonths-field")
    private WebElement estimatedMonths;

    @FindBy (id = "address1")
    private WebElement addressOne;

    @FindBy(id = "address2")
    private WebElement addressTwo;

    @FindBy(id="next-button")
    private WebElement nextBtn;

    @FindBy( id = "cityVillage")
    private WebElement city;

    @FindBy(id = "stateProvince")
    private WebElement state;

    @FindBy (id = "country")
    private WebElement country;

    @FindBy (id = "postalCode")
    private WebElement postalCode;

    @FindBy(id="fr1632-field")
    private WebElement phone;


    private void fillOutDemographics(){
softAssert.assertTrue(givenName.isDisplayed());
familyName.click();


    }


    private void fillOutAddressInfo(){

    }

    private void fillOutRelationshipInfo(){

    }

    public void fillOutPatientInfo(Map<String,String> data){

    }







}
