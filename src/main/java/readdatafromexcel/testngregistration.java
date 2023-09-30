package readdatafromexcel;

import org.testng.annotations.*;

import TestNG.takescreenshotonfailedtestcasesScreenshotListener;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
@Listeners(takescreenshotonfailedtestcasesScreenshotListener.class)
public class testngregistration {

	public static WebDriver driver;

	@BeforeTest
	public void setUp() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		driver.get("https://qavbox.github.io/demo/signup/");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)

	public void untitled() throws InterruptedException {
		
		driver.manage().window().setSize(new Dimension(1042, 614));
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("Haneef khan");
		Thread.sleep(1000);
		driver.findElement(By.id("email")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("email")).sendKeys("sabatkhel071@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("tel")).sendKeys("03129137393");
		driver.findElement(By.id("fax")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("fax")).click();
		driver.findElement(By.id("fax")).click();
		driver.findElement(By.id("fax")).click();
		driver.findElement(By.id("fax")).click();
		{
			WebElement element = driver.findElement(By.id("fax"));
			Actions builder = new Actions(driver);
			builder.doubleClick(element).perform();
		}
		// driver.findElement(By.name("datafile")).sendKeys("C:\\fakepath\\hssc and
		// scc.pdf");
		{
			WebElement dropdown = driver.findElement(By.name("sgender"));
			Thread.sleep(1000);
			dropdown.findElement(By.xpath("//option[. = 'Male']")).click();
		}
		driver.findElement(By.xpath("(//input[@id='ip'])[2]")).click();
		{
			Thread.sleep(1000);
			WebElement dropdown = driver.findElement(By.id("tools"));
			dropdown.findElement(By.xpath("//option[. = 'Selenium']")).click();
		}
		driver.findElement(By.id("submit")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.switchTo().alert().getText(), "Registration Done!");
		driver.switchTo().alert().accept();
	}
}
