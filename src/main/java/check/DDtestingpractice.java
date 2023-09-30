package check;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DDtestingpractice {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		String[][] testData = {
			{"Admin", "admin123"},
			{"Admin1", "admin1234"},
			{"Admin2", "admin12345"}
		};
		
		for (String[] data : testData) {
			login(data[0], data[1]);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.navigate().back();
		}
		
		driver.quit();
	}

	public static void login(String username, String password) {
		driver.findElement(By.xpath("//input[@placeholder='Username']"))
			.sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']"))
			.sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
}
