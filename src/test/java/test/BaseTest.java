package test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;
import page.BasePage;
import util.LoggerLoad;
import util.driver.DriverFactory;

import static util.PropertyFileReader.getProperty;
import static util.driver.DriverHolder.getDriver;
import static util.driver.DriverHolder.setDriver;
import com.aventstack.chaintest.plugins.ChainTestListener;

@Listeners(ChainTestListener.class)
public class BaseTest {

    @BeforeTest
    public void beforeTest() {
        ChainTestListener.log("Start testing....");
    }

    @BeforeMethod
    public void before(ITestResult result) {
        ChainTestListener.log("starting test " + result.getMethod().getQualifiedName());
        setDriver(DriverFactory.getNewDriverInstance(getProperty("browser")));
        getDriver().manage().window().maximize();
        LoggerLoad.info("===========[ Stating Browser ]===========");
        ChainTestListener.log("Opening application....");
        LoggerLoad.info("===========[ Navigating to Application ]===========");
        getDriver().get(getProperty("application_url"));
        BasePage.clickContinueShopping(getDriver());
    }

    @AfterMethod
    public void after(ITestResult result) {
        ChainTestListener.log("Closing application....");
        LoggerLoad.info("===========[ Quiting Browser ]===========");
        ChainTestListener.log("ending test " + result.getMethod().getQualifiedName());
        if (!result.isSuccess()) {
            TakesScreenshot scr = (TakesScreenshot) getDriver();
            byte imgScr[] = scr.getScreenshotAs(OutputType.BYTES);
            ChainTestListener.embed(imgScr, "image/png");
            ChainTestListener.log("Test failed: " + result.getName());
        }
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

    @AfterTest
    public void afterTest() {
        ChainTestListener.log("Ending Test.....");
    }
}