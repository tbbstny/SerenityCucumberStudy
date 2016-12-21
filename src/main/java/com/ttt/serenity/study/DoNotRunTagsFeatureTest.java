package com.ttt.serenity.study;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
     features   = { "classpath:com/ttt/serenity/study/feature_file_tags/serenity_do_not_run_test_tags" }
)

public class DoNotRunTagsFeatureTest
{
}
