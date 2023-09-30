package DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dd1browserstack {
	WebDriver driver;
	@Test(dataProvider = "testdata")
	public void demoClass(String username, String password) throws InterruptedException {
//System.setProperty("webdriver.chrome.driver", "Path of Chrome Driver");
		WebDriverManager.chromedriver().setup();
		// Webdriver driver = new ChromeDriver();
         
		
		// driver.get("<a href="https://www.browserstack.com/users/sign_in</a>");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]"))
				.sendKeys(username);
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/input[1]"))
				.sendKeys(password);
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]"))
				.click();

		Thread.sleep(5000);
	
		System.out.println("Login successful");
	}

	@AfterMethod
	void ProgramTermination() {
		driver.quit();
	}

	@DataProvider(name = "testdata")
	public Object[][] testDataExample(ReadExcelFile config) {
		ReadExcelFile configuration = new ReadExcelFile("/Testingnew/xlxs/DOM2.xlsx");
		int rows = configuration.getRowCount(0);
		Object[][] signin_credentials = new Object[rows][2];

		for (int i = 0; i < rows; i++) {
			signin_credentials[i][0] = config.getData(0, i, 0);
			signin_credentials[i][1] = config.getData(0, i, 1);
		}
		return signin_credentials;
	}
}