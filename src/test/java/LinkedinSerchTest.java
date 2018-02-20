
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.Thread.sleep;

public class LinkedinSerchTest {
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
    public void basicSearchTest(){
        LinkedinLoginPage loginPage = new LinkedinLoginPage(driver);
        loginPage.loginAs("alkalin.qa@gmail.com", "Qweasd#1324");


        // search
        //input [@placeholder="Search"]
        //*{}\\[@type='search-icon']
        //div[contains(@class, 'search-result-person')]
        //WebElement searchField = driver.findElement(By.class("nav-search-typeahead"));
        //searchField.sendKeys("HR");

    }
}
