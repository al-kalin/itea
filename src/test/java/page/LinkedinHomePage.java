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

    public LinkedinHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isSignedIn() {
        waitUntilElementIsClickable(userIcon);
        return userIcon.isDisplayed();
    }

    //метод поиска который принимает на вход значение для поиска
    public LinkedinSearchPage searchByTerm(String searchTerm) {
        searchField.sendKeys(searchTerm + "\n");
        return new LinkedinSearchPage(driver);
    }
}
