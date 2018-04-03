package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.LinkedinLandingPage;

public class LinkedinBaseTest {
    WebDriver driver;
    LinkedinLandingPage landingPage;

    /**
     * @param browserType
     * @param testUrl
     */
    @Parameters({"browserType", "testUrl"})

    @BeforeMethod
    public void beforTest(@Optional("firefox")String browserType, @Optional("https://www.linkedin.com/") String testUrl) {

        switch (browserType.toLowerCase()){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("Unsupported browser");
                break;
        }

        driver.get(testUrl);
        landingPage = new LinkedinLandingPage(driver);
    }

    /**
     * close driver after test
     */
    @AfterMethod
    public void afterTest() {
        driver.close();
    }
}
