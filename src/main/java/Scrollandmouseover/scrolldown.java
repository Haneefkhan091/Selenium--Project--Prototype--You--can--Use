package Scrollandmouseover;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class scrolldown {
	public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); 
    	WebDriver driver = new ChromeDriver();
        driver.get("https://imo.ls.codesorbit.net/");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, Math.max(0, (document.documentElement.scrollHeight - window.innerHeight) / 2));");
        Thread.sleep(2000);
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    
    }
}
