package Screenshotreuse;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class simplescreenshotway {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		//co.addArguments("");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://imo.ls.codesorbit.net/");
		Thread.sleep(1000);
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source=ts.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(source, new File("C:\\Users\\Codes Orbit\\eclipse-workspace\\CodesOrbit.co\\screenshot"));
//		System.out.println("completed");
		Thread.sleep(3000);
		takeScreenshot("visible");

}

	public static void takeScreenshot(String fileName) throws IOException {
		// 1. take screenshot and store it as a file format:
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// 2. now copy the screenshot to desired location using copyfile method:
		FileUtils.copyFile(file, new File("C:\\Users\\Codes Orbit\\eclipse-workspace\\CodesOrbit.co"+"\\screenshot\\"+fileName+".png"));
	}
}

