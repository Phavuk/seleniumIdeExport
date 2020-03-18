import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class DisabledElementTest {
    private final String BASE_URL= "http://localhost/nemenne.php";
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void NameTest(){
        driver.get(BASE_URL);
        //System.out.println(driver.findElement(By.id("inputEmail3")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("inputEmail3")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("sel1")).isEnabled());
        Assert.assertTrue(driver.findElement(By.id("sel2")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"sel2\"]/option[1]")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"sel2\"]/option[2]")).isEnabled());
        //System.out.println(driver.findElement(By.xpath("//*[@id=\"sel2\"]/option[1]")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"sel2\"]/option[3]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"sel2\"]/option[3]")).isEnabled());
    }

    @Test
    public void ButtonTest(){
        driver.get(BASE_URL);
        Assert.assertFalse(driver.findElement(By.xpath("//button[1]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//button[2]")).isEnabled());
    }

    @After
    public void tearDown(){

    }
}
