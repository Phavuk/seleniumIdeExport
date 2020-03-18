import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.util.*;

public class NavigationTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void Test(){
        String expectedCLass = "active";
        driver.get(BASE_URL+"vybersi.php");
        System.out.println(driver.findElement(By.xpath("//li[a/@href='vybersi.php']")).getAttribute("class"));
        Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='vybersi.php']"))
                .getAttribute("class")
                .contains(expectedCLass));

        driver.get(BASE_URL+"tabulka.php");
        Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='tabulka.php']"))
                .getAttribute("class")
                .contains(expectedCLass));

        driver.get(BASE_URL+"zjavenie.php");
        Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='zjavenie.php']"))
                .getAttribute("class")
                .contains(expectedCLass));
    }

    @Test
    public void UrlTest(){
        String expectedClass = "active";
        List<String> pages = new ArrayList<>();
        pages.add("vybersi.php");
        pages.add("tabulka.php");
        pages.add("zjavenie.php");
        for (String page : pages){
            driver.get(BASE_URL + "/" + page);
            Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='" + page +"']"))
                    .getAttribute("class")
                    .contains(expectedClass));
        }

    }
    @After
    public void tearDown(){

    }
}
