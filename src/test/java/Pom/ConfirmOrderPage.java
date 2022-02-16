package Pom;

import BaseClass.ReporterOutput;
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
        ReporterOutput.ReporterLog("Getting Total Order Price");
        waitMethod(totalPrice);
        String priceOfOneItem = driver.findElement(totalPrice).getText();
        ReporterOutput.ReporterLog("Total order value : " + priceOfOneItem);
        return priceOfOneItem;
    }

    public String totalShippingPrice() {
        ReporterOutput.ReporterLog("Getting total shipping price");
        waitMethod(totalShipping);
        String priceOfShipping = driver.findElement(totalShipping).getText();
        ReporterOutput.ReporterLog("Total shipping value : " + priceOfShipping);
        return priceOfShipping;
    }

    public String priceofProduct() {
        ReporterOutput.ReporterLog("Getting price of one product");
        waitMethod(priceOfOneProduct);
        String priceOfProduct = driver.findElement(priceOfOneProduct).getText();
        ReporterOutput.ReporterLog("Total Product value : " + priceOfProduct);
        return priceOfProduct;
    }


}


