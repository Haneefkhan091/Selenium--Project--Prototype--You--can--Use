package readdatafromexcel;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class readdataexcel {
	public static WebDriver driver;

	@BeforeMethod
	public void launch() throws InterruptedException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(dataProvider = "loginData")
	public void test(String username, String password) {
		driver.findElement(By.xpath("//input[@placeholder='Username']"))
			.sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']"))
			.sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@DataProvider(name = "loginData")
	public Iterator<Object[]> getLoginData() throws IOException {
		List<Object[]> data = new ArrayList<Object[]>();
		String excelFilePath = "C:\\Users\\Codes Orbit\\eclipse-workspace\\CodesOrbit.co\\xlxs\\dd.xlsx";
		File excelFile = new File(excelFilePath);
		Workbook workbook = WorkbookFactory.create(excelFile);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.rowIterator();
		rowIterator.next(); // skip header row
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			String username = row.getCell(0).getStringCellValue();
			String password = row.getCell(1).getStringCellValue();
			Object[] login = { username, password };
			data.add(login);
		}
		workbook.close();
		return data.iterator();
	}

	@AfterMethod
	public void aftermetho() {
		driver.quit();
	}
}
