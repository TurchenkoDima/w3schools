package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HowToLoginFormPage extends AbstractPage {

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@class='w3-modal-content w3-card-4 w3-animate-zoom']//button[text()='Login']")
    private WebElement loginButtonModal;

    @FindBy(xpath = "//*[@class='w3-modal-content w3-card-4 w3-animate-zoom']/..")
    private WebElement loginModalWindow;

    @FindBy(xpath = "//input[@placeholder='Enter Username']")
    private WebElement userNameInput;

    @FindBy(xpath = "//input[@placeholder='Enter Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//label[text()=' Remember me']/input")
    private WebElement rememberMeCheckBox;

    public HowToLoginFormPage() {
        super();
        PageFactory.initElements(this.webDriver, this);
    }

    /**
     * Actions methods
     */

    /**
     * Click on 'Login'button
     */
    public void clickLoginButton() {
        logger.info("Click on " + loginButton.toString());
        loginButton.click();
    }

    /**
     * Click on 'Login'button in modal window
     */
    public void clickLoginButtonInModalWindow() {
        logger.info("Click on " + loginButtonModal.toString());
        loginButtonModal.click();
    }

    /**
     * Type 'userName'
     *
     * @param userName
     */
    public void typeUserName(String userName) {
        logger.info(String.format("Type '%s' to '%s'", userName, userNameInput.toString()));
        userNameInput.sendKeys(userName);
    }

    /**
     * Type 'password'
     *
     * @param password
     */
    public void typePassword(String password) {
        logger.info(String.format("Type '%s' to '%s'", password, passwordInput.toString()));
        passwordInput.sendKeys(password);
    }

    /**
     * Set 'Remember me' checkbox to state
     *
     * @param shouldBeSelected - true if selected
     */
    public void rememberMeSelected(boolean shouldBeSelected) {
        logger.info(String.format("Set 'Remember me' checkbox to state.\nExpected:'%s'", shouldBeSelected));
        if (shouldBeSelected) {
            if (!rememberMeCheckBox.isSelected()) {
                rememberMeCheckBox.click();
            }
        } else {
            if (rememberMeCheckBox.isSelected()) {
                rememberMeCheckBox.click();
            }
        }
    }

    /**
     * Verification methods
     */

    /**
     * Verify that 'Login' modal window is opened
     *
     * @param shouldBeOpened - true if opened
     */
    public void verifyLoginModalIsOpened(boolean shouldBeOpened) {
        logger.info(String.format("Verify modal window state. \nShould be opened:'%s'", shouldBeOpened));
        if (shouldBeOpened) {
            Assert.assertTrue(loginModalWindow.getAttribute("style").contains("block"));
        } else {
            Assert.assertFalse(loginModalWindow.getAttribute("style").contains("block"));
        }
    }
}
