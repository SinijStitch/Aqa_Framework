package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import tools.Browsers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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

    public static WebDriver getDriver() throws IOException {
        if (DRIVER.get() == null) {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/config.properties"));
            String browser = properties.getProperty("browser");
            switch (browser) {
                case "CHROME" -> {
                    WebDriverManager.chromedriver().setup();
                    DRIVER.set(new ChromeDriver());
                }
                case "FIREFOX" -> {
                    WebDriverManager.firefoxdriver().setup();
                    DRIVER.set(new FirefoxDriver());
                }
                default -> throw new RuntimeException("This Browser is not supported");
            }
        }

        return DRIVER.get();
    }

}
