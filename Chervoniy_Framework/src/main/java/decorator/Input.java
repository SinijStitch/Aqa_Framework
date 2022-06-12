package decorator;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Input extends Element{
    public Input(WebElement element) {
        super(element);
        this.element = element;
    }

    public void waitForMeVisible(WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (TimeoutException e) {
            System.out.println("Failed to wait visibility of " + element.getAccessibleName());
        }
    }

    public void sendData(String data) {
        element.clear();
        element.sendKeys(data);
    }
}
