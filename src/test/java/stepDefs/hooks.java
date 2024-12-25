package stepDefs;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;
import pageObjects.basePage;
import utility.Report;

import java.io.IOException;

public class hooks extends basePage {
    Scenario scenario;
    static ExtentReports report;
    public static ExtentTest test;

    @Before
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @BeforeAll
    public static void browserLaunch() throws IOException {
        initateBrowser();
        report = Report.generateExtentReport("Iam Neo Report");
        Report.attachScreenshotToReport("Screenshot", test, "Execution Screenshot");
    }

    @AfterAll
    public static void tearDown() throws Exception {
        //Report.attachScreenshotToReport("Screenshot", test, "Execution Screenshot");
        driver.quit();
    }
}
