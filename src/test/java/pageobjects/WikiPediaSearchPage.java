package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by vijayapalkayyam on 13/08/2017.
 */
public class WikiPediaSearchPage {
    @FindBy(id = "searchInput")
    private WebElement searchField;
    @FindBy(id = "searchLanguage")
    private WebElement searchLanguageButton;
    @FindBy(css = ".pure-button")
    private WebElement searchButton;
    @FindBy(xpath = "//select[@id='searchLanguage']/option[text()='Deutsch']")
    private WebElement deutschLanguageButton;
    @FindBy(xpath = "//select[@id='searchLanguage']/option[text()='English']")
    private WebElement englishLanguageButton;

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchButton.click();
    }

    public void searchFor(WebDriver driver, String searchTerm, String language) throws InterruptedException {
        searchField.sendKeys(searchTerm);
        searchLanguageButton.click();
        WebElement element = driver.findElement(By.xpath("//select[@id='searchLanguage']/option[text()='" + language + "']"));
        element.click();
        searchButton.click();
    }
}
