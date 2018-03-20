package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LinkedinLandingPage;

public class LinkedinBaseTest {
    WebDriver driver;
    LinkedinLandingPage landingPage;

    //метод который срабатывает перед основным кодом -запускает браузер, открывает нужный урл.
    @BeforeMethod
    public void beforTest() {
        driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com");
        landingPage = new LinkedinLandingPage(driver);
    }
    //метод который выполняется после основного кода- закрывает браузер.
    @AfterMethod
    public void afterTest() {
        driver.close();
    }
}
