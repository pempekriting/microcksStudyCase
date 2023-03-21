package page;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailDocumentationPage extends BasePage {

    @FindBy(className = "lh-title")
    private WebElement headerDocumentationTitle;

    public DetailDocumentationPage(TestContext testContext) {
        super(testContext);
    }

    public String getHeaderDocumentTitle() {
        return headerDocumentationTitle.getText();
    }
}
