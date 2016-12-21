package com.ttt.serenity.study;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features   = { "classpath:com/ttt/serenity/study" },
        tags       = { "@verify_norun_tags" }
)

public class DoNotRunTagsFeatureTest
{
}
