package features;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.WikiPediaResultsPage;
import pageobjects.WikiPediaSearchPage;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;
import static org.junit.Assert.assertTrue;

/**
 * Created by vijayapalkayyam on 13/08/2017.
 */
public class WebFrontEndSteps {

    private WebDriver driver;
    private WikiPediaSearchPage wikiPediaSearchPage;
    private WikiPediaResultsPage wikiPediaResultsPage;
    private HashMap<String, String> languages;

    public WebFrontEndSteps() {
        languages = new HashMap<>();
        languages.put("English", "en");
        languages.put("Deutsch", "de");
        languages.put("Français", "fr");
    }

    @Before("@browser_skills")
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/Users/vijayapalkayyam/Downloads/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After("@browser_skills")
    public void tearDown() {
        driver.quit();
    }

    @Given("^I navigate to \"([^\"]*)\"$")
    public void iNavigateTo(String url) throws Throwable {
        driver.navigate().to(url);
        wikiPediaSearchPage = PageFactory.initElements(driver, WikiPediaSearchPage.class);
    }

    @When("^I search for \"([^\"]*)\" in \"([^\"]*)\" language$")
    public void iSearchForInLanguage(String searchTerm, String language) throws Throwable {
        wikiPediaSearchPage.searchFor(driver, searchTerm, language);
        wikiPediaResultsPage = PageFactory.initElements(driver, WikiPediaResultsPage.class);
    }

    @Then("^I should see first heading \"([^\"]*)\" in results page$")
    public void iShouldSeeFirstHeadingInResultsPage(String expectedResult) throws Throwable {
        String actualResult = wikiPediaResultsPage.getResultsHeader();
        assertTrue("Incorrect search results, expected text is: " + expectedResult + ", but actual result is: " + actualResult,
                containsIgnoreCase(actualResult, expectedResult));
    }

    @And("^the language should be \"([^\"]*)\"$")
    public void theLanguageShouldBe(String expectedLanguage) throws Throwable {
        String actualLanguage = wikiPediaResultsPage.getResultsLanguage();
        assertTrue("Incorrect language, expected language is: " + expectedLanguage + ", but actual language is: " + actualLanguage,
                actualLanguage.equals(languages.get(expectedLanguage)));
    }

    @And("^a link to English language is included$")
    public void aLinkToEnglishLanguageIsIncluded() throws Throwable {
        assertTrue("Link to version in English is missing", wikiPediaResultsPage.isEnglishLanguageLinkPresent());
    }
}
