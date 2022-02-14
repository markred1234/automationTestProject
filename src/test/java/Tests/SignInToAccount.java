package Tests;


import BaseClass.BaseClass;
import Pom.HomePage;
import Pom.MyAccountPage;
import Pom.SearchResultsPage;
import Pom.SignInPage;
import org.testng.annotations.Test;

import javax.swing.*;


public class SignInToAccount extends BaseClass {

    HomePage objHomePage;
    SignInPage objSignInPage;
    MyAccountPage objMyAccountPage;

    @Test
    public void SignIntoAccount() {

        objSignInPage = new SignInPage(driver);
        objHomePage = new HomePage(driver);
        objMyAccountPage = new MyAccountPage(driver);

        objHomePage.veryHeader();
        objHomePage.clickonSignInButton();

        objSignInPage.authUsernamePassword(userName, password);
        objSignInPage.clickOnSignInButton();
        objMyAccountPage.verifymyAccount();
        objMyAccountPage.verifymyAccountWelcome();


    }


}
