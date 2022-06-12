package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import tools.Browsers;

public class BrowserFactory {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver(Browsers browser) {
        if (DRIVER.get() == null) {
            switch (browser) {
                case CHROME -> {
                    WebDriverManager.chromedriver().setup();
                    DRIVER.set(new ChromeDriver());
                }
                case FIREFOX -> {
                    WebDriverManager.firefoxdriver().setup();
                    DRIVER.set(new FirefoxDriver());
                }
            }
        }

        return DRIVER.get();
    }

}
