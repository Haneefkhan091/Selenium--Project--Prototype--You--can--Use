package CrossBrowserTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dev.failsafe.internal.util.Assert;

import org.openqa.selenium.edge.EdgeDriver;

public class ifcondition {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // Check if Chrome is available
        if (isChromeAvailable()) {
            WebDriverManager.chromedriver().setup();
            WebDriver chromeDriver = new ChromeDriver();
            testWebsite(chromeDriver, "Chrome");
            chromeDriver.quit();
        }
        // Check if Firefox is available
        else if (isFirefoxAvailable()) {
            WebDriverManager.firefoxdriver().setup();
            WebDriver firefoxDriver = new FirefoxDriver();
            testWebsite(firefoxDriver, "Firefox");
            firefoxDriver.quit();
        }
        // Check if Edge is available
        else if (isEdgeAvailable()) {
            WebDriverManager.edgedriver().setup();
            WebDriver edgeDriver = new EdgeDriver();
            testWebsite(edgeDriver, "Edge");
            edgeDriver.quit();
        }
    }

    public static void testWebsite(WebDriver driver, String browserName) throws InterruptedException {
        // Maximize the browser window
        driver.manage().window().maximize();
        driver.get("https://imo.ls.codesorbit.net/");
        String expectedurl = driver.getCurrentUrl();

//        Assert.assertEquals(expectedurl, );
        Thread.sleep(3000);
        System.out.println("Browser: " + browserName + " | Page Title: " + driver.getTitle());
    }

    public static boolean isChromeAvailable() {
        try {
            WebDriverManager.chromedriver().setup();
            new ChromeDriver().quit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isFirefoxAvailable() {
        try {
            WebDriverManager.firefoxdriver().setup();
            new FirefoxDriver().quit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isEdgeAvailable() {
        try {
            WebDriverManager.edgedriver().setup();
            new EdgeDriver().quit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
