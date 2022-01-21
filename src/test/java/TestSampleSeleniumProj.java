import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class TestSampleSeleniumProj {
    /*
    Different ways to find elements in webpage
    - id []
    - name []
    - classname
    - tagname
    - linkText
    - partialLinkText
    - xpath [slower]
    - css []
     */

    public static void main(String[] args) throws InterruptedException {
        // Set the property for webdriver.chrome.driver to be the location to your local
        System.setProperty("webdriver.chrome.driver", "/Users/deeptijain/code/seleniumProj/chromedriver");

        // Create new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
//        googleCheeseWaitForResult(driver);
//        findElementByNameLetsKodeIt(driver);
//        findElementByXPathLetsKodeIt(driver);
       // findElementByTagNameLetsKodeIt(driver);
        //findElementByTagNameFBExample(driver);
        findElementByLinkText(driver);
        //Close the browser
        driver.quit();

    }

    public static void findElementByLinkText(WebDriver driver) throws InterruptedException {
        String baseURL = "https://letskodeit.teachable.com/";
        driver.get(baseURL);

        System.out.println("Find by link text and get the tag name "+driver.findElement(By.linkText("Login")).getTagName());
        Thread.sleep(3000);
    }
    public static void findElementByTagNameFBExample(WebDriver driver) {
        String baseURL = "https://www.facebook.com";
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.className("inputtext")).sendKeys("Automation");
        driver.findElement(By.className("uiButtonConfirm")).click();
    }
    public static void findElementByNameLetsKodeIt(WebDriver driver ) {

        String baseURL = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
        driver.findElement(By.name("user[email]")).sendKeys("dj.tated@gmail.com");
        System.out.println("Title : "+driver.getTitle());
    }

    public static void findElementByXPathLetsKodeIt(WebDriver driver) {
        String baseURL = "https://learn.letskodeit.com";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
        driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
        driver.findElement(By.id("user_email")).sendKeys("letskodeit@gmail.com");
    }

    public static void findElementByTagNameLetsKodeIt(WebDriver driver) {
        String baseURL = "http://demostore.x-cart.com/";
        driver.manage().window().maximize();
        driver.get(baseURL);

        //Finding element by tag name a
        driver.findElement(By.tagName("a")).click();

//        WebElement tagElement = new WebDriverWait(driver, 1000)
//                .until(ExpectedConditions.elementToBeClickable(By.tagName("a")));
        WebElement tagElement = driver.findElement(By.tagName("a"));
        System.out.println(tagElement.getText());

    }
/*
<a href="shipping"><span>Shipping</span></a>
<!doctype html>
<meta charset=utf-8>
<title>Race Condition Example</title>

<script>
  var initialised = false;
  window.addEventListener("load", function() {
    var newElement = document.createElement("p");
    newElement.textContent = "Hello from JavaScript!";
    document.body.appendChild(newElement);
    initialised = true;
  });
</script>


//        ExpectedConditions for Webdriver Waits
//        alert is present
//        element exists
//        element is visible
//        title contains
//        title is
//        element staleness
//        visible text
//        https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html

*/

    public static void googleCheeseWaitForResult(WebDriver driver) {

        // And now use this to visit Google
        driver.get("http://www.google.com");

        // Find the text input element by its name
        //WebElement element = driver.findElement(By.name("q"));
        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Initialize and wait till element(link) became clickable - timeout in 10 seconds
//        WebElement firstResult =
//                new WebDriverWait(driver, 1000).until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));

        WebElement firstResult = driver.findElement(By.xpath("//a/h3"));

                System.out.println("First Result of searching cheese on google : "+ firstResult.getText());

    }
}
