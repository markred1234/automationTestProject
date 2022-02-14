package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;


public class SearchResultsPage {

    WebDriver driver;
    By searchResults = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/h5/a");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchResults(String searchfor) {
        assertEquals(searchfor, driver.findElement(searchResults).getText().trim(),"Could not search criteria");
    }

}


