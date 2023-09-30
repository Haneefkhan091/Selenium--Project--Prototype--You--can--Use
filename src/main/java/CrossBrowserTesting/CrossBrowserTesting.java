package CrossBrowserTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.opera.OperaDriver;

public class CrossBrowserTesting {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// Setup Chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver chromeDriver = new ChromeDriver();
		testWebsite(chromeDriver, "Chrome");

		// Setup Firefox driver
		WebDriverManager.firefoxdriver().setup();
		WebDriver firefoxDriver = new FirefoxDriver();
		testWebsite(firefoxDriver, "Firefox");

		// Setup Edge driver
		WebDriverManager.edgedriver().setup();
		WebDriver edgeDriver = new EdgeDriver();
		testWebsite(edgeDriver, "Edge");

		// Setup Opera driver
		WebDriverManager.operadriver().setup();
//        WebDriver operaDriver = new OperaDriver();
//        testWebsite(operaDriver, "Opera");

		// Quit all the browsers
		chromeDriver.quit();
		firefoxDriver.quit();
		edgeDriver.quit();
//        operaDriver.quit();
	}

	public static void testWebsite(WebDriver driver, String browserName) throws InterruptedException {
		// Maximize the browser window
		driver.manage().window().maximize();
		driver.get("https://imo.ls.codesorbit.net/");
		Thread.sleep(3000);
		System.out.println("Browser: " + browserName + " | Page Title: " + driver.getTitle());
	}
}
