package Tests;


import BaseClass.DataDriven;
import BaseClass.BaseClass;
import Pom.HomePage;
import Pom.SearchResultsPage;
import org.testng.annotations.Test;



public class SearchForItemsDataDriven extends BaseClass {

    HomePage objHomePage;
    SearchResultsPage objSearchResultsPage;


    @Test(priority = 1, dataProvider = "Product Search", dataProviderClass = DataDriven.class)
    public void SearchforItems(String Item) {

        objSearchResultsPage = new SearchResultsPage(driver);
        objHomePage = new HomePage(driver);

        objHomePage.clickOnSearchBox();
        objHomePage.searchOnSearchBox(Item);
        objHomePage.clickOnSearchButton();
        objSearchResultsPage.searchResults(Item);

    }


}
