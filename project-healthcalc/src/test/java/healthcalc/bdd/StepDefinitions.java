package healthcalc.bdd;

import org.junit.jupiter.api.Assertions;

import healthcalc.HealthCalcImpl;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	private HealthCalcImpl healthCalc;
    private float weight;
    private int height;
    private int age;
    private char gender;
    private double BMR;
	private double idealWeight;
    private boolean raiseException;
	
	@Before
	public void initialization() {
		healthCalc = null;
	    raiseException = false;
	}
	@Given("I have a health calculator")
	public void i_have_a_health_calculator() {
		healthCalc = new HealthCalcImpl();
	}
	@Given("a weight of {float} kg")
    public void a_weight_of_kg(float weight) {
        this.weight = weight;
    }
    
    @Given("a height of {int} cm")
    public void a_height_of_cm(int height) {
        this.height = height; 
    }
    
    @Given("an age of {int} years")
    public void an_age_of_years(int age) {
        this.age = age;
    }
    
    @Given("a male gender")
    public void a_male_gender() {
        this.gender = 'M';
    }

	@Given("a female gender")
	public void a_female_gender() {
		this.gender = 'F';
}

	@Given("an unknown gender")
	public void an_unknown_gender() {
    	this.gender = 'X'; 
}
    
    @When("I compute the basal metabolic rate")
    public void i_compute_the_basal_metabolic_rate() {
        try {
            BMR = healthCalc.basalMetabolicRate(weight, height, age, gender);
        } catch (Exception e) {
            raiseException = true;
        }
    }
    
    @Then("The system returns {double} kcal\\/day")
    public void the_system_returns_kcal_day(double expectedBMR) {
        Assertions.assertFalse(raiseException, "An exception was raised when computing BMR");
        Assertions.assertEquals(expectedBMR, BMR, 0.1, "The calculated BMR does not match expected");
    }

	@When("I compute the ideal weight")
	public void i_compute_the_ideal_weight() {
    try {
        idealWeight = healthCalc.idealWeight(height, gender);
    } catch (Exception e) {
        raiseException = true;
    }
}

	@Then("The system returns {double} kg")
	public void the_system_returns_kg(double expectedWeight) {
		Assertions.assertFalse(raiseException, "An exception was raised during ideal weight calculation.");
		Assertions.assertEquals(expectedWeight, idealWeight, 0.1, "The calculated ideal weight is incorrect.");
	}

	@Given("a negative height {int} cm")
	public void a_negative_height_cm(int  height) {
		this.height = height; 
	}

	@Then("The system throws an error of invalid parameter")
	public void the_system_throws_an_error_of_invalid_parameter() {
		Assertions.assertTrue(raiseException, "Invalid parameter error");
	}

	


}
