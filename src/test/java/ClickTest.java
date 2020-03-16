import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class ClickTest {
    private WebDriver driver;
    private final String BASE_URL = ("http://localhost/clickmebaby.php");

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
    }
    @Test
    public void test(){
        System.out.println(driver.findElement(By.xpath("/html/body/div/div[2]/h1")).getText());
        Assert.assertEquals(0 , driver.findElement(By.xpath("/html/body/div/div/[2]/h1")).getText());
      //Assert.assertEquals(0,driver.findElement(By.xpath("/html/body/div/div[2]/h1")).getText());
    }
    @After
    public void tearDown(){

    }
}
