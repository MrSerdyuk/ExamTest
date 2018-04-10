package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends GoogleBasePage{
    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement searchButton;

    /**
     * Constructor of GoogleHomePage class that takes WebDriver instance from GoogleBasePage class
     * and initialize GoogleHomePage WebElements via PageFactory.
     * @param driver - WebDriver instance
     */
    public GoogleHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Constructor of GoogleSearchResultsPage class that takes searchTerm, writes search term to the searchInput,
     * submits searchTerm with searchButton and create new instance of GoogleSearchResultsPage
     * @param searchTerm - String search term
     * @return new instance of GoogleSearchResultsPage
     */
    public GoogleSearchResultsPage getSearchResultsPage(String searchTerm) {
        searchInput.sendKeys(searchTerm);
        searchButton.submit();
        return new GoogleSearchResultsPage(driver);
    }
}
