import bo.SauceBO;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.Browsers;

public class DescriptionTC {

    private WebDriver driver;

    private SauceBO sauceBO;

    @DataProvider
    public Object[][] descriptionDP() {
        return new Object[][]{
                {"Sauce Labs Backpack", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."},
                {"Sauce Labs Bike Light", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAAA battery included."}
        };
    }

    @BeforeClass
    public void init() {
        this.driver = BrowserFactory.getDriver(Browsers.CHROME);
        this.sauceBO = new SauceBO(driver);
    }


    @Test(dataProvider = "descriptionDP")
    public void test(String itemName, String description) {
        Assert.assertEquals(sauceBO
                .openLoginPage()
                .login("standard_user", "secret_sauce")
                .clickItem(itemName)
                .getDescription(), description);
    }

    @AfterClass
    public void close() {
        driver.close();
        driver.quit();
    }
}
