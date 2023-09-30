package Scrollandmouseover;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scrollandmouseover {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.browserstack.com/guide/wait-commands-in-selenium-webdriver");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	        // Scroll up by pixel
//	        js.executeScript("window.scrollBy(0, -500)");
//
//	        // Scroll up to the top of the page
//	        js.executeScript("window.scrollTo(0, 0)");
//		js.executeScript("window.scrollBy(0, 1000)");
//		   js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// Scroll down smoothly
		Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//p[contains(text(),'Test on BrowserStack')]")))
                .clickAndHold()
                .moveByOffset(0, 500)
                .release()
                .perform();
        WebElement element = driver.findElement(By.xpath("//a[@title='Sign up on BrowserStack']"));
        actions.moveToElement(element).perform();
	}
}
