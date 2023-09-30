package Existingbrowseropen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class notworkingwithlatestversion {
	public static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.setExperimentalOption("debuggerAddress","localhost:9222");
		driver=new ChromeDriver(opt);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

}
