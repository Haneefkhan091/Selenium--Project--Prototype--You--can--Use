package Cucomber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class test {

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("the login page");
	}

	@When("I enter valid credentials")
	public void i_enter_valid_credentials() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("valid credentials");
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("login button");
	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("logged in successfully");
	}

}
