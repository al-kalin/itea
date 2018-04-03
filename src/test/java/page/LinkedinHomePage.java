package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LinkedinHomePage extends LinkedinBasePage {

    /**
     * Find WebElment user icon
     */
    @FindBy(id = "profile-nav-item")
    private WebElement userIcon;

    /**
     * Find WebElment searchField
     * locator for user icon web element
     */
    @FindBy(xpath = ".//artdeco-typeahead-input/input")
    private WebElement searchField;

    /**
     * Constructor of LinkedinHomePage that takes WebDriver instance from LinkedinBasePage class
     * and initialized LinkedinHomePage WebElments via PageFactory.
     * @param driver - WebDriver instance which was initialized in @BeforMethod
     */
    public LinkedinHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Is the User SignedIn or not?
     * @return True if the element is displayed (user is signed in), false otherwise.
     */
    public boolean isSignedIn() {
        waitUntilElementIsClickable(userIcon);
        return userIcon.isDisplayed();
    }

    /**
     * Enter and Submit Term for Search
     * @param searchTerm - Term for Search
     * @return new page with search results
     */
    public LinkedinSearchPage searchByTerm(String searchTerm) {
        searchField.sendKeys(searchTerm + "\n");
        return new LinkedinSearchPage(driver);
    }

    /**
     * Is the element loaded or not?
     * @return True if the element is displayed, false otherwise.
     */
    public boolean isLoaded(){
        boolean isLoaded;
        try {
            isLoaded = userIcon.isDisplayed();
        }
        catch (NoSuchElementException e){
            isLoaded = false;
        }
        return  isLoaded;
    }
}
