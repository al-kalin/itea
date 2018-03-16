package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedinBasePage;
import page.LinkedinHomePage;
import page.LinkedinLandingPage;
import page.LinkedinLoginPage;

public class LinkedinLoginTest {
    WebDriver driver;
    LinkedinLandingPage landingPage;
    String initialPageTitle;
    String initialPageUrl;

    @BeforeMethod
    public void beforTest() {
        driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com");
        landingPage = new LinkedinLandingPage(driver);
        initialPageTitle = landingPage.getPageTitle();
        initialPageUrl = landingPage.getPageUrl();
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
    }

    @Test
    public void successfullLoginTest() {

        //Assert.assertEquals(initialPageTitle, "LinkedIn: Log In or Sign Up",
          //      "Login page title is wrong"); (work if you on en version)

        LinkedinHomePage homePage = landingPage.loginAs("alkalin.qa@gmail.com", "Qweasd#1324");
        Assert.assertTrue(homePage.isSignedIn(), "User is not signed in");

        Assert.assertNotEquals(homePage.getPageTitle(), initialPageTitle,
                "Page title did not change after login");

        Assert.assertNotEquals(homePage.getPageUrl(), initialPageUrl,
                "Page url did not change after login");
    }

    @Test
    public void negativLoginTest() {
        LinkedinLoginPage loginPage = landingPage.loginAs("test@ukr.net", "12345");

        Assert.assertTrue(loginPage.isNotSignedIn(), "Alert massage is not displayed");
        //Assert.assertNotEquals(homePage.isSignedIn(), "User is not signed in");

        Assert.assertNotEquals(loginPage.getPageTitle(), initialPageTitle,
                "Page title did not change after login");

        Assert.assertNotEquals(loginPage.getPageUrl(), initialPageUrl,
                "Page url did not change after login");
    }
}
