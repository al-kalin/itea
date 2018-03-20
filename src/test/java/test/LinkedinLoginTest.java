package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedinBasePage;
import page.LinkedinHomePage;
import page.LinkedinLandingPage;
import page.LinkedinLoginPage;

public class LinkedinLoginTest extends LinkedinBaseTest{
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

    @DataProvider
    public Object[][] negativTestCredentials() {
        return new Object[][]{
                {"", ""},
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
