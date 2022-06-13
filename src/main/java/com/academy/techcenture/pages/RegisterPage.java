package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
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

    @FindBy(className = "logo")
    private WebElement logoIcon;
    @FindBy(name="givenName")
    private WebElement givenName;
    @FindBy(name="familyName")
    private WebElement familyName;
    @FindBy(id = "checkbox-unknown-patient")
    private WebElement boxCheck;
    @FindBy(xpath = "//label[@for='checkbox-unknown-patient']")
    private WebElement unidentifiedPatient;
    @FindBy(id = "next-button")
    private WebElement greenBtn;
    @FindBy(id = "gender-field")
    private WebElement genderField;

    @FindBy(id = "birthdateDay-field")
    private WebElement birthday;

    @FindBy(id = "birthdateMonth-field")
    private WebElement birthdayMonth;

    @FindBy(id = "birthdateYear-field")
    private WebElement birthdayYear;

    @FindBy(id = "birthdateYears-field")
    private WebElement estimatedYears;

    @FindBy(id = "birthdateMonths-field")
    private WebElement estimatedMonths;

    @FindBy(id = "address1")
    private WebElement addressOne;

    @FindBy(id = "address2")
    private WebElement addressTwo;

    @FindBy(id = "next-button")
    private WebElement nextBtn;

    @FindBy(id = "cityVillage")
    private WebElement city;

    @FindBy(id = "stateProvince")
    private WebElement state;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "postalCode")
    private WebElement postalCode;

    @FindBy(name="phoneNumber")
    private WebElement phoneNumber;
    @FindBy(id = "relationship_type")
    private WebElement patientRelated;
    @FindBy(xpath = "//input[contains(@class,'person-typeahead')]")
    private WebElement personNameRelated;
    @FindBy(xpath = "//div[@id='dataCanvas']//span")
    private List<WebElement> confirmationList;




    private void fillOutDemographics(Map<String, String> data) throws InterruptedException {
        softAssert.assertTrue(logoIcon.isDisplayed());

        softAssert.assertTrue(givenName.isDisplayed());

        String givenName1 = data.get("givenName");
        givenName.sendKeys(givenName1);


        String familyName1 = data.get("familyName");
        familyName.sendKeys(familyName1);

        softAssert.assertEquals(unidentifiedPatient.getText().trim(),"Unidentified Patient");
        wait.until(ExpectedConditions.visibilityOf(unidentifiedPatient));
        softAssert.assertTrue(greenBtn.isEnabled());
        greenBtn.click();
        Select select=new Select(genderField);
        String gender1 = data.get("gender");
        select.selectByVisibleText(gender1);
        greenBtn.click();
        if(data.get("ifDob").equalsIgnoreCase("yes")){
            String dateOfBirth = data.get("dateOfBirth");
            String[] splitDob = dateOfBirth.split("/");
            int day = Integer.parseInt(splitDob[1]);
            birthday.sendKeys(day+"");
            String month= Integer.parseInt(splitDob[0]) +"";
            Select select1=new Select(birthdayMonth);
            select1.selectByValue(month);
            int year = Integer.parseInt(splitDob[2]);
            birthdayYear.sendKeys(year+"");

        }else{
            String estimatedYears = data.get("estimatedYears");
            estimatedYears =  estimatedYears.substring(0, estimatedYears.indexOf("."));

            this.estimatedYears.sendKeys(estimatedYears);

            String estimatedMonths = data.get("estimatedMonths"); //2.0
            estimatedMonths  =estimatedMonths.substring(0,estimatedMonths.indexOf(".")); //1
            this.estimatedMonths.sendKeys(estimatedMonths);
        }


        Thread.sleep(1000);
        greenBtn.click();

    }


    private void fillOutAddressInfo(Map<String,String>data) {
        String adress1 = data.get("adress1");
        addressOne.sendKeys(adress1);

        String adress2 = data.get("adress2");
        addressTwo.sendKeys(adress2);
        String cityVillage1 = data.get("cityVillage");
        city.sendKeys(cityVillage1);
        String stateProvince1 = data.get("stateProvince");
        state.sendKeys(stateProvince1);
        String country1 = data.get("country");
        country.sendKeys(country1);
        String postalCode1 = data.get("postalCode");
        postalCode.sendKeys(postalCode1);
        greenBtn.click();


        String phoneNumber1 = data.get("phoneNumber");
        phoneNumber.sendKeys(phoneNumber1);
        greenBtn.click();





    }

    private void fillOutRelationshipInfo(Map<String,String>data) {
        Select select = new Select(patientRelated);
        select.selectByVisibleText(data.get("relationshipType"));

        personNameRelated.sendKeys(data.get("personName"));
        greenBtn.click();



    }

    private void ConfirmationDetails(Map<String,String>data){

        for (int i = 0; i <confirmationList.size(); i++) {


        }


    }





    public void fillOutPatientInfo(Map<String, String> data) throws InterruptedException {
        fillOutDemographics(data);
        fillOutAddressInfo(data);
        fillOutRelationshipInfo(data);

    }



}
