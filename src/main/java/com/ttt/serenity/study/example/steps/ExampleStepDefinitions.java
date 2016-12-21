package com.ttt.serenity.study.example.steps;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import com.ttt.serenity.study.example.steplibs.CalcSteps;
import com.ttt.serenity.study.example.steplibs.UserSteps;

import cucumber.api.PendingException;
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

//    @Given("^this \"([^\"]*)\" and \"([^\"]*)\" IS marked SKIPPED or PENDING$")
//    public void IS_marked_SKIPED_or_PENDING(String featureName, String scenarioName) {
//        noRun(scenarioName);
//    }
//
//    @Then("^the \"([^\"]*)\" steps SHOULD NOT BE executed$")
//    public void the_steps_SHOULD_NOT_BE_executed(String scenarioName) {
//        noRun(scenarioName);
//    }
//
//    private void noRun(String scenarioName) {
//        user.noRunStep(scenarioName);
//        assertTrue("Cucumber Step Definition: This step definition SHOULD NOT run because " + scenarioName + " IS marked SKIPPED or PENDING.", true);
//        doFail(scenarioName);
//    }
//
//    private void doFail(String scenarioName) {
//        user.alwaysFailStep(scenarioName);
//        fail("Cucumber Step Definition: A step definition that always fails to provide clear indication if test execution is working as expected.");
//    }
//
//    @Given("^this \"([^\"]*)\" and \"([^\"]*)\" IS NOT marked SKIPPED or PENDING$")
//    public void IS_NOT_marked_SKIPED_or_PENDING(String featureName, String scenarioName) throws Throwable {
//        doRun(scenarioName);
//    }
//
//    @Then("^the \"([^\"]*)\" steps SHOULD BE executed$")
//    public void the_steps_SHOULD_BE_executed(String scenarioName) {
//        doRun(scenarioName);
//    }
//
//    private void doRun(String scenarioName) {
//        user.doRunStep(scenarioName);
//        assertTrue("Cucumber Step Definition: This step definition SHOULD run because " + scenarioName + " IS NOT marked SKIPPED or PENDING.", true);
//        doFail(scenarioName);
//    }
}
