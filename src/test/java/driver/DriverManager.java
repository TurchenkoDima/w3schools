package driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static browsers.BrowserManager.getBrowser;

public class DriverManager {
    protected static final Logger logger = LogManager.getRootLogger();
    private static WebDriver webDriver;
    private static final String GECKO_WEBDRIVER = "webdriver.gecko.driver";
    private static final String GECKODRIVER_PATH = "src/test/resources/drivers/firefox/geckodriver";
    private static final String CHROME_WEBDRIVER = "webdriver.chrome.driver";
    private static final String CHROMEDRIVER_PATH = "src/test/resources/drivers/chrome/chromedriver";
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";

    public static void initDriver(String browser) {
        logger.info(String.format("Init driver: %s", browser));
        if (CHROME.equals(browser)) {
            System.setProperty(CHROME_WEBDRIVER, CHROMEDRIVER_PATH);
            webDriver = new ChromeDriver();
        } else if (FIREFOX.equals(browser)) {
            System.setProperty(GECKO_WEBDRIVER, GECKODRIVER_PATH);
            webDriver = new FirefoxDriver();
        } else {
            logger.info(String.format("No such browsers. Please check parameters.\nActual value: %s", browser));
        }
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        if(webDriver == null) {
            initDriver(getBrowser());
        }
        return webDriver;
    }

    public static void closeDriver() {
        logger.info("Close driver");
        webDriver.quit();
        webDriver = null;
    }
}
