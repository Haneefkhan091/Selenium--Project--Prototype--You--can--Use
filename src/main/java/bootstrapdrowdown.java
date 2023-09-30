import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bootstrapdrowdown {
	public static WebDriver driver;

	public static void main(String[] args) {
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\Desktop\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Clicking on Bootstrap Dropdown
		WebElement optiona = driver.findElement(By.xpath("//div[contains(text(),'Select Option')]"));
		optiona.click();
		WebElement option2 = driver.findElement(By.xpath("//div[@id='react-select-2-option-0-1']"));
		option2.click();
		// Select element

		WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
		// Create a Select object
		Select dropdown = new Select(dropdownElement);
		// Get all options as a list of WebElements
		List<WebElement> options = dropdown.getOptions();
		dropdown.selectByVisibleText("Purple");
		// Print the text of each option
		for (WebElement option : options) {
			System.out.println(option.getText());

		}

	}
}