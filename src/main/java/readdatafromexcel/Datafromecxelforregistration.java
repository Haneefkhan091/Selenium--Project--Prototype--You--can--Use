package readdatafromexcel;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class Datafromecxelforregistration {

	public static WebDriver driver;
	public Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {

		// System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void untitled() {
		driver.get("https://qavbox.github.io/demo/signup/");
		driver.manage().window().setSize(new Dimension(1042, 614));
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("Haneef khan");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("sabatkhel071@gmail.com");
		driver.findElement(By.id("tel")).sendKeys("03129137393");
		driver.findElement(By.id("fax")).click();
		driver.findElement(By.id("fax")).click();
		driver.findElement(By.id("fax")).click();
		driver.findElement(By.id("fax")).click();
		driver.findElement(By.id("fax")).click();
		{
			WebElement element = driver.findElement(By.id("fax"));
			Actions builder = new Actions(driver);
			builder.doubleClick(element).perform();
		}
		//driver.findElement(By.name("datafile")).sendKeys("C:\\fakepath\\hssc and scc.pdf");
		{
			WebElement dropdown = driver.findElement(By.name("sgender"));
			dropdown.findElement(By.xpath("//option[. = 'Male']")).click();
		}
		driver.findElement(By.xpath("(//input[@id='ip'])[2]")).click();
		{
			WebElement dropdown = driver.findElement(By.id("tools"));
			dropdown.findElement(By.xpath("//option[. = 'Selenium']")).click();
		}
		driver.findElement(By.id("submit")).click();
		assertThat(driver.switchTo().alert().getText(), is("Registration Done!"));
		driver.switchTo().alert().accept();
	}
}
