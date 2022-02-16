package Pom;

import BaseClass.ReporterOutput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class SearchResultsPage {


    WebDriver driver;
    By searchResults = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/h5/a");


    public WebElement waitMethod(By Xpath)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Xpath));
        return element;
    }

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;

    }

    public void searchResults(String searchfor) {
        ReporterOutput.ReporterLog("Confirming Search results for " + searchfor);

        waitMethod(searchResults);
        assertEquals(searchfor, driver.findElement(searchResults).getText().trim(), "Could not search criteria");
    }



    public void itemClick() {
        ReporterOutput.ReporterLog("Clicking on ITEM");
        waitMethod(searchResults);
        driver.findElement(searchResults).click();
    }



}


