package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class LinkedinSearchPage extends LinkedinBasePage{

    /**
     * Find WebElment resultsWebElementList
     */
    @FindBy(xpath = "//li[contains(@class,'search-result__occluded-item')]")
    private List<WebElement> resultsWebElementList;

    /**
     * Find WebElment resultsNumber
     */
    @FindBy(xpath = "//h3[contain(@clas,'search-results_total')]")
    private WebElement resultsNumber;

    public LinkedinSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Is the element loaded or not?
     * @return True if the element is displayed, false otherwise.
     */
    public boolean isLoaded(){
        boolean isLoaded;
        try {
            isLoaded = resultsNumber.isDisplayed();
        }
        catch (NoSuchElementException e){
            isLoaded = false;
        }
        return  isLoaded;
    }

    /**
     * check each item in the list with search term
     * @return list of results
     */
    public List<String> getResults() {
        //waitUntilElementIsClickable(resultsContainer);
        waitUntilELementIsVisible(resultsNumber, 10);
        List<String> resultsStringList = new ArrayList();
        for (WebElement result : resultsWebElementList) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", result);
            String cardTitle = result.getText();
            resultsStringList.add(cardTitle);
            System.out.println(cardTitle);
        }

        return resultsStringList;
    }
}
