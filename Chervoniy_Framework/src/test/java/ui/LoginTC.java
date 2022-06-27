package ui;

import bo.SauceBO;
import factory.BrowserFactory;
import hibernate.HibernateService;
import listener.AllureListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import tools.Browsers;

import java.io.IOException;

@Listeners({AllureListener.class})
public class LoginTC {

    private WebDriver driver;

    private SauceBO sauceBO;

    @DataProvider
    public Object[][] loginDP() {
       return HibernateService.getLoginTestData();
    }

    @BeforeClass
    public void init() throws IOException {
        this.driver = BrowserFactory.getDriver();
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
