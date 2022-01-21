package practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Practise1 {

    Practise1(){
//        System.setProperty("webdriver.driver.chrome","/Users/deeptijain/code/seleniumProj/chromedriver");
//        opts = new ChromeOptions();
//        opts.addArguments("--headless");
//        driver = new ChromeDriver();
    }
//    @Test
//    public void testPractise() {
//        System.out.println("in practise test");
//    }

    public static void main(String[] args) {
        WebDriver driver;
        ChromeOptions opts;
        System.setProperty("webdriver.driver.chrome","/Users/deeptijain/code/seleniumProj/chromedriver");
        opts = new ChromeOptions();
      //  opts.addArguments("--headless");
        driver = new ChromeDriver();
        System.out.println("in practise test");
    }
}
