package Selectfile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleSelectionExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("https://demoqa.com/select-menu");

        // Locate the dropdown element and click to open it
        WebElement dropdown = driver.findElement(By.xpath("//div[contains(text(),'Select...')]"));
        dropdown.click();

        // Locate and click on the desired options in the dropdown list
        WebElement greenOption = driver.findElement(By.xpath("//div[@id='react-select-4-option-0']"));
        WebElement blueOption = driver.findElement(By.xpath("//div[@id='react-select-4-option-1']"));
        WebElement blackOption = driver.findElement(By.xpath("//div[@id='react-select-4-option-3']"));

        greenOption.click();
        blueOption.click();
        blackOption.click();

        // Get all selected options
        List<WebElement> selectedOptions = driver.findElements(By.xpath("//div[@class=' css-1pahdxg-control']//div[@class=' css-1hwfws3']"));
        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }

        // Close the browser
        
    }
}
