package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage extends basePage {

    public homePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='gh-logo']")
    public static WebElement title;

    @FindBy(xpath= "(//a[text()='Electronics'])[2]")
    public static WebElement electronicSection;

    @FindBy(xpath= "(//a[text()='Motors'])[1]")
    public static WebElement motorsSection;

    @FindBy(xpath= "(//a[text()='Fashion'])[2]")
    public static WebElement fashionSection;

    @FindBy(xpath= "//a[text()='Smart home']")
    public static WebElement smartHomeCategory;

    @FindBy(xpath= "//h1[text()='Surveillance & Smart Home Electronics']")
    public static WebElement smartHomeTitle;

    @FindBy(xpath= "//h2[text()='468,833 Results']")
    public static WebElement smartHomeResults;

    @FindBy(xpath= "//a[text()='Smartphones and accessories']")
    public static WebElement smartPhoneCategory;

    @FindBy(xpath= "//*[@id='gh-btn']")
    public static WebElement searchhButton;

    @FindBy(xpath= "//h1[text()='Cell Phones, Smart Watches & Accessories']")
    public static WebElement smartPhoneTitle;

    @FindBy(xpath= "//*[@id='gh-ac']")
    public static WebElement searchhTextBox;

}
