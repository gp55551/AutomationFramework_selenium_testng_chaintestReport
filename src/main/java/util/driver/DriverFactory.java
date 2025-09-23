package util.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver getNewDriverInstance(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome-headless":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("start-maximized");
                return new ChromeDriver(chromeOptions);
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            default:
                return new ChromeDriver();
        }
    }
}
