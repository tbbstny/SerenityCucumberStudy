package com.ttt.serenity.study.example.steplibs;

import com.ttt.serenity.study.example.pages.AmazonPage;

import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class UserSteps extends ScenarioSteps
{
    private static final long serialVersionUID = 1191855957443965503L;

    private AmazonPage page;

    public UserSteps(final Pages pages) {
        super(pages);
    }

    public void opensBrowser() {
        page.open();
    }

    public void closesBrowser() {
        page.getDriver().close();
    }
}

