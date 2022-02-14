package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;


public class SignInPage {

    WebDriver driver;
    By userName = By.xpath("//*[@id=\"email\"]");
    By password = By.xpath("//*[@id=\"passwd\"]");
    By signInButton = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button/span");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void authUsernamePassword(String Username, String Password) {
        driver.findElement(userName).sendKeys(Username);
        driver.findElement(password).sendKeys(Password);
    }

    public void clickOnSignInButton() {
        driver.findElement(signInButton).click();
    }

}


