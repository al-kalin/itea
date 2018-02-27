import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Predicates.equalTo;
import static java.lang.Thread.sleep;

public class LinkedinSerchTest {
    WebDriver driver;

    //метод который срабатывает перед основным кодом -запускает браузер, открывает нужный урл.
    @BeforeMethod
    public void beforTest() {
        driver = new FirefoxDriver();
        //штука которая ждет появления элементов перед тем как нажимать их или тп
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.linkedin.com");
    }
    //метод который выполняется после основного кода- закрывает браузер.
    @AfterMethod
    public void afterTest() {
        driver.close();
    }

    @Test
    public void basicSearchTest() throws InterruptedException {
        LinkedinLoginPage loginPage = new LinkedinLoginPage(driver);
        loginPage.loginAs("alkalin.qa@gmail.com", "Qweasd#1324");

        String searchTerm = "hr";

        WebElement searchField = driver.findElement(By.xpath(".//artdeco-typeahead-input/input"));
        searchField.sendKeys(searchTerm + "\n");
        //search from Nikolay
        //String searchTerm = "HR";
        //driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(searchTerm);
        //driver.findElement(By.xpath("//*[@type='search-icon']")).click();

        //находим наши 10 элементов и убеждаемся что их 10
        List<WebElement> results = driver.findElements(By.xpath("//li[contains(@class,'search-result__occluded-item')]"));
        Assert.assertEquals(results.size(), 10, "Number of results is wrong");
        //[contains(@class,'search-result__occluded-item')] xpath запрос который говорит что мы ищем ли с классом который содержит
        //в своем название текст "search-result__occluded-item"
        // скролим по элементам
        for (int i = 0; i < results.size(); i++) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", results.get(i));
        }

        List<WebElement> cardTitles = driver.findElements(By.xpath("//li[contains(@class,'search-result__occluded-item')]//span[contains(@class, 'actor-name')]"));

        for (int i = 1; i <= cardTitles.size(); i++) {
            String cardTitle = driver.findElement(By.xpath("//li[contains(@class,'search-result__occluded-item')][" +i+ "]//span[contains(@class, 'actor-name')]")).getText();
            System.out.println(cardTitle);
            Assert.assertTrue(cardTitle.toLowerCase().contains(searchTerm),"Searchterm "+searchTerm+ " not found in cart ");
        }


        //for (int i = 1; i < cardTitles.size(); i++) {
        //  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", cardTitles.get(i));

        //String cardTitle = driver.findElement(By.xpath("//li[contains(@class,'search-result__occluded-item')][" + i + "]//span[contains(@class, 'actor-name')]")).getText();
        //System.out.println(cardTitle);
        //Assert.assertTrue(cardTitle.contains(searchTerm.toLowerCase()),
        //       "Searchterm "+searchTerm+ "not found in cart number"+ Integer.toString(i));
        // }
        // WebElement webElement = driver.findElement(By.xpath('//li[contains(@class, 'search-result__occluded-item')])');

        //int countResult = driver.findElements(By.xpath(".//li[@class='search-result search-result__occluded-item ember-view']")).size();
        //System.out.println(countResult);
        //Assert.assertEquals("HR", driver.findElement(By.xpath(".//p[@class='subline-level-1 Sans-15px-black-85% search-result__truncate']")).getText());
        //WebDriver a = driver.findElement(By.xpath(".//p[@class='subline-level-1 Sans-15px-black-85% search-result__truncate']").getText());
        //Assert.assertTrue(a.contains("HR"));
        //}
        //import org.testng.annotations.AfterMethod;
        //import org.testng.annotations.BeforeMethod;
        //import org.testng.annotations.Test;

        //List<WebElement> results = driver.findElements(By.xpath("//li[contains(@class,'search-result__occluded-item')]"));
        //int currentResultsNumber = results.size();
        //Assert.assertEquals(results.size(), 10, "Number of results is wrong");
    }
}
