import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    WebDriver driver;

    @BeforeClass
    public void beforClass() {

    }

    @AfterClass
    public void afterClass() {

    }

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
    public void successfullLoginTest() throws InterruptedException {
        String initialPageTitle = driver.getTitle();
        String initialPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(driver.getTitle(), "Крупнейшая в мире сеть профессиональных контактов | LinkedIn", "Login page title is wrong");
        //WebElement emailField = driver.findElement(By.xpath("//*[@id='login-email']"))  13-14 строки идентичны
        WebElement emailField = driver.findElement(By.id("login-email"));
        WebElement passwordField = driver.findElement(By.id("login-password"));
        WebElement signInButton = driver.findElement(By.id("login-submit"));

        emailField.sendKeys("alkalin.qa@gmail.com");
        passwordField.sendKeys("Qweasd#1324");
        signInButton.click();
        sleep(5000);
        WebElement helloMessage = driver.findElement(By.xpath("//a[@href='/in/alkalin-qa-99903315a/']"));
        Assert.assertTrue(helloMessage.isDisplayed(),"Hello message is not displayed");
        WebElement userIcon = driver.findElement(By.id("profile-nav-item"));
        Assert.assertTrue(userIcon.isDisplayed(),"user icon was not displayed");

        //Assert.assertNotEquals(driver.getTitle(), initialPageTitle, "Page title did not change after login");
        Assert.assertFalse(driver.getTitle().equals(initialPageTitle), "Page title did not change after login");

        Assert.assertNotEquals(driver.getCurrentUrl(), initialPageUrl, "Page url did not change after login");
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
