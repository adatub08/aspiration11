package Steps.ui;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ui.AspirarionPage;
import utilities.helper.ui.BrowserHelper;
import utilities.ui.ConfigsReader;
import utilities.ui.Driver;

import java.util.Set;

public class AspirationProductsSteps {

    AspirarionPage aspirPage = new AspirarionPage();
    BrowserHelper browserHelper = new BrowserHelper();
    String secondWindow;
    Set<String> allWindowHandles;
    String emailInputWindow;

    @Given("^The user is on \"([^\"]*)\" homepage$")
    public void the_user_is_on_homepage(String homePageUrl) throws Throwable {
        Driver.getDriver().navigate().to(ConfigsReader.getProperty("baseUrl"));
    }

    @When("^user clicks \"([^\"]*)\" button$")
    public void user_clicks_button(String spendNSave) throws Throwable {
        aspirPage.spendNsaveLink.click();
    }

    @Then("^verify \"([^\"]*)\" and \"([^\"]*)\" products are displayed on the page$")
    public void verify_and_products_are_displayed_on_the_page(String aspiration, String aspirationPlus) throws Throwable {
        secondWindow = Driver.getDriver().getWindowHandle();
        Assert.assertTrue(aspirPage.getAspirationButton.isDisplayed());
        Assert.assertTrue(aspirPage.getAspirationPlusButton.isDisplayed());

    }

    @Then("^user clicks \"([^\"]*)\"$")
    public void user_clicks(String getAspiration) {
        browserHelper.clickWithJS(aspirPage.getAspirationButton);
        emailInputWindow = Driver.getDriver().getWindowHandle();
        allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(secondWindow)) {
                Driver.getDriver().switchTo().window(windowHandle);
            }
        }
    }

    @Then("^input field for email address is displayed$")
    public void input_field_for_email_address_is_displayed() throws Throwable {
        Assert.assertTrue(aspirPage.inputForEmailOnModalWindow.isDisplayed());
        Driver.getDriver().switchTo().window(secondWindow);
        //aspirPage.buttonCloseOnAlert.click();
        browserHelper.clickWithJS(aspirPage.getAspirationPlusButton);

        allWindowHandles = Driver.getDriver().getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(secondWindow) && !windowHandle.equals(emailInputWindow)) {
                Driver.getDriver().switchTo().window(windowHandle);
            }
        }

        browserHelper.waitForVisibility(aspirPage.signSeventyOneFromRadioButtonFromYearly, 3000);

    }

    @Then("^monthly and early plans are displayed$")
    public void monthly_and_early_plans_are_displayed() throws Throwable {
    }

    @Then("^verify that yearly radio option is \"([^\"]*)\"$")
    public void verify_that_yearly_radio_option_is(String signSeventyOne) throws Throwable {
       // Assert.assertTrue(aspirPage.signSeventyOneFromRadioButtonFromYearly.isDisplayed());

    }

    @Then("^verify that monthly radio button is \"([^\"]*)\"$")
    public void verify_that_monthly_radio_button_is(String signSevenNightyNine) throws Throwable {
       // Assert.assertTrue(aspirPage.signSevenNightyNineFromRadioButtonFromMonthly.isDisplayed());
    }

}
