package TestNG;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class takescreenshotonfailedtestcasesScreenshotListener extends TestListenerAdapter {
    public static final String SCREENSHOT_FOLDER = "C:\\Users\\Codes Orbit\\eclipse-workspace\\CodesOrbit.co\\screenshot";

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);

        WebDriver driver = new ChromeDriver(); // Replace MyDriverManager with your driver manager class
        if (driver != null) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
                String fileName = "FAILED_" + result.getName() + "_" + timestamp + ".png";
                Path destinationPath = Paths.get(SCREENSHOT_FOLDER + fileName);
                Files.copy(sourceFile.toPath(), destinationPath);
                System.out.println("Screenshot taken: " + destinationPath.toAbsolutePath());
            } catch (IOException e) {
                System.err.println("Failed to take screenshot: " + e.getMessage());
            }
        }
    }
}

