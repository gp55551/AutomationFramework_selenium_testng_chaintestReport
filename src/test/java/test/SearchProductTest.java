package test;

import org.testng.annotations.Test;
import page.HomePage;

import static util.driver.DriverHolder.getDriver;

public class SearchProductTest extends BaseTest {

    @Test
    public void searchProductAndVerifyFirstLink() {
        HomePage homePage = new HomePage(getDriver());
        homePage.searchProduct("iPhone 15")
                .verifyFirstLink("iPhone 15");
    }

    @Test
    public void verifySearch() {
        HomePage homePage = new HomePage(getDriver());
        homePage.verifySearchField();
        homePage.verifySearchButton();
    }
}