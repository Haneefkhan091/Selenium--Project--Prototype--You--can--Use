package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
//import io.netty.channel.pool.FixedChannelPool.AcquireTimeoutAction;
//import net.bytebuddy.implementation.bind.annotation.DefaultCall.Binder.DefaultMethodLocator.Implicit;

public class dependonmethod {
	WebDriver driver;

	@BeforeSuite
	public void beforesuite() {
		System.out.println("before suite testing");

	}

	@BeforeMethod
	public void before() {
		System.out.println("before testing");
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test()
	public void login() {
		// driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("Software
		// testing demos{Enter}");
		System.out.println("Login succesful");
		WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		usernameInput.sendKeys("Admin");
		passwordInput.sendKeys("admin123");
		loginButton.click();
	}

	@Test(dependsOnMethods = "login")
	public void Logout() {
		// TODO Auto-generated method stub

		System.out.println("Logout ");
		// driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[4]/a[1]")).click();
		driver.findElement(By.xpath("//img[@class='oxd-userdropdown-img']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	}

//	@AfterMethod
//	public void after() {
//		System.out.println("after testing");
//
//	}
//
//	@AfterTest
//	public void afterTest() {
//		System.out.println("after test");
//	}
}
