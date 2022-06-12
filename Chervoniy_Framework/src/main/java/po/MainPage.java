package po;

import decorator.Button;
import decorator.CustomFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;

    @FindBy(className = "shopping_cart_link")
    Button cartButton;

    Button itemNameButton;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public boolean verifyLogin() {
        try {
            cartButton.waitForMeClickable(new WebDriverWait(driver, Duration.ofSeconds(3)));
        }
        catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
        return true;
    }

    public void clickItem(String itemName) {

    }
}
