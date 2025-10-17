package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import static util.driver.DriverHolder.getDriver;

public class HomepageTest extends BaseTest {

    @Test
    public void verifyHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.verifyHomePage();
    }

    @Test
    public void verifyTitle() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertEquals(getDriver().getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, " +
                "Watches, Shoes and More - Amazon.in");

    }

    @Test
    public void verifyHomepageLanguageLink() {
        HomePage homePage = new HomePage(getDriver());
        homePage.verifyLanguageLink();
    }
}