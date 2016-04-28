package com.orzechp.restprime.acceptance;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Ignore;
import org.junit.runner.RunWith;

@Ignore
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/acceptance/features",
        tags = "~@ExpectedToFail",
        glue = {"com.orzechp.restprime.acceptance"},
        format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})

public class CucumberAcceptanceTest {

}
