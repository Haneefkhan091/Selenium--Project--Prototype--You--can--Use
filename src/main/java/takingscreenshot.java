import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.ScreenshotUtil;

public class takingscreenshot {
	public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of the ChromeDriver
        driver = new ChromeDriver();

        // Navigate to a webpage
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(10000);

        // Capture a screensho t using the utility method
        ScreenshotUtil.captureScreenshot(driver, "C:\\Users\\Codes Orbit\\eclipse-workspace\\CodesOrbit.co\\screenshot", "1.png");

        // Quit the driver and close the browser
        driver.quit();
    }
}
