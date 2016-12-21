package com.ttt.serenity.study;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
     features   = { "classpath:com/ttt/serenity/study/feature_file_tags/serenity_driver_tag/use_firefox_browser.feature" }
)

public class FirefoxDriverFeatureTest
{
}
