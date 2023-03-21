package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class WebDriverInstance {

    public RemoteWebDriver initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--remote-allow-origins=*");

        //Auto download driver
        WebDriverManager.chromedriver().setup();

        RemoteWebDriver remoteWebDriver = new ChromeDriver(options);
        remoteWebDriver.get("https://microcks.io/");
        remoteWebDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return remoteWebDriver;
    }
}
