package bo;

import org.openqa.selenium.WebDriver;
import po.LoginPage;
import po.MainPage;

public class SauceBO {

    private final WebDriver driver;

    private final LoginPage loginPage;

    private final MainPage mainPage;

    public SauceBO(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    public SauceBO openLoginPage() {
        loginPage.openLoginPage();
        return this;
    }

    public SauceBO login(String login, String password) {
        loginPage.typeLogin(login);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        return this;
    }

    public boolean verifyLogin() {
        return mainPage.verifyLogin();
    }
}
