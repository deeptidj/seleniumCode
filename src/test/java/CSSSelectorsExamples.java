import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CSSSelectorsExamples {
    public static void main(String[] args) {

        /*
        Syntax: tag[attribute='value']
        Example - By.cssSelector("input[placeholder=\"City, Address, School, Agent, ZIP\"]");
        Example - By.cssSelector("input[placeholder='City, Address, School, Agent, ZIP']");

        “#” -> Id
        “.” -> Class
            Example Text Box:
                input[id=displayed-text]
                #displayed-text
                input#displayed-text
                    Notice no single quotes

        Element with 2 or more class names ex : class="inputs displayed-text"
        css is .inputs.displayed-text
        Example - topMenuFeedMenuLink inline-block menuItemClickable verticallyCenterFlexContent menuItemAlign clickable

        Wild cards with css selectors
            “^” -> Represents the starting text
            “$” -> Represents the ending text
            “*” -> Represents the text contained

         */
        System.setProperty("webdriver.chrome.driver", "/Users/deeptijain/code/seleniumProj/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.redfin.com/");

//        List<WebElement> elements = driver.findElement(By.cssSelector("#content")).findElements(By.tagName("div"));
//
//        elements.forEach(ele -> {
//            System.out.println(ele.getText().toString());
//        });

        System.out.println("search boxes on Redfin");
        List<WebElement> searchBoxes = driver.findElements(By.cssSelector("input[placeholder='City, Address, School, Agent, ZIP']"));
        System.out.println(" Size 3 = "+searchBoxes.size());
        searchBoxes.forEach(ele -> {
            System.out.println("Text = "+ele.getText()+" Tag = "+ele.getTagName());
            System.out.println("PlaceHolder for each of the search boxes on the page : "+ele.getAttribute("placeholder"));
        });


        //Element with 2 or more class names ex : class="inputs displayed-text"
        WebElement classNameElement = driver.findElement(By.cssSelector(".topMenuFeedMenuLink.inline-block.menuItemClickable.verticallyCenterFlexContent.menuItemAlign.clickable"));
        System.out.println("Element with lot of class names  = "+classNameElement.getText());
        System.out.println();


        //Wild cards with css selectors
        List<WebElement> wildCardElements1 = driver.findElements(By.cssSelector("input[id^='search-box']"));
        wildCardElements1.forEach(ele -> {
            System.out.println("PlaceHolder for each of the search boxes on the page : "+ele.getAttribute("placeholder"));
        });

        System.out.println("Names ending with InputBox");
        List<WebElement> wildCardElements2 = driver.findElements(By.cssSelector("input[name$='InputBox']"));
        wildCardElements2.forEach(ele -> {
            System.out.println("PlaceHolder for each of the search boxes on the page : "+ele.getAttribute("placeholder"));
        });


        System.out.println("Classes containing 'search'");
        List<WebElement> wildCardElements3 = driver.findElements(By.cssSelector("input[class*='search']"));
        wildCardElements3.forEach(ele -> {
            System.out.println("PlaceHolder for each of the search boxes on the page : "+ele.getAttribute("placeholder"));
        });


        System.out.println("children of form");
        List<WebElement> wildCardElements4 = driver.findElements(By.cssSelector("form>div>div>input"));
        wildCardElements4.forEach(ele -> {
            System.out.println("PlaceHolder for each of the search boxes on the page : "+ele.getAttribute("placeholder"));
        });


        System.out.println("children of form with class names");
        List<WebElement> wildCardElements5 = driver.findElements(By.cssSelector("form>div>.InputBox>input"));
        wildCardElements5.forEach(ele -> {
            System.out.println("PlaceHolder for each of the search boxes on the page : "+ele.getAttribute("placeholder"));
        });

        driver.quit();

    }
}
