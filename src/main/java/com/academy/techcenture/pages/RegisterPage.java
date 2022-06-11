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
    @FindBy(xpath = "//input[@id='fr7620-field' or @name='givenName']")
    private WebElement givenName;
    @FindBy(xpath = "//input[@i;d='fr7037-field' or @name='familyName']")
    private WebElement familyName;
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

    @FindBy(xpath = "//input[@id='fr7957-field' or @name='phoneNumber']")
    private WebElement phoneNumber;
    @FindBy (xpath = "//select[@id='relationship_type']//option")
    private WebElement patientRelated;
    @FindBy (xpath ="//input[contains(@class,'person-typeahead')]")
    private WebElement personNameRelated;










        private void fillOutDemographics(Map<String,String> data){
            softAssert.assertTrue(logoIcon.isDisplayed());

   softAssert.assertTrue(givenName.isDisplayed());
   givenName.sendKeys(data.get("givenName"));
   familyName.sendKeys(data.get("familyName"));
   unidentifiedPatient.sendKeys(data.get("gender"));
   greenBtn.click();





    }


    private void fillOutAddressInfo(){

    }

    private void fillOutRelationshipInfo(){

    }

    public void fillOutPatientInfo(Map<String,String> data){

    }







}
