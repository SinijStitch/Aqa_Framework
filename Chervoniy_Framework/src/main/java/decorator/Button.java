package decorator;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button extends Element{
    public Button(WebElement element) {
        super(element);
        this.element = element;
    }

    public void waitForMeClickable(WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Failed to wait " + element.getAccessibleName() + " to be clickable");
        }
    }

    public void clickMe() {
        element.click();
    }
}
