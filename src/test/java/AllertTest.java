import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class AllertTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/redalert.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void Test(){
        driver.get(BASE_URL);
        driver.findElement(By.id("alert1")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println(driver.findElement(By.xpath("/html/body/div/div/div/h1")).getText());
    }

    @Test
    public void DissmissTest(){
        driver.get(BASE_URL);
        driver.findElement(By.id("alert2")).click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        System.out.println(driver.findElement(By.xpath("/html/body/div/div/div/h1")));
    }
    @Test
    public void TextAlertTest(){
        driver.get(BASE_URL);
        driver.findElement(By.id("alert3")).click();

        Alert alert= driver.switchTo().alert();
        alert.sendKeys("Tester");
        alert.accept();
        System.out.println(driver.findElement(By.xpath("/html/body/div/div/div/h1")).getText());
        Assert.assertEquals("textTest","Waiting for your commands Tester",driver.findElement(By.xpath("/html/body/div/div/div/h1")).getText());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
