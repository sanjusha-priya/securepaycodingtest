package pageRepository;

import config.WriteConfiguration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    protected WebDriver driver;
    public long defaultTimeOut ;

    public HomePage(WebDriver driver){
        this.driver = driver;
        defaultTimeOut=Long.parseLong(WriteConfiguration.getProperty("defaultTimeOut"));
    }
    public void waitForElementPresent(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, defaultTimeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitAndEnterText(WebElement element,String text)
    {
        waitForElementPresent(element);
        element.clear();
        element.sendKeys(text);
    }
    public void waitAndClick(WebElement element)
    {
        waitForElementPresent(element);
        element.click();
        waitForPageLoad();
    }
    public void hover(WebElement element)
    {
        waitForElementPresent(element);
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
    public String getPageTitle()
    {
       return driver.getTitle();
    }
    public void waitForPageLoad()
    {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
    public void waitForPageTitle(String title)
    {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return (driver.getTitle().equalsIgnoreCase(title));
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    public void selectDropDownByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }
}