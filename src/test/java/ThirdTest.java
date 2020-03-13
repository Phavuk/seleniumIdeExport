import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class ThirdTest {
    private WebDriver driver;
    public final String BASE_URL = "http://localhost/registracia.php";
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        driver.findElement(By.xpath("/html/body/div/div/form/div[1]/input")).sendKeys("test@mail.sk");
        driver.findElement(By.xpath("/html/body/div/div/form/div[2]/input")).sendKeys("Johny");
        driver.findElement(By.xpath("/html/body/div/div/form/div[3]/input")).sendKeys("Macarony");
        driver.findElement(By.xpath("/html/body/div/div/form/div[4]/input")).sendKeys("hesielko");
        driver.findElement(By.xpath("/html/body/div/div/form/div[5]/input")).sendKeys("hesielko");
        driver.findElement(By.name("robot")).click();
        driver.findElement(By.xpath("/html/body/div/div/form/button")).click();

    }

    @After
    public void tearDown(){

    }
}
