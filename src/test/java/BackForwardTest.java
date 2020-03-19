import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class BackForwardTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/registracia.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
        driver.get(BASE_URL);
        driver.findElement(By.name("email")).sendKeys("mojmail@mail.com");
        driver.findElement(By.xpath("//a[@href='zenaalebomuz.php']")).click();
        driver.navigate().back();
        System.out.println(driver.findElement(By.name("email")).getAttribute("value"));

    }

    @After
    public void tearDown(){

    }
}
