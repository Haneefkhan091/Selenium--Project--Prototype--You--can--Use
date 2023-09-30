//package readdatafromexcel;
//
//import org.testng.annotations.AfterMethod;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeMethod;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.core.IsNot.not;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import static org.hamcrest.MatcherAssert.assertThat;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.Keys;
//import java.util.*;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//@Test
//public class onlywaitcommandadded {
//
//    public static WebDriver driver;
//    public Map<String, Object> vars;
//    JavascriptExecutor js;
//
//    @BeforeMethod
//	public void setUp() {
//
//        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//        ChromeOptions co = new ChromeOptions();
//        co.addArguments("--remote-allow-origins=*");
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver(co);
//        js = (JavascriptExecutor) driver;
//        vars = new HashMap<String, Object>();
//    }
//
//    @AfterMethod
//	public void tearDown() {
//        driver.quit();
//    }
//
//    public void untitled() {
//        driver.get("https://qavbox.github.io/demo/signup/");
//        driver.manage().window().setSize(new Dimension(1042, 614));
//
//      //  WebDriverWait wait = new WebDriverWait(driver, 10);
//
//        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
//        username.click();
//        username.sendKeys("Haneef khan");
//
//        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
//        email.click();
//        email.sendKeys("sabatkhel071@gmail.com");
//
//        WebElement tel = wait.until(ExpectedConditions.elementToBeClickable(By.id("tel")));
//        tel.sendKeys("03129137393");
//
//        WebElement fax = wait.until(ExpectedConditions.elementToBeClickable(By.id("fax")));
//        for (int i = 0; i < 5; i++) {
//            fax.click();
//        }
//
//        WebElement datafile = wait.until(ExpectedConditions.elementToBeClickable(By.name("datafile")));
//        datafile.sendKeys("C:\\fakepath\\hssc and scc.pdf");
//
//        WebElement sgender = wait.until(ExpectedConditions.elementToBeClickable(By.name("sgender")));
//        sgender.click();
//        sgender.findElement(By.xpath("//option[. = 'Male']")).click();
//
//        WebElement ip = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='ip'])[2]")));
//        ip.click();
//
//        WebElement tools = wait.until(ExpectedConditions.elementToBeClickable(By.id("tools")));
//        tools.click();
//        tools.findElement(By.xpath("//option[. = 'Selenium']")).click();
//
//        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
//        submit.click();
//
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        assertThat(alert.getText(), is("Registration Done!"));
//        alert.accept();
//    }
//}
