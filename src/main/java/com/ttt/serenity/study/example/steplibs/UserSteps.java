package com.ttt.serenity.study.example.steplibs;

import static org.junit.Assert.*;

import com.ttt.serenity.study.example.pages.AmazonPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class UserSteps extends ScenarioSteps
{
    private static final long serialVersionUID = 1191855957443965503L;

    private AmazonPage page;

    public UserSteps(final Pages pages) {
        super(pages);
    }

    @Step
    public void opensBrowser() {
        page.open();
    }

    @Step
    public void closesBrowser() {
        page.getDriver().close();
    }

//    @Step
//    public void noRunStep(String scenarioName) {
//        assertTrue("Serenity Step Library: This step method SHOULD NOT run because " + scenarioName + " IS marked SKIPPED or PENDING.", false);
//    }
//
//    @Step
//    public void doRunStep(String scenarioName) {
//        assertTrue("Serenity Step Library: This step method SHOULD run because " + scenarioName + " IS NOT marked SKIPPED or PENDING.", true);
//    }
//
//    @Step
//    public void alwaysFailStep(String scenarioName) {
//        fail("Serenity Step Library: A step that always fails to provide clear indication if test execution is working as expected.");
//    }
}

