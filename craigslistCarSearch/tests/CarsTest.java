package com.test.craigslistCarSearch.tests;

import com.test.craigslistCarSearch.pages.CarsPage;
import com.test.craigslistCarSearch.pages.MainPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CarsTest extends TestBase {
    @DataProvider(name = "carSearchData")
    public Object[][] carSearchData() {
        return new Object[][] {
                {"Honda", 4000, 15000, "60459", "2010", "201"},
                {"Nissan", 4000, 15000, "60459", "2010", "201"},
                {"Toyota", 4000, 15000, "60459", "2010", "201"},
                {"", 4000, 15000, "60459", "2010", "201"}
        };
    }
    @Test(dataProvider = "carSearchData")
    public void searchCar(String make, int minPrice, int maxPrice, String zipCode, String minAutoYear, String milesFromLocation) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnCarsBTN();
        CarsPage carsPage = new CarsPage(driver);
        carsPage.searchSetUP(minPrice, maxPrice, make, zipCode, minAutoYear, milesFromLocation);
        carsPage.collectCarsInfo(driver);
    }


}
