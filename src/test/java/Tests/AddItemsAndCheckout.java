package Tests;


import BaseClass.*;
import Pom.*;
import org.testng.annotations.Test;


public class AddItemsAndCheckout extends BaseClass {

    HomePage objHomePage;
    SignInPage objSignInPage;
    MyAccountPage objMyAccountPage;
    SearchResultsPage objSearchResultsPage;
    ProceedToCheckOutPage objProccedToCheckOutPage;


    @Test
    public void SignIntoAccount() throws InterruptedException {

        objSignInPage = new SignInPage(driver);
        objHomePage = new HomePage(driver);
        objMyAccountPage = new MyAccountPage(driver);
        objSearchResultsPage = new SearchResultsPage(driver);
        objProccedToCheckOutPage = new ProceedToCheckOutPage(driver);
        Calculation calculation = new Calculation();

        objHomePage.veryHeader();
        objHomePage.clickonSignInButton();

        objSignInPage.authUsernamePassword(userName, password);
        objSignInPage.clickOnSignInButton();
        objMyAccountPage.verifymyAccount();
        objMyAccountPage.verifymyAccountWelcome();

        objHomePage.searchOnSearchBox(item);
        objHomePage.clickOnSearchButton();
        objSearchResultsPage.searchResults(item);

        objSearchResultsPage.itemClick();
        objSearchResultsPage.addtoCart();
        objProccedToCheckOutPage.clickCheckout();

        objProccedToCheckOutPage.confirmCheckoutPagePopup();

        calculation.CalculateTotal(objProccedToCheckOutPage.productTotalValue(),objProccedToCheckOutPage.shippingTotal(),objProccedToCheckOutPage.goodsTotal());
        objProccedToCheckOutPage.goodsTotal();

        objProccedToCheckOutPage.clickProceedToCheckout();
        objProccedToCheckOutPage.confirmCheckOutPage();


    }


}
