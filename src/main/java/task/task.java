package task;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task {
	public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
    	WebDriverManager.chromedriver().setup();
        ChromeOptions co =  new ChromeOptions();
//        co.addArguments("");
        driver = new ChromeDriver(co);

        
        driver.get("https://savevideo.me/en/");

        
    }
}
