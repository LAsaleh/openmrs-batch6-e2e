package com.academy.techcenture.e2e;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.config.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.RegisterPage;
import com.academy.techcenture.util.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class OpenMrsPatientRegistrationE2ETest {

    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("URL"));
        softAssert = new SoftAssert();
    }

    @Test(dataProvider = "data")
    public void testRun(Map<String,String > data) throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver, softAssert);
        HomePage homePage = new HomePage(driver, softAssert);
        RegisterPage registerPage = new RegisterPage(driver, softAssert);
        loginPage.logIn();
        homePage.verifyHomeActions();
        registerPage.fillOutPatientInfo(data);
    }

    @DataProvider(name="data")
    public Object[][] registration() {
        ExcelReader excelReadr = new ExcelReader("src/main/resources/testData/Data.xlsx", "data");
        return excelReadr.getData();
    }


    @AfterMethod
    public void clearUp(){
        if (driver != null){
            driver.quit();
        }
    }


}
