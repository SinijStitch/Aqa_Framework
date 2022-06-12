package decorator;

import org.openqa.selenium.WebElement;

public class Item extends Element{
    public Item(WebElement element) {
        super(element);
        this.element = element;
    }
}
