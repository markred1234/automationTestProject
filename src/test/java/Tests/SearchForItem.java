package Tests;


import BaseClass.BaseClass;
import Pom.HomePage;
import Pom.SearchResultsPage;
import org.testng.annotations.Test;


public class SearchForItem extends BaseClass {

    HomePage objHomePage;
    SearchResultsPage objSearchResultsPage;

    @Test
    public void SearchforItem() {

        String SearchCriteria = "Faded Short Sleeve T-shirts";

        objSearchResultsPage = new SearchResultsPage(driver);
        objHomePage = new HomePage(driver);

        objHomePage.veryHeader();
        objHomePage.clickOnYourLogo();
        objHomePage.clickOnSearchBox();
        objHomePage.searchOnSearchBox(SearchCriteria);
        objHomePage.clickOnSearchButton();
        objSearchResultsPage.searchResults(SearchCriteria);

    }


}
