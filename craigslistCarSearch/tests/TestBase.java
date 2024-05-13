package com.test.craigslistCarSearch.tests;

import com.test.craigslistCarSearch.utils.BrowserUtils;
import com.test.craigslistCarSearch.utils.ConfigReader;
import com.test.craigslistCarSearch.utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("craigslist_URL"));
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.getScreenShot(driver, "Craiglist");
        //driver.quit();


    }
}
