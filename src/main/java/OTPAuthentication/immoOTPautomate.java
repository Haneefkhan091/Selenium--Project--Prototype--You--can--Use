package OTPAuthentication;

import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.search.SubjectTerm;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class immoOTPautomate {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        co.addArguments("--ignore-certificate-errors");
        WebDriver driver = new ChromeDriver(co);
        driver.get("https://imo.ls.codesorbit.net/login"); // Replace with the URL of your signup page

        
    }
}
