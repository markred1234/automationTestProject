package Pom;

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
    String moreProductdetails = "/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/div[2]/a[1]/span";
    By addtoCartButton = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span");


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
        assertEquals(searchfor, driver.findElement(searchResults).getText().trim(), "Could not search criteria");
    }

    public void itemClick() {

        driver.findElement(searchResults).click();

    }

    public void addtoCart() {
        driver.findElement(addtoCartButton).click();
    }


}


