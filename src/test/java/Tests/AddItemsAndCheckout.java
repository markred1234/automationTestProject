package Tests;


import BaseClass.*;
import Pom.*;
import org.testng.annotations.Test;


public class AddItemsAndCheckout extends BaseClass {

    HomePage objHomePage;
    SignInPage objSignInPage;
    MyAccountPage objMyAccountPage;
    SearchResultsPage objSearchResultsPage;
    AddtoCartPage objAddtoCartPage;
    ProceedToCheckOutPage objProccedToCheckOutPage;
    ConfirmOrderPage objConfirmOrderPage;


    @Test
    public void SignIntoAccount() {

        objSignInPage = new SignInPage(driver);
        objHomePage = new HomePage(driver);
        objMyAccountPage = new MyAccountPage(driver);
        objSearchResultsPage = new SearchResultsPage(driver);
        objProccedToCheckOutPage = new ProceedToCheckOutPage(driver);
        objAddtoCartPage = new AddtoCartPage(driver);
        objConfirmOrderPage = new ConfirmOrderPage(driver);
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
        objAddtoCartPage.itemsWanted(productQuantity);
        objAddtoCartPage.addtoCart();
        objProccedToCheckOutPage.clickCheckout();

        objProccedToCheckOutPage.confirmCheckoutPagePopup();

        //Performs a calculation based on sum of shipping, quantity and product value
        calculation.CalculateTotal(objProccedToCheckOutPage.shippingTotal(),objAddtoCartPage.oneItemPrice(),objProccedToCheckOutPage.goodsTotal(),productQuantity);

        objProccedToCheckOutPage.clickProceedToCheckout();
        objProccedToCheckOutPage.confirmCheckOutPage();

        calculation.CalculateTotal(objConfirmOrderPage.totalShippingPrice(),objConfirmOrderPage.priceofProduct(),objConfirmOrderPage.totalOrderPrice(),productQuantity);


    }


}
