import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class XPathExamples {

    public static void main(String[] args) {

        /*
        Syntax:
        //tag[@attribute='value']

         When to use Xpath - When there is no static ID, Unique name, Unique text link

        Absolute XPath [starts from the beginning]
        /html/body/div[1]/div[8]/div[2]/div/section/div/div/div/div/div/div[1]/div/div[2]/div/div/form

        Relative XPath
        Xpath from chrome browser
        //*[@id="search-box-input"]

        Difference between // and /
        // Look anywhere inside - like any child or nested child
        / immediate child of the parent node

        //*[@id="tabContentId0"]/div/div/form
        //a[text()='Real Estate Agents '] -> checks for text on links.

        Contains key word.
        //tag[contains(attribute,'value')]
        Example - //input[contains(@title='Find an agent in your area')]
        Finding Login link:
        //div[@id='navbar']//a[contains(text(),'Login')]
        //div[@id='navbar']//a[contains(@class,'navbar-link') and contains(@href,'sign_in')]

        Using starts-with to find elements
        //tag[starts-with(@attribute,'blah blah')]
        //input[starts-with(@classname,'Login')]

        Parent and Sibling
        Syntax
        xpath//parent::tag

        //a[@href='/houses-near-me']//parent::li

        Proceeding sibling
        //a[@href='/feed']//parent::li//preceding-sibling::li

        Following sibling
        //a[@href='/feed']//parent::li//preceding-sibling::li//following-sibling::li[2]

<button data-rf-test-name="searchButton" aria-label="submit search" class="inline-block SearchButton clickable float-right" type="submit" value="" title="Search" tabindex="0"><svg class="SvgIcon search"><svg viewBox="0 0 24 24"><g fill-rule="evenodd"><path d="M23.884 21.763l-7.554-7.554a8.976 8.976 0 001.526-6.835C17.203 3.68 14.204.72 10.502.122a9.01 9.01 0 00-10.38 10.38c.598 3.702 3.558 6.7 7.252 7.354a8.976 8.976 0 006.835-1.526l7.554 7.554a.25.25 0 00.353 0l1.768-1.768a.25.25 0 000-.353zM2 9c0-3.86 3.14-7 7-7s7 3.14 7 7-3.14 7-7 7-7-3.14-7-7z"></path></g></svg></svg></button>
<button data-rf-test-name="searchButton" aria-label="submit search" class="inline-block SearchButton clickable float-right" type="submit" value="" title="Search" tabindex="2"><svg class="SvgIcon search"><svg viewBox="0 0 24 24"><g fill-rule="evenodd"><path d="M23.884 21.763l-7.554-7.554a8.976 8.976 0 001.526-6.835C17.203 3.68 14.204.72 10.502.122a9.01 9.01 0 00-10.38 10.38c.598 3.702 3.558 6.7 7.252 7.354a8.976 8.976 0 006.835-1.526l7.554 7.554a.25.25 0 00.353 0l1.768-1.768a.25.25 0 000-.353zM2 9c0-3.86 3.14-7 7-7s7 3.14 7 7-3.14 7-7 7-7-3.14-7-7z"></path></g></svg></svg></button>


         */


        System.setProperty("webdriver.chrome.driver", "/Users/deeptijain/code/seleniumProj/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.redfin.com/");

        //*[@type='search']
        System.out.println("Simple XPath");
        List<WebElement> wildCardElements1 = driver.findElements(By.xpath("//*[@id=\"search-box-input\"]"));
        wildCardElements1.forEach(ele -> {
            System.out.println("PlaceHolder for each of the search boxes on the page : "+ele.getAttribute("placeholder"));
        });

        //input[@type='search']
        System.out.println("Simple XPath");
        List<WebElement> wildCardElements2 = driver.findElements(By.xpath("//input[@id=\"search-box-input\"]"));
        wildCardElements2.forEach(ele -> {
            System.out.println("PlaceHolder for each of the search boxes on the page : "+ele.getAttribute("placeholder"));
        });

        //21 //*[@id="content"]/div
        System.out.println("Immediate Child");
        List<WebElement> wildCardElements3 = driver.findElements(By.xpath("//div[@id=\"content\"]/div"));
        System.out.println("No of divs under content = "+wildCardElements3.size());

        //using text for effective Xpath
        //<a class="menuItemClickable dropdownWidget" href="/real-estate-agents">Real Estate Agents </a>
        //<a class="menuItemClickable dropdownWidget" href="/real-estate-agents">Real Estate Agents </a>
        //Dont use * instead use tagnames.

        System.out.println("Click Real Estate Agents Link");
//        WebElement realEstateAgent = new WebDriverWait(driver, 1000).
//                until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Real Estate Agents ']"))));
        WebElement realEstateAgent = driver.findElement(By.xpath("//a[text()='Real Estate Agents ']"));

        realEstateAgent.click();
        System.out.println("Title="+driver.getTitle()+" URL="+driver.getCurrentUrl());

//        System.out.println("Real agents link clicking");
//        WebElement findAgentInYourArea = new WebDriverWait(driver, 1000).
//                until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[contains(@title,'Find an agent in your area')]"))));
//        findAgentInYourArea.sendKeys("Mill Valley California Agents", Keys.ENTER);
//        System.out.println("Title="+driver.getTitle()+" URL="+driver.getCurrentUrl());
//        //<a class="item-title block" href="/city/12192/CA/Mill-Valley/real-estate/agents" title="Mill Valley Agents">Mill Valley Agents</a>
//        //<div class="guts" tabindex="0" data-rf-test-name="dialogGutsNode" aria-modal="true" role="dialog"><div class="header"><div class="inline-block icon hidden"></div><h3 data-rf-test-name="title" aria-label="Did You Mean">Did You Mean</h3><button type="button" class="button Button close-button icon suppressMinWidth actionIcon" title="Close" tabindex="0" role="button" aria-label="Close Button" data-rf-test-name="dialog-close-button"><div class="svg-icon"><svg class="SvgIcon close"><svg viewBox="0 0 24 24"><g fill-rule="evenodd"><path d="M21.105 4.134l-1.061-1.061a.252.252 0 00-.354 0l-7.601 7.602-7.602-7.602a.25.25 0 00-.353 0l-1.061 1.06a.252.252 0 000 .355l7.602 7.6-7.602 7.603a.25.25 0 000 .353l1.06 1.06a.25.25 0 00.354 0l7.602-7.601 7.6 7.602a.252.252 0 00.355 0l1.06-1.061a.25.25 0 000-.353l-7.601-7.602 7.602-7.601a.252.252 0 000-.354"></path></g></svg></svg></div></button></div><div class="content-wrapper"><div class="content" data-rf-test-name="content"><div class="resultsView"><div aria-live="polite" aria-hidden="true" id="screen-reader-text" class="ExpandedResults__sr-only"></div><div data-rf-test-name="expanded-results" class="ExpandedResults transition-display-none-to-block"><div class="expanded-section clear-fix" role="group"><svg class="SvgIcon agent float-left type-icon size-small"><svg viewBox="0 0 24 24"><path d="M23.3 15.6c-.2-1.4-1.1-2.6-2.4-3.2l-4.2-1.8c.9-1.1 1.4-2.6 1.4-4.1C18.1 2.9 15.3 0 12 0S5.9 2.9 5.9 6.5c0 1.6.5 3 1.4 4.1l-4.2 1.8C1.8 13 .9 14.2.7 15.6L0 20.9c-.1 1.1.6 2.1 1.7 2.2 1.8.3 6.4.9 10.3.9s8.5-.6 10.3-.9c1.1-.2 1.8-1.2 1.7-2.2l-.7-5.3zM12 13c1.1 0 2.2-.3 3.1-.9l.4.2c-1.4 1.6-2.8 3.2-3.5 3.6-.7-.4-2.1-2-3.5-3.6l.4-.2c.9.6 2 .9 3.1.9zm0-11c2.2 0 4 2 4 4.5 0 1.4-.6 2.7-1.5 3.5-.7.6-1.6 1-2.5 1s-1.8-.4-2.5-1C8.6 9.2 8 7.9 8 6.5 8 4 9.8 2 12 2zm0 20c-3.8 0-8.2-.6-10-.8l.7-5.3c.1-.7.6-1.3 1.2-1.6l2.7-1.1c4 4.9 5 4.9 5.4 4.9s1.4 0 5.4-4.9l2.7 1.1c.7.3 1.1.9 1.2 1.6l.7 5.3c-1.8.2-6.2.8-10 .8zm1-2c0 .6-.5 1-1 1-.6 0-1-.4-1-1s.5-1 1-1c.6 0 1 .4 1 1z"></path></svg></svg><div class="expanded-row-content"><div class="expanded-type">Agents</div><div class="item-row clickable" data-rf-test-name="item-row-active" role="link" tabindex="0"><noscript></noscript><a class="item-title block" href="/city/12192/CA/Mill-Valley/real-estate/agents" title="Mill Valley Agents">Mill Valley Agents</a><div class="item-sub-title item-sub-title-city">Mill Valley, CA, USA</div></div><div class="item-row clickable" data-rf-test-name="item-row-active" role="link" tabindex="0"><noscript></noscript><a class="item-title block" href="/neighborhood/42288/CA/Mill-Valley/Downtown-Mill-Valley/real-estate/agents" title="Downtown Mill Valley Agents">Downtown Mill Valley Agents</a><div class="item-sub-title item-sub-title-city">Mill Valley, CA, USA</div></div><div class="item-row clickable" data-rf-test-name="item-row-active" role="link" tabindex="0"><noscript></noscript><a class="item-title block" href="/neighborhood/109921/CA/Mill-Valley/Mill-Valley-Heights/real-estate/agents" title="Mill Valley Heights Agents">Mill Valley Heights Agents</a><div class="item-sub-title item-sub-title-city">Mill Valley, CA, USA</div></div><div class="item-row clickable" data-rf-test-name="item-row-active" role="link" tabindex="0"><noscript></noscript><a class="item-title block" href="/neighborhood/65431/CA/Mill-Valley/Tam-Valley/real-estate/agents" title="Tam Valley Agents">Tam Valley Agents</a><div class="item-sub-title item-sub-title-city">Mill Valley, CA, USA</div></div><div class="item-row clickable" data-rf-test-name="item-row-active" role="link" tabindex="0"><noscript></noscript><a class="item-title block" href="/neighborhood/116934/CA/Mill-Valley/Bayfront/real-estate/agents" title="Bayfront Agents">Bayfront Agents</a><div class="item-sub-title item-sub-title-city">Mill Valley, CA, USA</div></div><div class="item-row clickable" data-rf-test-name="item-row-active" role="link" tabindex="0"><noscript></noscript><a class="item-title block" href="/neighborhood/40069/CA/Mill-Valley/Edgewood/real-estate/agents" title="Edgewood Agents">Edgewood Agents</a><div class="item-sub-title item-sub-title-city">Mill Valley, CA, USA</div></div><div class="item-row clickable" data-rf-test-name="item-row-active" role="link" tabindex="0"><noscript></noscript><a class="item-title block" href="/neighborhood/40610/CA/Mill-Valley/Panoramic/real-estate/agents" title="Panoramic Agents">Panoramic Agents</a><div class="item-sub-title item-sub-title-city">Mill Valley, CA, USA</div></div><div class="item-row clickable" data-rf-test-name="item-row-active" role="link" tabindex="0"><noscript></noscript><a class="item-title block" href="/neighborhood/42324/CA/Mill-Valley/Scott-Valley-Alto/real-estate/agents" title="Scott Valley-Alto Agents">Scott Valley-Alto Agents</a><div class="item-sub-title item-sub-title-city">Mill Valley, CA, USA</div></div><div class="item-row clickable" data-rf-test-name="item-row-active" role="link" tabindex="0"><noscript></noscript><a class="item-title block" href="/neighborhood/112816/CA/Mill-Valley/Enchanted-Knolls/real-estate/agents" title="Enchanted Knolls Agents">Enchanted Knolls Agents</a><div class="item-sub-title item-sub-title-city">Mill Valley, CA, USA</div></div><div class="item-row clickable" data-rf-test-name="item-row-active" role="link" tabindex="0"><noscript></noscript><a class="item-title block" href="/neighborhood/39182/CA/Mill-Valley/Country-Club/real-estate/agents" title="Country Club Agents">Country Club Agents</a><div class="item-sub-title item-sub-title-city">Mill Valley, CA, USA</div></div></div></div><noscript></noscript></div><div class="OutOfAreaBlurb"><span style="float: left; margin-right: 10px;"><svg class="SvgIcon info fill-link size-small"><svg viewBox="0 0 24 24"><g fill-rule="nonzero"><path d="M12 0c6.627 0 12 5.373 12 12s-5.373 12-12 12S0 18.627 0 12 5.373 0 12 0zm0 2C6.486 2 2 6.486 2 12s4.486 10 10 10 10-4.486 10-10S17.514 2 12 2z"></path><path d="M13 16v-5.75a.25.25 0 00-.25-.25h-2.5a.25.25 0 00-.25.25V12h1v4h-1v1.75c0 .138.112.25.25.25h3.5a.25.25 0 00.25-.25V16h-1zM12.75 8h-1.5a.25.25 0 01-.25-.25v-1.5a.25.25 0 01.25-.25h1.5a.25.25 0 01.25.25v1.5a.25.25 0 01-.25.25z"></path></g></svg></svg></span><span>Don't see what you're looking for? Your search might be outside our <a href="/sitemap" tabindex="-1">service areas</a>.</span></div></div></div></div></div>
//        WebElement agent = new WebDriverWait(driver, 1000).
//                until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[title='Mill Valley Agents'])")));
//        agent.click();
//        System.out.println("Title="+driver.getTitle()+" URL="+driver.getCurrentUrl());




        driver.quit();
    }
}
