package DatadrivenTesting;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Datadriventhrougharray {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // ChromeOptions co = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        String[][] logins = { { "Admin", "admin123" }, { "User1", "password1" }, { "User2", "password2" } };

        for (String[] login : logins) {
            performLogin(login[0], login[1]);
            // Perform any additional actions after login
            // ...
            // You can add additional actions here for each set of data, if needed
        }

        // Logout or navigate to another page
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"))
                .click();
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();

        driver.quit();
    }

    public static void performLogin(String username, String password) {
        WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
