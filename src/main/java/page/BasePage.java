package page;

import context.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    WebDriver webDriver;

    public BasePage(TestContext context) {
        webDriver = context.webDriver;
        PageFactory.initElements(context.webDriver, this);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
