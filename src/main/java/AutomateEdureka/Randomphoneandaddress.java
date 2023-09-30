package AutomateEdureka;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.util.Assert;

public class Randomphoneandaddress {
    public static WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private JavascriptExecutor js;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        // System.setProperty("webdriver.chrome.driver", "");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testImmoProfileUpdate() throws Exception {
        driver.get("https://imo.ls.codesorbit.net/");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("test101");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345678abC.");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("HaneefUllah00345@gmail.com");
        driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email address'])[1]/following::div[2]"))
                .click();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Haneef@123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        driver.findElement(
//                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='No'])[15]/following::div[2]")).click();
//        try {
//            assertEquals(driver.findElement(By.id("swal2-title")).getText(), "Success");
//        } catch (Error e) {
//            verificationErrors.append(e.toString());
//        }
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[contains(@class,'nav-link dropdown-toggle')]")).click();

        driver.findElement(By.linkText("My Profile")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("Haneef Khan");
        driver.findElement(By.id("phone_number")).click();
        driver.findElement(By.id("phone_number")).clear();
        driver.findElement(By.id("phone_number")).sendKeys(generateRandomPhoneNumber());
        driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Address'])[1]/following::div[1]"))
                .click();
        driver.findElement(By.id("website")).click();
        driver.findElement(By.id("website")).clear();
        driver.findElement(By.id("website")).sendKeys("https://imo.ls.codesorbit.net/");
        driver.findElement(By.xpath("//input[@id='address']")).click();
        driver.findElement(By.xpath("//input[@id='address']")).clear();
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys(generateRandomAddress());
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='location']")).click();
        driver.findElement(By.xpath("//input[@id='location']")).clear();
        driver.findElement(By.xpath("//input[@id='location']"))
                .sendKeys("8803 Rüschlikon, Switzerland");

        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        // Provide the file path of the image you want to upload
        String imagePath = "C:\\Users\\Codes Orbit\\eclipse-workspace\\CodesOrbit.co\\Images\\Screenshot (5).png";
        // Use the sendKeys() method on the file input element to upload the image
        fileInput.sendKeys(imagePath);

        driver.findElement(By.xpath("//button[normalize-space()='Set Profile']")).click();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        // driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    private String generateRandomPhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder("+41 ");
        phoneNumber.append((int) (Math.random() * 10)).append((int) (Math.random() * 10)).append(" ");
        phoneNumber.append((int) (Math.random() * 10)).append((int) (Math.random() * 10)).append((int) (Math.random() * 10)).append(" ");
        phoneNumber.append((int) (Math.random() * 10)).append((int) (Math.random() * 10)).append(" ");
        phoneNumber.append((int) (Math.random() * 10)).append((int) (Math.random() * 10));
        return phoneNumber.toString();
    }



    
    private String generateRandomAddress() {
        String[] streets = { "Street A", "Street B", "Street C", "Street D", "Street E" };
        String[] cities = { "City X", "City Y", "City Z" };
        String[] countries = { "Country A", "Country B", "Country C" };

        String randomStreet = streets[(int) (Math.random() * streets.length)];
        String randomCity = cities[(int) (Math.random() * cities.length)];
        String randomCountry = countries[(int) (Math.random() * countries.length)];

        return randomStreet + ", " + randomCity + ", " + randomCountry;
    }
}
