package Pom;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {

    WebDriver driver;
    By Header = By.xpath("//h1");
    By yourLogo = By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[1]/a/img");
    By searchBox = By.xpath("//*[@id=\"search_query_top\"]");
    By searchButton = By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[2]/form/button");
    By signInButton = By.xpath("/html/body/div[1]/div[1]/header/div[2]/div/div/nav/div[1]/a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitMethod(By Xpath)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Xpath));
        return element;
    }


    public void veryHeader() {
        assertEquals("Automation Practice Website", driver.findElement(Header).getText().trim(),"Could not find header text");
    }

    public void clickOnYourLogo() {
        driver.findElement(yourLogo).click();
    }

    public void clickOnSearchBox() {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).click();
    }

    public void  clickonSignInButton(){
        driver.findElement(signInButton).click();
    }

    public void searchOnSearchBox(String Search) {
        driver.findElement(searchBox).sendKeys(Search);
    }

    public void clickOnSearchButton() {
        driver.findElement(searchButton).click();
    }

}


