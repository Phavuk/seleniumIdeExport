import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class XpathTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/tabulka.php";
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[6]/td[3]"));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
