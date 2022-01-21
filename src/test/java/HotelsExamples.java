import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HotelsExamples {
    //Vacation rentals
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","/Users/deeptijain/code/seleniumProj/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://www.hotels.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Vacation rentals")).click();
        System.out.println("Clicked on Vacation Rentals");
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getWindowHandle());


        //driver.findElement(By.name("q-destination")).sendKeys("Las Vegas", Keys.ENTER);
        Thread.sleep(2000);
        //q-room-0-adults
        WebElement dropDown = driver.findElement(By.id("qf-0q-room-0-adults"));
        Select sel = new Select(dropDown);
        List<WebElement> options =  sel.getOptions();
        options.forEach(option -> {
            System.out.println("Text for each option = "+option.getText());
        });

         sel.selectByValue("5");
         sel.selectByIndex(1);
        sel.getAllSelectedOptions().forEach(selected -> {
            System.out.println("Selected option of room = "+selected.getText());
        });

        driver.findElement(By.xpath("//ul[@class='secondary-section']//li[1]")).click();
        System.out.println(driver.getCurrentUrl());
        System.out.println("title = "+ driver.getTitle());

        ////

//        driver.findElement(By.id("user_email")).sendKeys("test@email.com");
//        System.out.println("Sending keys to username field");
//        driver.findElement(By.id("user_password")).sendKeys("test");
//        System.out.println("Sending keys to password field");
//        driver.findElement(By.id("user_email")).clear();
//        System.out.println("Clearing the username field");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
