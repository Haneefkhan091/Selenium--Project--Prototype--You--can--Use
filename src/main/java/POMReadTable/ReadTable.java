package POMReadTable;

import org.openqa.selenium.WebDriver;

public class ReadTable {
    public static WebDriver driver;

    public static void main(String[] args) {
     

        test1 test = new test1();
        test.openLoginPage();
        test.enterCredentials("Admin", "admin123");
        test.clickLoginButton();
        test.navigateToAdminModule();
        

        // Close the browser
        driver.quit();
    



//        // Find the table element
//        WebElement table = driver.findElement(By.xpath("//table[@id='your-table-id']"));
//
//        // Find all rows within the table
//        List<WebElement> rows = table.findElements(By.tagName("tr"));
//
//        // Iterate through each row
//        for (WebElement row : rows) {
//            // Find all cells within the row
//            List<WebElement> cells = row.findElements(By.tagName("td"));
//
//            // Iterate through each cell and retrieve the text
//            for (WebElement cell : cells) {
//                String cellText = cell.getText();
//                System.out.print(cellText + "\t");
//            }
//            System.out.println(); // Move to the next line after each row
//        }
//
//        // Close the browser
//        driver.quit();
	}
    }

