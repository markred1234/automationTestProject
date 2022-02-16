package Tests;


import BaseClass.BaseClass;
import Pom.HomePage;
import Pom.NavigationPage;
import Pom.SearchResultsPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class Navigation extends BaseClass {

    HomePage objHomePage;

    NavigationPage objNavigationPage;

    @Test
    public void MenuNavigation() throws InterruptedException {

        objNavigationPage = new NavigationPage(driver);
        objHomePage = new HomePage(driver);

        objHomePage.veryHeader();

        //Getting data from global properties file
        objNavigationPage.iteratethroughcategories(allCategories);

        //Getting data from global properties file
        objNavigationPage.hoverovercategoryandClickSubCategory(category,subcategory);


    }


}
