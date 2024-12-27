package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.homePage;
import utility.Log;

public class ebayStepDef extends homePage {
    @Given("Launch the application")
    public void launchTheApplication() {
        Log.info("Application Launched");
    }

    @And("Wait until application is loaded completely")
    public void waitUntilApplicationIsLoadedCompletely() {
        Log.info("Application Title is present ");
        waitTillElementPresent(homePage.title);
    }

    @Then("Validate the page title")
    public void validateThePageTitle() {
        Assert.assertTrue(isElementDisplayed(homePage.title));
        Log.info("Title is present");
    }

    @When("Hover on the Electronics section")
    public void hoverOnTheElectronicsSection() {
        hoverOverElement(homePage.electronicSection);
        Log.info("Hovered on Electronic Section");
    }

    @And("Navigate to Smart home category")
    public void navigateToSmartHomeCategory() {
        waitTillElementPresent(homePage.smartHomeCategory);
        clickOnElement(homePage.smartHomeCategory);
        Log.info("Clicked on Smart Home Category");
    }

    @Then("Validate that Smart home category screen is displayed")
    public void validateThatSmartHomeCategoryScreenIsDisplayed() {
        Assert.assertTrue(isElementDisplayed(homePage.smartHomeTitle));
        Log.info("Smart home page Title is present");
    }

    @And("Validate the number of results available")
    public void validateTheNumberOfResultsAvailable() {
        Assert.assertTrue(isElementDisplayed(homePage.smartHomeResults));
        Log.info("Smart home results is present");
    }

    @And("Navigate to Smartphones category")
    public void navigateToSmartphonesCategory() {
        waitTillElementPresent(homePage.smartPhoneCategory);
        clickOnElement(homePage.smartPhoneCategory);
        Log.info("Clicked on Smart Phone Category");
    }

    @And("Enter {string} in search box")
    public void enterInSearchBox(String brand) {
        waitTillElementPresent(homePage.searchhTextBox);
        homePage.searchhTextBox.sendKeys(brand);
    }

    @And("Click on Search button")
    public void clickOnSearchButton() {
        clickOnElement(homePage.searchhButton);
    }

    @Then("Validate that Smartphones category screen is displayed")
    public void validateThatSmartphonesCategoryScreenIsDisplayed() {
        Assert.assertTrue(isElementDisplayed(homePage.smartPhoneTitle));
        Log.info("Smart Phone results is present");
    }

    @Given("Navigate to home page")
    public void navigateToHomePage() {
        clickOnElement(homePage.title);
    }

    @And("Switch to New tab")
    public void switchToNewTab() {
        switchToNewWindow();
    }

    @And("Navigate to profile screen")
    public void navigateToProfileScreen() {
        homePage.title.click();
    }
}
