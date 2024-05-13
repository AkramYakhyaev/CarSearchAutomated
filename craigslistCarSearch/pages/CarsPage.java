package com.test.craigslistCarSearch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class CarsPage {
    public CarsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@enterkeyhint='search']")
    WebElement searchField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchBTN;

    @FindBy(xpath = "(//input[@placeholder='min'])[1]")
    WebElement minPrice;

    @FindBy(xpath = "(//input[@placeholder='max'])[1]")
    WebElement maxPrice;

    @FindBy(xpath = "//input[@name='bundleDuplicates']")
    WebElement hideDuplicates;

    @FindBy(xpath = "//input[@name='postedToday']")
    WebElement postedToday;

    @FindBy(xpath = "//button[.=contains(text(),'owner')]")
    WebElement soldByOwner;

    @FindBy(xpath = "//input[@name='auto_make_model']")
    WebElement makeAndModel;

    @FindBy(xpath = "//span[.=contains(text(),'apply')]")
    WebElement applyBTN;


    @FindBy(xpath = "//input[@placeholder='miles']")
    WebElement milesFromLocation;
    @FindBy(xpath = "//input[@placeholder='from zip']")
    WebElement fromZipcode;
    @FindBy(xpath = "//input[@name='min_auto_year']")
    WebElement minAutoYear;
    @FindBy(xpath = "//a[@class='cl-app-anchor text-only posting-title']")
    List<WebElement> carsURL;

    @FindBy(xpath = "//span[@class='priceinfo']")
    List<WebElement> carsPrice;
    @FindBy(xpath = "//a[@class='cl-app-anchor text-only posting-title']")
    List<WebElement> carsName;
    @FindBy(xpath = "//p[@class='no-results']")
    WebElement noPostings;

    public void searchSetUP(int minMoney, int maxMoney, String makeModel, String zipCode,
                            String minAutoYear, String milesFromLocation) throws InterruptedException {
        soldByOwner.click();
        postedToday.click();
        assertTrue(postedToday.isSelected());
        Thread.sleep(2000);
        hideDuplicates.click();
        assertTrue(hideDuplicates.isSelected());
        this.milesFromLocation.sendKeys(milesFromLocation);
        fromZipcode.sendKeys(zipCode);
        Thread.sleep(2000);
        maxPrice.sendKeys(String.valueOf(maxMoney));
        minPrice.sendKeys(String.valueOf(minMoney));
        makeAndModel.sendKeys(makeModel);
        Thread.sleep(2000);
        this.minAutoYear.sendKeys(minAutoYear);



    }


    public List<String> getCarAttributes(List<WebElement> elements, String attribute) {
        List<String> attributes = new ArrayList<>();
        for (WebElement element : elements) {
            if ("href".equalsIgnoreCase(attribute)) {
                attributes.add(element.getAttribute("href"));
            } else if ("text".equalsIgnoreCase(attribute)) {
                attributes.add(element.getText());
            }
        }
        return attributes;
    }


    public void collectCarsInfo(WebDriver driver) {
        // Click Apply button to perform the search
        applyBTN.click();

        // Wait for the search results to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='no-results']")));

        // Check if the element indicating no postings is present
        if (noPostings.isDisplayed()) {
            System.out.println("No postings found for this search.");
            return;
        }

        // Once the search results are loaded, collect the URLs, prices, and names
        List<String> urls = getCarAttributes(carsURL, "href");
        List<String> prices = getCarAttributes(carsPrice, "text");
        List<String> names = getCarAttributes(carsName, "text");

        // Print or log the collected information
        for (int i = 0; i < urls.size(); i++) {
            System.out.println(names.get(i) + ", Price: " + prices.get(i) + ", URL: " + urls.get(i));
        }
    }

}









