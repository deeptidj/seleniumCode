package ProsperAutomationInterview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProperApp {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/deeptijain/code/seleniumCode/seleniumProj/chromedriver");
        driver = new ChromeDriver();
        String url = "https://www.prosper.com/web-offers/get-rate/loan-amount";
        driver.get(url);
    }

    @Test
    public void test() {
        WebElement ele = driver.findElement(By.id("application_loan_amount_submit"));
        System.out.println(ele.getText());
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}