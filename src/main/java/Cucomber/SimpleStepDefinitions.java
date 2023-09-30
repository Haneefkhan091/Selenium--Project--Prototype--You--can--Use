package Cucomber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SimpleStepDefinitions {
	  @Given("I have Cucumber set up")
	    public void setupCucumber() {
	        System.out.println("Cucumber is set up!");
	    }

	    @When("I run a simple scenario")
	    public void runSimpleScenario() {
	        System.out.println("Running a simple scenario...");
	    }

	    @Then("I should see it passing")
	    public void verifyPassingScenario() {
	        System.out.println("Scenario passed!");
	    }

}
