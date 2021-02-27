package com.fatiko.project_name.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-report.html",
                  "json:target/cucumber.json",
                  "rerun:target/rerun.txt"},
        glue = "com/fatiko/project_name/step_definitions",
        features = "src/test/resources/features",
        dryRun = false,
        tags = ""
)

public class CukesRunner {



}
