
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutoCompleteRedfin {
    String baseURL;
    WebDriver driver ;

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","/Users/deeptijain/code/seleniumProj/chromedriver");
        baseURL = "https://www.redfin.com/";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

//    @Test
//    public void test() throws InterruptedException, IOException {
        //City, Address, School, Agent, ZIP
//        WebElement searchBox = driver.findElement(By.xpath("//input[@title = 'City, Address, School, Agent, ZIP']"));
//        searchBox.sendKeys("Mill Valley Agents", Keys.ENTER);
//            Thread.sleep(1000);
//            String filename = "abc" + ".png";
//            String directory = System.getProperty("user.dir") + "//screenshots//";
//            File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(sourceFile, new File(directory + filename));
//            List<WebElement> allAgentsList = driver.findElements(By.xpath("//a[@class='item-title block']"));
//            for (WebElement webElement : allAgentsList) {
//            System.out.println(webElement.getText().toString());
//                }
//    }

    @Test
    public void test2() {
        String s = driver.getWindowHandle();
        System.out.println(s);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }





}
