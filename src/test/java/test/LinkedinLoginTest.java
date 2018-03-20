package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedinBasePage;
import page.LinkedinHomePage;
import page.LinkedinLandingPage;
import page.LinkedinLoginPage;

public class LinkedinLoginTest extends LinkedinBaseTest {
    WebDriver driver;

    String initialPageTitle;
    String initialPageUrl;

    @DataProvider
    public Object[][] successfullTestCredentials() {
        return new Object[][]{
                {"alkalin.qa@gmail.com", "Qweasd#1324"},
                {"ALKALIN.QA@GMAIL.COM", "Qweasd#1324"}};
    }

    @Test(dataProvider = "successfullTestCredentials")
    public void successfullLoginTest(String email, String password) {
        String initialPageTitle = landingPage.getPageTitle();
        String initialPageUrl = landingPage.getPageUrl();

        //Assert.assertEquals(initialPageTitle, "LinkedIn: Log In or Sign Up",
        //      "Login page title is wrong"); (work if you on en version)

        LinkedinHomePage homePage = landingPage.loginAs(email, password);
        Assert.assertTrue(homePage.isSignedIn(), "User is not signed in");

        Assert.assertNotEquals(homePage.getPageTitle(), initialPageTitle,
                "Page title did not change after login");

        Assert.assertNotEquals(homePage.getPageUrl(), initialPageUrl,
                "Page url did not change after login");
    }

   /* @DataProvider
    public Object[][] negativTestCredentials() {
        return new Object[][]{
                //валидация имэйла
                {"qwe@qwe.qwe", "id = "session_key-login-error"},
                        //
                {"xyz", "xyz"}};

    }

    @Test(dataProvider = "negativTestCredentials")
    public void negativLoginTest(String email, String password) {
        String initialPageTitle = landingPage.getPageTitle();
        String initialPageUrl = landingPage.getPageUrl();
        LinkedinLoginPage loginPage = landingPage.loginAs(email, password);

        Assert.assertTrue(loginPage.isNotSignedIn(), "Alert massage is not displayed");

        Assert.assertNotEquals(loginPage.getPageTitle(), initialPageTitle,
                "Page title did not change after login");

        Assert.assertNotEquals(loginPage.getPageUrl(), initialPageUrl,
                "Page url did not change after login");
    }
}

























































    /*@DataProvider
    public Object[][] negativeTestCredentialsReturnToLanding(){
        return new Object[][]{
                {"", ""},
                {"iteatest@i.ua", ""},
                {"", "1q2w3e_4r5t"}};
    }
    @Test(dataProvider = "negativeTestCredentialsReturnToLanding")
    public void negativeTestCredentialsReturnToLanding(String email, String password) {
        linkedinLandingPage.loginAs(email, password);
        Assert.assertEquals(linkedinLandingPage.getPageTitle(), initialPageTitle, "Page title did not change after login");
    }

    @DataProvider
    public Object[][] negativeTestCredentialsReturnToLoginPage(){
        return new Object[][]{
                {"xyzxyz", "xyz", "Please enter a valid email address.", "The password you provided must have at least 6 characters."}};
    }
    @Test(dataProvider = "negativeTestCredentialsReturnToLoginPage")
    public void negativeTestCredentialsReturnToLoginPage(String email, String password, String emailAlert, String passwordAlert) {
        LinkedinLoginPage linkedinLoginPage = linkedinLandingPage.loginAs(email, password);
        Assert.assertTrue(linkedinLoginPage.isNotSignedIn(), "Alert massage is not displayed");
        Assert.assertNotEquals(linkedinLoginPage.getPageTitle(), initialPageTitle, "Page title did not change after login");
        Assert.assertEquals(linkedinLoginPage.getEmailErrorMassage(), emailAlert, "Email alert message is not displayed");
        Assert.assertEquals(linkedinLoginPage.getPasswordErrorMassage(), passwordAlert, "Password alert message is not displayed");
    }

    @DataProvider
    public Object[][] negativeLoginTestWithoutRightPassword(){
        return new Object[][]{
                {"iteatest@i.ua", "xyzzyx", "Hmm, that's not the right password. Please try again or request a new one."}};
    }
    @Test(dataProvider = "negativeLoginTestWithoutRightPassword")
    public void negativeLoginTestWithoutRightPassword(String email, String password, String passwordAlert) {
        LinkedinLoginPage linkedinLoginPage = linkedinLandingPage.loginAs(email, password);
        Assert.assertTrue(linkedinLoginPage.isNotSignedIn(), "Alert massage is not displayed");
        Assert.assertNotEquals(linkedinLoginPage.getPageTitle(), initialPageTitle, "Page title did not change after login");
        Assert.assertEquals(linkedinLoginPage.getPasswordErrorMassage(), passwordAlert, "Password alert message is not displayed");
    }

    @DataProvider
    public Object[][] negativeTestWithDomainSuggestionMessage(){
        return new Object[][]{
                {"iteatest@i.u", "1q2w3e_4r5t"}};
    }
    @Test(dataProvider = "negativeTestWithDomainSuggestionMessage")
    public void negativeTestWithDomainSuggestionMessage(String email, String password) {
        LinkedinLoginPage linkedinLoginPage = linkedinLandingPage.loginAs(email, password);
        Assert.assertTrue(linkedinLoginPage.isNotSignedIn(), "Alert massage is not displayed");
        Assert.assertNotEquals(linkedinLoginPage.getPageTitle(), initialPageTitle, "Page title did not change after login");
        Assert.assertTrue(linkedinLoginPage.isDomainSuggestionDisplayed(), "Domain suggestion message is not displayed");

    }
}*/
}
