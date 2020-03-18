import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class RadioButtonTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/zenaalebomuz.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Test(){
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//input[@value='wurst']")).click();
        //System.out.println(driver.findElement(By.xpath("//h1[@class='description text-center']")));
        Assert.assertEquals("It's wurst",driver.findElement(By.xpath("//h1[@class='description text-center']")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='conchita']")).isSelected());
    }
}
