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

public class PriceTC {

    private WebDriver driver;

    private SauceBO sauceBO;

    @DataProvider
    public Object[][] priceDP() {
        return new Object[][]{
                {"Sauce Labs Backpack", "$29.99"},
                {"Sauce Labs Onesie", "$8.99"}
        };
    }

    @BeforeClass
    public void init() {
        this.driver = BrowserFactory.getDriver(Browsers.CHROME);
        this.sauceBO = new SauceBO(driver);
    }


    @Test(dataProvider = "priceDP")
    public void test(String itemName, String price) {
        Assert.assertEquals(sauceBO
                .openLoginPage()
                .login("standard_user", "secret_sauce")
                .clickItem(itemName)
                .getPrice(), price);
    }

    @AfterClass
    public void close() {
        driver.close();
        driver.quit();
    }
}
