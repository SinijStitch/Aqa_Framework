package po;

import decorator.Button;
import decorator.CustomFieldDecorator;
import decorator.Input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    @FindBy(xpath = "//input[contains(@placeholder, \"Username\")]")
    Input loginInput;

    @FindBy(xpath = "//input[contains(@placeholder, \"Password\")]")
    Input passwordInput;

    @FindBy(xpath = "//input[contains(@type, \"submit\")]")
    Button loginButton;

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public void openLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void typeLogin(String login) {
        loginInput.waitForMeVisible(new WebDriverWait(driver, Duration.ofSeconds(3)));
        loginInput.sendData(login);
    }

    public void typePassword(String password) {
        passwordInput.waitForMeVisible(new WebDriverWait(driver, Duration.ofSeconds(3)));
        passwordInput.sendData(password);
    }

    public void clickLogin() {
        loginButton.waitForMeClickable(new WebDriverWait(driver, Duration.ofSeconds(3)));
        loginButton.clickMe();
    }
}
