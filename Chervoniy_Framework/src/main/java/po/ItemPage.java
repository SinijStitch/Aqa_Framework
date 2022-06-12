package po;

import decorator.Button;
import decorator.CustomFieldDecorator;
import decorator.Div;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage {

    private WebDriver driver;

    @FindBy(className = "inventory_details_price")
    Div priceDiv;

    @FindBy(xpath = "//button[contains(text(), \"Add to cart\")]")
    Button addToCartButton;

    @FindBy(className = "shopping_cart_link")
    Button cartButton;

    @FindBy(xpath = "//div[contains(@class, \"inventory_details_desc\") and contains(@class, \"large_size\")]")
    Div descriptionDiv;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public String getPrice() {
        priceDiv.waitForMeVisible(new WebDriverWait(driver, Duration.ofSeconds(3)));
        return priceDiv.getText();
    }

    public void clickAddToCart() {
        addToCartButton.waitForMeClickable(new WebDriverWait(driver, Duration.ofSeconds(2)));
        addToCartButton.clickMe();
    }

    public void clickCartButton() {
        cartButton.clickMe();
    }

    public String getDescription() {
        descriptionDiv.waitForMeVisible(new WebDriverWait(driver, Duration.ofSeconds(3)));
        return descriptionDiv.getText();
    }


}
