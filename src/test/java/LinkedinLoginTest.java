import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedinLoginTest {

    @Test
    public void successfullLoginTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com");
        //WebElement emailField = driver.findElement(By.xpath("//*[@id='login-email']"))  13-14 строки идентичны
        WebElement emailField = driver.findElement(By.id("login-email"));
        WebElement passwordField = driver.findElement(By.id("login-password"));
        WebElement signInButton = driver.findElement(By.id("login-submit"));

        emailField.sendKeys("alkalin.qa@gmail.com");
        passwordField.sendKeys("k4l1n14enk0");
        signInButton.click();
    }

    @Test
    public void negativLoginTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com");
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
