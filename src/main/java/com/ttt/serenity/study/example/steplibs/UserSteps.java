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
}
