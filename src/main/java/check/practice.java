package check;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;

public class practice {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    //System.setProperty("webdriver.chrome.driver", "Xpath");
    WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    try {
      assertEquals(driver.findElement(By.xpath("//div[@id='app']/div/div/div/div/div[2]/div[2]/div/div/p")).getText(), "Username : Admin");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("Admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin123");
    try {
      assertEquals(driver.getTitle(), "OrangeHRM");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.name("password")).click();
    try {
      assertEquals(driver.findElement(By.name("password")).getAttribute("value"), "admin123");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//img[@alt='company-branding']")).click();
    driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
    driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    try {
      assertEquals(driver.findElement(By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li[8]/a/span")).getText(), "Dashboard");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li/a/span")).click();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div[2]/div[3]")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [doubleClick | xpath=//div[@id='app']/div/div[2]/div[2]/div/div[2]/div[3] | ]]
    driver.findElement(By.linkText("Leave")).click();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList");
    driver.findElement(By.linkText("PIM")).click();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div/div/div[2]/div/div/input")).click();
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div/div/div[2]/div/div/input")).clear();
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div/div/div[2]/div/div/input")).sendKeys("Maruti Bharat  Mage");
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div[2]/div/div[2]/input")).click();
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div[2]/div/div[2]/input")).clear();
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div[2]/div/div[2]/input")).sendKeys("123112");
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div[3]/div/div[2]/div/div/div[2]/i")).click();
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div[4]/div/div[2]/div/div/div")).click();
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div[5]/div/div[2]/div/div/input")).click();
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div[5]/div/div[2]/div/div/input")).clear();
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div[5]/div/div[2]/div/div/input")).sendKeys("Sania  Shaheen");
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div[6]/div/div[2]/div/div/div")).click();
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div[7]/div/div[2]/div/div")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//div[@id='oxd-toaster_1']/div/div/div[2]/p[2]")).click();
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
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
}
