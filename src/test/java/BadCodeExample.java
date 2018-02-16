import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;

public class BadCodeExample {

    public static void main(String args[]) throws InterruptedException {
        System.out.println("Hello World");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));
        // Enter something to search for
        element.sendKeys("Selenium");
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        sleep(5000);
        driver.close();

    }
}
