package addproperty;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class Createanalert {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.manage().window().setSize(new Dimension(1280, 680));
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
    @Test(priority = 0)
    public void login() {
		// TODO Auto-generated method stub
    	 driver.get("https://imo.ls.codesorbit.net/");
         driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
          driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Haneef0880@gmail.com");
          driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Haneef@12345678");
          driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

    @Test(priority = 1)
    public void createProperty() throws InterruptedException {
//        driver.get("https://imo.ls.codesorbit.net/");
//       driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
//        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Haneef0880@gmail.com");
//        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Haneef@12345678");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(text(),'Add Property')]")).click();

        driver.findElement(By.xpath("//a[@class='btn btn-min btn btn-hoverblue w-100']")).click();
        driver.findElement(By.id("category")).click();
        {
            WebElement dropdown = driver.findElement(By.id("category"));
            dropdown.findElement(By.xpath("//option[. = 'Flat']")).click();
        }
        driver.findElement(By.id("property_sub_category_id")).click();
        {
            WebElement dropdown = driver.findElement(By.id("property_sub_category_id"));
            dropdown.findElement(By.xpath("//option[. = 'Studio']")).click();
        }
        driver.findElement(By.cssSelector(".col-md-12:nth-child(3) .form-check:nth-child(2) > .custom-control-label")).click();
        driver.findElement(By.id("step-1-applyy")).click();
        driver.findElement(By.id("title")).click();
        driver.findElement(By.id("title")).sendKeys("Sector i10");
        driver.findElement(By.id("data.number_of_rooms")).click();
        {
            WebElement dropdown = driver.findElement(By.id("data.number_of_rooms"));
            dropdown.findElement(By.xpath("//option[. = '4.0']")).click();
        }
        driver.findElement(By.id("living_space")).click();
        driver.findElement(By.id("living_space")).sendKeys("23");
        driver.findElement(By.id("data.floor_space")).click();
        driver.findElement(By.id("data.floor_space")).sendKeys("32");
        driver.findElement(By.id("data.floor")).click();
        {
            WebElement dropdown = driver.findElement(By.id("data.floor"));
            dropdown.findElement(By.xpath("//option[. = '2. Floor']")).click();
        }
        driver.findElement(By.cssSelector(".col-md-12:nth-child(6) .form-check:nth-child(2) > .custom-control-label")).click();
        driver.findElement(By.id("data.description")).click();
        driver.findElement(By.id("data.description")).sendKeys("ghh");
        driver.findElement(By.cssSelector(".col-md-12:nth-child(9) .form-check:nth-child(2) > .custom-control-label")).click();
        driver.findElement(By.id("data.selling_price")).click();
        driver.findElement(By.id("data.selling_price")).sendKeys("3000");
        driver.findElement(By.cssSelector(".check-label-blue")).click();
        driver.findElement(By.cssSelector(".check-label-blue")).click();
        driver.findElement(By.id("data.country_id")).click();
        {
            WebElement dropdown = driver.findElement(By.id("data.country_id"));
            dropdown.findElement(By.xpath("//option[. = 'Switzerland']")).click();
        }
        driver.findElement(By.id("data.postcode_city")).click();
        driver.findElement(By.id("data.postcode_city")).sendKeys("6");
    }}
           
