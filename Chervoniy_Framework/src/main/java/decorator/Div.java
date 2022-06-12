package decorator;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Div extends Element{
    public Div(WebElement element) {
        super(element);
        this.element = element;
    }

    public void waitForMeVisible(WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (TimeoutException e) {
            System.out.println("Couldnt find element " + element.getAccessibleName());
        }
    }

    public String getText() {
        return element.getText();
    }
}
