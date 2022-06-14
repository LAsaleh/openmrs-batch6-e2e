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

public class FindPatientRecordPage {

    private WebDriver driver;
    private SoftAssert softAssert;
    private WebDriverWait wait;


    public FindPatientRecordPage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@id='apps']//a")
        private List<WebElement> homePageFunctionality;

    @FindBy(id = "breadcrumbs")
    private WebElement topPatientsRecord;

    @FindBy(id = "patient-search")
    private WebElement patientsIdInput;

    @FindBy(xpath = "//tr[@class='odd']/td[1]")
    private WebElement firstPatientId;

    @FindBy(xpath = "//tr[@class='odd']//td")
    private List<WebElement> firstTableResult;

    @FindBy(xpath = "//i[contains(@class,'icon-home')]")
    private WebElement goHomeBtn;



public void verifyNewPatientTable() throws InterruptedException {

    homePageFunctionality.get(0).click();

    softAssert.assertEquals(driver.getTitle().trim(), "OpenMRS Electronic Medical Record");
    softAssert.assertTrue(topPatientsRecord.isDisplayed());

    String patientIdSaved = firstPatientId.getText().trim();
    patientsIdInput.sendKeys(patientIdSaved);


    for (int i = 0; i < firstTableResult.size(); i++) {
        softAssert.assertEquals(firstTableResult.get(i).getText().trim(), 5);

    }

    softAssert.assertTrue(goHomeBtn.isDisplayed());
    goHomeBtn.click();

    Thread.sleep(3000);
    driver.close();


    }


}







