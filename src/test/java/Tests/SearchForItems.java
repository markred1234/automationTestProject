package Tests;


import BaseClass.BaseClass;
import Pom.HomePage;
import Pom.SearchResultsPage;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class SearchForItems extends BaseClass {

    HomePage objHomePage;
    SearchResultsPage objSearchResultsPage;



    @Test
    public void SearchforItems() {

        objSearchResultsPage = new SearchResultsPage(driver);
        objHomePage = new HomePage(driver);

        objHomePage.veryHeader();

        String SearchCriteria = "Faded Short Sleeve T-shirts,Printed Chiffon Dress,Blouse";

        ArrayList aList= new ArrayList(Arrays.asList(SearchCriteria.split(",")));

        for(int i=0;i<aList.size();i++)
        {
            objHomePage.clickOnSearchBox();
            objHomePage.searchOnSearchBox((String) aList.get(i));
            objHomePage.clickOnSearchButton();
            objSearchResultsPage.searchResults((String) aList.get(i));
        }


    }


}
