package Pom;

import BaseClass.ReporterOutput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class SignInPage {

    WebDriver driver;
    By userName = By.xpath("//*[@id=\"email\"]");
    By password = By.xpath("//*[@id=\"passwd\"]");
    By signInButton = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button/span");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitMethod(By Xpath)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Xpath));
        return element;
    }


    public void authUsernamePassword(String Username, String Password) {
        ReporterOutput.ReporterLog("Entering username " +userName + " password "+ password);
        waitMethod(userName);
        driver.findElement(userName).sendKeys(Username);
        driver.findElement(password).sendKeys(Password);
    }

    public void clickOnSignInButton() {
        ReporterOutput.ReporterLog("Clicking on sign in button");
        driver.findElement(signInButton).click();
    }

}


