package Pom;

import BaseClass.ReporterOutput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class NavigationPage {


    WebDriver driver;
    By subcategoryheader = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/h1/span[1]");


    //Wait method for link text
    public WebElement waitMethod(String linkText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("" + linkText + "")));
        return element;
    }

    public NavigationPage(WebDriver driver) {
        this.driver = driver;

    }

    public void hoverovercategory(String name) {
        ReporterOutput.ReporterLog("Hovering over category " +name );

        WebElement element = driver.findElement(By.linkText("" + name + ""));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void hoverovercategoryandClickSubCategory(String category, String subcategory) {

        ReporterOutput.ReporterLog("Selecting subcategory " +subcategory+ " under category "+category );

        //Selecting Category
        WebElement element = driver.findElement(By.linkText("" + category + ""));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();


        //Selecting sub category
        waitMethod(subcategory);
        WebElement elements = driver.findElement(By.linkText("" + subcategory + ""));
        Actions actions = new Actions(driver);
        actions.moveToElement(elements).click().perform();
        assertTrue(subcategory.equalsIgnoreCase(driver.findElement(subcategoryheader).getText().trim()));
    }

    public void iteratethroughcategories(String categories){

        ReporterOutput.ReporterLog("Iterating through categories " +categories);


        ArrayList aList= new ArrayList(Arrays.asList(categories.split(",")));

        for(int i=0;i<aList.size();i++)
        {
            hoverovercategory((String) aList.get(i));
        }
    }


}


