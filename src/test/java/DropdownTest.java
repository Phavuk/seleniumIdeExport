import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import java.util.*;

public class DropdownTest {
    private WebDriver driver;
    private final String BASE_URL = ("http://localhost/vybersi.php");

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        new Select(driver.findElement(By.className("form-control"))).selectByIndex(1);
        Assert.assertEquals("I choose you Charmander !",driver.findElement(By.xpath("/html/body/div/div[2]/h3")).getText());
        new Select(driver.findElement(By.className("form-control"))).selectByValue("02");
        Assert.assertEquals("I choose you Bulbasaur !",driver.findElement(By.xpath("/html/body/div/div[2]/h3")).getText());
        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Pikachu");
        Assert.assertEquals("I choose you Pikachu !",driver.findElement(By.xpath("/html/body/div/div[2]/h3")).getText());
    }

    @Test
    public void textTest(){
        driver.get(BASE_URL);
        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Pikachu");
        driver.findElement(By.xpath("//div/h3")).getText();
        System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//div/h3")).getText().contains("Pikachu"));
        Assert.assertFalse(driver.findElement(By.xpath("//div/h3")).getText().contains("Charmander"));
    }
    @After
    public void tearDown(){

    }
}
