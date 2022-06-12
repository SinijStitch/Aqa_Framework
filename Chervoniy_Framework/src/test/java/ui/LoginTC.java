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

public class LoginTC {

    private WebDriver driver;

    private SauceBO sauceBO;

    @DataProvider
    public Object[][] loginDP() {
        return new Object[][]{
                {"2123", "123"},
                {"233", "13"},
                {"standard_user", "secret_sauce"}
        };
    }

    @BeforeClass
    public void init() {
        this.driver = BrowserFactory.getDriver(Browsers.CHROME);
        this.sauceBO = new SauceBO(driver);
    }


    @Test(dataProvider = "loginDP")
    public void test(String login, String password) {
        Assert.assertTrue(sauceBO
                .openLoginPage()
                .login(login, password)
                .verifyLogin());
    }

    @AfterClass
    public void close() {
        driver.close();
        driver.quit();
    }
}
