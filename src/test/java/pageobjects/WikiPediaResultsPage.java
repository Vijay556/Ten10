package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by vijayapalkayyam on 13/08/2017.
 */
public class WikiPediaResultsPage {
    @FindBy(id = "firstHeading")
    private WebElement headingText;
    @FindBy(xpath = "//div[@id='p-lang']//a[text()='English']")
    private WebElement englishLangauageButton;

    public String getResultsHeader() {
        return headingText.getText();
    }

    public String getResultsLanguage() {
        return headingText.getAttribute("lang");
    }

    public boolean isEnglishLanguageLinkPresent() {
        return englishLangauageButton.isDisplayed();
    }
}
