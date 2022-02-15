package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class ProceedToCheckOutPage {


    WebDriver driver;
    By checkOutButton = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button");
    By proccedToCheckout = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span");
    By cartDetail = By.xpath("/html/body/div/div[2]/div/div[3]/div/ul/li[1]/span");
    By checkoutPageConfirmation = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/h2");
    By totalForProducts = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[1]/span");
    By totalShipping = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[2]/span");
    By total = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[3]/span");



    public ProceedToCheckOutPage(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement waitMethod(By Xpath)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Xpath));
        return element;
    }

    public String productTotalValue(){
        String totalproductvalue = driver.findElement(totalForProducts).getText();
        System.out.println("Total Product value : "+totalproductvalue);

        return totalproductvalue;
    }

    public String shippingTotal(){
        String TotalShippingcosts = driver.findElement(totalShipping).getText();
        System.out.println("Total Shipping value : "+TotalShippingcosts);

        return TotalShippingcosts;
    }

    public String goodsTotal(){
        String totalForGoods = driver.findElement(total).getText();
        System.out.println("Total for goods : "+totalForGoods);

        return totalForGoods;
    }



    public void clickCheckout(){
        driver.findElement(checkOutButton).click();
    }

    public void clickProceedToCheckout(){
        waitMethod(proccedToCheckout);
        driver.findElement(proccedToCheckout).click();
    }

    public void confirmCheckoutPagePopup() {
        waitMethod(checkoutPageConfirmation);
        assertEquals(driver.findElement(checkoutPageConfirmation).getText().trim(),"Product successfully added to your shopping cart","Could not find text");
    }

    public void confirmCheckOutPage() {
        waitMethod(cartDetail);
        assertEquals("01. Summary", driver.findElement(cartDetail).getText().trim(),"Could not find text");
    }

}


