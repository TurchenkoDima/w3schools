package pages;

import static driver.DriverManager.getDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

    protected final Logger logger = LogManager.getRootLogger();
    protected WebDriver webDriver;
    protected Wait<WebDriver> webDriverWait;

    @Parameters("browser")
    public AbstractPage() {
        this.webDriver = getDriver();
        webDriverWait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }
}
