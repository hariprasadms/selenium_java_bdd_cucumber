package com.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/java/com/features",
        glue = {"com.stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber.html"},
        tags = "@SmokeTest"
)
public class CucumberRunner {

}
