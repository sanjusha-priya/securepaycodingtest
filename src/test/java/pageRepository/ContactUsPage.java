package pageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.apache.commons.lang3.RandomStringUtils.*;


public class ContactUsPage extends HomePage {
    @FindBy(css = "input[name='firstName']")
    private WebElement fName;
    @FindBy(css = "input[name='lastName']")
    private WebElement lName;
    @FindBy(css = "input[name='email']")
    private WebElement eMail;
    @FindBy(css = "input[name='phone']")
    private WebElement pNumber;
    @FindBy(css = "input[name='website']")
    private WebElement wUrl;
    @FindBy(css = "input[name='company']")
    private WebElement company;
    @FindBy(css = "select[name='amount']")
    private WebElement reason;
    @FindBy(css = "textarea[name='message']")
    private WebElement msg;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToMenu(String menu) {
        waitAndClick(driver.findElement(By.linkText("Contact us")));
    }

    public void fillForm() {
        fName.sendKeys(randomAlphabetic(30));
        lName.sendKeys(randomAlphabetic(30));
        eMail.sendKeys(randomAlphabetic(30) + "@hotmail.com");
        pNumber.sendKeys(randomNumeric(10));
        wUrl.sendKeys("http://www." + randomAlphanumeric(10) + ".com");
        company.sendKeys(randomAlphabetic(40));
        selectDropDownByValue(reason, "0");
        msg.sendKeys(randomAlphanumeric(40));
    }
}


