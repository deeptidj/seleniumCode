package GoogleSearchBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleSearchTest {
    WebDriver driver;

    @BeforeTest
  void setup(){
      driver = new ChromeDriver();
      driver.get("www.google.com");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
  }

  @Test
  void test1(){
      WebElement searchInputBox = driver.findElement(By.name("q"));
      searchInputBox.sendKeys("Deepti Jain");
      System.out.println(driver.getCurrentUrl());

      List<WebElement> resultLinks = driver.findElements(By.tagName("a"));
      for (WebElement res : resultLinks) {
          if (res != null)
          System.out.println("Link = "+ res.getAttribute("href"));
      }

  }

  @AfterTest
  void cleanUp(){
        //driver.close();
  }
}
