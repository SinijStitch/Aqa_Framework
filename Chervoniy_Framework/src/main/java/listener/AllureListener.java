package listener;

import factory.BrowserFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tools.Browsers;

public class AllureListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        getScreenshot();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] getScreenshot() {
        return ((TakesScreenshot) BrowserFactory.getDriver(Browsers.CHROME)).getScreenshotAs(OutputType.BYTES);
    }
}
