package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HowToLoginFormPage;
import pages.HowToPage;

public class HowToSteps {

    private HowToPage howToPage = new HowToPage();
    private HowToLoginFormPage howToLoginForm = new HowToLoginFormPage();

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
}
