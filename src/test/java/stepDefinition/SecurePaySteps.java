package stepDefinition;

import driver.BaseDriver;
import config.WriteConfiguration;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import pageRepository.GoogleSearchPage;
import pageRepository.ContactUsPage;

import java.io.File;
import java.io.PrintWriter;

public class SecurePaySteps extends BaseDriver {
    private String googlePageUrl;
    protected GoogleSearchPage googleSearchPage;
    protected ContactUsPage securePayPage;

    @Before
    public void startUp() {
        //Create the webdriver
        String driverLocation = WriteConfiguration.getProperty("driver_location");
        setDriver(driverLocation);
        //Create objects of pageObject classes
        googleSearchPage = PageFactory.initElements(getDriver(), GoogleSearchPage.class);
        securePayPage = PageFactory.initElements(getDriver(), ContactUsPage.class);
    }

    @After
    public void cleanUp(Scenario scenario) {
        //If test fails, save the screenshot and dom for debug
        if (scenario.isFailed()) {
            try {
                File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/results/screenshots/" + scenario.getName() + ".jpg"));
                PrintWriter pagesrc = new PrintWriter(scenario.getName() + ".html", "UTF-8");
                pagesrc.write(getDriver().getPageSource());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot:");
                e.printStackTrace();
            }
        }
        quitDriver();
    }

    @Given("^the user is on google search")
    public void userIsOnGooglePage() {
        googlePageUrl = WriteConfiguration.getProperty("googlePageUrl");
        getDriver().get(googlePageUrl);
    }

    @When("^the user searches \"([^\"]*)\" on Google$")
    public void userSearchFor(String arg0) {
        googleSearchPage.enterSearchText(arg0);
        googleSearchPage.clickSearchButton();
    }


    @And("^the user clicks the link \"([^\"]*)\"$")
    public void userClicksTheLink(String link) throws Throwable {
        googleSearchPage.openLink(link);
    }


    @And("^the user navigates to \"([^\"]*)\" link$")
    public void userNavigatesToMenu( String menu) throws Throwable {

        securePayPage.navigateToMenu(menu);
    }


    @And("^the user fills the form with random data$")
    public void userFillsTheFormWithRandomData() throws Throwable {
        securePayPage.fillForm();
    }

    @Then("^verify the user is on the page displaying \"([^\"]*)\"$")
    public void verifyUserIsOnThePageWithTitle(String title) throws Throwable {
        securePayPage.waitForPageTitle(title);
        Assert.assertEquals(title, getDriver().getTitle());
    }
}
