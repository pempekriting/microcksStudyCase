package hooks;

import context.TestContext;
import driver.WebDriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CucumberHooks {

    private final TestContext testContext;
    private RemoteWebDriver remoteWebDriver;

    public CucumberHooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void beforeTest() {
        WebDriverInstance webDriverInstance = new WebDriverInstance();
        remoteWebDriver = webDriverInstance.initializeDriver();
        testContext.webDriver = remoteWebDriver;
    }

    @After
    public void after(Scenario scenario) {
        scenario.attach(((TakesScreenshot) remoteWebDriver).getScreenshotAs(OutputType.BYTES), "image/png", "attachment");
        remoteWebDriver.quit();
    }
}
