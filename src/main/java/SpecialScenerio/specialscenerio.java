package SpecialScenerio;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class specialscenerio {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
		webdwait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='oxd-main-menu-item active']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Haneef");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Middle Name']")).sendKeys("khan");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("khannnn");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--focus']")).sendKeys("123123123213");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--focus']")).sendKeys("123123123213");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--focus']")).sendKeys("123123123213");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--focus']")).sendKeys("123123123213");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--focus']")).sendKeys("123123123213");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--focus']")).sendKeys("123123123213");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--focus']")).sendKeys("123123123213");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--focus']")).sendKeys("123123123213");

//		driver.findElement(By.linkText("")).click();
//		driver.findElement(By.name("firstName")).click();
//	    driver.findElement(By.name("firstName")).clear();
//	    driver.findElement(By.name("firstName")).sendKeys("Haneef");
//	    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div/div[2]/div/div/div[2]/input")).click();
//	    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div[2]/div[2]/div/div/div[2]/input")).click();
//	    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div[2]/div[2]/div/div/div[2]/input")).clear();
//	    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div[2]/div[2]/div/div/div[2]/input")).sendKeys("123213124124adas");

	}
}
