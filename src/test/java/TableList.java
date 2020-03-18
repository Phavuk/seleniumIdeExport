import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.util.*;

public class TableList {
    private WebDriver driver;
    private final String BASE_URL = ("http://localhost/tabulka.php");

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText();
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText());;
        int rows = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText()));
        for (int i = 1; i < rows; i++) {
            System.out.println(driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText());
            Assert.assertFalse(driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText().isEmpty());

        }
    }

    @Test
    public void elementsTest(){
        driver.get(BASE_URL);
        List<WebElement> rows= driver.findElements(By.xpath("//table/tbody/tr"));
       // System.out.println(rows);
        for (WebElement row : rows){
            //System.out.println(row.getText());
            System.out.println(row.findElement(By.xpath("//table/tbody/tr/td[3]")).getText());
            Assert.assertFalse(row.findElement(By.xpath("//table/tbody/tr/td[3]")).getText().isEmpty());
        }
    }

    @After
    public void tearDown(){

    }
}
