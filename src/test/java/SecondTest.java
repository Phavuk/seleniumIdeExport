import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class SecondTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/clickmebaby.php";
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        driver.findElement(By.id("clickMe"));
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
