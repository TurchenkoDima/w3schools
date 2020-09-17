package pages;

import istances.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class HowToCheckoutFormPage extends AbstractPage {

    private static final String URL = "https://www.w3schools.com/howto/howto_css_checkout_form.asp";
    private List<User> users = Arrays.asList(new User());

    @FindAll({
            @FindBy(xpath = "//h4[text()='Cart ']/following-sibling::p//a[@class='linkr']")
    })
    private List<WebElement> cartItems;

    @FindBy(xpath = "//h4[contains(text(),'Cart')]/following-sibling::p[contains(text(),'Total')]//b")
    private WebElement totalAmount;

    @FindBy(name = "firstname")
    private WebElement fullNameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "address")
    private WebElement addressInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "state")
    private WebElement stateInput;

    @FindBy(name = "zip")
    private WebElement zipInput;

    @FindBy(name = "cardname")
    private WebElement cardnameInput;

    @FindBy(name = "cardnumber")
    private WebElement cardnumberInput;

    @FindBy(name = "expmonth")
    private WebElement expmonthInput;

    @FindBy(name = "expyear")
    private WebElement expyearInput;

    @FindBy(name = "cvv")
    private WebElement cvvInput;

    @FindBy(xpath = "//button[contains(text(),'Continue to checkout')]")
    private WebElement continueToCheckoutButton;

    public HowToCheckoutFormPage() {
        super();
        PageFactory.initElements(this.webDriver, this);
    }

    /**
     * Actions methods
     */

    public void typeAllFieldsInForm(String formName, String information) {
        if(formName.equals("Billing Address")){
            typeAllFieldsInBillingAddress(information);
        } else if(formName.equals("Payment")) {
            typeAllFieldsInPayment(information);
        }
    }

    private void typeAllFieldsInBillingAddress(String information) {
        logger.info("Set data to 'BillingAddress' form. User: " + information);
        User userData = users.stream().filter(userItem -> userItem.getFullName().contains(information)).findFirst().get();
        fullNameInput.sendKeys(userData.getFullName());
        emailInput.sendKeys(userData.getEmail());
        addressInput.sendKeys(userData.getAddress());
        cityInput.sendKeys(userData.getCity());
        stateInput.sendKeys(userData.getState());
        zipInput.sendKeys(String.valueOf(userData.getZip()));
    }

    private void typeAllFieldsInPayment(String information) {
        logger.info("Set data to 'Payment' form. User: " + information);
        User userData = users.stream().filter(userItem -> userItem.getCreditCardNumber().contains(information)).findFirst().get();
        cardnameInput.sendKeys(userData.getNameOnCard());
        cardnumberInput.sendKeys(userData.getCreditCardNumber());
        expmonthInput.sendKeys(userData.getExpMonth());
        expyearInput.sendKeys(String.valueOf(userData.getExpYear()));
        cvvInput.sendKeys(String.valueOf(userData.getCVV()));
    }

    public void clickOnContinueToCheckoutButton() {
        logger.info("Click on " + continueToCheckoutButton.toString());
        continueToCheckoutButton.click();
    }

    /**
     * Verification methods
     */

    /**
     * Verify count of items in cart
     * @param expectedCount
     */
    public void countOfItemsInCart(int expectedCount) {
        logger.info("Verify count of items in cart");
        Assert.assertEquals(cartItems.size(), expectedCount);
    }

    /**
     * Verify total amount in cart
     * @param expectedAmount
     */
    public void totalAmountInCart(int expectedAmount) {
        logger.info("Verify total amount in cart");
        Assert.assertEquals(totalAmount.getText(), String.format("$%s", expectedAmount));
    }

    /**
     * Verify that page is opened
     */
    public void isPageOpened() {
        logger.info("Verify that page is opened");
        Assert.assertEquals(webDriver.getCurrentUrl(), URL);
    }

    /**
     * Verify that checkout form fields is not empty
     */
    public void checkoutFormFieldsIsNotEmpty() {
        logger.info("Verify that checkout form fields is not empty");
        List<WebElement> elements = Arrays.asList(fullNameInput, emailInput, addressInput, cityInput, stateInput,
                zipInput, cardnameInput, cardnumberInput, expmonthInput, expyearInput, cvvInput);
        elements.stream().forEach(element -> Assert.assertFalse(element.getAttribute("value").isEmpty()));
    }

}
