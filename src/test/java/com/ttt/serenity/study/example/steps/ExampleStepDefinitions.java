package com.ttt.serenity.study.example.steps;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.ttt.serenity.study.example.steplibs.UserSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * Example Step Definitions used to ensure build scripts and other configuration are working correctly.
 */
public class ExampleStepDefinitions
{
    private List<Integer> numbers = new ArrayList<Integer>();
    private Integer total = 0;

    @Steps
    private UserSteps user;

    @Given("^a number \'([^\']*)\'$")
    public void given_a_number(final String addend) throws Throwable {
        numbers.add(Integer.parseInt(addend));
    }

    /**
     * Adds numbers.
     */
    @When("^added together$")
    public void added_together() {
        for (Integer addend : numbers) {
            total += addend;
        }
    }

    /**
     * Subtracts numbers.
     */
    @When("^A subtract B$")
    public void subtract_B_from_A() {
        for (int i = 0; i < numbers.size(); i++) {
            total = (i == 0) ? numbers.get(i) : total - numbers.get(i);
        }
    }

    @Then("^the result is \'([^\']*)\'$")
    public void the_result_is(final String expected) throws Throwable {
        assertEquals("A + B = C", Integer.valueOf(expected), total);
    }

    @Given("^the browser is open$")
    public void the_browser_is_open() throws Throwable {
        user.opensBrowser();
    }

    @Then("^close the browser$")
    public void close_the_browser() throws Throwable {
        user.closesBrowser();
    }
}
