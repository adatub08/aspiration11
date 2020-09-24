package com.devxschool.apiframework.cucumber.testrunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features/gorestusers.feature"
        },
        glue = {
                "com.devxschool.apiframework.cucumber.steps.gorest"
        },
        tags = {
                "@createUser"
        },
        dryRun = false
)
public class GorestTest {}
