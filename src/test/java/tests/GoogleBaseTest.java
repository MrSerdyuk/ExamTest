package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.GoogleHomePage;

public class GoogleBaseTest {
    WebDriver driver;
    GoogleHomePage homePage;
    String initialPageTitle;

    /**
     * Method, with help of TestNG @Parameters and @Optional, sets the browserType, which will be run before @Test;
     * in this case, there are possible 2 browsers: firefox and default chrome;
     * then goes to google and creates new instance of GoogleHomePage class and get page title
     * @param browserType is a possible(firefox or default chrome) browser to be run
     */
    @Parameters({"browserType"})
    @BeforeMethod
    public void beforeTest(@Optional("") String browserType) {

        switch (browserType.toLowerCase()) {
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default :
                 WebDriverManager.chromedriver().setup();
                 driver = new ChromeDriver();
                 break;
        }

        driver.navigate().to("https://www.google.com/");

        homePage = new GoogleHomePage(driver);
        initialPageTitle = homePage.getPageTitle();
    }

    /**
     * Method closes driver and all browser windows when test is finished
     */
    @AfterMethod
    public void afterTest() {driver.quit();}
}
