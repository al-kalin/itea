package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedinHomePage;
import page.LinkedinLandingPage;
import page.LinkedinSearchPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinkedinSerchTest {
    WebDriver driver;
    LinkedinLandingPage landingPage;
    LinkedinHomePage homePage;
    LinkedinHomePage searchResultsPage;


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

    @Test
    public void basicSearchTest() throws InterruptedException {
        String searchTerm = "hr"
        LinkedinHomePage homePage = landingPage.loginAs("alkalin.qa@gmail.com", "Qweasd#1324");
        LinkedinSearchPage serchPage = homePage.searchByTerm(searchTerm);
        List<String> results = searchPage.getResults();

        Assert.assertEquals(results.size(), 10, "Number of results is wrong");
        Assert.assertTrue(searchPage.isSearchIn(), "User is not signed in");

        for (String result : results) {
            Assert.assertTrue(result.toLowerCase().contains(searchTerm),
                    "Searchterm "+searchTerm+ " not found in cart ");
        }

    }
}
