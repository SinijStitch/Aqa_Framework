package bo;

import org.openqa.selenium.WebDriver;
import po.*;

public class SauceBO {

    private final WebDriver driver;

    private final LoginPage loginPage;

    private final MainPage mainPage;

    private final ItemPage itemPage;

    private final CartPage cartPage;

    private final CheckoutPage checkoutPage;

    public SauceBO(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        itemPage = new ItemPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
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

    public SauceBO clickItem(String itemName) {
        mainPage.clickItem(itemName);
        return this;
    }

    public String getPrice() {
        return itemPage.getPrice();
    }

    public SauceBO addItemToCart() {
        itemPage.clickAddToCart();
        return this;
    }

    public SauceBO clickCartButton() {
        itemPage.clickCartButton();
        return this;
    }

    public boolean verifyCartItem(String itemName) {
        return cartPage.verifyItem(itemName);
    }

    public SauceBO makeOrder(String firstName, String lastName, String postalCode) {
        cartPage.clickCheckoutButton();
        checkoutPage.typeFirstName(firstName);
        checkoutPage.typeLastName(lastName);
        checkoutPage.typePostalCode(postalCode);
        checkoutPage.pressSubmit();
        checkoutPage.pressFinish();
        return this;
    }

    public boolean verifyOrder() {
        return checkoutPage.verifyOrder();
    }

    public String getDescription() {
        return itemPage.getDescription();
    }
}
