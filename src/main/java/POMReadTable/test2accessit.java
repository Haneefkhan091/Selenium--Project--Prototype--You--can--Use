package POMReadTable;

import org.openqa.selenium.WebDriver;

public class test2accessit {
	public static WebDriver driver;

	public static void main(String[] args) {
//        waitsEXandIM test = new waitsEXandIM();
		test1 test = new test1();
		test.openLoginPage();
		test.enterCredentials("Admin", "admin123");
		test.clickLoginButton();
		// Navigate to different modules
		test.navigateToLeaveModule();
		test.navigateToTimeModule();
		test.navigateToRecruitmentModule();
		test.navigateToPIMModule();
		test.navigateToPerformanceModule();
		test.navigateToDashboardModule();
		test.navigateToDirectoryModule();
		test.navigateToMaintenanceModule();
        test.navigateToBuzzModule(); 
        test.navigateToAdminModule();
        test.navigateToPIMModulePage();
        
		

	}
}
