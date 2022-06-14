package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class PatientDetailsPage {

    private WebDriver driver;
    private SoftAssert softAssert;
    private WebDriverWait wait;

    public PatientDetailsPage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[contains(@class,'col-sm-auto')]//span/span")
    private List<WebElement> topSectionName;

    @FindBy(xpath = "//div[contains(@class,'gender-age')]//span[1]")
    private WebElement topSectionGender;

    @FindBy(xpath = "//div[contains(@class,'gender-age')]//span[2]")
    private WebElement topSectionDob;

    @FindBy(xpath = "//div[@class='float-sm-right']//span")
    private WebElement topSectionID;

    @FindBy(className = "icon-sticky-note")
    private WebElement yellowStickyNote;

    @FindBy(xpath = "//textarea[contains(@class,'editable-has-buttons')]")
    private WebElement textBox;

    @FindBy(xpath = "//button[contains(@class,'btn-primary')]")
    private WebElement noteCheckMark;

    @FindBy(xpath = "//div[contains(@class,'toast-container')]")
    private WebElement successfullyAdded;


    @FindBy(xpath = "//div[@class='info-header']")
    private List<WebElement> headerList;

    @FindBy(xpath = "//ul[@class='float-left']//li")
    private List<WebElement> generalActionsList;

    @FindBy(xpath = "//i[contains(@class,'icon-home')]")
    private WebElement goHomeBtn;




    public void verfiyingPatientsDetails(Map<String, String> data){
        verifyTopSections(data);
        verifyListsOfInfo(data);
    }


    private void verifyTopSections(Map<String, String> data) {
        for (int i = 0; i < topSectionName.size(); i++) {

            softAssert.assertEquals(topSectionName.get(0).getText().trim(), data.get("givenName"));
            softAssert.assertEquals(topSectionName.get(1).getText().trim(), data.get("familyName"));
        }

        softAssert.assertEquals(topSectionGender.getText().trim(), data.get("gender"));
        if (data.get("ifDob").equalsIgnoreCase("y")) {
            softAssert.assertEquals(topSectionDob.getText().split(" ")[2].trim(), data.get("dateOfBirth").replace("-", "."));
    }else {
            softAssert.assertEquals(topSectionDob.getText().split(" ")[0].trim(), data.get("estimatedYears")+"year(s)");
            softAssert.assertEquals(topSectionDob.getText().split(" ")[0].trim(), data.get("estimatedMonths")+"month(s)" );

            softAssert.assertTrue(topSectionID.isDisplayed());

            softAssert.assertTrue(yellowStickyNote.isDisplayed());
            yellowStickyNote.click();

            textBox.sendKeys(data.get("randomMessages"));
            noteCheckMark.click();

            softAssert.assertTrue(successfullyAdded.isDisplayed());
            softAssert.assertEquals(successfullyAdded.getText().trim(), "Patient note successfully saved");



        }


    }


    private void verifyListsOfInfo(Map<String, String> data){
        for (int i = 0; i < headerList.size(); i++) {
            softAssert.assertEquals(headerList.get(i).getText().trim(), data.get("headerList").split(",")[i].trim());
        }
        for (int i = 0; i < generalActionsList.size(); i++) {
            softAssert.assertEquals(generalActionsList.get(i).getText().trim(), data.get("generalActions").split(",")[i].trim());
        }

        softAssert.assertTrue(goHomeBtn.isDisplayed());
        goHomeBtn.click();

    }
}