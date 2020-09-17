package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HowToCheckoutFormPage;
import pages.HowToLoginFormPage;
import pages.HowToPage;

public class HowToSteps {

    private HowToPage howToPage = new HowToPage();
    private HowToLoginFormPage howToLoginForm = new HowToLoginFormPage();
    private HowToCheckoutFormPage howToCheckoutFormPage = new HowToCheckoutFormPage();

    @Given("I open https://www.w3schools.com/howto$")
    public void iOpenHowToPage() {
        howToPage.openHowToPage();
    }

    @When("^I choose 'Login Form'$")
    public void iChooseLoginForm() {
        howToPage.clickLoginForm();
    }

    @When("^I press 'Login' button$")
    public void iPressLoginButton() {
        howToLoginForm.clickLoginButton();
    }

    @Then("^login pop-up form is opened$")
    public void loginPopUpFormIsOpened() {
        howToLoginForm.verifyLoginModalIsOpened(true);
    }

    @When("^I enter username$")
    public void iEnterUsername() {
        howToLoginForm.typeUserName("Username");
    }

    @And("^I enter password$")
    public void iEnterPassword() {
        howToLoginForm.typePassword("Password");
    }

    @And("^I do not opt-in 'Remember me' check-box$")
    public void iDoNotOptInRememberMeCheckBox() {
        howToLoginForm.rememberMeSelected(false);
    }

    @And("^I press 'Login' button in pop-up$")
    public void iPressLoginButtonInPopUp() {
        howToLoginForm.clickLoginButtonInModalWindow();
    }

    @Then("^login pop-up form is closed$")
    public void loginPopUpFormIsClosed() {
        howToLoginForm.verifyLoginModalIsOpened(false);
    }

    @When("^I choose ‘Checkout Form’$")
    public void iChooseCheckoutForm() {
        howToPage.clickCheckoutForm();
    }

    @Then("^I see shopping cart that contains (\\d+) items$")
    public void iSeeShoppingCartThatContainsItems(int count) {
        howToCheckoutFormPage.countOfItemsInCart(count);
    }

    @And("I see total amount as \\$(\\d+)$")
    public void iSeeTotalAmountAs(int amount) {
        howToCheckoutFormPage.totalAmountInCart(amount);
    }

    @When("^I fill in '([^\"]*)' form with my '([^\"]*)' information$")
    public void iFillInFormWithMyPersonalInformation(String formName, String information) {
        howToCheckoutFormPage.typeAllFieldsInForm(formName, information);
    }

    @And("^I press 'Continue to checkout' button$")
    public void iPressContinueToCheckoutButton() {
        howToCheckoutFormPage.clickOnContinueToCheckoutButton();
    }

    @Then("^nothing happens$")
    public void nothingHappens() {
        howToCheckoutFormPage.isPageOpened();
        howToCheckoutFormPage.checkoutFormFieldsIsNotEmpty();
    }
}
