package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class AddtoCartPage {


    WebDriver driver;
    By addtoCartButton = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span");
    By itemPrice = By.xpath("//*[@id=\"our_price_display\"]");
    By itemwanted = By.xpath("//*[@id=\"quantity_wanted\"]");


    public WebElement waitMethod(By Xpath)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Xpath));
        return element;
    }

    public AddtoCartPage(WebDriver driver) {
        this.driver = driver;

    }

    public void itemsWanted(String quantity){
        waitMethod(itemwanted);
        driver.findElement(itemwanted).clear();
        driver.findElement(itemwanted).sendKeys(quantity);
    }

    public void addtoCart() {
        driver.findElement(addtoCartButton).click();
    }

    public String oneItemPrice(){
        waitMethod(itemPrice);
        String priceOfOneItem = driver.findElement(itemPrice).getText();
        System.out.println("Total Product value : "+priceOfOneItem);
        return priceOfOneItem;
    }


}


