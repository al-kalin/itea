package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LinkedinHomePage extends LinkedinBasePage {

    @FindBy(id = "profile-nav-item")
    private WebElement userIcon;

    @FindBy(xpath = ".//artdeco-typeahead-input/input")
    private WebElement searchField;


    @FindBy(xpath = "//li[contains(@class,'search-result__occluded-item')][\" +i+ \"]//span[contains(@class, 'actor-name')]")
    private List<WebElement> cardTitles;

    public LinkedinHomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignedIn() {
        waitUntilElementIsClickable(userIcon);
        return userIcon.isDisplayed();
    }

    //метод поиска который принимает на вход значение для поиска
    public LinkedinHomePage searchByTerm(String searchTerm) {
        searchField.sendKeys(searchTerm + "\n");
        return PageFactory.initElements(driver, LinkedinHomePage.class);
    }

    //находим наши 10 элементов и убеждаемся что их 10
    public LinkedinHomePage checkSearchResults() {
        driver.findElements(results);
        //[contains(@class,'search-result__occluded-item')] xpath запрос который говорит что мы ищем ли
        // с классом который содержит в своем название текст "search-result__occluded-item"
        // скролим по элементам
        for (int i = 0; i < results.size(); i++) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", results.get(i));
        }
    }
}
