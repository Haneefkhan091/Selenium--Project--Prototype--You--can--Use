package TASSSK;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        try {
            driver.get("https://savevideo.me/en/");
            // Disable JavaScript to prevent ads from loading
            ((JavascriptExecutor) driver).executeScript("window.onload = null;");
            
            WebElement urlInput = driver.findElement(By.xpath("//input[@id='url']"));
            urlInput.sendKeys("https://youtu.be/sO8eGL6SFsA", Keys.ENTER);

            // Wait for new tab to open (assuming the link opens in a new tab)
            String parentHandle = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(parentHandle)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

            // Perform actions in the child tab if needed
            // ...

            // Close the child tab and switch back to the parent tab
            driver.close();  // Close the child tab
            driver.switchTo().window(parentHandle);  // Switch back to parent tab

            // Continue interacting with the parent tab
            // ...

            WebElement urlInput2 = driver.findElement(By.xpath("//input[@id='url']"));
            urlInput2.sendKeys("https://youtu.be/sO8eGL6SFsA", Keys.ENTER);

        } finally {
            driver.quit();
        }
    }
}
