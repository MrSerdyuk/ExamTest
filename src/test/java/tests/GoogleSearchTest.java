package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GoogleSearchResultsPage;

public class GoogleSearchTest extends GoogleBaseTest{

    /**
     * Annotated method returns two objects, in this case - two searchTerms, which will be used in @Test with dataProvider
     * @return - two searchTerms
     */
    @DataProvider
    public Object[][] sensitiveKeywordSearch(){
        return new Object[][]{
                {"selenium"},
                {"SELENIUM"}};
    }

    /**
     * Method with @Test annotation checks that page title is correct after navigation to google.com, which described in
     * beforeTest() method in GoogleBaseTest class,
     * then creates new instance of GoogleSearchResultsPage by sending searchTerm to getSearchResultsPage() method,
     * then checks that searchTerm contains in all search result header and that there are displayed 10 results
     * on the first and the second pages
     * @param searchTerm - search word
     */
    @Test(dataProvider = "sensitiveKeywordSearch")
    public void basicSearchTest(String searchTerm) {
        Assert.assertEquals(initialPageTitle, "Google", "Google home page title is wrong");

        GoogleSearchResultsPage searchResultsPage = homePage.getSearchResultsPage(searchTerm);
        Assert.assertNotEquals(searchResultsPage.getPageTitle(), initialPageTitle, "Page title did not change after search");

        Assert.assertEquals(searchResultsPage.headersContainsSearchTermCounter(searchTerm), 10,
                "Search Term doesn't present in every header");
        Assert.assertEquals(searchResultsPage.getResultsList().size(), 10, "There are displayed not 10 results");

        GoogleSearchResultsPage secondSearchResultsPage = searchResultsPage.openSecondResultsPage();
        Assert.assertEquals(secondSearchResultsPage.headersContainsSearchTermCounter(searchTerm), 10,
                "Search Term doesn't present in every header");
        Assert.assertEquals(secondSearchResultsPage.getResultsList().size(), 10, "There are displayed not 10 results");
    }
}
