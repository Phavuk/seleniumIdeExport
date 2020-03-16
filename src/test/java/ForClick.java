import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class ForClick {

    private WebDriver driver;
    public final String BASE_URL = ("http://localhost/clickmebaby.php");


        @Before
        public void setUp(){
            System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            
        }
        @Test
        public void test(){
            driver.get(BASE_URL);
            driver.findElement(By.id("clicks")).getText();
            System.out.println(driver.findElement(By.id("clicks")).getText());
            Assert.assertEquals("0",driver.findElement(By.id("clicks")).getText());

            driver.findElement(By.id("clickMe")).click();
            Assert.assertEquals("1",driver.findElement(By.id("clicks")).getText());
            driver.findElement(By.id("clickMe")).click();
            Assert.assertEquals("Initialny pocet klikov","2",driver.findElement(By.id("clicks")).getText());
            driver.findElement(By.id("clickMe")).click();
            Assert.assertEquals("Initialny pocet klikov","3",driver.findElement(By.id("clicks")).getText())
            ;driver.findElement(By.id("clickMe")).click();
            Assert.assertEquals("Initialny pocet klikov","4",driver.findElement(By.id("clicks")).getText());



        }
        @After
        public void tearDown(){

        }

}
