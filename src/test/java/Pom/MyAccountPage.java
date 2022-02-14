package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;


public class MyAccountPage {

    WebDriver driver;
    By myAccount = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/h1");
    By myAccountWelcome = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p");
    By signInButton = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button/span");


    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifymyAccount() {
        assertEquals("MY ACCOUNT", driver.findElement(myAccount).getText().trim(), "Could not text");
    }

    public void verifymyAccountWelcome() {
        assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", driver.findElement(myAccountWelcome).getText().trim(), "Could not text");
    }

}


