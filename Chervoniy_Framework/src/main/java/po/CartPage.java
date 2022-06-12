package po;

import decorator.CustomFieldDecorator;
import decorator.Div;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;

    Div cartItem;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public boolean verifyItem(String itemName) {
        cartItem = new Div(driver.findElement(By.xpath("//div[contains(@class, \"inventory_item_name\") and contains(text(), \"%s\")]".formatted(itemName))));
        try {
            cartItem.waitForMeVisible(new WebDriverWait(driver, Duration.ofSeconds(3)));
        }
        catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
        return cartItem.getText().equals(itemName);
    }
}
