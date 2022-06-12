package po;

import decorator.Button;
import decorator.CustomFieldDecorator;
import decorator.Div;
import decorator.Input;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class CheckoutPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[contains(@name, \"firstName\")]")
    Input firstNameInput;

    @FindBy(xpath = "//input[contains(@name, \"lastName\")]")
    Input lastNameInput;

    @FindBy(xpath = "//input[contains(@name, \"postalCode\")]")
    Input postalCodeInput;

    @FindBy(xpath = "//input[contains(@name, \"continue\")]")
    Button continueButton;

    @FindBy(id = "finish")
    Button finishButton;

    @FindBy(className = "complete-header")
    Div thanksForOrderDiv;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public void typeFirstName(String firstName) {
        firstNameInput.waitForMeVisible(new WebDriverWait(driver, Duration.ofSeconds(3)));
        firstNameInput.sendData(firstName);
    }

    public void typeLastName(String lastName) {
        lastNameInput.waitForMeVisible(new WebDriverWait(driver, Duration.ofSeconds(3)));
        lastNameInput.sendData(lastName);
    }

    public void typePostalCode(String postalCode) {
        postalCodeInput.waitForMeVisible(new WebDriverWait(driver, Duration.ofSeconds(3)));
        postalCodeInput.sendData(postalCode);
    }

    public void pressSubmit() {
        continueButton.waitForMeClickable(new WebDriverWait(driver, Duration.ofSeconds(3)));
        continueButton.clickMe();
    }

    public void pressFinish() {
        finishButton.waitForMeClickable(new WebDriverWait(driver, Duration.ofSeconds(3)));
        finishButton.clickMe();
    }

    public boolean verifyOrder() {
        try {
            thanksForOrderDiv.waitForMeVisible(new WebDriverWait(driver, Duration.ofSeconds(3)));
        }
        catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
        return true;
    }

}
