package usingselectorHUb;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class testing {
    public static WebDriver driver;

    public static void main(String[] args) {
        // Set the path to chromedriver executable
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
    	
        WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(duration); 
        // Initialize WebDriverWait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://imo.ls.codesorbit.net/");

        // Click on the 'Home' link
        WebElement homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Home']")));
        homeLink.click();

        // Click on the 'Financing' link
        WebElement financingLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Financing']")));
        financingLink.click();

        // Click on the 'Moving' link
        WebElement movingLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Moving']")));
        movingLink.click();

        // Click on the 'Favourite' link
        WebElement favouriteLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Favourite']")));
        favouriteLink.click();
        driver.navigate().back();

        // Click on the 'Contact' link
        WebElement contactLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body//div//nav//div//ul//li//a[normalize-space()='Contact']")));
        contactLink.click();
        driver.navigate().back();

        // Click on the 'Sign in' link
        WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Sign in']")));
        signInLink.click();
        driver.navigate().back();

        // Click on the 'Add Property' link
        WebElement addPropertyLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Add Property']")));
        addPropertyLink.click();
        driver.navigate().back();

        driver.quit();
    }
}
