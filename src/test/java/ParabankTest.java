import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParabankTest  extends env_target {

    @Test
    public void main(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(basrUrlParaBank);

        driver.quit();

    }

}
