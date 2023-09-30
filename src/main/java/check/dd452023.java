package check;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.*;

public class dd452023 {

    public static void main(String[] args) {
        // Specify the path to the chromedriver executable
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        // Create a new ChromeDriver instance
        WebDriver driver = new ChromeDriver(co);

        // Navigate to the login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        try {
            // Create a FileInputStream object to read from the Excel file
            FileInputStream excelFile = new FileInputStream(new File("C:\\Users\\Lenovo y50-70\\eclipse-workspace\\Testingnew\\xlxs\\DOM2.xlsx"));

            // Create a Workbook object representing the Excel file
            Workbook workbook = new XSSFWorkbook(excelFile);

            // Get the first sheet of the Excel file
            Sheet sheet = workbook.getSheetAt(0);

            // Loop through each row of the sheet, starting from the second row (index 1)
            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                // Get the current row
                Row row = sheet.getRow(i);

                // Get the username and password cells for the current row
                Cell usernameCell = row.getCell(0);
                Cell passwordCell = row.getCell(1);

                // Get the values of the username and password cells
                String username = usernameCell.getStringCellValue();
                String password = passwordCell.getStringCellValue();

                // Enter the username and password and submit the form
                driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys(username);
				driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/input[1]")).sendKeys(password);
				driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]")).click();


                // Add assertion or verification steps heres
            }

            // Close the FileInputStream object
            excelFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Quit the WebDriver instance to close the browser
            //driver.quit();
        }
    }
}
