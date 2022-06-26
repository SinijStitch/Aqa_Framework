package ui;

import bo.SauceBO;
import factory.BrowserFactory;
import hibernate.HibernateService;
import listener.AllureListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import tools.Browsers;

@Listeners({AllureListener.class})
public class PriceTC {

    private WebDriver driver;

    private SauceBO sauceBO;

    @DataProvider
    public Object[][] priceDP() {
        return HibernateService.getPriceData();
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
