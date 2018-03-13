package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class LinkedinSearchPage extends LinkedinBasePage{

    @FindBy(xpath = "//li[contains(@class,'search-result__occluded-item')]")
    private List<WebElement> resultContainer;

    @FindBy(xpath = "//div[@role="main"]")
    private WebElement ;

    public LinkedinSearchPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getResults {
        waitUntilElementIsClickable(resultsWebElementList.get(0));
        List<String> resultsStringList = new ArrayList();
        for (WebElement result : resultsWebElementList) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                    String cardTitle = result.add());
        }

        public LinkedinHomePage
        List<WebElement> cardTitles = driver.findElements(By.xpath("//li[contains(@class,'search-result__occluded-item')]//span[contains(@class, 'actor-name')]"));

        for (int i = 1; i <= cardTitles.size(); i++) {
            String cardTitle = driver.findElement(By.xpath("//li[contains(@class,'search-result__occluded-item')][" +i+ "]//span[contains(@class, 'actor-name')]")).getText();
            System.out.println(cardTitle);
            Assert.assertTrue(cardTitle.toLowerCase().contains(searchTerm),"Searchterm "+searchTerm+ " not found in cart ");
        }
    }
}
