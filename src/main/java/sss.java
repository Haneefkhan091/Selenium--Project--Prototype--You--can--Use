import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sss {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        co.addArguments("--ignore-certificate-errors");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(co);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void captureScreenshot() throws InterruptedException, IOException {
        driver.get("https://imo.ls.codesorbit.net/");
        Thread.sleep(1000);

        // Take a screenshot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Specify the directory where you want to save the screenshot
        String saveDirectory = "/path/to/save/directory/";

        // Save the screenshot to the specified directory
        File destinationFile = new File(saveDirectory + "screenshot.png");
        FileUtils.copyFile(screenshotFile, destinationFile);

        System.out.println("Screenshot saved to: " + destinationFile.getAbsolutePath());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
