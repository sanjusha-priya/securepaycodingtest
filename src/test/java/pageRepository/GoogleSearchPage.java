package pageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleSearchPage extends HomePage {
    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css = "input[title='Search']")
    private WebElement searchTextBox;

    @FindBy(css = "input[value='Google Search']")
    private WebElement searchButton;

    private String linkCss = "a[href='LINK']";

    @FindBy (xpath="//p[contains(text(),\" Your search - \")]")
    private List<WebElement> noResult;

    public void enterSearchText(String text)
    {
        waitAndEnterText(searchTextBox,text);
    }

    public void clickSearchButton()
    {
        waitAndClick(searchButton);
    }

    public void openLink(String link){
        linkCss=linkCss.replace("LINK",link);
        waitAndClick(driver.findElement(By.cssSelector(linkCss)));
    }
    public int getNoResultsCount()
    {
        return noResult.size();
    }
}
