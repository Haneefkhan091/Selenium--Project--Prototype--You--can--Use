import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateOTP {
	public static WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();

		driver.manage().window().setSize(new Dimension(1280, 680));
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

	@Test(priority = 0)
	public void login() {
		String userProfile = "D:\\information about automation\\report";

		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\user\\Desktop\\chromedriver.exe");

//		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + userProfile);
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://imo.ls.codesorbit.net/");
		  driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("HaneefUllah00345@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Haneef@12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.findElement(By.xpath("//input[@id='code']")).sendKeys("");
		driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
	}

}