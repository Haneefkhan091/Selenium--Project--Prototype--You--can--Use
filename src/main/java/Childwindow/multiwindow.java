package Childwindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class multiwindow {
	public static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://imo.ls.codesorbit.net/");

		// Open a new window
//        driver.findElement(By.xpath("//a[normalize-space()='Financing']")
		driver.findElement(By.xpath("//a[normalize-space()='Financing']")).click();
		// Get the window handles
		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();

		// Iterate through the handles
		for (String handle : handles) {
			if (!handle.equals(parentHandle)) {
				// Switch to the new window
				driver.switchTo().window(handle);
				break;
			}
		}

		// Perform actions on the new window
		System.out.println("Title of the new window: " + driver.getTitle());

		// Close the new window
		driver.close();
		// Switch back to the parent window
		driver.switchTo().window(parentHandle);
		// Perform actions on the parent window
		System.out.println("Title of the parent window: " + driver.getTitle());

		// Close the parent window
		//driver.quit();
	}
}
