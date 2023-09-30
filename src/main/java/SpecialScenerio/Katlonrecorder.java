package SpecialScenerio;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;

public class Katlonrecorder {
  public static WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  WebDriverManager.chromedriver().setup();
    //System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("Admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin123");
    driver.findElement(By.xpath("//form[@action='/web/index.php/auth/validate']")).click();
    try {
      assertEquals(driver.findElement(By.xpath("//div[@id='app']/div/div/div/div/div[2]/div[2]/div/div")).getText(), "Username : AdminPassword : admin123");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.xpath("//button[@type='submit']")).getText(), "Login");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(driver.findElement(By.xpath("//div[@id='app']/div/div/div/div/div[2]/div[2]/form/div[4]/p")).getText().matches("^Forgot your password[\\s\\S]$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    driver.findElement(By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li[6]/a/span")).isDisplayed();
    driver.findElement(By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li[6]/a/span")).click();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7");
    driver.findElement(By.linkText("Contact Details")).click();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/contactDetails/empNumber/7");
    Thread.sleep(1000);
    
    // Generate random values for number and email
    String randomNumber = generateRandomNumber(8);
    String randomEmail = generateRandomEmail();
    
    // Find elements and perform actions
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div/div/div/div/div[2]/input")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div/div/div/div/div[2]/input")).clear();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div/div/div/div/div[2]/input")).sendKeys("Rustam");
    Thread.sleep(1000);
    // Continue with the rest of the actions
    
    // Set the generated random values for number and email
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div/div/div[5]/div/div[2]/input")).clear();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div/div/div[5]/div/div[2]/input")).sendKeys(randomNumber);
    Thread.sleep(1000);
    // Set the generated random email
    String emailFieldXpath = "//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div[3]/div/div/div/div[2]/input";
    setRandomEmail(emailFieldXpath, randomEmail);
    
    // Click the submit button
    driver.findElement(By.xpath("//button[@type='submit']")).click();
  
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
//    driver.quit();
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
  
  // Generate a random number with the specified length
  private String generateRandomNumber(int length) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      int randomDigit = (int) (Math.random() * 10);
      sb.append(randomDigit);
    }
    return sb.toString();
  }
  
  // Generate a random email
  private String generateRandomEmail() {
    return "Haneef" + generateRandomNumber(5) + "@gmail.com";
  }
  
  // Set a random email value for the specified email field xpath
  private void setRandomEmail(String emailFieldXpath, String randomEmail) throws InterruptedException {
    WebElement emailField = driver.findElement(By.xpath(emailFieldXpath));
    emailField.clear();
    Thread.sleep(1000);
    emailField.sendKeys(randomEmail);
  }
}
