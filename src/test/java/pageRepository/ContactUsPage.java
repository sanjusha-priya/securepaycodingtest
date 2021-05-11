package pageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.github.javafaker.Faker;

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
        Faker faker = new Faker();

        fName.sendKeys(faker.name().firstName());
        lName.sendKeys(faker.name().lastName());
        eMail.sendKeys(faker.name().username()+"@gmail.com");
        pNumber.sendKeys(faker.phoneNumber().cellPhone());
        wUrl.sendKeys(faker.internet().url());
        company.sendKeys(faker.company().name());
        selectDropDownByValue(reason, "0");
        msg.sendKeys(faker.lorem().sentences(30).toString());
    }
}


