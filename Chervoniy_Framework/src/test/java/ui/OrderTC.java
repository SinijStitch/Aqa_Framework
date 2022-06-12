package ui;

import bo.SauceBO;
import factory.BrowserFactory;
import listener.AllureListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import tools.Browsers;

@Listeners({AllureListener.class})
public class OrderTC {

    private WebDriver driver;

    private SauceBO sauceBO;

    @BeforeClass
    public void init() {
        this.driver = BrowserFactory.getDriver(Browsers.CHROME);
        this.sauceBO = new SauceBO(driver);
    }


    @Test
    public void test() {
        Assert.assertTrue(sauceBO
                .openLoginPage()
                .login("standard_user", "secret_sauce")
                .clickItem("Sauce Labs Fleece Jacket")
                .addItemToCart()
                .clickCartButton()
                .makeOrder("oleg", "chervoniy", "80100")
                .verifyOrder());
    }

    @AfterClass
    public void close() {
        driver.close();
        driver.quit();
    }
}
