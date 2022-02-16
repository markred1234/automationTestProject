package Pom;

import BaseClass.ReporterOutput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class MyAccountPage {

    WebDriver driver;
    By myAccount = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/h1");
    By myAccountWelcome = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p");

    public WebElement waitMethod(By Xpath)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Xpath));
        return element;
    }


    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifymyAccount() {
        ReporterOutput.ReporterLog("Verifying the correct page is loaded");
        waitMethod(myAccount);
        assertEquals("MY ACCOUNT", driver.findElement(myAccount).getText().trim(), "Could not text");
    }

    public void verifymyAccountWelcome() {
        ReporterOutput.ReporterLog("Verifying the correct page is loaded");
        assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", driver.findElement(myAccountWelcome).getText().trim(), "Could not text");
    }

}


