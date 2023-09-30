package TestNG;

import static org.testng.Assert.assertEquals;

import org.testng.TestNG;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import dev.failsafe.internal.util.Assert;
@Listeners(takescreenshotonfailedtestcasesScreenshotListener.class)
public class softassertionhardassertion {
	SoftAssert softassert = new SoftAssert();

	@Test(retryAnalyzer = retrylistnerscode.class)

	public void test() {
		// TODO Auto-generated method stub
//IN soft assert you must have assertall to store all the softassert result there
		// If hard assert got passed the below test cases will be automatically got
		// failed(Mostly use after login)

		System.out.println("Login");

		// assertEquals(true, false);
		softassert.assertEquals(true, false, "THis got failed");
		System.out.println("Logout");
		assertEquals(true, true);
		System.out.println("Dashboard");
		softassert.assertEquals(true, true, "THis got passed");
		System.out.println("admin");
		softassert.assertAll();
	}

	@Test
	public void test2() {

		// TODO Auto-generated method stub

	}
}
