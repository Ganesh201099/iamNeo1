package pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

public class basePage {
    public static RemoteWebDriver driver;
    public static String ConfigurationFile = System.getProperty("user.dir") + "/Configs/Configuration.properties";
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    public static void initateBrowser() throws IOException {
        System.out.println("Initializing the desktop web browser");
        FileInputStream fis = new FileInputStream(ConfigurationFile);
        Properties prop = new Properties();
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        Browser_Launch(browserName);
        driver.get(prop.getProperty("url"));
    }

    public static void Browser_Launch(String browser) throws IOException {
        if (browser.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        } else if (browser.contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        } else if (browser.contains("safari")) {
            SafariOptions options = new SafariOptions();
            driver = new SafariDriver(options);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        } else if (browser.contains("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
    }

    public void waitTillElementPresent(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isElementDisplayed(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public void hoverOverElement(WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            Log.error("Hover Over element error:" + e);
            //System.out.println("Hover Over element error: "+ e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Log.error("Click on Element error:" + e);
            //System.out.println("Click on Element error: "+ e);
        }
    }

    public void switchToNewWindow() {
        try {
            Set<String> windowHandles = driver.getWindowHandles();
            for (String windowHandle : windowHandles) {
                if (!windowHandle.isEmpty()) {
                    driver.switchTo().window(windowHandle);
                } else {
                    throw new Exception("New window could not be retrieved");
                }
            }
        } catch (Exception e) {
            Log.error("Error: "+e);
        }
    }
}
