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

public class LinkedinSerchTest extends LinkedinBaseTest{

    /**
     * Test that verifies basic Search by specific Search term
     */
    @Test
    public void basicSearchTest() {
        String searchTerm = "hr";

        LinkedinHomePage homePage = landingPage.loginAs("alkalin.qa@gmail.com", "Qweasd#1324");
        LinkedinSearchPage searchPage = homePage.searchByTerm(searchTerm);
        List<String> results = searchPage.getResults();

        Assert.assertEquals(results.size(), 10, "Number of results is wrong");


        for (String result : results) {
            Assert.assertTrue(result.toLowerCase().contains(searchTerm),
                    "Searchterm "+searchTerm+ " not found in cart ");
        }

    }
}
