package POMReadTable;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test1 {
	private WebDriver driver;
	private WebDriverWait wait;

	public test1() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		co.addArguments("--ignore-certificate-errors");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void openLoginPage() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	public void enterCredentials(String username, String password) {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
	}

	public void clickLoginButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Password']")));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	public void closeBrowser() {
		// driver.quit();
	}

	public void waitForElementToBeVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void navigateToAdminModule() {
		waitForElementToBeVisible(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']//span"));
		navigateToPage(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']//span"));
		WebElement element = driver.findElement(By.xpath("//div[@class='oxd-table-body']"));

        // Scroll to the element using JavaScriptExecutor
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        //Find all the element in the table 
        
        WebElement table = driver.findElement(By.xpath("//div[@role='table']"));

        // Find all rows within the table
        List<WebElement> rows = table.findElements(By.tagName("div"));

        // Iterate through each row
        for (WebElement row : rows) {
            // Find all cells within the row
            List<WebElement> cells = row.findElements(By.tagName("div"));

            // Iterate through each cell and retrieve the text
            for (WebElement cell : cells) {
                String cellText = cell.getText();
                System.out.print(cellText + "\t");
            }
            System.out.println(); // Move to the next line after each row
        }

	}

	public void navigateToPIMModulePage() {
		waitForElementToBeVisible(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']//span"));
		navigateToPage(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']//span"));
	}

	public void navigateToPage(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
	}

	public void navigateToLeaveModule() {
		waitForElementToBeVisible(By.xpath("//a[@href='/web/index.php/leave/viewLeaveModule']//span"));
		navigateToPage(By.xpath("//a[@href='/web/index.php/leave/viewLeaveModule']//span"));
	}

	public void navigateToTimeModule() {
		waitForElementToBeVisible(By.xpath("//a[@href='/web/index.php/time/viewTimeModule']//span"));
		navigateToPage(By.xpath("//a[@href='/web/index.php/time/viewTimeModule']//span"));
	}

	public void navigateToRecruitmentModule() {
		waitForElementToBeVisible(By.xpath("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']//span"));
		navigateToPage(By.xpath("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']//span"));
	}

	public void navigateToPIMModule() {
		waitForElementToBeVisible(By.xpath("//a[@href='/web/index.php/pim/viewMyDetails']//span"));
		navigateToPage(By.xpath("//a[@href='/web/index.php/pim/viewMyDetails']//span"));
	}

	public void navigateToPerformanceModule() {
		waitForElementToBeVisible(By.xpath("//a[@href='/web/index.php/performance/viewPerformanceModule']//span"));
		navigateToPage(By.xpath("//a[@href='/web/index.php/performance/viewPerformanceModule']//span"));
	}

	public void navigateToDashboardModule() {
		waitForElementToBeVisible(By.xpath("//a[@href='/web/index.php/dashboard/index']//span"));
		navigateToPage(By.xpath("//a[@href='/web/index.php/dashboard/index']//span"));
	}

	public void navigateToDirectoryModule() {
		waitForElementToBeVisible(By.xpath("//a[@href='/web/index.php/directory/viewDirectory']//span"));
		navigateToPage(By.xpath("//a[@href='/web/index.php/directory/viewDirectory']//span"));
	}

	public void navigateToMaintenanceModule() {
		waitForElementToBeVisible(By.xpath("//a[@href='/web/index.php/maintenance/viewMaintenanceModule']//span"));
		navigateToPage(By.xpath("//a[@href='/web/index.php/maintenance/viewMaintenanceModule']//span"));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123" + Keys.ENTER);
	}

	public void navigateToBuzzModule() {
		waitForElementToBeVisible(By.xpath("//a[@href='/web/index.php/buzz/viewBuzz']//span"));
		navigateToPage(By.xpath("//a[@href='/web/index.php/buzz/viewBuzz']//span"));
	}

//    public static void main(String[] args) {
//        test1 test = new test1();
//        test.openLoginPage();
//        test.enterCredentials("Admin", "admin123");
//        test.clickLoginButton();
//        test.closeBrowser();
//    }
}
