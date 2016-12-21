package com.ttt.serenity.study;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
     plugin     = {"pretty", "html:target/cucumber-reports"},
     features   = { "classpath:com/ttt/serenity/study" },
     tags       = { "@verify_tags" }
)

public class StudyIT
{
}
