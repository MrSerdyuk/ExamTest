package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultsPage extends GoogleBasePage {

    @FindBy(xpath = "//div[@class='srg']//h3[@class='r']")
    private List<WebElement> searchResultsList;

    @FindBy(xpath = "//div[@id='resultStats']")
    WebElement totalSearchResults;

    @FindBy(xpath = "//a[@aria-label='Page 2']")
    WebElement secondPageLink;

    /**
     * Constructor of GoogleSearchResultsPage class that takes WebDriver instance from GoogleBasePage class
     * and initialize GoogleSearchResultsPage WebElements via PageFactory.
     * @param driver - WebDriver instance
     */
    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**Method creates new instance of GoogleSearchResultsPage class by clicking on the link of the second google search page
     * @return new instance of GoogleSearchResultsPage
     */
    public GoogleSearchResultsPage openSecondResultsPage(){
        secondPageLink.click();
        return new GoogleSearchResultsPage(driver);
    }

    /**
     * Method waits until totalSearchResults becomes clickable, then with xpath help finds all search result headers,
     * writes headers text in String List and returns list with all header
     * @return string list with all headers
     */
    public List<String> getResultsList() {
        waitUntilElementIsClickable(totalSearchResults);
        List<String> list = new ArrayList<>();

        for (int i = 0; i < searchResultsList.size(); i++) {

            String searchItemName = searchResultsList.get(i).getText().toLowerCase();
            list.add(searchItemName);
        }
        return list;
        }

    /**
     * Method returns the number of matches of the searchTerm with search headers in searchResultsList
     * @param searchTerm - is the search term
     * @return the number of matches
     */
    public int headersContainsSearchTermCounter(String searchTerm) {
        int counter = 0;
        for (String result : getResultsList()) {
            if (result.contains(searchTerm.toLowerCase())) {
                counter += 1;
            }
        }
        return counter;
        }
}
