package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HowToPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(@href, 'howto_css_login_form.asp') and @class='h2-anchor']")
    private WebElement loginFormLink;

    @FindBy(xpath = "//h2[text()='Forms']/following-sibling::a[contains(@href, 'howto_css_checkout_form.asp')]")
    private WebElement checkoutFormLink;

    private static final String URL = "https://www.w3schools.com/howto";

    public HowToPage() {
        super();
        PageFactory.initElements(this.webDriver, this);
    }

    /**
     * Open 'How to' page
     */
    public void openHowToPage() {
        logger.info(String.format("Navigate to '%s'", URL));
        webDriver.navigate().to(URL);
    }

    /**
     * Click on 'Login' form
     */
    public void clickLoginForm() {
        logger.info("Click on " + loginFormLink.toString());
        loginFormLink.click();
    }

    /**
     * Click on 'Checkout' form
     */
    public void clickCheckoutForm() {
        logger.info("Click on " + checkoutFormLink.toString());
        checkoutFormLink.click();
    }

}
