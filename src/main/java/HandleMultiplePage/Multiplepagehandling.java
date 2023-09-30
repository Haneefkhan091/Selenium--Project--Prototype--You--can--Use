package HandleMultiplePage;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiplepagehandling {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://imo.ls.codesorbit.net/");
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);

        // Perform mouse-over action on the element
       // actions.moveToElement(element).build().perform();
		Alert alert = driver.switchTo().alert();
		alert.accept();
//		WebElement financing = driver.findElement(By.xpath("//a[normalize-space()='Financing']"));
		WebElement financing = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
		actions.moveToElement(financing).build().perform();
		actions.moveToElement(financing).perform();
		financing.click();
		 // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Iterate through each window handle
        for (String windowHandle : windowHandles) {
            // Switch to the new tab/window
            driver.switchTo().window(windowHandle);
            // Perform actions in the new tab/window
            // Close the new tab/window if it is not the parent window
            if (!windowHandle.equals(driver.getWindowHandle())) {
                driver.close();
            }
        }
        // Switch back to the parent window
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        // Continue with actions in the parent window
        // Close the browser
        driver.quit();
	}
}
