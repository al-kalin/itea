import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LinkedinLoginTest {
    WebDriver driver;

    @BeforeMethod
    public void beforTest() {
        driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
    }

    @Test
    public void successfullLoginTest() {
        LinkedinLoginPage loginPage = new LinkedinLoginPage(driver);

        String initialPageTitle = loginPage.getPageTitle();
        String initialPageUrl = loginPage.getPageUrl();

        //Assert.assertEquals(initialPageTitle, "LinkedIn: Log In or Sign Up",
          //      "Login page title is wrong");

        LinkedinBasePage homePage = loginPage.loginAs("alkalin.qa@gmail.com", "Qweasd#1324");
        Assert.assertNotEquals(homePage.isSignedIn(), "User is not signed in");

        Assert.assertNotEquals(homePage.getPageTitle(), initialPageTitle,
                "Page title did not change after login");

        Assert.assertNotEquals(homePage.getPageUrl(), initialPageUrl,
                "Page url did not change after login");
    }

    @Test
    public void negativLoginTest() {
        //WebElement emailField = driver.findElement(By.xpath("//*[@id='login-email']"))  13-14 строки идентичны
        WebElement emailField = driver.findElement(By.id("login-email"));
        WebElement passwordField = driver.findElement(By.id("login-password"));
        WebElement signInButton = driver.findElement(By.id("login-submit"));

        emailField.sendKeys("test@ukr.net");
        passwordField.sendKeys("12345");
        signInButton.click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[@id='global-alert-queue']//strong[not(text()='')]"));
        Assert.assertTrue(alertMessage.isDisplayed(),"Alert message is not displayed");
    }

}
