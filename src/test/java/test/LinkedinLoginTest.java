package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedinBasePage;
import page.LinkedinHomePage;
import page.LinkedinLandingPage;

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
          //      "Login page title is wrong");

        LinkedinHomePage homePage = landingPage.loginAs("alkalin.qa@gmail.com", "Qweasd#1324");
        Assert.assertNotEquals(homePage.isSignedIn(), "User is not signed in");

        Assert.assertNotEquals(homePage.getPageTitle(), initialPageTitle,
                "Page title did not change after login");

        Assert.assertNotEquals(homePage.getPageUrl(), initialPageUrl,
                "Page url did not change after login");
    }

    /*@Test
    public void negativLoginTest() {
        //Assert.assertEquals(initialPageTitle, "LinkedIn: Log In or Sign Up",
        //      "Login page title is wrong");

        page.LinkedinLandingPage loginPage = new page.LinkedinLandingPage(driver);



        LinkedinBasePage notHomePage = loginPage.loginAs("test@ukr.net", "12345");
        WebElement alertMessage = notHomePage.findElement(By.xpath("//div[@id='global-alert-queue']//strong[not(text()='')]"));
        Assert.assertTrue(alertMessage.isDisplayed(),"Alert message is not displayed");


        //Assert.assertNotEquals(homePage.isSignedIn(), "User is not signed in");

        Assert.assertNotEquals(notHomePage.getPageTitle(), initialPageTitle,
                "Page title did not change after login");

        Assert.assertNotEquals(notHomePage.getPageUrl(), initialPageUrl,
                "Page url did not change after login");
    }*/

}
