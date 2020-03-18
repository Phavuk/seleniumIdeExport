import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.util.*;

public class CssTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/stroopeffect.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void Test(){
        driver.get(BASE_URL);
        List<WebElement> titles = driver.findElements(By.xpath("//div[contains(@class,'colours')]/h1"));
        for (WebElement title : titles){
            System.out.println(title.getCssValue("color"));
            System.out.println(title.getText());
        }
        //System.out.println(driver.findElement(By.xpath("//div[contains(@class,'colours')]/h1[1]")).getCssValue("color"));

    }
}
