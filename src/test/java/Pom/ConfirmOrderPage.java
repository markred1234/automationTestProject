package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ConfirmOrderPage {


    WebDriver driver;
    By totalPrice = By.xpath("//*[@id=\"total_price\"]");
    By totalShipping = By.xpath("//*[@id=\"total_shipping\"]");
    By priceOfOneProduct = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[4]/span/span");

    public WebElement waitMethod(By Xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Xpath));
        return element;
    }

    public ConfirmOrderPage(WebDriver driver) {
        this.driver = driver;

    }

    public String totalOrderPrice() {
        waitMethod(totalPrice);
        String priceOfOneItem = driver.findElement(totalPrice).getText();
        System.out.println("Total order value : " + priceOfOneItem);
        return priceOfOneItem;
    }

    public String totalShippingPrice() {
        waitMethod(totalShipping);
        String priceOfShipping = driver.findElement(totalShipping).getText();
        System.out.println("Total shipping value : " + priceOfShipping);
        return priceOfShipping;
    }

    public String priceofProduct() {
        waitMethod(priceOfOneProduct);
        String priceOfProduct = driver.findElement(priceOfOneProduct).getText();
        System.out.println("Total Product value : " + priceOfProduct);
        return priceOfProduct;
    }


}


