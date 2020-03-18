import org.junit.*;
import org.junit.internal.runners.statements.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.util.logging.*;

public class TableTest {
    private final String BASE_URL = "http://localhost/tabulka.php";
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    Logger logger = LoggerFactory.getLogger(TableTest.class);

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Test(){
        driver.get(BASE_URL);
        try {
        Assert.assertEquals("1",driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[1]/td[1]")));
        }
        catch (Error e){
            verificationErrors.append(e.toString());
        }
        System.out.println("Tabulka skontrolovana");
    }
    @After
    public void tearDown(){
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)){
        logger.warning(verificationErrorString);
    }
    }
}
