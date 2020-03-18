import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

public class DynamicTest {
    private final String BASE_URL = "http://localhost/zjavenie.php";
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Test() throws InterruptedException {
        driver.get(BASE_URL);
        driver.findElement(By.id("showHim")).click();
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='brano']")));
        System.out.println(driver.findElement(By.xpath("//img[@class='brano']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='brano']")).isDisplayed());
        driver.findElement(By.id("hideHim")).click();
        //Assert.assertFalse(driver.findElement(By.xpath("//img[@class='brano']")).isDisplayed());
    }

    @After
    public void tearDown(){

    }
}
