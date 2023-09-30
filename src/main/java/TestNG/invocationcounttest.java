package TestNG;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

public class invocationcounttest {
	public static WebDriver driver;

	@Test(invocationCount = 5)
	public void inocationcount() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("before testing");
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		takeScreenshot(driver, "sunday.png");

	}

	@Test
	public static void takeScreenshot(WebDriver driver, String filename) throws IOException {
		// Convert WebDriver instance to TakesScreenshot
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Call getScreenshotAs method to create an image file
		File source = ts.getScreenshotAs(OutputType.FILE);

		// Save the image file to the specified filename
		FileHandler.copy(source, new File(filename));
	}
}
