package ui;

import bo.SauceBO;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.Browsers;

public class CartTC {

    private WebDriver driver;

    private SauceBO sauceBO;

    @DataProvider
    public Object[][] cartDP() {
        return new Object[][]{
                {"Sauce Labs Backpack"},
                {"Test.allTheThings() T-Shirt (Red)"}
        };
    }

    @BeforeClass
    public void init() {
        this.driver = BrowserFactory.getDriver(Browsers.CHROME);
        this.sauceBO = new SauceBO(driver);
    }


    @Test(dataProvider = "cartDP")
    public void test(String itemName) {
        Assert.assertTrue(sauceBO
                .openLoginPage()
                .login("standard_user", "secret_sauce")
                .clickItem(itemName)
                .addItemToCart()
                .clickCartButton()
                .verifyCartItem(itemName));
    }

    @AfterClass
    public void close() {
        driver.close();
        driver.quit();
    }
}
