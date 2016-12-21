package com.ttt.serenity.study.example.steps;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import com.ttt.serenity.study.example.steplibs.CalcSteps;
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

    @Steps
    private UserSteps user;

    @Steps
    private CalcSteps calc;


    @Given("^I add (\\d+) and (\\d+)$")
    public void addition(final int a, final int b) throws Throwable {
        calc.add(a, b);
    }

    @Given("^a number \'([^\']*)\'$")
    public void given_a_number(final String num) throws Throwable {
        calc.aNum(Integer.parseInt(num));
    }

    /**
     * Adds numbers.
     */
    @When("^added together$")
    public void added_together() {
        calc.add();
    }

    @Then("^the result is \'([^\']*)\'$")
    public void the_result_is(final String expected) throws Throwable {
        calc.checkResult(Integer.valueOf(expected));
    }

    @Then("^the result is (\\d+)$")
    public void the_result_is(final Integer expected) throws Throwable {
        calc.checkResult(expected);
    }

    @Given("^the browser is open$")
    public void the_browser_is_open() throws Throwable {
        user.opensBrowser();
    }

    @Then("^close the browser$")
    public void close_the_browser() throws Throwable {
        user.closesBrowser();
    }

    @Then("^tests marked \"([^\"]*)\" should not execute$")
    public void fail(final String tag) {
        fail("This should not have executed because the test was tagged as " + tag);
    }

}
