package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Register extends env_target {
    @Given("User is on parabank homepage")
    public void userIsOnParabankHomepage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(basrUrlParaBank);
//        Duration duration = Duration.ofSeconds(10);
//
//        WebDriverWait wait = new WebDriverWait(driver,duration);
//        wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftPanel']/h2")));

    }

    @When("User click register link button")
    public void userClickRegisterLinkButton() {
        driver.findElement(By.linkText("Register")).click();
    }

    @Then("User in register page")
    public void userInRegisterPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Signing up is easy!')]"))
        );
    }

    @When("User input name")
    public void userInputName() {
        driver.findElement(By.id("customer.firstName")).sendKeys("Testing Seleninum");
    }

    @And("User input address detail")
    public void userInputAddressDetail() {
        driver.findElement(By.id("customer.lastName")).sendKeys("Last Seleninum");
        driver.findElement(By.id("customer.address.street")).sendKeys("Testing Seleninum");
        driver.findElement(By.id("customer.address.city")).sendKeys("City Seleninum");
        driver.findElement(By.id("customer.address.state")).sendKeys("State Seleninum");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("Code Seleninum");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("Code Seleninum");

        driver.findElement(By.id("customer.ssn")).sendKeys("1234567");


    }

    @And("User fill valid username")
    public void userFillValidUsername() {

        Random rand = new Random();
        int userRand = rand.nextInt(10000);
        driver.findElement(By.id("customer.username")).sendKeys("Yesselenium"+userRand);
        driver.findElement(By.id("customer.password")).sendKeys("yourpassword");


    }

    @And("User input password confirmation")
    public void userInputPasswordConfirmation() {
        driver.findElement(By.id("repeatedPassword")).sendKeys("yourpassword");

    }

    @When("User click register button")
    public void userClickRegisterButton() {
        driver.findElement(By.xpath("//input[@value='Register']")).click();
    }


    @Then("User register successfully")
    public void userRegisterSuccessfully() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        // Wait for the success message to be visible
        WebElement successMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(), 'Your account was created successfully. You are now logged in.')]")
                )
        );

        // Optional: Assert that the success message is actually displayed
        Assert.assertTrue("Success message not displayed", successMessage.isDisplayed());

    }

    @And("User fill invalid username and password")
    public void userFillInvalidUsernameAndPassword() {
        driver.findElement(By.id("customer.username")).sendKeys("YesSelenium");
        driver.findElement(By.id("customer.password")).sendKeys("selenium");
    }

    @Then("User get error Password did not match")
    public void userGetErrorPasswordDidNotMatch() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Passwords did not match.')]"))
        );
        driver.quit();
    }

}
