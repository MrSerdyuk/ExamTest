package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleBasePage {
    WebDriver driver;

    /**
     * Constructor of GoogleBasePage class which takes WebDriver instance initialized in @BeforeMethod
     * for reuse in GoogleBasePage class methods
     * @param driver - WebDriver instance
     */
    public GoogleBasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method gets the title of the current page
     * @return - title of the current page
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Method waits for timeoutInSeconds until the WebElement becomes visible and clickable on the current page
     * @param webElement - any webElement on the current page
     * @param timeoutInSeconds - expectation time
     */
    public void waitUntilElementIsClickable(WebElement webElement, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Method waits 5 seconds until the WebElement becomes visible and clickable on the current page
     * @param webElement - any webElement on the current page
     */
    public void waitUntilElementIsClickable(WebElement webElement) {
        waitUntilElementIsClickable(webElement, 5);
    }

}
