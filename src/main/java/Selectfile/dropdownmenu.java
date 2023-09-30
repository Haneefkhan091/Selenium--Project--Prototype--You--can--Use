package Selectfile;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdownmenu {
	public static WebDriver driver;

	public static void main(String[] args) {
		// Set the path to the chromedriver executable

		WebDriverManager.chromedriver().setup();
		// Initialize ChromeDriver
		driver = new ChromeDriver();

		// Navigate to the web page containing the dropdown
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().setSize(new Dimension(1377, 734));
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
