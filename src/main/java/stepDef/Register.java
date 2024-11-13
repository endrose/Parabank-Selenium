package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {
    @Given("User is on parabank homepage")
    public void userIsOnParabankHomepage() {
        System.setProperty("webdriver","src/main/resources/drivers/chromedriver.exe");
    }

    @When("User click register link button")
    public void userClickRegisterLinkButton() {
    }

    @Then("User in register page")
    public void userInRegisterPage() {
    }

    @When("User input name")
    public void userInputName() {
    }

    @And("User input address detail")
    public void userInputAddressDetail() {
    }

    @And("User fill valid username")
    public void userFillValidUsername() {
    }

    @And("User input password confirmation")
    public void userInputPasswordConfirmation() {
    }

    @When("User click register button")
    public void userClickRegisterButton() {
    }

    @Then("User get error {string}")
    public void userGetError(String arg0) {
    }

    @And("User fill invalid username and password")
    public void userFillInvalidUsernameAndPassword() {
    }
}
