package page;

import context.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "#search-input")
    private WebElement searchInput;

    public void searchDocumentation(String keyword) {
        searchInput.sendKeys(keyword);
    }

    public HomePage(TestContext context) {
        super(context);
    }

    public void clickDocumentationListBasedOnTitle(String documentationTitle) {
        String selectorTemp = String.format("//div[@class='algolia-docsearch-suggestion--title'][text()='%s']", documentationTitle);
        getWebDriver().findElement(By.xpath(selectorTemp)).click();
    }

    public boolean isUserAlreadyOnTheHomePage() {
        return searchInput.isDisplayed();
    }
}
