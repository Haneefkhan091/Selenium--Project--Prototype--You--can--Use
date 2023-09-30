package check;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DD442023 {

	public static void main(String[] args) {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		try {
			FileInputStream file = new FileInputStream(
					"C:\\Users\\Lenovo y50-70\\eclipse-workspace\\Testingnew\\xlxs\\DOM.xlsx");
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheet("sheet1");

			for (Row row : sheet) {
				Cell usernameCell = row.getCell(0);
				Cell passwordCell = row.getCell(1);

				String Username = usernameCell.getStringCellValue();
				String Password = passwordCell.getStringCellValue();

				driver.findElement(By.xpath("//input[@placeholder='username']")).sendKeys(Username);
				driver.findElement(By.xpath("//input[@placeholder='password']")).sendKeys(Password);
				driver.findElement(By.xpath("//button[@type='submit']")).click();

				// Add assertion or verification steps here
			}

			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//driver.quit();
		}
	}

}
