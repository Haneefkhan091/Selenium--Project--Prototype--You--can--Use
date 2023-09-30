package TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class testngsimplecode {
 
	@BeforeSuite
	public void beforesuite() {
		// TODO Auto-generated method stub
		System.out.println("before suite testing");

	}
	@BeforeMethod
	public void before() {
		System.out.println("before testing");

	}
	
    @Test
    public void testExample() {
        System.out.println("Test here");
    }
    
    @AfterTest
    public void after() {
		// TODO Auto-generated method stub

    	System.out.println("after testing");
	}
    

}