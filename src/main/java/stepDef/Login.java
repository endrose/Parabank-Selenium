package stepDef;

import config.env_target;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Login extends env_target {

    @Test
    public void main() {
//        LOCATION PATH
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
//
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseUrl);

        Duration duration = Duration.ofSeconds(10);

        WebDriverWait wait  = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))
        );

        driver.findElement(By.name("user-name")).sendKeys("standard_user");


        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("(//input[@id='login-button'])")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product_label'][contains(text(), 'Products')]"))
        );


        driver.quit();
    }


    @Test
    public void invalidPassword() {
//        LOCATION PATH
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
//
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseUrl);

        Duration duration = Duration.ofSeconds(10);

        WebDriverWait wait  = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))
        );

        driver.findElement(By.name("user-name")).sendKeys("standard_user");


        driver.findElement(By.id("password")).sendKeys("secret_sauce1");

        driver.findElement(By.xpath("(//input[@id='login-button'])")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test='error']"))
        );

        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String errorText = errorMessage.getText();
        System.out.println(errorText);

        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", errorText, "Error message is not as expected");

        driver.quit();
    }


    @Test
    public void invalidUsername() {
//        LOCATION PATH
        System.setProperty("webdriver.chrome.driver", chromePath);
//
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseUrl);

        Duration duration = Duration.ofSeconds(10);

        WebDriverWait wait  = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))
        );

        driver.findElement(By.name("user-name")).sendKeys("standard_user1");


        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("(//input[@id='login-button'])")).click();


        wait.until(


                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test='error']"))

        );

        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String errorText = errorMessage.getText();
        System.out.println(errorText);

        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", errorText, "Error message is not as expected");

        driver.quit();
    }

}
