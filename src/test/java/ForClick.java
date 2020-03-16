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
            driver.manage().window().maximize();
            
        }
        @Test
        public void test(){
            driver.get(BASE_URL);
            driver.findElement(By.id("clicks")).getText();
            System.out.println(driver.findElement(By.id("clicks")).getText());
            Assert.assertEquals("klikov",driver.findElement(By.className("description")).getText());
            System.out.println(driver.findElement(By.className("description")).getText());





        }
        @Test
        public void gramTest(){
            driver.get(BASE_URL);
            driver.findElement(By.className("description"));

            for (int i = 1; i <= 5 ; i++) {
                driver.findElement(By.id("clickMe")).click();
                Assert.assertEquals(String.valueOf(i),driver.findElement(By.id("clicks")).getText());
                System.out.println(driver.findElement(By.className("description")).getText());
                if (i == 1){
                    Assert.assertEquals("klik",driver.findElement(By.className("description")).getText());
                }

                if (i > 1 && i < 5  ){
                    Assert.assertEquals("kliky",driver.findElement(By.className("description")).getText());
                }
                if (i > 4){
                    Assert.assertEquals("klikov",driver.findElement(By.className("description")).getText());
                }

            }

        }

        @After
        public void tearDown(){

        }

}
